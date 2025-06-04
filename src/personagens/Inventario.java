//Pacote
package personagens;

//Import
import itens.Item;

import java.util.ArrayList;

//Classe Inventario
public class Inventario {
    private ArrayList<Item> itens;
    private double pesoMaximo;
    private double pesoTotal;

    // Construtor
    public Inventario(double pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
        this.itens = new ArrayList<>();
        this.pesoTotal = 0.0;
    }

    // Adiciona item por uma condicional(retorna true se conseguiu, false se não)
    public boolean adicionarItem(Item item) {
        if (pesoTotal + item.getPeso() > pesoMaximo) {
            return false; // Não adicionou por ultrapassar peso máximo
        }
        itens.add(item);
        pesoTotal += item.getPeso();
        return true;// Tudo certo pode seguir o procedimento de adicionar o item
    }

    // Remove item por um loop(for each) + condicional pelo nome (retorna true se removeu, false se não encontrou)
    public boolean removerItem(String nomeItem) {
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                itens.remove(item);
                pesoTotal -= item.getPeso();
                return true; // Remoção com sucesso
            }
        }
        return false; // Item não encontrado
    }

    // Usa item pelo nome (retorna true se usou, false se não encontrou)
    public boolean usarItem(String nomeItem, Personagem personagem) {
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                item.usar(personagem);
                itens.remove(item);
                pesoTotal -= item.getPeso();
                return true; // Uso com sucesso
            }
        }
        return false; // Item não encontrado
    }

    // Retorna lista de itens (para exibir na GUI)
    public ArrayList<Item> getItens() {
        return new ArrayList<>(itens); // Cópia da lista
    }

    //Getter do PesoTotal
    public double getPesoTotal() {
        return pesoTotal;
    }

    // Espaço disponível baseado no peso
    public double getEspacoDisponivel() {
        return pesoMaximo - pesoTotal;
    }

    //Getter do Peso máximo
    public double getPesoMaximo() {
        return pesoMaximo;
    }
}
