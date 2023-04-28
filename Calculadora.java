import java.math.*;
import java.text.*;
import java.util.*;

public class Calculadora {

    private ArrayList<Pessoa> pessoas;

    private ArrayList<Pizza> pizzasSalgadas;

    private int pedacosSalgadas;

    private int qtdPizzasSalgadas;

    private ArrayList<Pizza> prioridadesSalgadas;

    private ArrayList<Pizza> relacaoDePizzasSalgadas;

    private ArrayList<Pizza> pizzasDoces;

    private int pedacosDoces;

    private int qtdPizzasDoces;

    private ArrayList<Pizza> prioridadesDoces;

    private ArrayList<Pizza> relacaoDePizzasDoces;

    private double precoTotal;

    private double precoDividido;

    private double cota;

    public Calculadora(ArrayList<Pessoa> pessoas){

        this.pessoas = pessoas;

        pizzasSalgadas = new ArrayList<Pizza>(Arrays.asList(
                //Inserir aqui as pizzas e os seus respectivos preços da seguinte forma: "new Pizza("Sabor", Preço)"
                new Pizza("Fala Baixo", 79.9),
                new Pizza("Siciliana", 80.9),
                new Pizza("Fala Mag", 81.9),
                new Pizza("Frango Catupiry", 67.9),
                new Pizza("Portuguesa", 71.9),
                new Pizza("Calabresa", 67.9),
                new Pizza("Californication", 67.9),
                new Pizza("Marguerita", 67.9),
                new Pizza("Mussarela", 67.9),
                new Pizza("Mango Chutney", 67.9),
                new Pizza("Frango Barbecue", 67.9),
                new Pizza("Calabresa Cheddar", 78.9),
                new Pizza("Fala Baixo Cheddar", 79.9),
                new Pizza("Queijos", 86.9),
                new Pizza("Cala Catu", 79.9)
        )
        );

        pizzasDoces = new ArrayList<Pizza>(Arrays.asList(
                new Pizza("Bisladen", 81.9),
                new Pizza("Chocobrothers", 78.9),
                new Pizza("Tworros", 71.9)
        )
        );

        definePedacosSalgadasTemp();

        defineQtdPizzasSalgadas();

        definePedacosSalgadasDef();

        filtraVotosSalgadas();

        incrementaPizzasSalgadas();

        definePrioridadesSalgadas();

        defineRelacaoSalgadas();

        definePedacosDocesTemp();

        defineQtdPizzasDoces();

        definePedacosDocesDef();

        filtraVotosDoces();

        incrementaPizzasDoces();

        definePrioridadesDoces();

        defineRelacaoDoces();

        definePrecoTotal();

        definePrecoDividido();

        defineCota();

        defineCotaPessoa();

    }

