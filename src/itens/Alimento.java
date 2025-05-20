package itens;

import exceptions.FomeCheiaException;
import personagens.Personagem;

public class Alimento extends Item {
    private int valornutricional;
    private String tipo;
    private int prazodevalidade;

    public Alimento(String nome, int peso, int durabilidade, String tipo, int valornutricional, int prazodevalidade) {
        super(nome, peso, durabilidade);
        this.valornutricional = valornutricional;
        this.tipo = tipo;
        this.prazodevalidade = prazodevalidade;
    }

    public int getValorNutricional() {
        return valornutricional;
    }

    public String getTipo() {
        return tipo;
    }

    public int getPrazodeValidade() {
        return prazodevalidade;
    }

    public void setValorNutricional(int valornutricional) {
        this.valornutricional = valornutricional;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPrazodeValidade(int prazodevalidade) {
        this.prazodevalidade = prazodevalidade;
    }

    public String consumir(Personagem personagem) {
        if (personagem.getFome() >= 100) {
            throw new FomeCheiaException(personagem.getNome() + " já está com a fome totalmente saciada.");
        }
        personagem.recuperarFome(valornutricional);
        return personagem.getNome() + " consumiu " + getNome() + " e recuperou " + valornutricional + " de fome.";
    }

    @Override
    public void usar(Personagem personagem) {
        consumir(personagem);
    }
}
