package itens;

import eventos.EventoCriatura;
import exceptions.ArmaQuebradaException;
import interfaces.Atacavel;
import personagens.Personagem;

public class Arma extends Item implements Atacavel {
    private String tipo;
    private double dano;
    private double distancia;
    private EventoCriatura inimigo; // Inimigo a ser atacado

    public Arma(String nome, int peso, int durabilidade, String tipo, double dano, double distancia) {
        super(nome, peso, durabilidade);
        this.tipo = tipo;
        this.dano = dano;
        this.distancia = distancia;
    }

    // Getters e Setters
    public String getTipo() {
        return tipo;
    }

    public double getDano() {
        return dano;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDano(double dano) {
        this.dano = dano;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public void setInimigo(EventoCriatura inimigo) {
        this.inimigo = inimigo;
    }

    public EventoCriatura getInimigo() {
        return inimigo;
    }

    // Lógica do ataque
    public void atacar(EventoCriatura inimigo) {
        if (getDurabilidade() <= 0) {
            throw new ArmaQuebradaException("A arma está quebrada e não pode ser usada.");
        }
        inimigo.receberDano(dano);
        setDurabilidade(getDurabilidade() - 1);
    }

    // Método usar sobrescrito
    @Override
    public void usar(Personagem personagem) {
        if (inimigo == null) {
            throw new IllegalStateException("Nenhum inimigo definido para ataque.");
        }
        atacar(inimigo); // Lógica do back-end
    }

    @Override
    public String toString() {
        return getNome();
    }
}
