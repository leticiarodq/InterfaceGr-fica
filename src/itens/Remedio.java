package itens;

import interfaces.AcaoCurar;
import personagens.Personagem;
import exceptions.VidaCheiaException;

public class Remedio extends Item implements AcaoCurar {
    private String tipo;
    private String efeito;
    private int cura;

    public Remedio(String nome, int peso, int durabilidade, String tipo, String efeito, int cura) {
        super(nome, peso, durabilidade);
        this.tipo = tipo;
        this.efeito = efeito;
        this.cura = cura;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEfeito() {
        return efeito;
    }

    public int getCura() {
        return cura;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setEfeito(String efeito) {
        this.efeito = efeito;
    }

    public void setCura(int cura) {
        this.cura = cura;
    }

    // Método curar com Exception(Aplicar Try Catch no GUI)
    public void curar(Personagem personagem)  {
        if (personagem.getVida() >= 100) {
            throw new VidaCheiaException(personagem.getNome() + " já está com a vida cheia.");
        }
        personagem.recuperarVida(cura);
    }

    @Override
    public String toString() {
        return getNome();
    }
}
