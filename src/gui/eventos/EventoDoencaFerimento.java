package gui.eventos;

import gui.system.PainelJogo;

import java.util.Random;

public class EventoDoencaFerimento {

    private PainelJogo gp;


    private int contadorDesidratacao = 0;
    private final int intervaloDesidratacao = 600;

    private int contadorDesmoronamento=0;
    private final int intervaloDesmoronamento=200;
    private boolean desmoronamentoAtivo=false;
    private int contadorInfeccao = 0;
    private final int intervaloInfeccao = 100; // por exemplo, 600 frames (~10 segundos se rodar a 60fps)


    public EventoDoencaFerimento(PainelJogo gp) {
        this.gp = gp;


    }

    public void eventoDesidratacao() {
        if (gp.jogador.getSede() <= 2) {
            gp.jogador.setDesidratado(true);
        } else {
            gp.jogador.setDesidratado(false);
            contadorDesidratacao = 0;
        }

        if (gp.jogador.isDesidratado()) {
            contadorDesidratacao++;
            if (contadorDesidratacao >= intervaloDesidratacao) {
                gp.jogador.setEnergia(gp.jogador.getEnergia() - 1);
                gp.jogador.setSanidade(Math.max(0, gp.jogador.getSanidade() - 1)); // Reduz sanidade com intervalo
                gp.setEstadoJogo(gp.getEstadoDialogo());
                gp.getIu().setDialogoAtual("DESIDRATAÇÃO\nOoh, não...\nVocê está desidratado e\nperdeu 1 ponto de vida.");
                contadorDesidratacao = 0;
            }
        }

        delirio();
    }

    public void aguaContaminada(int estadoJogo) {
        if (gp.jogador.getSede() < gp.jogador.getSedeMaxima()) {
            gp.jogador.setSede(gp.jogador.getSede() + 1);
            gp.setEstadoJogo(estadoJogo);


            Random random = new Random();
            int chance = random.nextInt(100); // 0 a 99

            if (chance < 100) {
                String personagem=gp.getPersonagemSelecionado();
                if("médico".equals(personagem)){
                    gp.jogador.setVida(gp.jogador.getVida()-1);

                }
                else{
                    gp.jogador.setVida(gp.jogador.getVida()-2);
                }

                gp.getIu().setDialogoAtual("Você bebeu água\ncontaminada\ne foi infectado!");
            } else {
                gp.getIu().setDialogoAtual("Você bebeu água\ncontaminada,\nmas não ficou infectado.");
            }
        } else {
            gp.setEstadoJogo(estadoJogo);
            gp.getIu().setDialogoAtual("Você já está hidratado.");
        }

    }


    public void delirio () {
        if (gp.jogador.getSanidade() <= 2 || gp.jogador.isDesidratado()) {
            gp.getIu().setDialogoAtual("Você está delirando!");
            gp.jogador.setVelocidade(1);
            gp.setMostrarEfeitoConfusao(true);
        } else {
            gp.setMostrarEfeitoConfusao(false);
            gp.jogador.setVelocidade(2); // velocidade normal
        }
    }

    private final Random random = new Random();

    public void eventoDesmoronamento(int mapa) {
        if (mapa == gp.getMapaAtual()) {
            if (contadorDesmoronamento >= intervaloDesmoronamento) {
                int chanceMaxima;
                switch (mapa) {
                    case 0:
                        chanceMaxima = 0;
                        break;
                    case 1:
                        chanceMaxima = 0;
                        break;
                    case 2:
                        chanceMaxima = 0;
                        break;
                    case 3:
                        chanceMaxima = 30;
                        break;
                    default:
                        chanceMaxima = 0;
                        break;
                }

                int chance = random.nextInt(100);
                if (chance < chanceMaxima) {
                    gp.setEstadoJogo(gp.getEstadoDialogo());
                    gp.getIu().setDialogoAtual("[DESMORONAMENTO]\nUm aterrorizante tremor faz a\nterradesabar, causando dano e\nfadiga.");
                    gp.jogador.setVida(gp.jogador.getVida() - 1);
                    gp.jogador.setEnergia(gp.jogador.getEnergia() - 1);
                    gp.setMostraEfeitoDesmoronamento(true);
                    desmoronamentoAtivo = true;
                }

                contadorDesmoronamento = 0; // Reseta o contador após a verificação
            } else {
                contadorDesmoronamento++;
                gp.setMostraEfeitoDesmoronamento(false);
            }
        }
    }
}