    public Calculadora(){

        pessoas = new ArrayList<Pessoa>(Arrays.asList(
                //Inserir aqui as pessoas e os seus votos da seguinte forma: "new Pessoa("Nome", Quantidade de Pedaços, new ArrayList<String>(Arrays.asList("Voto1", "Voto2")))"
                new Pessoa("", 0, new ArrayList<String>(Arrays.asList("")), 0, new ArrayList<String>(Arrays.asList(""))),
                new Pessoa("", 0, new ArrayList<String>(Arrays.asList("")), 0, new ArrayList<String>(Arrays.asList(""))),
                new Pessoa("", 0, new ArrayList<String>(Arrays.asList("")), 0, new ArrayList<String>(Arrays.asList(""))),
                new Pessoa("", 0, new ArrayList<String>(Arrays.asList("")), 0, new ArrayList<String>(Arrays.asList(""))),
                new Pessoa("", 0, new ArrayList<String>(Arrays.asList("")), 0, new ArrayList<String>(Arrays.asList(""))),
                new Pessoa("", 0, new ArrayList<String>(Arrays.asList("")), 0, new ArrayList<String>(Arrays.asList(""))),
                new Pessoa("", 0, new ArrayList<String>(Arrays.asList("")), 0, new ArrayList<String>(Arrays.asList(""))),
                new Pessoa("", 0, new ArrayList<String>(Arrays.asList("")), 0, new ArrayList<String>(Arrays.asList(""))),
                new Pessoa("", 0, new ArrayList<String>(Arrays.asList("")), 0, new ArrayList<String>(Arrays.asList(""))),
                new Pessoa("", 0, new ArrayList<String>(Arrays.asList("")), 0, new ArrayList<String>(Arrays.asList(""))),
                new Pessoa("", 0, new ArrayList<String>(Arrays.asList("")), 0, new ArrayList<String>(Arrays.asList(""))),
                new Pessoa("", 0, new ArrayList<String>(Arrays.asList("")), 0, new ArrayList<String>(Arrays.asList(""))),
                new Pessoa("", 0, new ArrayList<String>(Arrays.asList("")), 0, new ArrayList<String>(Arrays.asList(""))),
                new Pessoa("", 0, new ArrayList<String>(Arrays.asList("")), 0, new ArrayList<String>(Arrays.asList(""))),
                new Pessoa("", 0, new ArrayList<String>(Arrays.asList("")), 0, new ArrayList<String>(Arrays.asList(""))),
                new Pessoa("", 0, new ArrayList<String>(Arrays.asList("")), 0, new ArrayList<String>(Arrays.asList(""))),
                new Pessoa("", 0, new ArrayList<String>(Arrays.asList("")), 0, new ArrayList<String>(Arrays.asList(""))),
                new Pessoa("", 0, new ArrayList<String>(Arrays.asList("")), 0, new ArrayList<String>(Arrays.asList(""))),
                new Pessoa("", 0, new ArrayList<String>(Arrays.asList("")), 0, new ArrayList<String>(Arrays.asList(""))),
                new Pessoa("", 0, new ArrayList<String>(Arrays.asList("")), 0, new ArrayList<String>(Arrays.asList(""))),
                new Pessoa("", 0, new ArrayList<String>(Arrays.asList("")), 0, new ArrayList<String>(Arrays.asList(""))),
                new Pessoa("", 0, new ArrayList<String>(Arrays.asList("")), 0, new ArrayList<String>(Arrays.asList("")))
        )
        );

        pizzasSalgadas = new ArrayList<Pizza>(Arrays.asList(
                //Inserir aqui as pizzas e os seus respectivos preços da seguinte forma: "new Pizza("Sabor", Preço)"
                new Pizza("Fala Baixo", 79.9),
                new Pizza("Siciliana", 80.9),
                new Pizza("Fala Mag", 81.9),
                new Pizza("Frango Catupiry", 67.9),
                new Pizza("Portuguesa", 71.9),
                new Pizza("Calabresa", 67.9),
                new Pizza("Californication", 67.9),
                new Pizza("Marguerita", 67.9),
                new Pizza("Mussarela", 67.9),
                new Pizza("Mango Chutney", 67.9),
                new Pizza("Frango Barbecue", 67.9),
                new Pizza("Calabresa Cheddar", 78.9),
                new Pizza("Fala Baixo Cheddar", 79.9),
                new Pizza("Queijos", 86.9),
                new Pizza("Cala Catu", 79.9)
        )
        );

        pizzasDoces = new ArrayList<Pizza>(Arrays.asList(
                new Pizza("Bisladen", 81.9),
                new Pizza("Chocobrothers", 78.9),
                new Pizza("Tworros", 71.9)
        )
        );

        definePedacosSalgadasTemp();

        defineQtdPizzasSalgadas();

        definePedacosSalgadasDef();

        filtraVotosSalgadas();

        incrementaPizzasSalgadas();

        definePrioridadesSalgadas();

        defineRelacaoSalgadas();

        definePedacosDocesTemp();

        defineQtdPizzasDoces();

        definePedacosDocesDef();

        filtraVotosDoces();

        incrementaPizzasDoces();

        definePrioridadesDoces();

        defineRelacaoDoces();

        definePrecoTotal();

        definePrecoDividido();

        defineCota();

        defineCotaPessoa();

    }

    private void filtraVotosSalgadas(){

        for(Pessoa i : pessoas){

            int j = 0;

            while(j < i.getVotosSalgadas().size()){

                boolean contem = false;

                for(Pizza k : pizzasSalgadas){

                    if(k.getSabor().equals(i.getVotosSalgadas().get(j))){
                        contem = true;
                        break;
                    }

                }

                if(!contem){

                    i.getVotosSalgadas().remove(i.getVotosSalgadas().get(j));
                    j--;

                }

                j++;

            }

            if(i.getVotosSalgadas().size() == 0){

                i.setPedacosSalgadas(0);

            }

            else{

                ArrayList<String> votosSalgadaTemp = new ArrayList<>();

                for(String k : i.getVotosSalgadas()){

                    votosSalgadaTemp.add(k);

                }

                i.setVotosSalgadas(new ArrayList<String>());

                for(String k : votosSalgadaTemp){

                    if(!i.getVotosSalgadas().contains(k)){

                        i.getVotosSalgadas().add(k);

                    }

                }

                while (i.getVotosSalgadas().size() > 2){

                    i.getVotosSalgadas().remove(2);

                }

            }

        }

    }

