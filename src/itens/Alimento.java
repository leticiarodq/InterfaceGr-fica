package itens; // Define que esta classe pertence ao pacote 'itens'

import personagens.Personagem;

// A classe é uma subclasse da classe Item
public abstract class Alimento extends Item{
    private int valornutricional;
    private String tipo;
    private int prazodevalidade;

    //Construtor
    public Alimento(String nome, int peso, int durabilidade, String tipo, int valornutricional, int prazodevalidade){
        super(nome, peso, durabilidade);
        this.valornutricional = valornutricional;
        this.tipo = tipo;
        this.prazodevalidade = prazodevalidade;
    }

    //Método getters
    public int getValorNutricional(){
        return valornutricional;
    }

    public String getTipo(){
        return tipo;
    }

    public int getPrazodeValidade(){
        return prazodevalidade;
    }

    //Método Setters
    public void setValorNutricional(int valornutricional){
        this.valornutricional = valornutricional;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public void setPrazodeValidade(int prazodevalidade){
        this.prazodevalidade = prazodevalidade;
    }

    //Método Consumir
    public void consumir(Personagem personagem){
        personagem.recuperacaodeFome(valornutricional);
        System.out.println(personagem.getNome() + " consumiu " + getNome() + " e recuperou " + valornutricional + " de fome.");
    }

    public void usar(Personagem personagem) {
        consumir(personagem);
    }

}
