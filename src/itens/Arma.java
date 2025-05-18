package itens; // Define que esta classe pertence ao pacote 'itens'

//Imports necessarios para ter relação direta com gui.criaturas

import eventos.EventoCriatura;
import personagens.Personagem;

// A classe Arma é uma subclasse da classe Item
public abstract class Arma extends Item{
    private String tipo;
    private double dano;
    private double distancia;

    //Construtor
    public Arma(String nome, int peso, int durabilidade, String tipo, double dano, double distancia) {
        super(nome, peso, durabilidade);
        this.tipo = tipo;
        this.dano = dano;
        this.distancia = distancia;
    }

    //Metodo Getters
    public String getTipo(){
        return tipo;
    }

    public double getDano(){
        return dano;
    }

    public double getDistancia(){
        return distancia;
    }

    //Metodos Setters
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public void setDano(double dano){
        this.dano = dano;
    }

    public void setDistancia(double distancia){
        this.distancia = distancia;
    }

    //Metodo atacar
    public void atacar(EventoCriatura inimigo) {
        if (getDurabilidade() > 0) {
            inimigo.receberDano(dano); // Aplica dano ao inimigo (precisa implementar em Alvo ou Inimigo)
            System.out.println("Você atacou com uma arma " + tipo + " causando " + dano + " de dano.");
            setDurabilidade(getDurabilidade() - 1); // Reduz durabilidade da arma
        } else {
            System.out.println("A arma está quebrada e não pode ser usada.");
        }
    }

    public void usar(Personagem personagem, EventoCriatura inimigo) {
        atacar(inimigo);
    }

}

