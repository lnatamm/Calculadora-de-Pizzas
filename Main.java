import java.util.*;
import java.text.*;

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

        int controle = 1;

        ArrayList<Pessoa> pessoas = new ArrayList<>();

        while(controle == 1){

            System.out.print("\nNome: ");

            String nome = inputString("\nNome: ", sc);

            System.out.print("\nQuantidade de Pedaços(Pizza Salgada): ");

            int pedacosSalgadas = inputInt("\nQuantidade de Pedaços(Pizza Salgada): ", sc);

            ArrayList<String> votosSalgada;

            if(pedacosSalgadas > 0) {

                System.out.print("\nDigite seus Votos (Pizza Salgada): ");

                votosSalgada = new ArrayList<>(Arrays.asList(inputString("\nDigite seus Votos (Pizza Salgada): ", sc).split(", ")));

            }

            else {

                votosSalgada = new ArrayList<>(Arrays.asList(""));

            }

            System.out.print("\nQuantidade de Pedaços(Pizza Doce): ");

            int pedacosDoces = inputInt("\nQuantidade de Pedaços(Pizza Doce): ", sc);

            ArrayList<String> votosDoce;

            if(pedacosDoces > 0) {

                System.out.print("\nDigite seus Votos (Pizza Doce): ");

                votosDoce = new ArrayList<>(Arrays.asList(inputString("\nDigite seus Votos (Pizza Doce): ", sc).split(", ")));

            }

            else {

                votosDoce = new ArrayList<>(Arrays.asList(""));

            }

            pessoas.add(new Pessoa(nome, pedacosSalgadas, votosSalgada, pedacosDoces, votosDoce));

            System.out.print("\nDeseja adicionar outra pessoa? (1: Sim | !1: Não): ");

            controle = inputInt("\nDeseja adicionar outra pessoa? (1: Sim | !1: Não): ", sc);

        }

        Calculadora calculadora = new Calculadora(pessoas);
        System.out.println("\nTotal de Pedaços Salgadas: " + calculadora.getPedacosSalgadas());
        System.out.println("Quantidade de Pizzas Salgadas: " + calculadora.getQtdPizzasSalgadas() + "\n");
        System.out.println("Total de Pedaços Doces: " + calculadora.getPedacosDoces());
        System.out.println("Quantidade de Pizzas Doces: " + calculadora.getQtdPizzasDoces() + "\n");
        System.out.println("Pedaços Salgados por Sabores:");
        System.out.println("-----------------------\n");
        calculadora.showPizzasSalgadas();
        System.out.println("Pedaços Doces por Sabores:");
        System.out.println("-----------------------\n");
        calculadora.showPizzasDoces();
        System.out.println("Quantidade de Pizzas Salgadas de cada Sabor");
        System.out.println("-----------------------\n");
        calculadora.showRelacaoSalgadas();
        System.out.println("Quantidade de Pizzas Doces de cada Sabor");
        System.out.println("-----------------------\n");
        calculadora.showRelacaoDoces();
        System.out.println("Preço total: R$" + calculadora.getPrecoTotal());
        System.out.println("Preço dividido: R$" + calculadora.getPrecoDividido());
        System.out.println("Preço a pagar: R$" + (calculadora.getPrecoTotal() - calculadora.getPrecoDividido()));
        System.out.println("O preço está correto? (Sim/Não/Yes/No/S/Y/N)");
        boolean resposta = inputResposta("O preço está correto?", sc);
        if(!resposta){
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

    }

}