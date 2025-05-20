package eventos;

import ambientes.Ambiente;
import interfaces.AcaoEvento;
import personagens.Personagem;

import java.util.Arrays;
import java.util.List;

public abstract class Evento implements AcaoEvento {

    private String nomeEvento;
    private String descricaoEvento;
    private int probabilidadeOcorrencia;
    private List<String> impactoEvento;
    private List<String> condicaoAtivacao;

    public Evento(String nomeEvento, String descricaoEvento, int probabilidadeOcorrencia, String[] impacto, String[] condicao){
        this.nomeEvento=nomeEvento;
        this.descricaoEvento=descricaoEvento;
        this.probabilidadeOcorrencia=probabilidadeOcorrencia;
        this.impactoEvento= Arrays.asList(impacto);
        this.condicaoAtivacao=Arrays.asList(condicao);

    }

    public String getNomeEvento(){
        return nomeEvento;
    }

    public String getDescricaoEvento(){
        return descricaoEvento;
    }

    public int getProbabilidadeOcorrencia(){
        return probabilidadeOcorrencia;
    }

    public List<String> getImpactoEvento() {
        return impactoEvento;
    }

    public List<String> getCondicaoAtivacao(){
        return condicaoAtivacao;
    }

    public abstract void executar(Personagem personagem, Ambiente local);
}