    private void defineQtdPizzasSalgadas(){

        qtdPizzasSalgadas = Math.ceilDiv(pedacosSalgadas, 8);

    }

    private void definePedacosSalgadasTemp(){

        pedacosSalgadas = 0;

        for(Pessoa i : pessoas){

            pedacosSalgadas += i.getPedacosSalgadas();

        }

    }

    private void definePedacosSalgadasDef(){

        pedacosSalgadas = qtdPizzasSalgadas * 8;

    }

    private Pizza getPizzaSalgadas(String sabor){

        for(Pizza i : pizzasSalgadas){

            if(sabor.equals(i.getSabor())){
                return i;
            }

        }

        return null;

    }

    private void incrementaPizzasSalgadas(){

        ArrayList<Pessoa> pessoasAux = new ArrayList<>();

        for(Pessoa i : pessoas){

            pessoasAux.add(new Pessoa(i.getNome(), i.getPedacosSalgadas(), i.getVotosSalgadas(), i.getPedacosDoces(), i.getVotosDoces()));

        }

        for(Pessoa i : pessoasAux){

            for(String j : i.getVotosSalgadas()){

                for(Pizza k : pizzasSalgadas){

                    if(j.equals(k.getSabor())){

                        double divisao = i.getPedacosSalgadas() / (i.getVotosSalgadas().size() * 1.0);

                        BigDecimal bdValor = new BigDecimal(divisao);
                        if (bdValor.setScale(0, RoundingMode.DOWN).compareTo(bdValor) != 0) {
                            //tem decimal

                            if(i.getVotosSalgadas().size() > 1){

                                int divisaoInteira;

                                try{

                                    if(k.getQuantidade() == getPizzaSalgadas(i.getVotosSalgadas().get(1)).getQuantidade()){

                                        k.incQuantidade(divisao);
                                        getPizzaSalgadas(i.getVotosSalgadas().get(1)).incQuantidade(divisao);
                                        i.getVotosSalgadas().remove(1);
                                        break;

                                    }

                                    else if(k.getQuantidade() > getPizzaSalgadas(i.getVotosSalgadas().get(1)).getQuantidade()){

                                        divisaoInteira = Math.ceilDiv(i.getPedacosSalgadas(), i.getVotosSalgadas().size());
                                        k.incQuantidade(divisaoInteira);

                                    }

                                    else{

                                        divisaoInteira = Math.floorDiv(i.getPedacosSalgadas(), i.getVotosSalgadas().size());
                                        k.incQuantidade(divisaoInteira);

                                    }

                                    i.getVotosSalgadas().remove(0);
                                    i.decPedacosSalgadas(divisaoInteira);

                                }

                                catch(NullPointerException e){

                                }

                            }

                        } else {
                            //não tem decimal
                            k.incQuantidade(i.getPedacosSalgadas() / i.getVotosSalgadas().size());
                        }

                    }

                }

            }

        }

    }

    private void deRoundingSalgadas(){

        for(Pizza i : pizzasSalgadas){

            i.setQuantidade(Math.ceil(i.getQuantidade()));

        }

    }

    private void definePrioridadesSalgadas(){

        deRoundingSalgadas();

        prioridadesSalgadas = new ArrayList<>();

        for(Pizza i : pizzasSalgadas){

            if(i.getQuantidade() > 0) {
                prioridadesSalgadas.add(i);
            }

        }

        Collections.sort(prioridadesSalgadas);

    }

    private void defineRelacaoSalgadas(){

        relacaoDePizzasSalgadas = new ArrayList<>();

        double tempPizzas = (double)qtdPizzasSalgadas;

        int i = 0;

        while(tempPizzas > 0 && i < prioridadesSalgadas.size()){

            double divisao = prioridadesSalgadas.get(i).getQuantidade() / 8.0;

            if(prioridadesSalgadas.size() == 1){
                divisao = 1;
            }

            int parteInteira = (int)Math.floor(divisao);

            double parteDecimal = Math.abs(divisao - parteInteira);

            if(parteDecimal < 0.25){

                if(parteInteira > 0){
                    divisao = Math.floor(divisao);
                }

                else{
                    divisao = parteInteira + 0.5;
                }

            }

            else{

                divisao = parteInteira + 0.5;

            }

            relacaoDePizzasSalgadas.add(new Pizza(prioridadesSalgadas.get(i).getSabor(), divisao, prioridadesSalgadas.get(i).getPreco()));

            tempPizzas -= divisao;

            i++;

        }

    }

