//Pacote
package eventos;

//Imports
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import ambientes.Ambiente;
import personagens.Personagem;
import itens.CatalogoDeItens;

//Classe de gerenciamento de eventos
public class GerenciadorDeEventos {

    private CatalogoDeEventos catalogoDeEventos;
    private Random random;

    private int contadorClimatico;
    private int contadorDoenca;

    private final int INTERVALO_VERIFICACAO_CLIMA = 1200;
    private final int INTERVALO_VERIFICACAO_DOENCA = 600;

    //Construtor
    public GerenciadorDeEventos(CatalogoDeItens catalogoItens) {
        this.catalogoDeEventos = new CatalogoDeEventos(catalogoItens);
        this.random = new Random();
        this.contadorClimatico = 0;
        this.contadorDoenca = 0;
    }

    public String processarEventosPeriodicos(Personagem personagem, Ambiente ambiente) {
        String resultadoEvento = null;

        // Processa Eventos Climáticos
        contadorClimatico++;
        if (contadorClimatico >= INTERVALO_VERIFICACAO_CLIMA) {
            contadorClimatico = 0;
            resultadoEvento = sortearEExecutarEvento(personagem, ambiente, EventoClimatico.class);
            if (resultadoEvento != null) return resultadoEvento;
        }

        // Processa Efeitos Contínuos de Doenças
        contadorDoenca++;
        if (contadorDoenca >= INTERVALO_VERIFICACAO_DOENCA) {
            contadorDoenca = 0;

            EventoDoencaFerimento eventoSaude = (EventoDoencaFerimento) catalogoDeEventos.getEventoPorNome("Desidratação"); // Você precisará deste método em CatalogoDeEventos

            if (eventoSaude != null) {
                resultadoEvento = eventoSaude.aplicarEfeitoContinuoDesidratacao(personagem);
                if (resultadoEvento != null) return resultadoEvento;
                resultadoEvento = eventoSaude.aplicarEfeitoContinuoInfeccao(personagem);
                if (resultadoEvento != null) return resultadoEvento;
            }
        }

        return null;
    }

    private <T extends Evento> String sortearEExecutarEvento(Personagem personagem, Ambiente ambiente, Class<T> tipoDeEvento) {
        List<Evento> eventosCompativeis = catalogoDeEventos.getTodosEventos().stream()
                .filter(tipoDeEvento::isInstance)
                .filter(evento -> eventoCompativel(evento, ambiente))
                .collect(Collectors.toList());

        if (eventosCompativeis.isEmpty()) {
            return null;
        }

        Evento eventoEscolhido = eventosCompativeis.get(random.nextInt(eventosCompativeis.size()));

        if (random.nextInt(100) < eventoEscolhido.getProbabilidadeOcorrencia()) {
            return eventoEscolhido.executar(personagem, ambiente);
        }

        return null;
    }

    private boolean eventoCompativel(Evento evento, Ambiente ambiente) {
        if (evento.getCondicaoAtivacao().isEmpty() || evento.getCondicaoAtivacao().get(0).isEmpty()) {
            return true;
        }

        String nomeAmbiente = ambiente.getNomeAmbiente();
        for (String condicao : evento.getCondicaoAtivacao()) {
            if (nomeAmbiente.equalsIgnoreCase(condicao)) {
                return true;
            }
        }
        return false;
    }
}