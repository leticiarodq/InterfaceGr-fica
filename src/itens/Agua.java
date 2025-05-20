package itens;

import exceptions.SedeCheiaException;
import personagens.Personagem;

public class Agua extends Item {
    private String pureza;
    private int volume;

    public Agua(String nome, int peso, int durabilidade, String pureza, int volume) {
        super(nome, peso, durabilidade);
        this.pureza = pureza;
        this.volume = volume;
    }

    public String getPureza() {
        return pureza;
    }

    public int getVolume() {
        return volume;
    }

    public void setPureza(String pureza) {
        this.pureza = pureza;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String beber(Personagem personagem) {
        if (personagem.getSede() >= 100) {
            throw new SedeCheiaException(personagem.getNome() + " já está com a sede cheia.");
        }
        personagem.recuperarSede(volume);
        return personagem.getNome() + " bebeu " + getNome() + " e recuperou " + volume + " de sede.";
    }

    @Override
    public void usar(Personagem personagem) {
        beber(personagem);
    }
}
