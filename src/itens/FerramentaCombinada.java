//Pacote
package itens;

//Imports
import exceptions.FerramentaQuebradaException;
import personagens.Personagem;

//FerramentaCombinada é uma subclasse de Ferramenta (Necessária para criar ferramentas por combinação de materiais, a classe ferramenta não é responsavel por essa combinação, necessitando uma nova instancia)
public class FerramentaCombinada extends Ferramenta {

    //Construtor
    public FerramentaCombinada(String nome, int peso, int durabilidade, String tipo, int eficiencia) {
        super(nome, peso, durabilidade, tipo, eficiencia);
    }


    @Override
    // Metodo usar com exception (Aplicar Try Catch na GUI)
    public void usar(Personagem personagem) {
        if (getDurabilidade() <= 0) {
            throw new FerramentaQuebradaException("A ferramenta combinada " + getNome() + " está quebrada e não pode ser usada.");
        }
        setDurabilidade(getDurabilidade() - 1);
    }
}
