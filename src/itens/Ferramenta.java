package itens;// Define que esta classe pertence ao pacote 'itens'

//Imports necessarios

import personagens.Personagem;

// A classe Ferramenta é uma subclasse da classe Item
public abstract class Ferramenta extends Item{
    private String tipo;
    private int eficiencia;

    //Construtor
    public Ferramenta(String nome, int peso, int durabilidade,String tipo, int eficiencia){
        super(nome, peso, durabilidade);
        this.tipo = tipo;
        this.eficiencia = eficiencia;
    }

    //Método getters
    public int getEficiencia(){
        return eficiencia;
    }

    public String getTipo(){
        return tipo;
    }

    //Métodos setters
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public void setEficiencia(int eficiencia){
        this.eficiencia = eficiencia;
    }

    //Método usar
    public void usar(Personagem personagem){
        setDurabilidade(getDurabilidade() - 1);
        System.out.println("Você usou a ferramenta: " + getNome());
    }

}
