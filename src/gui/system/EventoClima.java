package gui.system;

import java.awt.*;
import java.util.Random;

public class EventoClima {

    private PainelJogo gp;

    private int contadorChuva = 0;
    private final int intervaloChuva = 1200; // número de frames (ajuste como quiser)
    private int contadorCalor = 0;
    private final int intervaloCalor = 1200;
    private int contadorNevasca = 0;
    private final int intervaloNevasca = 600;


    private final Random random = new Random();

    public boolean chuvaAtiva = false;
    public boolean calorExtremoAtivo = false;
    public boolean nevascaAtiva = false;

    // Variável para controlar o tempo de duração da nevasca
    private int tempoDuracaoNevasca = 10; // duração em segundos
    private int contadorTempoNevasca = 0; // contador para a duração


    public EventoClima(PainelJogo gp) {
        this.gp = gp;
    }

    public void eventoChuva() {
        if (contadorChuva >= intervaloChuva && !calorExtremoAtivo && !nevascaAtiva) {
            int chance = random.nextInt(100);
            if (chance < 10) { // 10% de chance
                gp.setEstadoJogo(gp.getEstadoDialogo());
                gp.getIu().setDialogoAtual("CHUVA FORTE\nUma chuva forte começou!\nVocê perdeu 1 ponto de vida.");
                gp.jogador.setVida(gp.jogador.getVida() - 1);
                gp.iniciarChuva(100);
                chuvaAtiva = true; // Marca chuva como ativa
            }
            contadorChuva = 0; // reseta o contador após ativar
        } else {
            contadorChuva++;
            gp.mostrarChuva = false;
        }
    }

    public void eventoCalorExtremo() {
        if (contadorCalor >= intervaloCalor) {
            Random random = new Random();
            int chance = random.nextInt(100); // 0 a 99

            if (chance < 90) { // 10% de chance
                gp.setEstadoJogo(gp.getEstadoDialogo());
                gp.getIu().setDialogoAtual("CALOR EXTREMO\nParece que o clima\nesquentou...\nVocê precisa beber água.");
                gp.jogador.setSede(gp.jogador.getSede() - 2);

            }

            contadorCalor = 0; // reseta o contador só após tentar ativar
        } else {
            contadorCalor++;
        }
    }



    public void eventoNevasca() {
        if (contadorNevasca >= intervaloNevasca) {
            Random random = new Random();
            int chance = random.nextInt(100); // 0 a 99

            if (chance < 5) { // 10% de chance
                gp.setEstadoJogo(gp.getEstadoDialogo());
                gp.getIu().setDialogoAtual("NEVASCA\nO vento gelado sopra com\nforça...\nVocê está perdeu energia!");
                gp.jogador.setEnergia(gp.jogador.getEnergia() - 1);
                gp.iniciarNevasca(100);
            }

            contadorNevasca = 0; // reseta o contador só após tentar ativar
        } else {
            contadorNevasca++;
            gp.mostrarNevasca = false;
        }
    }
}





