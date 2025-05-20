package itens; // Define que esta classe pertence ao pacote 'itens'

import interfaces.AcaoUsar;
import personagens.Personagem;

// Declaração da classe pública 'Item'
public abstract class Item implements AcaoUsar {
    private String nome;
    private int peso;
    private int durabilidade;

    //Construtor
    public Item(String nome, int peso, int durabilidade){
        this.nome = nome;
        this.peso = peso;
        this.durabilidade = durabilidade;
    }

    //Metodos getters
    public String getNome(){
        return nome;
    }

    public int getPeso(){
        return peso;
    }

    public int getDurabilidade(){
        return durabilidade;
    }

    //Metodos Setters
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setDurabilidade(int durabilidade){
        this.durabilidade = durabilidade;
    }

    public abstract void usar(Personagem personagem);
}
