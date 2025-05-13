package itens; // Define que esta classe pertence ao pacote 'itens'

import personagens.Personagem;


// A classe Remedio é uma subclasse da classe Item
public class Remedio extends Item {
    private String tipo;
    private String efeito;
    private int cura;

    //Construtor
    public Remedio (String nome, int peso, int durabilidade,String tipo, String efeito, int cura) {
        super(nome, peso, durabilidade); // Chama o construtor da superclasse Item
        this.tipo = tipo;
        this.efeito = efeito;
        this.cura = cura;
    }

    //Método getters
    public String getTipo(){
        return tipo;
    }

    public String getEfeito(){
        return efeito;
    }

    public int getCura(){
        return cura;
    }

    //Método setters
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public void setEfeito(String efeito){
        this.efeito = efeito;
    }

    public void setCura(int cura){
        this.cura = cura;
    }

    //Método usar
    public void usar(Personagem personagem){
        personagem.recuperacaodeVida(cura);
        System.out.println("Você usou um remédio do tipo " + tipo + " com efeito: " + efeito);
    }
}
