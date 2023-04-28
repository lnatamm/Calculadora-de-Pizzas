import java.util.ArrayList;

public class Pessoa {

    private String nome;

    private int pedacosSalgadas;

    private ArrayList<String> votosSalgadas;

    private int pedacosDoces;

    private ArrayList<String> votosDoces;

    private double cota;


    public Pessoa(String nome, int pedacosSalgadas, ArrayList<String> votosSalgadas, int pedacosDoces, ArrayList<String> votosDoces){

        this.nome = nome;
        this.pedacosSalgadas = pedacosSalgadas;
        cota = 0;
        this.votosSalgadas = new ArrayList<>();
        for(String i : votosSalgadas) {
            this.votosSalgadas.add(i);
        }
        this.pedacosDoces = pedacosDoces;
        this.votosDoces = new ArrayList<>();
        for(String i : votosDoces){
            this.votosDoces.add(i);
        }
        this.votosDoces = votosDoces;

    }

    public String getNome(){
        return nome;
    }

    public int getPedacosSalgadas(){
        return pedacosSalgadas;
    }

    public ArrayList<String> getVotosSalgadas(){
        return votosSalgadas;
    }

    public int getPedacosDoces() {
        return pedacosDoces;
    }

    public ArrayList<String> getVotosDoces() {
        return votosDoces;
    }

    public double getCota(){
        return cota;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setPedacosSalgadas(int pedacosSalgadas){
        this.pedacosSalgadas = pedacosSalgadas;
    }

    public void setVotosSalgadas(ArrayList<String> votosSalgadas){
        this.votosSalgadas = votosSalgadas;
    }

    public void setPedacosDoces(int pedacosDoces) {
        this.pedacosDoces = pedacosDoces;
    }

    public void setVotosDoces(ArrayList<String> votosDoces) {
        this.votosDoces = votosDoces;
    }

    public void setCota(double cota){
        this.cota = cota;
    }

    public void decPedacosSalgadas(int pedacosSalgadas){
        this.pedacosSalgadas -= pedacosSalgadas;
    }

    public void decPedacosDoces(int pedacosDoces){
        this.pedacosDoces -= pedacosDoces;
    }

}