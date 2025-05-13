package eventos;

import java.util.Arrays;
import java.util.List;

public class EventoDescoberta extends Evento {

    private List<String> tipoDescoberta;
    private List<String> recursosEncontrados;
    private List<String> condicaoEspecial;

    public EventoDescoberta(String nomeEvento, String descricaoEvento, int probabilidadeOcorrencia, String[] impacto, String[] condicaoAtivacao,
                           String[] descoberta, String[] encontrados, String[] especial) {

        super(nomeEvento, descricaoEvento, probabilidadeOcorrencia, impacto, condicaoAtivacao);

        this.tipoDescoberta = Arrays.asList(descoberta);
        this.recursosEncontrados = Arrays.asList(encontrados);
        this.condicaoEspecial = Arrays.asList(especial);
    }

    public List<String> getTipoDescoberta() {
        return tipoDescoberta;
    }

    public List<String> getRecursosEncontrados() {
        return recursosEncontrados;
    }

    public List<String> getCondicaoEspecial() {
        return condicaoEspecial;
    }
}