    private void filtraVotosDoces(){

        for(Pessoa i : pessoas){

            int j = 0;

            while(j < i.getVotosDoces().size()){

                boolean contem = false;

                for(Pizza k : pizzasDoces){

                    if(k.getSabor().equals(i.getVotosDoces().get(j))){
                        contem = true;
                        break;
                    }

                }

                if(!contem){

                    i.getVotosDoces().remove(i.getVotosDoces().get(j));
                    j--;

                }

                j++;

            }

            if(i.getVotosDoces().size() == 0){

                i.setPedacosDoces(0);

            }

            else{

                ArrayList<String> votosDoceTemp = new ArrayList<>();

                for(String k : i.getVotosDoces()){

                    votosDoceTemp.add(k);

                }

                i.setVotosDoces(new ArrayList<String>());

                for(String k : votosDoceTemp){

                    if(!i.getVotosDoces().contains(k)){

                        i.getVotosDoces().add(k);

                    }

                }

                while (i.getVotosDoces().size() > 2){

                    i.getVotosDoces().remove(2);

                }

            }

        }

    }

    private void defineQtdPizzasDoces(){

        qtdPizzasDoces = Math.ceilDiv(pedacosDoces, 8);

    }

    private void definePedacosDocesTemp(){

        pedacosDoces = 0;

        boolean contem;

        for(Pessoa i : pessoas){

            contem = false;

            for(String j : i.getVotosDoces()){

                for(Pizza k : pizzasDoces){

                    if(k.getSabor().equals(j)){

                        contem = true;

                    }

                }

            }

            if(contem){
                pedacosDoces += i.getPedacosDoces();
            }

            else{
                i.setPedacosDoces(0);
            }

        }

    }

    private void definePedacosDocesDef(){

        pedacosDoces = qtdPizzasDoces * 8;

    }

    private Pizza getPizzaDoces(String sabor){

        for(Pizza i : pizzasDoces){

            if(sabor.equals(i.getSabor())){
                return i;
            }

        }

        return null;

    }

    private void incrementaPizzasDoces(){

        ArrayList<Integer> qtdAux = new ArrayList<>();

        for(int i = 0; i < pessoas.size(); i++){

            qtdAux.add(pessoas.get(i).getPedacosDoces());

        }

        for(int i = 0; i < pessoas.size(); i++){

            for(int j = 0; j < pessoas.get(i).getVotosDoces().size(); j++){

                for(int k = 0; k < pizzasDoces.size(); k++){

                    if(pessoas.get(i).getVotosDoces().get(j).equals(pizzasDoces.get(k).getSabor())){

                        double divisao = qtdAux.get(i) / (pessoas.get(i).getVotosDoces().size() * 1.0);

                        BigDecimal bdValor = new BigDecimal(divisao);
                        if (bdValor.setScale(0, RoundingMode.DOWN).compareTo(bdValor) != 0) {
                            //tem decimal

                            if(pessoas.get(i).getVotosDoces().size() > 1){

                                int divisaoInteira;

                                if(pizzasDoces.get(k).getQuantidade() == getPizzaDoces(pessoas.get(i).getVotosDoces().get(1)).getQuantidade()){

                                    pizzasDoces.get(k).incQuantidade(divisao);
                                    getPizzaDoces(pessoas.get(i).getVotosDoces().get(1)).incQuantidade(divisao);
                                    pessoas.get(i).getVotosDoces().remove(1);
                                    break;

                                }

                                else if(pizzasDoces.get(k).getQuantidade() > getPizzaDoces(pessoas.get(i).getVotosDoces().get(1)).getQuantidade()){

                                    divisaoInteira = Math.ceilDiv(qtdAux.get(i), pessoas.get(i).getVotosDoces().size());
                                    pizzasDoces.get(k).incQuantidade(divisaoInteira);

                                }

                                else{

                                    divisaoInteira = Math.floorDiv(qtdAux.get(i), pessoas.get(i).getVotosDoces().size());
                                    pizzasDoces.get(k).incQuantidade(divisaoInteira);

                                }

                                pessoas.get(i).getVotosDoces().remove(0);
                                qtdAux.set(i, qtdAux.get(i) - divisaoInteira);

                            }

                        } else {
                            //não tem decimal
                            pizzasDoces.get(k).incQuantidade(qtdAux.get(i) / pessoas.get(i).getVotosDoces().size());
                        }

                    }

                }

            }

        }

    }

