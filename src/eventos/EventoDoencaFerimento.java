//Pacote
package eventos;

//Imports
import ambientes.Ambiente;
import personagens.Personagem;
import java.util.Random;

//EventoDoencaFerimento é uma subclasse de Evento
public class EventoDoencaFerimento extends Evento {

    public EventoDoencaFerimento(String nomeEvento, String descricaoEvento, int probabilidadeOcorrencia,
                                 String[] impacto, String[] condicaoAtivacao,
                                 String[] condicao, String[] tipoImpacto, String[] cura) {
        super(nomeEvento, descricaoEvento, probabilidadeOcorrencia, impacto, condicaoAtivacao);
    }

    //Método override de Evento
    @Override
    public String executar(Personagem personagem, Ambiente local) {
        String nomeEsteEvento = this.getNomeEvento();

        if (nomeEsteEvento.equalsIgnoreCase("Desidratação")) { // Um evento que PODE causar desidratação
            if (personagem.getSede() <= 1 && !personagem.isDesidratado()) { // Condição mais severa para um evento "agudo"
                personagem.setDesidratado(true);
                String msgDelirio = verificarEAtivarOuDesativarDelirio(personagem);
                return "A sede extrema o atingiu! Você está gravemente desidratado." + (msgDelirio != null ? " " + msgDelirio : "");
            }
            return "Você sente muita sede, mas ainda resiste à desidratação aguda.";
        }

        if (nomeEsteEvento.equalsIgnoreCase("Infecção")) { // Um evento que PODE causar infecção
            Random random = new Random();
            if (!personagem.isInfectado() && random.nextInt(100) < 50) {
                personagem.setInfectado(true);
                return "Um ferimento piorou rapidamente e infeccionou gravemente!";
            }
        }

        return getDescricaoEvento() + " (Uma infecção te antigiu!)";
    }

    //Método de aplicar o efeito de desidratação
    public String aplicarEfeitoContinuoDesidratacao(Personagem personagem) {
        if (personagem.isDesidratado()) {
            personagem.setEnergia(personagem.getEnergia() - 1);
            // Sanidade também é afetada, e o delírio é uma consequência direta
            personagem.setSanidade(Math.max(0, personagem.getSanidade() - 1));

            String msgDelirio = verificarEAtivarOuDesativarDelirio(personagem);
            String msgPrincipal = "DESIDRATAÇÃO: Sua energia e sanidade continuam diminuindo.";

            return msgPrincipal + (msgDelirio != null ? " " + msgDelirio : "");
        }
        else {
            return verificarEAtivarOuDesativarDelirio(personagem);
        }
    }

    //Método de aplciar efeito de infecção
    public String aplicarEfeitoContinuoInfeccao(Personagem personagem) {
        if (personagem.isInfectado()) {
            personagem.setVida(personagem.getVida() - 1);
            return "INFECÇÃO: A doença consome sua vitalidade, você perdeu 1 de vida.";
        }
        return null;
    }

    //Método e verificar e aplicar o efeito de delirio
    private String verificarEAtivarOuDesativarDelirio(Personagem personagem) {
        boolean condicaoParaDelirio = (personagem.getSanidade() <= 2 || personagem.isDesidratado());
        boolean estavaDelirando = personagem.isDelirando();

        if (condicaoParaDelirio) {
            if (!estavaDelirando) {
                personagem.setDelirando(true);
                personagem.setVelocidade(1/2);
                personagem.reduzirSanidade(1);
                return "Sua mente começa a pregar peças... Você está delirando.";
            }
        } else { // Não há mais condição para delírio
            if (estavaDelirando) {
                personagem.setDelirando(false);
                personagem.setVelocidade(personagem.getVelocidade()); // Restaura velocidade no back-end
                return "Sua mente clareia... O delírio passou.";
            }
        }
        return null;
    }

    //Método de bber agua contaminada e contrair uma infeccção
    public String beberAguaContaminada(Personagem personagem) {
        if (personagem.getSede() < personagem.getSedeMaxima()) {
            personagem.setSede(personagem.getSede() + 1);
            Random random = new Random();
            if (random.nextInt(100) < 60) {
                personagem.setInfectado(true);
                return "Você bebeu água contaminada e foi infectado!";
            } else {
                return "Você bebeu água contaminada, mas parece que não foi infectado desta vez.";
            }
        } else {
            return "Você não está com sede no momento.";
        }
    }
}