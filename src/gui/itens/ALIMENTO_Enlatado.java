package gui.itens;

import gui.entidades.Entidade;
import gui.system.PainelJogo;
import itens.Alimento;

import java.util.Random;

public class ALIMENTO_Enlatado extends Entidade {

    private Alimento alimentoLogica;
    private PainelJogo gp;

    public ALIMENTO_Enlatado(PainelJogo gp, String tipoEnlatado) {

        super(gp);
        this.gp = gp;

        setNome(tipoEnlatado);

        switch (tipoEnlatado.toLowerCase()) {
            case "Lata de feijão":
                setDown1(setup("/alimentos/enalatado01", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                setTipo(getTipo_consumivel());
                setDescricao("[Lata de Feijão]\nAlimento nutritivo e durável.\nRecupera bastante fome.\nIdeal para longas jornadas.");
                break;

            case "Lata de feijão vencida":
                setDown1(setup("/alimentos/enlatado02", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                setTipo(getTipo_vencido());
                setDescricao("[Feijão Vencido]\nAinda com valor nutritivo,\nmas pode causar efeitos\ncolaterais leves.");
                break;

            case "lataervilha":
                setDown1(setup("/alimentos/enlatado03", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                setTipo(getTipo_consumivel());
                setDescricao("[Lata de Ervilha]\nLeve e saudável.\nRecupera um pouco de fome\nsem pesar no estômago.");
                break;

            case "ervilhavencida":
                setDown1(setup("/alimentos/enlatado04", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                setNome("Lata de ervilha vencida");
                setTipo(getTipo_vencido());
                setDescricao("[Lata de Ervilha Vencida]\nComestível, mas com gosto\nestranho. Use só em emergências.");
                break;

        }
    }

    public void usar(Entidade entidade){
        gp.setEstadoJogo(gp.getEstadoDialogo());
        gp.getIu().setDialogoAtual("Você comeu "+ getNome());
        entidade.setFome(entidade.getFome() + 1);

    }

    public void consumirAlimentoVencido(Entidade entidade) {
        gp.setEstadoJogo(gp.getEstadoDialogo());
        gp.getIu().setDialogoAtual("Você comeu " + getNome() + "...");
        Random random = new Random();

        int chance = random.nextInt(100); // 0 a 99
        String personagem = gp.getPersonagemSelecionado().toLowerCase();

        if (personagem.equals("médico")) {
            if (chance < 40) { // 40% de chance de ser infectado
                gp.jogador.setInfectado(true);
            }
        } else {
            if (chance < 60) { // 60% de chance de ser infectado
                gp.jogador.setInfectado(true);            }
        }

        if (gp.jogador.isInfectado()) {
            gp.jogador.setVida(gp.jogador.getVida() - 1);
            gp.getIu().setDialogoAtual("Você ingeriu alimento\nvencido e foi\ninfectado e perdeu\n1 ponto de vida!");
        } else {
            gp.getIu().setDialogoAtual("Você ingeriu alimento\nvencido, mas não\nfoi infectado.");
        }

        entidade.setFome(entidade.getFome() + 1);

    }
}
