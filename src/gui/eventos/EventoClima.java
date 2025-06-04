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

    private EventoClimatico eventoClima;

    public boolean chuvaAtiva = false;
    public boolean calorExtremoAtivo = false;
    public boolean nevascaAtiva = false;

    public EventoClima(PainelJogo gp) {
        this.gp = gp;

    }

    public void eventoChuva(int mapa) {
        if (mapa == gp.getMapaAtual()) {

            this.eventoClima = new EventoClimatico(
                    "Chuva",
                    "Uma forte chuva começa.",
                    16,
                    new String[]{"- 1 de energia e temperatura corporal"},
                    new String[]{"Floresta", "Lago e Rio", "Montanha", "Ruinas"},
                    "Chuva intensa",
                    100,
                    new String[]{"reduz energia pelo peso da roupa molhada"}
            );

            if (contadorChuva >= intervaloChuva && !calorExtremoAtivo && !nevascaAtiva) {
                int chanceMaxima;
                switch (mapa) {
                    case 0:
                        chanceMaxima = eventoClima.getProbabilidadeOcorrencia();
                        break;
                    case 1:
                        chanceMaxima = eventoClima.getProbabilidadeOcorrencia();
                        break;
                    case 2:
                        chanceMaxima = eventoClima.getProbabilidadeOcorrencia();
                        break;
                    case 3:
                        chanceMaxima = eventoClima.getProbabilidadeOcorrencia();
                        break;

                    default:
                        chanceMaxima = 0;
                        break;
                }

                int chance = random.nextInt(100);
                if (chance < chanceMaxima) {
                    gp.setEstadoJogo(gp.getEstadoDialogo());
                    gp.getIu().setDialogoAtual("CHUVA FORTE\nUma chuva forte começou!\nVocê perdeu energia.");
                    gp.jogador.setEnergia(gp.jogador.getEnergia() - 1);
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

        this.eventoClima=new EventoClimatico( "Calor",
                "Uma onda de calor começa.",
                25,
                new String[]{"- 2 de sede e +1 de temperatura corporal"},
                new String[]{"Caverna, Floresta, Ruinas"},
                "Calor intenso",
                100,
                new String[]{
                        "aumenta sede pelo aumento da temperatura corporal",
                        "aumenta a temperatura corporal"
                }
        );

        String personagem = gp.getPersonagemSelecionado();

        if (mapa == gp.getMapaAtual()) {
            if (contadorCalor >= intervaloCalor) {
                Random random = new Random();

                int chanceMaxima;
                switch (mapa) {
                    case 0:
                        chanceMaxima = eventoClima.getProbabilidadeOcorrencia();
                        break;
                    case 1:
                        chanceMaxima = 0;
                        break;
                    case 2:
                        chanceMaxima = eventoClima.getProbabilidadeOcorrencia(); // 5% no mapa 3
                        break;
                    case 3:
                        chanceMaxima = eventoClima.getProbabilidadeOcorrencia(); // 5% no mapa 3
                        break;
                    case 4:
                        chanceMaxima = eventoClima.getProbabilidadeOcorrencia(); // 5% no mapa 3
                        break;
                    default:
                        chanceMaxima = 0;
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

        this.eventoClima=new EventoClimatico( "Nevasca",
                "Uma nevasca começa.",
                15,
                new String[]{"- 1 de energia e - 2 de temperatura corporal"},
                new String[]{"Montanhas"},
                "Nevasca intensa",
                100,
                new String[]{
                        "reduz energia pela diminuição da temperatura corporal",
                        "reduz a temperatura corporal"}
                );

        if (mapa == gp.getMapaAtual()) {
            if (contadorNevasca >= intervaloNevasca) {
                Random random = new Random();

                int chanceMaxima;
                switch (mapa) {
                    case 0:
                        chanceMaxima = 0;
                        break;
                    case 1:
                        chanceMaxima = 0;
                        break;
                    case 2:
                        chanceMaxima = 15;
                        break;
                    case 3:
                        chanceMaxima = eventoClima.getProbabilidadeOcorrencia();
                        break;
                    default:
                        chanceMaxima = 0;
                        break;
                }

                int chance = random.nextInt(100);
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