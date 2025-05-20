package eventos;

import ambientes.Ambiente;
import personagens.Personagem;

import java.util.Arrays;
import java.util.List;

public class EventoCriatura extends Evento{

    private List<String> tipoCriatura;
    private int nivelPerigo;
    private String acao;
    private double vida = 100;

    public void receberDano(double dano) {
        vida -= dano;
        System.out.println("Criatura recebeu " + dano + " de dano. Vida restante: " + vida);
    }

    public EventoCriatura(String nomeEvento, String descricaoEvento, int probabilidadeOcorrencia, String[] impacto, String[] condicaoAtivacao,
                           String[] criatura, int nivelPerigo, String acao) {


        super(nomeEvento, descricaoEvento, probabilidadeOcorrencia, impacto, condicaoAtivacao);

        this.tipoCriatura=Arrays.asList(criatura);
        this.nivelPerigo=nivelPerigo;
        this.acao=acao;
    }

    public List<String> getTipoCriatura(){
        return tipoCriatura;
    }

    public int getNivelPerigo(){
        return nivelPerigo;
    }

    public String acao(){
        return acao;
    }

    public void executar(Personagem personagem, Ambiente local){

    }

}
