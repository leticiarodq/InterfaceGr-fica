//Pacote
package eventos;

//Imports
import ambientes.Ambiente;
import personagens.Personagem;

//EventoClimatico é uma subclasse de Evento
public class EventoClimatico extends Evento {

    private String tipoClima;
    private int duracao;

    //Construtor
    public EventoClimatico(String nomeEvento, String descricaoEvento, int probabilidadeOcorrencia,
                           String[] impacto, String[] condicaoAtivacao, String tipoClima,
                           int duracao, String[] efeito) {
        super(nomeEvento, descricaoEvento, probabilidadeOcorrencia, impacto, condicaoAtivacao);
        this.tipoClima = tipoClima;
        this.duracao = duracao;
    }

    //Método override de Evento em que aplica os efeitos do eventoClimatico
    @Override
    public String executar(Personagem personagem, Ambiente local) {
        // A lógica de impacto agora está encapsulada e retorna uma mensagem para a GUI
        if (this.getNomeEvento().equalsIgnoreCase("Chuva")) {
            personagem.setEnergia(personagem.getEnergia() - 1);
            return "Uma chuva forte começou! Você se sente mais cansado.";
        }
        if (this.getNomeEvento().equalsIgnoreCase("Nevasca")) {
            personagem.setEnergia(personagem.getEnergia() - 1);
            return "O vento gelado de uma nevasca sopra com força...";
        }
        if (this.getNomeEvento().equalsIgnoreCase("Calor")) {
            personagem.setSede(personagem.getSede() - 2);
            return "Uma onda de calor intenso faz você sentir mais sede.";
        }

        return getDescricaoEvento();
    }
}