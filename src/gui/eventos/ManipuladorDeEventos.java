package gui.eventos;

import gui.system.PainelJogo;

import java.awt.*;


public class ManipuladorDeEventos {

    private PainelJogo gp;
    private Rectangle retEvento;
    private int eventoRetanguloPadraoX, eventoRetanguloPadraoY;

    private EventoClima eventoClima;
    private EventoDoencaFerimento eventoDoencaFerimento;


    public ManipuladorDeEventos(PainelJogo gp) {
        this.gp = gp;

        this.eventoClima = new EventoClima(gp);
        this.eventoDoencaFerimento= new EventoDoencaFerimento(gp);

        retEvento = new Rectangle();
        retEvento.x = 23;
        retEvento.y = 23;
        retEvento.width = 2;
        retEvento.height = 2;
        eventoRetanguloPadraoX = retEvento.x;
        eventoRetanguloPadraoY = retEvento.y;

    }



    public void checarEvento() {
        boolean eventoMapaAtivo = false;  // Flag para bloquear eventos de mapa

        // Eventos de interação com o mapa
        if (acertar(26, 17, "up")) {
            pocoDeDanos(gp.getEstadoDialogo());
            return;
        }
        if (acertar(16, 23, "up")) {
            pocoDeDanos(gp.getEstadoDialogo());
            return;
        }
        if (acertar(15, 18, "up")) {
            pocoDeDanos(gp.getEstadoDialogo());
            return;
        }
        if (acertar(20, 13, "up")) {
            pocoDeDanos(gp.getEstadoDialogo());
            return;
        }
        if (acertar(25, 25, "up")) {
            teleporte(gp.getEstadoDialogo());
            return;
        }
        if (acertar(34, 24, "right")) {
            recuperarSede(gp.getEstadoDialogo());
            return;
        }
        if (acertar(12, 28, "left")) {
            eventoDoencaFerimento.aguaContaminada(gp.getEstadoDialogo());
            return;
        }
        if (acertar(28, 9, "up")) {
            mensagemBoasVindas(gp.getEstadoDialogo());
            return;
        }

        if (!eventoMapaAtivo && gp.getEstadoJogo() != gp.getEstadoDialogo()) {
            // Escolhe aleatoriamente apenas um evento climático para ocorrer
            int eventoAleatorio = new java.util.Random().nextInt(4);

            switch (eventoAleatorio) {
                case 0:
                    eventoClima.eventoChuva();
                    break;
                case 1:
                    eventoClima.eventoCalorExtremo();
                    break;
                case 2:
                    eventoClima.eventoNevasca();
                    break;
                case 3:
                    eventoDoencaFerimento.eventoDesidratacao();
                    break;
            }

            // Sempre executa a redução de energia
            baixarEnergia();
        }
    }



        public boolean acertar(int eventoCol, int eventoLinha, String direcaoRegistro) {
        boolean acertar = false;

        // Pegamos a área sólida do jogador
        Rectangle areaSolidaJogador = gp.jogador.getAreaSolida();

        // Salvamos a posição original da área sólida
        int areaSolidaOriginalX = areaSolidaJogador.x;
        int areaSolidaOriginalY = areaSolidaJogador.y;

        // Atualizamos a posição absoluta da área sólida no mundo
        areaSolidaJogador.x = gp.jogador.getMundoX() + gp.jogador.getAreaSolidaPadraoX();
        areaSolidaJogador.y = gp.jogador.getMundoY() + gp.jogador.getAreaSolidaPadraoY();

        // Posicionamos o retângulo do evento no mundo
        retEvento.x = eventoCol * gp.getTamanhoBloco() + eventoRetanguloPadraoX;
        retEvento.y = eventoLinha * gp.getTamanhoBloco() + eventoRetanguloPadraoY;

        // Verificamos colisão
        if (areaSolidaJogador.intersects(retEvento)) {
            if (gp.jogador.getDirecao().equals(direcaoRegistro) || direcaoRegistro.equals("any")) {
                acertar = true;
            }
        }

        // Restauramos as posições originais
        areaSolidaJogador.x = areaSolidaOriginalX;
        areaSolidaJogador.y = areaSolidaOriginalY;
        retEvento.x = eventoRetanguloPadraoX;
        retEvento.y = eventoRetanguloPadraoY;

        return acertar;
    }


    public void teleporte(int estadoJogo) {

        gp.setEstadoJogo(estadoJogo);
        gp.getIu().setDialogoAtual("Teleporte.");
        gp.jogador.setMundoX(gp.getTamanhoBloco() * 40);
        gp.jogador.setMundoY(gp.getTamanhoBloco() * 30);


    }

    public void pocoDeDanos(int estadoJogo) {

        gp.setEstadoJogo(estadoJogo);
        gp.getIu().setDialogoAtual("Você foi afetado por um\n cogumelo venenoso!");
        gp.jogador.setVida(gp.jogador.getVida() - 1);

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
        }


    }
    public void mensagemBoasVindas(int estadoJogo) {
        gp.setEstadoJogo(estadoJogo);
        String[] falas = {
                "Bem-vindo ao jogo\nÚLTIMA FRONTEIRA!",
                "Prepare-se para\n sobreviver.",
                "Use os recursos\ncom sabedoria.",
                "Boa sorte!"
        };
        gp.getIu().setDialogos(falas);
    }


}


