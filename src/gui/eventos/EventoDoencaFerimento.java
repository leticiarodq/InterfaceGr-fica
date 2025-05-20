package gui.eventos;

import gui.system.PainelJogo;

import java.util.Random;

public class EventoDoencaFerimento {

    private PainelJogo gp;


    private int contadorDesidratacao = 0;
    private final int intervaloDesidratacao = 600; // a cada 120 frames (2 segundos)

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

            if (chance < 100) { // 30% de chance de infecção
                gp.jogador.setInfectado(true);
                gp.getIu().setDialogoAtual("Você bebeu água\ncontaminada\ne foi infectado!");
            } else {
                gp.getIu().setDialogoAtual("Você bebeu água\ncontaminada,\nmas não ficou infectado.");
            }
        } else {
            gp.setEstadoJogo(estadoJogo);
            gp.getIu().setDialogoAtual("Você já está hidratado.");
        }

    }

    public void hipotermia() {


    }



    public void eventoInfectado() {

        String personagem = gp.getPersonagemSelecionado();

        if (gp.jogador.isInfectado()) {

            if ("médico".equals(personagem)) {
                // Médico perde vida imediatamente ao estar infectado (ou pode ser outra regra)
                gp.jogador.setVida(gp.jogador.getVida() - 1);

                gp.setEstadoJogo(gp.getEstadoDialogo());
                gp.getIu().setDialogoAtual("Você está infectado!\nPerdeu 1 ponto de vida.");

            } else {
                // Para outros personagens, conta até o intervalo para perder vida
                contadorInfeccao++;
                if (contadorInfeccao >= intervaloInfeccao) {
                    gp.jogador.setVida(gp.jogador.getVida() - 1);
                    contadorInfeccao = 0;

                    gp.setEstadoJogo(gp.getEstadoDialogo());
                    gp.getIu().setDialogoAtual("Você está infectado!\nPerdeu 1 ponto de vida.");
                }
                // NÃO reseta o contador aqui; ele deve acumular até atingir o intervalo
            }

        } else {
            // Se não está infectado, reseta o contador
            contadorInfeccao = 0;
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
}
