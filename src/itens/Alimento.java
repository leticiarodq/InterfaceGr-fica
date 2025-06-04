//Pacote
package itens;

//Imports
import exceptions.FomeCheiaException;
import personagens.Personagem;

//Alimento é uma subclasse de Item
public class Alimento extends Item {
    private int valornutricional;
    private String tipo;
    private int prazodevalidade;

    //Construtor
    public Alimento(String nome, int peso, int durabilidade, String tipo, int valornutricional, int prazodevalidade) {
        super(nome, peso, durabilidade);
        this.valornutricional = valornutricional;
        this.tipo = tipo;
        this.prazodevalidade = prazodevalidade;
    }

    //Getters
    public int getValorNutricional() {
        return valornutricional;
    }

    public String getTipo() {
        return tipo;
    }

    public int getPrazodeValidade() {
        return prazodevalidade;
    }

    //Setters
    public void setValorNutricional(int valornutricional) {
        this.valornutricional = valornutricional;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPrazodeValidade(int prazodevalidade) {
        this.prazodevalidade = prazodevalidade;
    }

    //Método consumir adaptado a GUI(contem exceção)
    public String consumir(Personagem personagem) {
        if (personagem.getFome() >= 6) {
            throw new FomeCheiaException(personagem.getNome() + " já está com a fome totalmente saciada.");
        }
        personagem.recuperarFome(valornutricional);
        personagem.recuperarEnergia(valornutricional);
        return personagem.getNome() + " consumiu " + getNome() + " e recuperou " + valornutricional + " de fome.";
    }

    //Método override de Item
    @Override
    public void usar(Personagem personagem) {
        consumir(personagem);
    }
}
