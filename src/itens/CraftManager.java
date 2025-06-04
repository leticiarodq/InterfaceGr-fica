//Pacote
package itens;

//Imports
import exceptions.ReceitaInvalidaException;

import java.util.List;

//Classe de gerenciamento de craft
public class CraftManager {

    // Cria uma nova FerramentaCombinada a partir de uma lista de materiais.
    public FerramentaCombinada craft(List<Material> materiais) {
        int pedras = 0;
        int gravetos = 0;

        // Conta quantos materiais de cada tipo foram passados
        for (Material m : materiais) {
            if (m.getNome().equalsIgnoreCase("pedra")) {
                pedras++;
            } else if (m.getNome().equalsIgnoreCase("graveto")) {
                gravetos++;
            }
        }

        // Verifica as receitas:
        // Machadinho: 2 pedras + 2 gravetos
        if (pedras == 2 && gravetos == 2 && materiais.size() == 4) {
            return new FerramentaCombinada("Machadinho", 5, 100, "Machado", 50);
        }

        // Picareta: 3 pedras + 2 gravetos
        if (pedras == 3 && gravetos == 2 && materiais.size() == 5) {
            return new FerramentaCombinada("Picareta", 6, 120, "Picareta", 70);
        }

        // Se não bate com nenhuma receita
        throw new ReceitaInvalidaException("Receita inválida!");
    }
}
