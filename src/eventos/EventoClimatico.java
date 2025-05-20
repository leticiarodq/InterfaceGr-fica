package eventos;

import ambientes.Ambiente;
import personagens.Personagem;

import java.util.Arrays;
import java.util.List;

public class EventoClimatico extends Evento {

    private String tipoClima;
    private int duracao;
    private List<String> efeitoAmbiente;

    public EventoClimatico(String nomeEvento, String descricaoEvento, int probabilidadeOcorrencia, String[] impacto, String[] condicaoAtivacao, String tipoClima, int duracao, String[] efeito) {
        super(nomeEvento, descricaoEvento, probabilidadeOcorrencia, impacto, condicaoAtivacao);

        this.tipoClima=tipoClima;
        this.duracao=duracao;
        this.efeitoAmbiente=Arrays.asList(efeito);
    }

    public String getTipoClima(){
        return tipoClima;
    }

    public int getDuracao(){
        return duracao;
    }

    public List<String> getEfeitoAmbiente(){
        return efeitoAmbiente;
    }

    public void executar(Personagem personagem, Ambiente local){
            switch (tipoClima.toLowerCase()) {
                case "chuva":
                    personagem.setTemperaturaCorporal(personagem.getVida() - 1);
                    personagem.setEnergia(personagem.getEnergia() -2);
                    break;
                case "calor":
                    personagem.setSede(personagem.getSede() - 2);
                    personagem.setEnergia(personagem.getEnergia() - 1);
                    break;
                case "nevasca":
                    personagem.setEnergia(personagem.getEnergia() - 2);
                    break;
                default:
                    // Sem efeito
                    break;
            }
        }


    }
