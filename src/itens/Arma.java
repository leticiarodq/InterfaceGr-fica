//Pacote
package itens;

//Imports
import eventos.EventoCriatura;
import exceptions.ArmaQuebradaException;
import personagens.Criatura;
import personagens.Personagem;

//Arma é uma subclasse de Item
public class Arma extends Item {
    private String tipo;
    private double dano;
    private double distancia;
    private EventoCriatura inimigo; // Inimigo a ser atacado

    //Construtor
    public Arma(String nome, int peso, int durabilidade, String tipo, double dano, double distancia) {
        super(nome, peso, durabilidade);
        this.tipo = tipo;
        this.dano = dano;
        this.distancia = distancia;
    }

    // Getters
    public String getTipo() {
        return tipo;
    }

    public double getDano() {
        return dano;
    }

    public double getDistancia() {
        return distancia;
    }

    //Setters
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
    public void atacar(Criatura inimigo) {
        if (getDurabilidade() <= 0) {
            throw new ArmaQuebradaException("A arma está quebrada e não pode ser usada.");
        }
        inimigo.receberDano(dano);
        setDurabilidade(getDurabilidade() - 1);
    }


    //Método override de Item
    @Override
    public void usar(Personagem personagem) {
        if (inimigo == null) {
            throw new IllegalStateException("Nenhum inimigo definido para ataque.");
        }
        atacar(inimigo.getCriaturaAtual());
    }

    // Sobrescreve o método toString() para que o objeto seja representado pelo seu nome por garantia de segurança
    @Override
    public String toString() {
        return getNome();
    }
}
