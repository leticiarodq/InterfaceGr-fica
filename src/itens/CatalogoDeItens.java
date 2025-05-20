package itens;

import java.util.ArrayList;
import java.util.List;

public class CatalogoDeItens {

    private List<Alimento> alimentos;
    private List<Agua> aguas;
    private List<Arma> armas;
    private List<Ferramenta> ferramentas;
    private List<Material> materiais;
    private List<Remedio> remedios;

    public CatalogoDeItens() {
        this.alimentos = new ArrayList<>();
        this.aguas = new ArrayList<>();
        this.armas = new ArrayList<>();
        this.ferramentas = new ArrayList<>();
        this.materiais = new ArrayList<>();
        this.remedios = new ArrayList<>();

        inicializarItens();
    }
    //Os valores ainda não estão definidos corretamente
    private void inicializarItens() {
        // Alimentos
        alimentos.add(new Alimento("Enlatado", 3, 100, "Enlatado", 25, 35));
        alimentos.add(new Alimento("Carne", 2, 80, "Proteína", 20, 90));
        alimentos.add(new Alimento("Fruta", 1, 30, "Natural", 15, 5));

        // Aguas
        aguas.add(new Agua("Agua Pura", 2, 100, "Limpa", 1000));
        aguas.add(new Agua("Agua Impura", 2, 80, "Suja", 500));

        // Armas
        armas.add(new Arma("Faca", 2, 30, "Corpo-a-corpo", 15.0, 1.0));
        armas.add(new Arma("Espada", 3, 50, "Corpo-a-corpo", 25.0, 1.0));

        // Ferramentas
        ferramentas.add(new Ferramenta("Machado", 5, 100, "Corte", 80));
        ferramentas.add(new Ferramenta("Picareta", 3, 60, "Escavação", 50));

        // Materiais
        materiais.add(new Material("Pedra", 2, 100, "Mineral", 80));
        materiais.add(new Material("Graveto", 1, 30, "Madeira", 40));

        // Remedios
        remedios.add(new Remedio("Analgésico", 1, 50, "Dor", "Alivia dores leves", 15));
        remedios.add(new Remedio("Antibiótico", 2, 80, "Bactéria", "Combate infecção bacteriana", 25));
        remedios.add(new Remedio("Bandagem", 1, 40, "Febre", "Reduz a febre", 10));
    }

    public List<Item> obterTodosOsItens() {
        List<Item> todos = new ArrayList<>();
        todos.addAll(alimentos);
        todos.addAll(aguas);
        todos.addAll(armas);
        todos.addAll(ferramentas);
        todos.addAll(materiais);
        todos.addAll(remedios);
        return todos;
    }

    // Getters individuais se precisar acessar separadamente
    public List<Alimento> getAlimentos() {
        return alimentos;
    }
    public List<Agua> getAguas() {
        return aguas;
    }
    public List<Arma> getArmas() {
        return armas;
    }
    public List<Ferramenta> getFerramentas() {
        return ferramentas;
    }
    public List<Material> getMateriais() {
        return materiais;
    }
    public List<Remedio> getRemedios() {
        return remedios;
    }
}
