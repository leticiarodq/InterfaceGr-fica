package gui.system;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventosTeclado implements KeyListener {

    PainelJogo gp;

    private boolean cimaPressionado, baixoPressionado, esquerdaPressionado, direitaPressionado, enterPressionado;

    private boolean mostrarTextoDebug = false;

    public boolean isChecarDesenhoTempo() {
        return mostrarTextoDebug;
    }

    public void setChecarDesenhoTempo(boolean checarDesenhoTempo) {
        this.mostrarTextoDebug = checarDesenhoTempo;
    }

    public boolean isCimaPressionado() {
        return cimaPressionado;
    }

    public boolean isBaixoPressionado() {
        return baixoPressionado;
    }

    public boolean isEsquerdaPressionado() {
        return esquerdaPressionado;
    }

    public boolean isDireitaPressionado() {
        return direitaPressionado;
    }

    public boolean isEnterPressionado() {
        return enterPressionado;
    }

    public boolean isMostrarTextoDebug() {
        return mostrarTextoDebug;
    }

    public void setEnterPressionado(boolean enterPressionado) {
        this.enterPressionado = enterPressionado;
    }


    public EventosTeclado(PainelJogo gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if (gp.getEstadoJogo() == gp.getEstadoTitulo()) {
            estadoTitulo(code);
        } else if (gp.getEstadoJogo() == gp.getEstadoPlay()) {
            estadoPlay(code);
        } else if (gp.getEstadoJogo() == gp.getEstadoDialogo()) {
            estadoDialogo(code);
        } else if (gp.getEstadoJogo() == gp.getEstadoPausa()) {
            estadoPausa(code);
        } else if (gp.getEstadoJogo() == gp.getEstadoPersonagem()) {
            estadoPersonagem(code);
        }else if(gp.getEstadoJogo()==gp.getEstadoJogoFinalizado()){
            estadoJogoFinalizado(code);
        }else if(gp.getEstadoJogo()==gp.getEstadoJogoDescricao()){
            estadoJogoDescricao(code);
        }
    }
    public void estadoJogoFinalizado(int code){

        if(code == KeyEvent.VK_W){
            gp.getIu().setComandoNum(gp.getIu().getComandoNum() - 1);
            if(gp.getIu().getComandoNum() < 0){
                gp.getIu().setComandoNum(1);
            }
        }

        if(code == KeyEvent.VK_S){
            gp.getIu().setComandoNum(gp.getIu().getComandoNum() + 1);
            if(gp.getIu().getComandoNum() > 1){
                gp.getIu().setComandoNum(0);
            }
        }

        if(code == KeyEvent.VK_ENTER){
            if(gp.getIu().getComandoNum() == 0){
                // ação para "Tentar novamente"
                // aqui você deve reiniciar o jogo ou resetar o estado
                gp.iniciarJogo();  // exemplo, dependendo da sua implementação
            } else if(gp.getIu().getComandoNum() == 1){
                // ação para "Sair"
                gp.setEstadoJogo(gp.getEstadoTitulo());
                gp.getIu().setTelaMenu(0); // volta para o menu principal
                gp.getIu().setComandoNum(0); // cursor no topo
            }
        }
    }

    public void estadoTelaCombate(int code) {

        if (code == KeyEvent.VK_E) {
            gp.setEstadoJogo(gp.getEstadoPlay());

        }
    }

    public void estadoJogoDescricao(int code){

        if (code == KeyEvent.VK_M) {
            gp.setEstadoJogo(gp.getEstadoPlay());



        }

    }

    public void estadoTitulo(int code) {

        if (gp.getIu().getTelaMenu() == 0) {
            if (code == KeyEvent.VK_W) {
                gp.getIu().setComandoNum(gp.getIu().getComandoNum() - 1);
                if (gp.getIu().getComandoNum() < 0) {
                    gp.getIu().setComandoNum(2);
                }
            }

            if (code == KeyEvent.VK_S) {
                gp.getIu().setComandoNum(gp.getIu().getComandoNum() + 1);
                if (gp.getIu().getComandoNum() > 2) {
                    gp.getIu().setComandoNum(0);
                }
            }

            if (code == KeyEvent.VK_ENTER) {
                if (gp.getIu().getComandoNum() == 0) {

                    gp.getIu().setTelaMenu(1);
                    gp.repaint();
                }
                if (gp.getIu().getComandoNum() == 1) {
                }
                if (gp.getIu().getComandoNum() == 2) {
                    System.exit(0);
                }
            }


        } else if (gp.getIu().getTelaMenu() == 2) {
            if (code == KeyEvent.VK_W) {
                gp.getIu().setComandoNum(gp.getIu().getComandoNum() - 1);
                if (gp.getIu().getComandoNum() < 0) {
                    gp.getIu().setComandoNum(4);
                }
            }

            if (code == KeyEvent.VK_S) {
                gp.getIu().setComandoNum(gp.getIu().getComandoNum() + 1);
                if (gp.getIu().getComandoNum() > 4) {
                    gp.getIu().setComandoNum(0);
                }
            }

            if (code == KeyEvent.VK_ENTER) {
                if (gp.getIu().getComandoNum() == 0) {
                    gp.getIu().setPersonagemSelecionado("O RASTREADOR"); // Note o nome correto
                    gp.getIu().setTelaMenu(3); // Vai para tela de descrição
                    gp.repaint();
                }
                if (gp.getIu().getComandoNum() == 1) {
                    gp.getIu().setPersonagemSelecionado("O MÉDICO");
                    gp.getIu().setTelaMenu(3);
                    gp.repaint();
                }
                if (gp.getIu().getComandoNum() == 2) {
                    gp.getIu().setPersonagemSelecionado("A MECÂNICA");
                    gp.getIu().setTelaMenu(3);
                    gp.repaint();
                }
                if (gp.getIu().getComandoNum() == 3) {
                    gp.getIu().setPersonagemSelecionado("A SOBREVIVENTE");
                    gp.getIu().setTelaMenu(3);
                    gp.repaint();
                }
                if (gp.getIu().getComandoNum() == 4) {
                    gp.getIu().setTelaMenu(1); // Volta para o menu principal
                }

            }

        } else if (gp.getIu().getTelaMenu() == 3) {
            if (code == KeyEvent.VK_ENTER) {
                // Confirma a seleção do personagem e inicia o jogo
                String personagem = "";
                if (gp.getIu().getPersonagemSelecionado().equals("O RASTREADOR")) {
                    personagem = "rastreador";
                } else if (gp.getIu().getPersonagemSelecionado().equals("O MÉDICO")) {
                    personagem = "médico";
                } else if (gp.getIu().getPersonagemSelecionado().equals("A MECÂNICA")) {
                    personagem = "mecânico";
                } else if (gp.getIu().getPersonagemSelecionado().equals("A SOBREVIVENTE")) {
                    personagem = "sobrevivente";
                }
                gp.setPersonagemSelecionado(personagem);
                gp.iniciarJogo();
                gp.setEstadoJogo(gp.getEstadoPlay());
            }
            if (code == KeyEvent.VK_ESCAPE) {
                gp.getIu().setTelaMenu(2);
                gp.repaint();
            }
        } else if (gp.getIu().getTelaMenu() == 1) {
            if (code == KeyEvent.VK_ENTER) {
                gp.getIu().setTelaMenu(2);
            }
            if (code == KeyEvent.VK_ESCAPE) {
                gp.getIu().setTelaMenu(0);
                gp.getIu().reiniciarEfeitoDigitacao();
                gp.repaint();
            }
        }
    }



    public void estadoPlay(int code) {

        if (code == KeyEvent.VK_W) {
            cimaPressionado = true;
        }

        if (code == KeyEvent.VK_S) {
            baixoPressionado = true;
        }
        if (code == KeyEvent.VK_A) {
            esquerdaPressionado = true;
        }
        if (code == KeyEvent.VK_D) {
            direitaPressionado = true;
        }

        if (code == KeyEvent.VK_P) {
            if (gp.getEstadoJogo() == gp.getEstadoPlay()) {
                gp.setEstadoJogo(gp.getEstadoPausa());

            } else if (gp.getEstadoJogo() == gp.getEstadoPausa()) {
                gp.setEstadoJogo(gp.getEstadoPlay());
            }
        }
        if (code == KeyEvent.VK_M) {
            if (gp.getEstadoJogo() == gp.getEstadoPlay()) {
                gp.setEstadoJogo(gp.getEstadoJogoDescricao());

            } else if (gp.getEstadoJogo() == gp.getEstadoJogoDescricao()) {
                gp.setEstadoJogo(gp.getEstadoPlay());
            }

        }
        if (code == KeyEvent.VK_C) {
            gp.setEstadoJogo(gp.getEstadoPersonagem());
        }

        if (code == KeyEvent.VK_ENTER) {
            enterPressionado = true;
        }

        if (code == KeyEvent.VK_T) {
            if (mostrarTextoDebug == false) {
                mostrarTextoDebug = true;
            } else if (isChecarDesenhoTempo()) {
                setChecarDesenhoTempo(false);
            }
        }




        if(code==KeyEvent.VK_R){
            switch(gp.getMapaAtual()){
                case 0:gp.getBlocosG().carregarMapa("/maps/floresta.txt",0); break;
                case 1:gp.getBlocosG().carregarMapa("/maps/lagoErio.txt",1); break;
                case 2:gp.getBlocosG().carregarMapa("/maps/ruinas.txt",2); break;
                case 3:gp.getBlocosG().carregarMapa("/maps/montanha.txt",3); break;
                case 4:gp.getBlocosG().carregarMapa("/maps/caverna.txt",4); break;
            }

        }



    }

   /* public void estadoCombate(int code) {
        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
            gp.getIu().setComandoNum(gp.getIu().getComandoNum() - 1);
            if (gp.getIu().getComandoNum() < 0) {
                gp.getIu().setComandoNum(1);
            }
        }

        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
            gp.getIu().setComandoNum(gp.getIu().getComandoNum() + 1);
            if (gp.getIu().getComandoNum() > 1) {
                gp.getIu().setComandoNum(0);
            }
        }

        if (code == KeyEvent.VK_ENTER) {
            if (gp.getIu().getComandoNum() == 0) {
                System.out.println("Você escolheu lutar!");
                gp.setEstadoJogo(gp.getEstadoTelaLuta());
            } else if (gp.getIu().getComandoNum() == 1) {
                System.out.println("Você fugiu do combate.");
                gp.setEstadoJogo(gp.getEstadoPlay());
            }
        }
    }


    */

    public void estadoPausa(int code) {

        if (code == KeyEvent.VK_P) {
            gp.setEstadoJogo(gp.getEstadoPlay());
        }

    }

    public void estadoDialogo(int code) {

        if (code == KeyEvent.VK_ENTER) {
            gp.getIu().avancarDialogo();

            if (gp.getIu().getDialogoAtual() == null) {
                gp.setEstadoJogo(gp.getEstadoPlay());
            }
        }

    }

    public void estadoPersonagem(int code) {

        if (code == KeyEvent.VK_C) {
            gp.setEstadoJogo(gp.getEstadoPlay());
        }

        if (code == KeyEvent.VK_W) {

            if (gp.getIu().getSlotLinha() != 0) {
                gp.getIu().setSlotLinha(gp.getIu().getSlotLinha() - 1); // Cima
            }
        }

        if (code == KeyEvent.VK_S) {
            if (gp.getIu().getSlotLinha() != 3) {
                gp.getIu().setSlotLinha(gp.getIu().getSlotLinha() + 1); // Baixo
            }
        }

        if (code == KeyEvent.VK_A) {
            if (gp.getIu().getSlotCol() != 0) {
                gp.getIu().setSlotCol(gp.getIu().getSlotCol() - 1); // Esquerda
            }
        }

        if (code == KeyEvent.VK_D) {
            if (gp.getIu().getSlotCol() != 4) {
                gp.getIu().setSlotCol(gp.getIu().getSlotCol() + 1); // Direita
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code=e.getKeyCode();

        if(code==KeyEvent.VK_W) {
            cimaPressionado=false;
        }
        if(code==KeyEvent.VK_S) {
            baixoPressionado=false;
        }
        if(code==KeyEvent.VK_A) {
            esquerdaPressionado=false;
        }
        if(code==KeyEvent.VK_D) {
            direitaPressionado=false;
        }
    }
}