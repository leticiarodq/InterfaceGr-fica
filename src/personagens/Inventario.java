package personagens;

import itens.Item;
import java.util.ArrayList;

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

    // Adiciona item
    public void adicionarItem(Item item) throws IllegalStateException {
        if (pesoTotal + item.getPeso() > pesoMaximo) {
            throw new IllegalStateException("Capacidade máxima de peso atingida! Não é possível adicionar " + item.getNome());
        }
        itens.add(item);
        pesoTotal += item.getPeso();
    }

    // Remove item pelo nome
    public void removerItem(String nomeItem) throws IllegalArgumentException {
        Item itemParaRemover = null;
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                itemParaRemover = item;
                break;
            }
        }
        if (itemParaRemover != null) {
            itens.remove(itemParaRemover);
            pesoTotal -= itemParaRemover.getPeso();
        } else {
            throw new IllegalArgumentException("Item " + nomeItem + " não encontrado no inventário.");
        }
    }

    // Usa item pelo nome
    public void usarItem(String nomeItem, Personagem personagem) throws IllegalArgumentException {
        Item itemParaUsar = null;
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                itemParaUsar = item;
                break;
            }
        }
        if (itemParaUsar != null) {
            itemParaUsar.usar(personagem);
            itens.remove(itemParaUsar);
            pesoTotal -= itemParaUsar.getPeso();
        } else {
            throw new IllegalArgumentException("Item " + nomeItem + " não encontrado no inventário.");
        }
    }

    // Retorna lista de itens (para exibir na GUI)
    public ArrayList<Item> getItens() {
        return new ArrayList<>(itens); // Retorna cópia para evitar alterações externas
    }

    // Peso atual
    public double getPesoTotal() {
        return pesoTotal;
    }

    // Espaço disponível baseado no peso
    public double getEspacoDisponivel() {
        return pesoMaximo - pesoTotal;
    }

    // Peso máximo
    public double getPesoMaximo() {
        return pesoMaximo;
    }
}
