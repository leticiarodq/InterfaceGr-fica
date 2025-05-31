package gui.eventos;

import gui.system.PainelJogo;

import java.awt.*;


public class ManipuladorDeEventos {

    private PainelJogo gp;
    private EventoRetangulo eventoRetangulo[][][];


    private int eventoAnteriorX;
    private int eventoAnteriorY;
    private boolean eventoPodeTocar=true;

    private EventoClima eventoClima;
    private EventoDoencaFerimento eventoDoencaFerimento;


    public ManipuladorDeEventos(PainelJogo gp) {
        this.gp = gp;
        eventoRetangulo=new EventoRetangulo[gp.getMapaMax()][gp.getColMundoMax()][gp.getLinhaMundoMax()];
        this.eventoClima = new EventoClima(gp);
        this.eventoDoencaFerimento= new EventoDoencaFerimento(gp);

        int mapa=0;
        int coluna=0;
        int linha=0;
        while(mapa< gp.getMapaMax() && coluna<gp.getColMundoMax() && linha<gp.getLinhaMundoMax()){
            eventoRetangulo[mapa][coluna][linha] = new EventoRetangulo();
            eventoRetangulo[mapa][coluna][linha].x = 23;
            eventoRetangulo[mapa][coluna][linha].y = 23;
            eventoRetangulo[mapa][coluna][linha].width = 2;
            eventoRetangulo[mapa][coluna][linha].height = 2;
            eventoRetangulo[mapa][coluna][linha].setEventoRetanguloPadraoX(eventoRetangulo[mapa][coluna][linha].x);
            eventoRetangulo[mapa][coluna][linha].setEventoRetanguloPadraoY(eventoRetangulo[mapa][coluna][linha].y);

            coluna++;
            if(coluna==gp.getColMundoMax()){
                coluna=0;
                linha++;

                if(linha==gp.getLinhaMundoMax()){
                    linha=0;
                    mapa++;
                }
            }

        }

    }



    public void checarEvento() {

        boolean eventoMapaAtivo = false;  // Flag para bloquear eventos de mapa

        int xDistancia=Math.abs(gp.jogador.getMundoX()-eventoAnteriorX);
        int yDistancia=Math.abs(gp.jogador.getMundoY()-eventoAnteriorY);
        int distancia=Math.max(xDistancia, yDistancia);
        if(distancia>gp.getTamanhoBloco()){
            eventoPodeTocar=true;
        }

        if(eventoPodeTocar==true){
            // Eventos de interação com o mapa

            if (acertar(0, 37, 23, "up")) {
                pocoDeDanos(gp.getEstadoDialogo());
                return;
            }
            else if (acertar(0, 36, 11, "up")) {
                recuperarSede(gp.getEstadoDialogo());
                return;
            }
            else if (acertar(0, 11, 17, "left")) {
                eventoDoencaFerimento.aguaContaminada(gp.getEstadoDialogo());
                return;
            }
            else if (acertar(0, 23, 10, "up")) {
                mensagemBoasVindas(gp.getEstadoDialogo());
                return;
            }

            else if(acertar(0, 16,49, "down")){
                teleporte(1, 24, 0);

            }
            else if(acertar(1, 24, 0, "up")){
                teleporte(0, 16,49);

            }
            else if(acertar(1, 44,0, "up")){
                teleporte(2, 25, 0);

            }
            else if(acertar(2, 25, 0, "up")){
                teleporte(1, 44,0);

            }

            else if(acertar(2, 35, 35, "up")){
                teleporte(3, 23,0);

            }
            else if(acertar(3, 23,0, "up")){
                teleporte(2, 35, 35);

            }

            else if(acertar(3, 33,37, "up")){
                teleporte(4, 25, 7);

            }

            else if(acertar(4, 25, 7, "up")){
                teleporte(3, 33,37);

            }

            if (!eventoMapaAtivo && gp.getEstadoJogo() != gp.getEstadoDialogo()) {

                int eventoAleatorio = new java.util.Random().nextInt(5);

                switch (eventoAleatorio) {
                    case 0:
                        eventoClima.eventoChuva(0);
                        eventoClima.eventoChuva(1);
                        eventoClima.eventoChuva(2);
                        eventoClima.eventoChuva(3);

                        break;
                    case 1:
                        eventoClima.eventoCalorExtremo(0);
                        eventoClima.eventoCalorExtremo(1);
                        eventoClima.eventoCalorExtremo(2);
                        eventoClima.eventoCalorExtremo(3);
                        break;
                    case 2:
                        eventoClima.eventoNevasca(0);
                        eventoClima.eventoNevasca(1);
                        eventoClima.eventoNevasca(2);
                        eventoClima.eventoNevasca(3);
                        break;

                }

            }

            baixarEnergia();
            eventoDoencaFerimento.eventoDesidratacao();

        }


    }

