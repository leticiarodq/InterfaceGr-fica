//Pacote
package eventos;

//Imports
import java.util.ArrayList;
import java.util.List;
import itens.CatalogoDeItens;
import personagens.CatalogoDeCriaturas;

//Classe CatalogoDeEventos (Necessário para aplicar na GUI)
public class CatalogoDeEventos {

    private List<EventoClimatico> eventosClimaticos;
    private List<EventoDescoberta> eventosDescoberta;
    private List<EventoDoencaFerimento> eventosDoencaFerimento;
    private List<EventoCriatura> eventosCriatura;

    //Construtor
    public CatalogoDeEventos(CatalogoDeItens catalogoItens) {
        eventosClimaticos = new ArrayList<>();
        eventosDescoberta = new ArrayList<>();
        eventosDoencaFerimento = new ArrayList<>();
        eventosCriatura = new ArrayList<>();

        inicializarEventos();
    }

    //Método para inicializar(instanciar) todos os eventos do jogo
    private void inicializarEventos() {
        CatalogoDeCriaturas catalogo = new CatalogoDeCriaturas();

        // Eventos Climáticos
        eventosClimaticos.add(new EventoClimatico(
                "Chuva",
                "Uma forte chuva começa.",
                30,
                new String[]{"- 1 de energia e temperatura corporal"},
                new String[]{"Floresta, Lago e Rio, Montanha, Ruinas"},
                "Chuva intensa",
                100,
                new String[]{
                        "reduz energia pelo peso da roupa molhada",
                        "reduz a temperatura corporal"
                }
        ));

        eventosClimaticos.add(new EventoClimatico(
                "Nevasca",
                "Uma nevasca começa.",
                15,
                new String[]{"- 1 de energia e - 2 de temperatura corporal"},
                new String[]{"Montanhas"},
                "Nevasca intensa",
                100,
                new String[]{
                        "reduz energia pela diminuição da temperatura corporal",
                        "reduz a temperatura corporal"
                }
        ));

        eventosClimaticos.add(new EventoClimatico(
                "Calor",
                "Uma onda de calor começa.",
                25,
                new String[]{"- 2 de sede e +1 de temperatura corporal"},
                new String[]{"Caverna, Floresta, Ruinas"},
                "Calor intenso",
                100,
                new String[]{
                        "aumenta sede pelo aumento da temperatura corporal",
                        "aumenta a temperatura corporal"
                }
        ));

        // Eventos de Descoberta
        eventosDescoberta.add(new EventoDescoberta(
                "Floresta",
                "Você encontrou uma floresta.",
                100,
                new String[]{""},
                new String[]{""},
                new String[]{""},
                new String[]{""},
                new String[]{""}
        ));

        eventosDescoberta.add(new EventoDescoberta(
                "Ruínas",
                "Você encontrou ruínas antigas.",
                100,
                new String[]{""},
                new String[]{""},
                new String[]{""},
                new String[]{""},
                new String[]{""}
        ));

        eventosDescoberta.add(new EventoDescoberta(
                "Montanha",
                "Você encontrou uma floresta.",
                100,
                new String[]{""},
                new String[]{""},
                new String[]{""},
                new String[]{""},
                new String[]{""}
        ));

        eventosDescoberta.add(new EventoDescoberta(
                "Lago e Rio",
                "Você encontrou uma floresta.",
                100,
                new String[]{""},
                new String[]{""},
                new String[]{""},
                new String[]{""},
                new String[]{""}
        ));

        eventosDescoberta.add(new EventoDescoberta(
                "Caverna",
                "Você encontrou uma floresta.",
                100,
                new String[]{""},
                new String[]{""},
                new String[]{""},
                new String[]{""},
                new String[]{""}
        ));

        // Eventos Doença/Ferimento
        eventosDoencaFerimento.add(new EventoDoencaFerimento(
                "Desidratação",
                "Você está sofrendo de desidratação.",
                40,
                new String[]{"-1 energia, -1 sanidade"},
                new String[]{"sede alta"},
                new String[]{"sede baixa"},
                new String[]{"energia reduzida"},
                new String[]{"cura com água limpa"}
        ));

        eventosDoencaFerimento.add(new EventoDoencaFerimento(
                "Infecção",
                "Você está infectado.",
                30,
                new String[]{"-2 vida"},
                new String[]{"ferimento aberto"},
                new String[]{"infecção"},
                new String[]{"vida reduzida"},
                new String[]{"cura com antisséptico"}
        ));

        // Eventos Criatura
        eventosCriatura.add(new EventoCriatura(
                "Encontro um Lobo",
                "Você encontrou um lobo feroz.",
                100,
                new String[]{"dano físico"},
                new String[]{"floresta"},
                List.of(catalogo.getCriaturaPorNome("Lobo"))
        ));

        eventosCriatura.add(new EventoCriatura(
                "Encontro com Urso",
                "Você encontrou um urso perigoso.",
                100,
                new String[]{"dano físico"},
                new String[]{"montanha", "caverna"},
                List.of(catalogo.getCriaturaPorNome("Urso"))
        ));

        eventosCriatura.add(new EventoCriatura(
                "Encontro com Aranha",
                "Você encontrou uma aranha venenosa.",
                100,
                new String[]{"dano físico"},
                new String[]{"ruinas"},
                List.of(catalogo.getCriaturaPorNome("Aranha"))
        ));

        eventosCriatura.add(new EventoCriatura(
                "Encontro com Morcego",
                "Você encontrou um morcego pacífico.",
                15,
                new String[]{"nenhum"},
                new String[]{"floresta"},
                List.of(catalogo.getCriaturaPorNome("Morcego"))
        ));

        eventosCriatura.add(new EventoCriatura(
                "Encontro com Coelho",
                "Você encontrou um coelho pacífico.",
                100,
                new String[]{"nenhum"},
                new String[]{"floresta"},
                List.of(catalogo.getCriaturaPorNome("Coelho"))
        ));

        eventosCriatura.add(new EventoCriatura(
                "Encontro com Besouro",
                "Você encontrou um besouro pacífico.",
                100,
                new String[]{"nenhum"},
                new String[]{"ruinas"},
                List.of(catalogo.getCriaturaPorNome("Besouro"))
        ));

        eventosCriatura.add(new EventoCriatura(
                "Encontro com Peixe",
                "Você encontrou um peixe pacífico.",
                100,
                new String[]{"nenhum"},
                new String[]{"lagos", "rios"},
                List.of(catalogo.getCriaturaPorNome("Peixe"))
        ));
    }

    //Getter para cahar o evento por nome
    public Evento getEventoPorNome(String nome) {
        return getTodosEventos().stream()
                .filter(e -> e.getNomeEvento().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    //Retorna a lista de eventos climaticos(para exibir na GUI)
    public List<EventoClimatico> getEventosClimaticos() {
        return eventosClimaticos;
    }

    //Retorna a lista de eventos descoberta(para exibir na GUI)
    public List<EventoDescoberta> getEventosDescoberta() {
        return eventosDescoberta;
    }

    //Retorna a lista de eventos doenças/ferimentos(para exibir na GUI)
    public List<EventoDoencaFerimento> getEventosDoencaFerimento() {
        return eventosDoencaFerimento;
    }

    //Retorna a lista de eventos criatura(para exibir na GUI)
    public List<EventoCriatura> getEventosCriatura() {
        return eventosCriatura;
    }

    // Adiciona todos os elementos da lista de eventos à lista 'todos'
    public List<Evento> getTodosEventos() {
        List<Evento> todos = new ArrayList<>();
        todos.addAll(eventosClimaticos);
        todos.addAll(eventosDoencaFerimento);
        todos.addAll(eventosCriatura);
        return todos;
    }
}