    private void deRoundingDoces(){

        for(Pizza i : pizzasDoces){

            i.setQuantidade(Math.ceil(i.getQuantidade()));

        }

    }

    private void definePrioridadesDoces(){

        deRoundingDoces();

        prioridadesDoces = new ArrayList<>();

        for(Pizza i : pizzasDoces){

            if(i.getQuantidade() > 0){
                prioridadesDoces.add(i);
            }

        }

        Collections.sort(prioridadesDoces);

    }

    private void defineRelacaoDoces(){

        relacaoDePizzasDoces = new ArrayList<>();

        double tempPizzas = (double)qtdPizzasDoces;

        int i = 0;

        while(tempPizzas > 0 && i < prioridadesDoces.size()){

            double divisao = prioridadesDoces.get(i).getQuantidade() / 8.0;

            if(prioridadesDoces.size() == 1){
                divisao = 1;
            }

            int parteInteira = (int)Math.floor(divisao);

            double parteDecimal = Math.abs(divisao - parteInteira);

            if(parteDecimal < 0.25){

                if(parteInteira > 0){
                    divisao = Math.floor(divisao);
                }

                else{
                    divisao = parteInteira + 0.5;
                }

            }

            else{

                divisao = parteInteira + 0.5;

            }

            relacaoDePizzasDoces.add(new Pizza(prioridadesDoces.get(i).getSabor(), divisao, prioridadesDoces.get(i).getPreco()));

            tempPizzas -= divisao;

            i++;

        }

    }

    private void definePrecoTotal(){

        DecimalFormat df = new DecimalFormat("#.00");

        precoTotal = 0;

        for(Pizza i : relacaoDePizzasSalgadas){

            precoTotal+=i.getPreco()*i.getQuantidade();
            precoTotal = Double.parseDouble(df.format(precoTotal).replace(",", "."));

        }

        for(Pizza i : relacaoDePizzasDoces){

            precoTotal+=i.getPreco()*i.getQuantidade();

        }

        precoTotal = Double.parseDouble(df.format(precoTotal).replace(",", "."));

    }

    private void definePrecoDividido(){

        DecimalFormat df = new DecimalFormat("#.00");

        precoDividido = precoTotal * 1/2; //Defina a fração de quanto do preço total será dividido entre os demais
        precoDividido = Double.parseDouble(df.format(precoDividido).replace(",", "."));

    }

    private void defineCota(){

        DecimalFormat df = new DecimalFormat("#.00");

        if(!(pedacosSalgadas == 0 && pedacosDoces == 0)) {
            cota = Double.parseDouble(df.format(precoDividido / (pedacosSalgadas + pedacosDoces)).replace(",", "."));
        }
        else {
            cota = 0;
        }

    }

