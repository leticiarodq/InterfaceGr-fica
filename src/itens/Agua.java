//Pacote
package itens;

//Imports
import enums.PurezaAgua;
import exceptions.SedeCheiaException;
import personagens.Personagem;

//Agua é uma subclasse de Item
public class Agua extends Item {
    private PurezaAgua pureza; // Novo
    private int volume;

    //Construtor
    public Agua(String nome, int peso, int durabilidade, PurezaAgua pureza, int volume) {
        super(nome, peso, durabilidade);
        this.pureza = pureza;
        this.volume = volume;
    }

    //Getters
    public PurezaAgua getPureza() {
        return pureza;
    }

    public String getPurezaDescricao() {
        return pureza.getDescricao();
    }

    public int getVolume() {
        return volume;
    }

    //Setter
    public void setVolume(int volume) {
        this.volume = volume;
    }

    //Método Beber adaptado a aplicação na GUI(contém exceção)
    public String beber(Personagem personagem) {
        if (personagem.getSede() >= 100) {
            throw new SedeCheiaException(personagem.getNome() + " já está com a sede cheia.");
        }
        personagem.recuperarSede(volume);
        return personagem.getNome() + " bebeu " + getNome() + " e recuperou " + volume + " de sede.";
    }

    //Método override de Item
    @Override
    public void usar(Personagem personagem) {
        beber(personagem);
    }
}
