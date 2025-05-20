package eventos;

import ambientes.Ambiente;
import personagens.Personagem;

import java.util.Arrays;
import java.util.List;


public class EventoDoencaFerimento extends Evento{

    private List<String> tipoCondicao;
    private List<String> tipoImpacto;
    private List<String> curaDisponivel;

    public EventoDoencaFerimento(String nomeEvento, String descricaoEvento, int probabilidadeOcorrencia, String[] impacto, String[] condicaoAtivacao,
                           String[] condicao, String[] tipoImpacto, String[] cura) {

        super(nomeEvento, descricaoEvento, probabilidadeOcorrencia, impacto, condicaoAtivacao);

        this.tipoCondicao= Arrays.asList(condicao);
        this.tipoImpacto= Arrays.asList(tipoImpacto);
        this.curaDisponivel= Arrays.asList(cura);
    }

    public List<String> getTipoCondicao(){
        return tipoCondicao;
    }

    public List<String> getTipoImpacto(){
        return tipoImpacto;
    }

    public List<String> getCuraDisponivel(){
        return curaDisponivel;
    }

    public void executar(Personagem personagem, Ambiente local){

    }

}
