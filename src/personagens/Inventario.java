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
    public boolean adicionarItem(Item item) {
        if (pesoTotal + item.getPeso() > pesoMaximo) {
            System.out.println("Capacidade máxima de peso atingida! Não é possível adicionar " + item.getNome());
            return false;
        }

        itens.add(item);
        pesoTotal += item.getPeso();
        System.out.println(item.getNome() + " foi adicionado ao inventário.");
        return true;
    }

    // Remove item
    public boolean removerItem(String nomeItem) {
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                itens.remove(item);
                pesoTotal -= item.getPeso();
                System.out.println(item.getNome() + " foi removido do inventário.");
                return true;
            }
        }
        System.out.println("Item " + nomeItem + " não encontrado.");
        return false;
    }

    // Usa item
    public boolean usarItem(String nomeItem, Personagem personagem) {
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                item.usar(personagem);
                itens.remove(item);
                pesoTotal -= item.getPeso();
                System.out.println(item.getNome() + " foi usado e removido do inventário.");
                return true;
            }
        }
        System.out.println("Item " + nomeItem + " não encontrado.");
        return false;
    }

    // Lista itens
    public void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("Inventário vazio.");
        } else {
            System.out.println("Itens no inventário:");
            for (Item item : itens) {
                System.out.println("- " + item.getNome() + " (" + item.getPeso() + " kg)");
            }
        }
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



