//Pacote
package itens;

//Imports
import java.util.ArrayList;
import java.util.List;
import enums.PurezaAgua;

//Classe CatalogoDeItens (Necessário para aplicar na GUI)
public class CatalogoDeItens {

    private List<Alimento> alimentos;
    private List<Agua> aguas;
    private List<Arma> armas;
    private List<Ferramenta> ferramentas;
    private List<Material> materiais;
    private List<Remedio> remedios;

    //Construtor
    public CatalogoDeItens() {
        this.alimentos = new ArrayList<>();
        this.aguas = new ArrayList<>();
        this.armas = new ArrayList<>();
        this.ferramentas = new ArrayList<>();
        this.materiais = new ArrayList<>();
        this.remedios = new ArrayList<>();

        inicializarItens();
    }

    //Método para inicializar(instanciar) todos os itens do jogo
    private void inicializarItens() {
        // Alimentos
        alimentos.add(new Alimento("Enlatado", 3, 100, "Enlatado", 25, 35)); //
        alimentos.add(new Alimento("Carne", 2, 80, "Proteína", 20, 90)); //
        alimentos.add(new Alimento("Fruta", 1, 30, "Natural", 15, 5)); //

        // Aguas
        aguas.add(new Agua("Agua Pura", 2, 80, PurezaAgua.PURA , 1000)); //
        aguas.add(new Agua("Agua contaminada", 2, 80, PurezaAgua.CONTAMINADA, 500)); //

        // Armas
        armas.add(new Arma("Faca", 2, 30, "Corpo-a-corpo", 15, 1.0)); //
        armas.add(new Arma("Espada", 3, 50, "Corpo-a-corpo", 25, 1.5)); //

        // Ferramentas
        ferramentas.add(new Ferramenta("Machado", 5, 100, "Corte", 80)); //
        ferramentas.add(new Ferramenta("Picareta", 3, 60, "Escavação", 50)); //

        // Materiais
        materiais.add(new Material("Pedra", 2, 100, "Mineral", 80)); //
        materiais.add(new Material("Graveto", 1, 30, "Madeira", 40)); //

        // Remedios
        remedios.add(new Remedio("Analgésico", 1, 50, "Dor", "Alivia dores leves", 15)); //
        remedios.add(new Remedio("Antibiótico", 2, 80, "Bactéria", "Combate infecção bacteriana", 25)); //
        remedios.add(new Remedio("Bandagem", 1, 40, "Febre", "Reduz a febre", 10)); //
    }

    //Retorna a lista de itens(para exibir na GUI)
    public List<Item> obterTodosOsItens() {
        List<Item> todos = new ArrayList<>();
        todos.addAll(alimentos); //
        todos.addAll(aguas); //
        todos.addAll(armas); //
        todos.addAll(ferramentas); //
        todos.addAll(materiais); //
        todos.addAll(remedios); //
        return todos;
    }

    // Getters individuais (existentes)
    public List<Alimento> getAlimentos() { return alimentos; } //
    public List<Agua> getAguas() { return aguas; } //
    public List<Arma> getArmas() { return armas; } //
    public List<Ferramenta> getFerramentas() { return ferramentas; } //
    public List<Material> getMateriais() { return materiais; } //
    public List<Remedio> getRemedios() { return remedios; } //

    //Getter especifico para alimento
    public Alimento getAlimentoPorNome(String nome) {
        for (Alimento alimento : alimentos) { //
            if (alimento.getNome().equalsIgnoreCase(nome)) { //
                return alimento; //
            }
        }
        return null;
    }

    //Getter para buscar o item pelo nome
    public Item getItemPorNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return null;
        }

        for (Item item : obterTodosOsItens()) { //
            if (item.getNome().equalsIgnoreCase(nome)) {
                return item;
            }
        }

        return null; // Item não encontrado em nenhuma das listas
    }
}