//Pacote
package eventos;

//Imports
import ambientes.Ambiente;
import itens.CatalogoDeItens;
import itens.Item;
import personagens.Personagem;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

//EventoDescoberta é uma subclasse de Evento
public class EventoDescoberta extends Evento {

    private List<String> tipoDescoberta;
    private List<String> recursosEncontrados;
    private List<String> condicaoEspecial; //

    //Construtor
    public EventoDescoberta(String nomeEvento, String descricaoEvento, int probabilidadeOcorrencia, String[] impacto,
                            String[] condicaoAtivacao, String[] tipoDescoberta, String[] recursosEncontrados, String[] condicaoEspecial) {
        super(nomeEvento, descricaoEvento, probabilidadeOcorrencia, impacto, condicaoAtivacao);
        this.tipoDescoberta = Arrays.asList(tipoDescoberta);
        this.recursosEncontrados = Arrays.asList(recursosEncontrados);
        this.condicaoEspecial = Arrays.asList(condicaoEspecial);
    }

    //Retorna a lista dos tipos de descoberta
    public List<String> getTipoDescoberta() {
        return tipoDescoberta;
    }

    //Retorna a lista dos recursos encontrados
    public List<String> getRecursosEncontrados() {
        return recursosEncontrados;
    }

    //Retorna a lista das condições especiais
    public List<String> getCondicaoEspecial() {
        return condicaoEspecial;
    }

    //Método override de Evento
    @Override
    public String executar(Personagem personagem, Ambiente local) {
        StringBuilder mensagem = new StringBuilder();
        Random random = new Random();

        String descobertaRealizada = this.getDescricaoEvento();
        if (tipoDescoberta != null && !tipoDescoberta.isEmpty() && !tipoDescoberta.get(0).isEmpty()) {
            descobertaRealizada = tipoDescoberta.get(random.nextInt(tipoDescoberta.size()));
        }

        mensagem.append("Descoberta: ").append(descobertaRealizada).append(".\n");

        if (condicaoEspecial != null && !condicaoEspecial.isEmpty() && !condicaoEspecial.get(0).isEmpty()) {
            mensagem.append("Observação: ").append(String.join(", ", condicaoEspecial)).append(".\n");
        }

        if (recursosEncontrados != null && !recursosEncontrados.isEmpty() && !recursosEncontrados.get(0).isEmpty()) {
            mensagem.append("Parece que você pode encontrar aqui: ").append(String.join(", ", recursosEncontrados)).append(".");
        } else {
            mensagem.append("Não parece haver nada de valor imediato aqui, mas o conhecimento é uma recompensa.");
        }

        return mensagem.toString();
    }

    //Método de coletar um recurso encontrado
    public String coletarRecursos(Personagem personagem, CatalogoDeItens catalogo) {
        if (recursosEncontrados == null || recursosEncontrados.isEmpty() || recursosEncontrados.get(0).isEmpty()) {
            return "Não há recursos específicos para coletar nesta descoberta.";
        }

        StringBuilder resultadoColeta = new StringBuilder();
        boolean itemColetado = false;

        for (String nomeRecurso : recursosEncontrados) {
            Item itemParaColetar = catalogo.getItemPorNome(nomeRecurso);

            if (itemParaColetar != null) {
                if (personagem.getInventario().adicionarItem(itemParaColetar)) {
                    resultadoColeta.append("Você coletou: ").append(itemParaColetar.getNome()).append(".\n");
                    itemColetado = true;
                } else {
                    resultadoColeta.append("Seu inventário está cheio, não foi possível pegar: ").append(itemParaColetar.getNome()).append(".\n");
                }
            } else {
                resultadoColeta.append("Recurso '").append(nomeRecurso).append("' não encontrado no catálogo para coleta.\n");
            }
        }
        return resultadoColeta.toString().trim();
    }
}