    public boolean acertar(int mapa, int coluna, int linha, String direcaoRegistro) {

        boolean acertar = false;

        if(mapa==gp.getMapaAtual()){

            // Pegamos a área sólida do jogador
            Rectangle areaSolidaJogador = gp.jogador.getAreaSolida();

            // Salvamos a posição original da área sólida
            int areaSolidaOriginalX = areaSolidaJogador.x;
            int areaSolidaOriginalY = areaSolidaJogador.y;

            // Atualizamos a posição absoluta da área sólida no mundo
            areaSolidaJogador.x = gp.jogador.getMundoX() + gp.jogador.getAreaSolidaPadraoX();
            areaSolidaJogador.y = gp.jogador.getMundoY() + gp.jogador.getAreaSolidaPadraoY();

            // Posicionamos o retângulo do evento no mundo
            eventoRetangulo[mapa][coluna][linha].x = coluna * gp.getTamanhoBloco() + eventoRetangulo[mapa][coluna][linha].x;
            eventoRetangulo[mapa][coluna][linha].y = linha * gp.getTamanhoBloco() +  eventoRetangulo[mapa][coluna][linha].y;

            // Verificamos colisão
            if (gp.jogador.getAreaSolida().intersects(eventoRetangulo[mapa][coluna][linha]) && !eventoRetangulo[mapa][coluna][linha].isEventoTerminado()) {
                if (gp.jogador.getDirecao().contentEquals(direcaoRegistro) || direcaoRegistro.contentEquals("any")) {
                    acertar = true;

                    eventoAnteriorX=gp.jogador.getMundoX();
                    eventoAnteriorY=gp.jogador.getMundoY();
                }
            }

            // Restauramos as posições originais
            areaSolidaJogador.x = areaSolidaOriginalX;
            areaSolidaJogador.y = areaSolidaOriginalY;
            eventoRetangulo[mapa][coluna][linha].x = eventoRetangulo[mapa][coluna][linha].getEventoRetanguloPadraoX();
            eventoRetangulo[mapa][coluna][linha].y = eventoRetangulo[mapa][coluna][linha].getEventoRetanguloPadraoY();


        }

        return acertar;
    }


    public void teleporte(int mapa, int coluna, int linha){

        gp.setMapaAtual(mapa);
        gp.jogador.setMundoX(gp.getTamanhoBloco() * coluna);
        gp.jogador.setMundoY(gp.getTamanhoBloco() * linha);
        eventoAnteriorX=gp.jogador.getMundoX();
        eventoAnteriorY=gp.jogador.getMundoY();
        eventoPodeTocar=false;


    }


    public void pocoDeDanos(int estadoJogo) {

        gp.setEstadoJogo(estadoJogo);
        gp.getIu().setDialogoAtual("Você foi afetado por um\n cogumelo venenoso!");
        gp.jogador.setVida(gp.jogador.getVida() - 1);
        //eventoRetangulo[mapa][coluna][linha].isEventoTerminado()=true;
        eventoPodeTocar=false;
    }

    public void recuperarSede(int estadoJogo) {
        if (gp.jogador.getSede() < gp.jogador.getSedeMaxima()) {
            gp.jogador.setSede(gp.jogador.getSedeMaxima());
            gp.setEstadoJogo(estadoJogo);
            gp.getIu().setDialogoAtual("Você acabou de beber água.");
        } else {
            gp.setEstadoJogo(estadoJogo);
            gp.getIu().setDialogoAtual("Você já está hidratado.");
        }
    }

    public void baixarEnergia(){

        if (gp.jogador.getEnergia() <= 3) {
            gp.jogador.setVelocidade(1);
            //gp.setEstadoJogo(gp.getEstadoDialogo());
            //gp.getIu().setDialogoAtual("Você precisa recuperar energia!");


        }


    }
    public void mensagemBoasVindas(int estadoJogo) {
        gp.setEstadoJogo(estadoJogo);
        String[] falas = {
                "Bem-vindo ao jogo ÚLTIMA\nFRONTEIRA!",
                "Prepare-se para sobreviver.",
                "Use os recursos com\nsabedoria.",
                "Boa sorte!"
        };
        gp.getIu().setDialogos(falas);
    }


}


