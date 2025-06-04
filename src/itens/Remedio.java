//Pacote
package itens;

//Imports
import exceptions.VidaCheiaException;
import personagens.Personagem;

//Remedio é uma subclasse de Item
public class Remedio extends Item {
    private String tipo;
    private String efeito;
    private int cura;

    //Construtor
    public Remedio(String nome, int peso, int durabilidade, String tipo, String efeito, int cura) {
        super(nome, peso, durabilidade);
        this.tipo = tipo;
        this.efeito = efeito;
        this.cura = cura;
    }

    //Getters
    public String getTipo() {
        return tipo;
    }

    public String getEfeito() {
        return efeito;
    }

    public int getCura() {
        return cura;
    }

    //Setters
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setEfeito(String efeito) {
        this.efeito = efeito;
    }

    public void setCura(int cura) {
        this.cura = cura;
    }

    // Método curar lança exceção unchecked se a vida estiver cheia
    public String curar(Personagem personagem) {
        if (personagem.getVida() >= 100) {
            throw new VidaCheiaException(personagem.getNome() + " já está com a vida cheia.");
        }
        personagem.recuperarVida(cura);
        return personagem.getNome() + " foi curado em " + cura + " pontos de vida.";
    }

    // //Método override de Item
    @Override
    public void usar(Personagem personagem) {
        curar(personagem);
    }

    // Sobrescreve o método toString() para que o objeto seja representado pelo seu nome por garantia de segurança
    @Override
    public String toString() {
        return getNome();
    }
}
