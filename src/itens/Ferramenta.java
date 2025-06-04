//Pacote
package itens;

//Imports
import exceptions.FerramentaQuebradaException;
import personagens.Personagem;

// A classe Ferramenta é uma subclasse da classe Item
public class Ferramenta extends Item {
    private String tipo;
    private int eficiencia;

    //Construtor
    public Ferramenta(String nome, int peso, int durabilidade,String tipo, int eficiencia){
        super(nome, peso, durabilidade);
        this.tipo = tipo;
        this.eficiencia = eficiencia;
    }

    //Método getters
    public int getEficiencia(){
        return eficiencia;
    }

    public String getTipo(){
        return tipo;
    }

    //Métodos setters
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public void setEficiencia(int eficiencia){
        this.eficiencia = eficiencia;
    }

    @Override
    // Metodo usar com exception (Aplicar Try Catch na GUI)
    public void usar(Personagem personagem) {
        if (getDurabilidade() <= 0) {
            throw new FerramentaQuebradaException("A ferramenta " + getNome() + " está quebrada e não pode ser usada.");
        }
        setDurabilidade(getDurabilidade() - 1);
    }
}
