//Pacote
package itens;

//Imports
import exceptions.CombinarException;
import personagens.Personagem;

import java.util.List;

//Material é uma subclasse de Item
public class Material extends Item {
    private String tipo;
    private int resistencia;

    //Construtor
    public Material(String nome, int peso, int durabilidade, String tipo, int resistencia) {
        super(nome, peso, durabilidade);
        this.tipo = tipo;
        this.resistencia = resistencia;
    }

    //Getters
    public String getTipo() {
        return tipo;
    }

    public int getResistencia() {
        return resistencia;
    }

    //Setters
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    // Método combinar com exception (Aplicar Try Catch na GUI)
    public Item combinar(List<Material> materiais) throws CombinarException {
        CraftManager craftManager = new CraftManager();
        FerramentaCombinada ferramenta = craftManager.craft(materiais);
        if (ferramenta != null) {
            return ferramenta;  // Retorna a ferramenta criada
        } else {
            // Lança exceção que o front deve capturar e mostrar para o usuário
            throw new CombinarException("Não foi possível criar nenhuma ferramenta com esses materiais.");
        }
    }

    //Método override de Item
    @Override
    public void usar(Personagem personagem) {
        // Como o Material não é "usável" diretamente, lançamos exceção
        throw new UnsupportedOperationException("Material não pode ser usado diretamente. Use combinar para criar ferramentas.");
    }

}