    private void defineCotaPessoa(){

        DecimalFormat df = new DecimalFormat("#.00");

        for(Pessoa i : pessoas){

            i.setCota(Double.parseDouble(df.format(cota * (i.getPedacosSalgadas() + i.getPedacosDoces())).replace(",", ".")));

        }

    }

    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }

    public ArrayList<Pizza> getPizzasSalgadas() {
        return pizzasSalgadas;
    }

    public int getPedacosSalgadas(){
        return pedacosSalgadas;
    }

    public int getQtdPizzasSalgadas(){
        return qtdPizzasSalgadas;
    }

    public ArrayList<Pizza> getPrioridadesSalgadas() {
        return prioridadesSalgadas;
    }

    public ArrayList<Pizza> getRelacaoDePizzasSalgadas() {
        return relacaoDePizzasSalgadas;
    }

    public ArrayList<Pizza> getPizzasDoces() {
        return pizzasDoces;
    }

    public int getPedacosDoces() {
        return pedacosDoces;
    }

    public int getQtdPizzasDoces() {
        return qtdPizzasDoces;
    }

    public ArrayList<Pizza> getPrioridadesDoces() {
        return prioridadesDoces;
    }

    public ArrayList<Pizza> getRelacaoDePizzasDoces() {
        return relacaoDePizzasDoces;
    }

    public double getPrecoTotal(){
        return precoTotal;
    }

    public double getPrecoDividido(){
        return precoDividido;
    }

    public double getCota() {
        return cota;
    }

    public void setPessoas(ArrayList<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public void setPizzasSalgadas(ArrayList<Pizza> pizzasSalgadas) {
        this.pizzasSalgadas = pizzasSalgadas;
    }

    public void setPedacosSalgadas(int pedacosSalgadas) {
        this.pedacosSalgadas = pedacosSalgadas;
    }

    public void setQtdPizzasSalgadas(int qtdPizzasSalgadas) {
        this.qtdPizzasSalgadas = qtdPizzasSalgadas;
    }

    public void setPrioridadesSalgadas(ArrayList<Pizza> prioridadesSalgadas) {
        this.prioridadesSalgadas = prioridadesSalgadas;
    }

    public void setRelacaoDePizzasSalgadas(ArrayList<Pizza> relacaoDePizzasSalgadas) {
        this.relacaoDePizzasSalgadas = relacaoDePizzasSalgadas;
    }

    public void setPizzasDoces(ArrayList<Pizza> pizzasDoces) {
        this.pizzasDoces = pizzasDoces;
    }

    public void setPedacosDoces(int pedacosDoces) {
        this.pedacosDoces = pedacosDoces;
    }

    public void setQtdPizzasDoces(int qtdPizzasDoces) {
        this.qtdPizzasDoces = qtdPizzasDoces;
    }

    public void setPrioridadesDoces(ArrayList<Pizza> prioridadesDoces) {
        this.prioridadesDoces = prioridadesDoces;
    }

    public void setRelacaoDePizzasDoces(ArrayList<Pizza> relacaoDePizzasDoces) {
        this.relacaoDePizzasDoces = relacaoDePizzasDoces;
    }

    public void setPrecoTotal(double precoTotal) {
        DecimalFormat df = new DecimalFormat("#.00");
        this.precoTotal = Double.parseDouble(df.format(precoTotal).replace(",", "."));
        definePrecoDividido();
        defineCota();
        defineCotaPessoa();
    }

    public void setPrecoDividido(double precoDividido) {
        this.precoDividido = precoDividido;
    }

    public void setCota(double cota) {
        this.cota = cota;
    }

    public void showPizzasSalgadas(){

        for(Pizza i : prioridadesSalgadas){

            if(i.getQuantidade() > 0){

                System.out.println("Sabor: " + i.getSabor());
                System.out.println("Pedaços: " + i.getQuantidade() + "\n");

            }

        }

        System.out.println("-----------------------\n");

    }

    public void showRelacaoSalgadas(){

        for(Pizza i : relacaoDePizzasSalgadas){

            if(i.getQuantidade() > 0){

                System.out.println("Sabor: " + i.getSabor());
                System.out.println("Quantidade: " + i.getQuantidade()+ "\n");

            }

        }

        System.out.println("-----------------------\n");

    }

    public void showPizzasDoces(){

        for(Pizza i : prioridadesDoces){

            if(i.getQuantidade() > 0){

                System.out.println("Sabor: " + i.getSabor());
                System.out.println("Pedaços: " + i.getQuantidade() + "\n");

            }

        }

        System.out.println("-----------------------\n");

    }

    public void showRelacaoDoces(){

        for(Pizza i : relacaoDePizzasDoces){

            if(i.getQuantidade() > 0){

                System.out.println("Sabor: " + i.getSabor());
                System.out.println("Quantidade: " + i.getQuantidade()+ "\n");

            }

        }

        System.out.println("-----------------------\n");

    }

    public void showPessoas(){

        for(Pessoa i : pessoas){

            System.out.println("Nome: " + i.getNome());
            System.out.println("Quantidade de Pedaços Salgados: " + i.getPedacosSalgadas());
            System.out.println("Quantidade de Pedaços Doces:" + i.getPedacosDoces());
            System.out.println("Votos de Pizzas Salgadas:");
            for(String j : i.getVotosSalgadas()){
                System.out.println("-" + j);
            }
            System.out.println("Votos de Pizzas Doces:");
            for(String j : i.getVotosDoces()){
                System.out.println("-" + j);
            }
            if(!(i.getNome().equals("Duda") || i.getNome().equals("duda") || i.getNome().equals("Dudinha"))) {
                System.out.println("Cota: R$" + i.getCota() + "\n");
            }
            else {
                System.out.println("Cota: Deixa que eu pago pra vc mozao! ♥ :) \n");
            }

        }

        System.out.println("-----------------------\n");

    }

}