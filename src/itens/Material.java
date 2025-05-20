package itens;

import exceptions.CombinarException;
import interfaces.Combinavel;

import java.util.List;

public class Material extends Item implements Combinavel {
    private String tipo;
    private int resistencia;

    public Material(String nome, int peso, int durabilidade, String tipo, int resistencia) {
        super(nome, peso, durabilidade);
        this.tipo = tipo;
        this.resistencia = resistencia;
    }

    public String getTipo() {
        return tipo;
    }

    public int getResistencia() {
        return resistencia;
    }

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
}
