import java.util.*;
import java.text.*;
//Final Commit
public class Main {

    public static boolean inputResposta(String frase, Scanner sc){

        String s = sc.nextLine();

        s = Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");

        s = s.toLowerCase();

        if(s.equals("sim") || s.equals("s")  || s.equals("yes")|| s.equals("y") || s.equals("nao") || s.equals("no") || s.equals("n")){

            if(s.equals("sim") || s.equals("s")  || s.equals("yes")|| s.equals("y")){
                return true;
            }

            else {
                return false;
            }

        }

        else {

            System.out.println(frase);
            return inputResposta(frase, sc);

        }

    }

    public static String inputString(String frase, Scanner sc){

        try{

            String s = sc.nextLine();

            try{

                Integer.parseInt(s);
                throw new InputMismatchException();

            }

            catch (NumberFormatException e) {

                return s;

            }

        }

        catch (InputMismatchException e){

            System.out.print(frase);
            return inputString(frase, sc);

        }

    }

    public static int inputInt(String frase, Scanner sc){

        try{

            int numero = Integer.parseInt(sc.nextLine());
            if(numero >= 0) {
                return numero;
            }
            else {
                throw new NumberFormatException();
            }

        }

        catch (NumberFormatException e){

            System.out.print(frase);
            return inputInt(frase, sc);

        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean rodando = true;

        while (rodando) {

            boolean controle = true;

            ArrayList<Pessoa> pessoas = new ArrayList<>();

            while (controle) {

                System.out.print("\nNome: ");

                String nome = inputString("\nNome: ", sc);

                System.out.print("\nQuantidade de Pedaços(Pizza Salgada): ");

                int pedacosSalgadas = inputInt("\nQuantidade de Pedaços(Pizza Salgada): ", sc);

                ArrayList<String> votosSalgada;

                if (pedacosSalgadas > 0) {

                    System.out.print("\nDigite seus Votos (Pizza Salgada)(Separe por  \", \"): ");

                    votosSalgada = new ArrayList<>(Arrays.asList(inputString("\nDigite seus Votos (Pizza Salgada): ", sc).split(", ")));

                } else {

                    votosSalgada = new ArrayList<>(Arrays.asList(""));

                }

                System.out.print("\nQuantidade de Pedaços(Pizza Doce): ");

                int pedacosDoces = inputInt("\nQuantidade de Pedaços(Pizza Doce): ", sc);

                ArrayList<String> votosDoce;

                if (pedacosDoces > 0) {

                    System.out.print("\nDigite seus Votos (Pizza Doce)(Separe por  \", \"): ");

                    votosDoce = new ArrayList<>(Arrays.asList(inputString("\nDigite seus Votos (Pizza Doce): ", sc).split(", ")));

                } else {

                    votosDoce = new ArrayList<>(Arrays.asList(""));

                }

                pessoas.add(new Pessoa(nome, pedacosSalgadas, votosSalgada, pedacosDoces, votosDoce));

                System.out.println("\nDeseja adicionar outra pessoa? (Sim/Não/Yes/No/S/Y/N): ");

                controle = inputResposta("\nDeseja adicionar outra pessoa? (Sim/Não/Yes/No/S/Y/N): ", sc);

            }

            DecimalFormat df = new DecimalFormat("#.00");
            Calculadora calculadora = new Calculadora(pessoas);
            System.out.println("\nTotal de Pedaços Salgadas: " + calculadora.getPedacosSalgadas());
            System.out.println("Quantidade de Pizzas Salgadas: " + calculadora.getQtdPizzasSalgadas() + "\n");
            System.out.println("Total de Pedaços Doces: " + calculadora.getPedacosDoces());
            System.out.println("Quantidade de Pizzas Doces: " + calculadora.getQtdPizzasDoces() + "\n");
//          (Descomente para mostrar quantos para saber quantos pedacos ao todo de cada sabor deram.)
//          System.out.println("Pedaços Salgados por Sabores:");
//          System.out.println("-----------------------\n");
//          calculadora.showPizzasSalgadas();
//          System.out.println("Pedaços Doces por Sabores:");
//          System.out.println("-----------------------\n");
//          calculadora.showPizzasDoces();
            System.out.println("Quantidade de Pizzas Salgadas de cada Sabor");
            System.out.println("-----------------------\n");
            calculadora.showRelacaoSalgadas();
            System.out.println("Quantidade de Pizzas Doces de cada Sabor");
            System.out.println("-----------------------\n");
            calculadora.showRelacaoDoces();
            System.out.println("Preço total: R$" + calculadora.getPrecoTotal());
            System.out.println("Preço dividido: R$" + calculadora.getPrecoDividido());
            System.out.println("Preço a pagar: R$" + (Double.parseDouble(df.format(calculadora.getPrecoTotal() - calculadora.getPrecoDividido()).replace(",", "."))));
            System.out.println("O preço está correto? (Sim/Não/Yes/No/S/Y/N)");
            boolean resposta = inputResposta("O preço está correto?", sc);
            if (!resposta) {
                System.out.print("\nDigite o novo preço total: ");
                calculadora.setPrecoTotal(Double.parseDouble(sc.nextLine()));
                System.out.println("Preço total: R$" + calculadora.getPrecoTotal());
                System.out.println("Preço dividido: R$" + calculadora.getPrecoDividido());
                System.out.println("Preço a pagar: R$" + (calculadora.getPrecoTotal() - calculadora.getPrecoDividido()));
            }
            System.out.println("-----------------------\n");
            System.out.println("Pessoas:");
            System.out.println("-----------------------\n");
            calculadora.showPessoas();
            System.out.println("Deseja fazer um novo cálculo? (Sim/Não/Yes/No/S/Y/N): ");
            rodando = inputResposta("Deseja fazer um novo cálculo? (Sim/Não/Yes/No/S/Y/N): ", sc);

        }

    }

}