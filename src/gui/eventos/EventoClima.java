package gui.eventos;

import eventos.EventoClimatico;
import gui.system.PainelJogo;

import java.util.Random;

public class EventoClima {

    private PainelJogo gp;

    private int contadorChuva = 0;
    private final int intervaloChuva = 1200;
    private int contadorCalor = 0;
    private final int intervaloCalor = 1200;
    private int contadorNevasca = 0;
    private final int intervaloNevasca = 600;


    private final Random random = new Random();


    public boolean chuvaAtiva = false;
    public boolean calorExtremoAtivo = false;
    public boolean nevascaAtiva = false;

    public EventoClima(PainelJogo gp) {
        this.gp = gp;


    }

    public void eventoChuva(int mapa) {
        if (mapa == gp.getMapaAtual()) {
            if (contadorChuva >= intervaloChuva && !calorExtremoAtivo && !nevascaAtiva) {
                int chanceMaxima;
                switch (mapa) {
                    case 0:
                        chanceMaxima = 16;
                        break;
                    case 1:
                        chanceMaxima = 15;
                        break;
                    case 2:
                        chanceMaxima = 10;
                        break;
                    case 3:
                        chanceMaxima = 5;
                        break;

                    default:
                        chanceMaxima = 0;
                        break;
                }

                int chance = random.nextInt(100);
                if (chance < chanceMaxima) {
                    gp.setEstadoJogo(gp.getEstadoDialogo());
                    gp.getIu().setDialogoAtual("CHUVA FORTE\nUma chuva forte começou!\nVocê perdeu energia.");
                    gp.jogador.setVida(gp.jogador.getEnergia() - 1);
                    gp.iniciarChuva(100);
                    chuvaAtiva = true;
                }

                contadorChuva = 0; // Reseta o contador após a verificação
            } else {
                contadorChuva++;
                gp.setMostrarChuva(false);
            }
        }
    }


    public void eventoCalorExtremo(int mapa) {

        String personagem = gp.getPersonagemSelecionado();

        if (mapa == gp.getMapaAtual()) {
            if (contadorCalor >= intervaloCalor) {
                Random random = new Random();

                int chanceMaxima;
                switch (mapa) {
                    case 0:
                        chanceMaxima = 100; // 15% de chance no mapa 1
                        break;
                    case 1:
                        chanceMaxima = 5; // 10% no mapa 2
                        break;
                    case 2:
                        chanceMaxima = 10; // 5% no mapa 3
                        break;
                    case 3:
                        chanceMaxima = 5; // 5% no mapa 3
                        break;
                    default:
                        chanceMaxima = 8; // valor padrão
                        break;
                }

                int chance = random.nextInt(100); // 0 a 99
                if (chance < chanceMaxima) {
                    gp.setEstadoJogo(gp.getEstadoDialogo());
                    gp.getIu().setDialogoAtual("CALOR EXTREMO\nParece que o clima\nesquentou...\nVocê precisa beber água.");
                    if ("sobrevivente".contentEquals(personagem)) {
                        gp.jogador.setSede(gp.jogador.getSede() - 1);
                    } else {
                        gp.jogador.setSede(gp.jogador.getSede() - 2);
                    }

                }

                contadorCalor = 0; // reseta o contador após tentar ativar
            } else {
                contadorCalor++;
            }
        }
    }


    public void eventoNevasca(int mapa) {
        if (mapa == gp.getMapaAtual()) {
            if (contadorNevasca >= intervaloNevasca) {
                Random random = new Random();

                int chanceMaxima;
                switch (mapa) {
                    case 0:
                        chanceMaxima = 0; // 15% de chance no mapa 1
                        break;
                    case 1:
                        chanceMaxima = 0; // 10% no mapa 2
                        break;
                    case 2:
                        chanceMaxima = 15; // 5% no mapa 3
                        break;
                    case 3:
                        chanceMaxima = 10; // 5% no mapa 3
                        break;
                    default:
                        chanceMaxima = 0; // valor padrão
                        break;
                }

                int chance = random.nextInt(100); // 0 a 99
                if (chance < chanceMaxima) {
                    gp.setEstadoJogo(gp.getEstadoDialogo());
                    gp.getIu().setDialogoAtual("NEVASCA\nO vento gelado sopra com\nforça...\nVocê perdeu energia.");
                    gp.jogador.setEnergia(gp.jogador.getEnergia() - 1);
                    gp.iniciarNevasca(100);
                }
            }
        }
    }
}