package gui.system;

import gui.entidades.*;
import personagens.Rastreador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventosTeclado implements KeyListener {

    private PainelJogo gp;

    private boolean cimaPressionado, baixoPressionado, esquerdaPressionado, direitaPressionado, enterPressionado;

    private boolean mostrarTextoDebug = false;


    // Métodos de acesso

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

    public void setCimaPressionado(boolean cimaPressionado) {
        this.cimaPressionado = cimaPressionado;
    }

    public void setBaixoPressionado(boolean baixoPressionado) {
        this.baixoPressionado = baixoPressionado;
    }

    public void setEsquerdaPressionado(boolean esquerdaPressionado) {
        this.esquerdaPressionado = esquerdaPressionado;
    }

    public void setDireitaPressionado(boolean direitaPressionado) {
        this.direitaPressionado = direitaPressionado;
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
        } else if (gp.getEstadoJogo() == gp.getEstadoJogoDescricao()) {
            estadoJogoDescricao(code);
        } else if (gp.getEstadoJogo() == gp.getEstadoJogoFinalizado()) {
            estadoJogoFinalizado(code);
        } else if(gp.getEstadoJogo()==gp.getEstadoOpcoes()){
            estadoOpcoes(code);
        } else if(gp.getEstadoJogo()==gp.getEstadoAssarAlimento()){
            estadoAssarAlimento(code);
        }
    }


    public void estadoJogoDescricao(int code) {

        if (code == KeyEvent.VK_M) {
            gp.setEstadoJogo(gp.getEstadoPlay());

        }

    }



    public void estadoTitulo(int code) {
        System.out.println("TelaMenu: " + gp.getIu().getTelaMenu() + ", ComandoNum: " + gp.getIu().getComandoNum() + ", code: " + code);
        int tela = gp.getIu().getTelaMenu();
        int comando = gp.getIu().getComandoNum();

        if (tela == 0) { // Menu principal
            if (code == KeyEvent.VK_W) {
                comando--;
                if (comando < 0) comando = 2;
                gp.playSE(1);
                gp.getIu().setComandoNum(comando);
            } else if (code == KeyEvent.VK_S) {
                gp.playSE(1);
                comando++;
                if (comando > 2) comando = 0;
                gp.getIu().setComandoNum(comando);
            } else if (code == KeyEvent.VK_ENTER) {
                if (comando == 0) {
                    // IMPORTANTE: Limpar seleção anterior antes de ir para seleção
                    gp.setPersonagemSelecionado(null);
                    gp.getIu().setPersonagemSelecionado(null);
                    gp.getIu().setTelaMenu(1);
                    gp.getIu().setComandoNum(0); // Resetar comando
                } else if (comando == 1) {
                    // Implementar outra opção do menu se houver
                } else if (comando == 2) {
                    System.exit(0);
                }
            }
        } else if (tela == 1) { // Tela intermediária
            if (code == KeyEvent.VK_ENTER) {
                gp.getIu().setTelaMenu(2);
                gp.getIu().setComandoNum(0); // Resetar para primeira opção
            } else if (code == KeyEvent.VK_ESCAPE) {
                gp.getIu().setTelaMenu(0);
                gp.getIu().setComandoNum(0);
                gp.getIu().reiniciarEfeitoDigitacao();
            }
        } else if (tela == 2) { // Tela seleção de personagem
            if (code == KeyEvent.VK_W) {
                gp.playSE(1);

                comando--;
                if (comando < 0) comando = 4;
                gp.getIu().setComandoNum(comando);
            } else if (code == KeyEvent.VK_S) {
                gp.playSE(1);
                comando++;
                if (comando > 4) comando = 0;
                gp.getIu().setComandoNum(comando);
            } else if (code == KeyEvent.VK_ENTER) {
                switch (comando) {
                    case 0:
                        gp.getIu().setPersonagemSelecionado("O RASTREADOR");
                        gp.getIu().setTelaMenu(3);
                        break;
                    case 1:
                        gp.getIu().setPersonagemSelecionado("O MÉDICO");
                        gp.getIu().setTelaMenu(3);
                        break;
                    case 2:
                        gp.getIu().setPersonagemSelecionado("A MECÂNICA");
                        gp.getIu().setTelaMenu(3);
                        break;
                    case 3:
                        gp.getIu().setPersonagemSelecionado("A SOBREVIVENTE");
                        gp.getIu().setTelaMenu(3);
                        break;
                    case 4:
                        gp.getIu().setTelaMenu(0);
                        gp.getIu().setComandoNum(0);
                        break;
                }
            } else if (code == KeyEvent.VK_ESCAPE) {
                gp.getIu().setTelaMenu(1);
                gp.getIu().setComandoNum(0);
            }
        } else if (tela == 3) { // Tela de confirmação do personagem
            if (code == KeyEvent.VK_ENTER) {
                String personagem = gp.getIu().getPersonagemSelecionado();
                String personagemKey = "";
                switch (personagem) {
                    case "O RASTREADOR":
                        personagemKey = "rastreador";
                        break;
                    case "O MÉDICO":
                        personagemKey = "medico";
                        break;
                    case "A MECÂNICA":
                        personagemKey = "mecanica";
                        break;
                    case "A SOBREVIVENTE":
                        personagemKey = "sobrevivente";
                        break;
                }

                // Definir o personagem selecionado no jogo
                gp.setPersonagemSelecionado(personagemKey);

                // Agora ir para o jogo
                gp.setEstadoJogo(gp.getEstadoPlay());

                System.out.println("Personagem selecionado: " + personagemKey);

            } else if (code == KeyEvent.VK_ESCAPE) {
                gp.getIu().setTelaMenu(2);
                gp.getIu().setComandoNum(0);
            }
        }


        /*(code==KeyEvent.VK_W){

            if(gp.getIu().getComandoNum()<0){
                gp.getIu().setComandoNum(2);
            }
        } if (code == KeyEvent.VK_S) {
            gp.getIu().setComandoNum(gp.getIu().getComandoNum()-1);
            if (gp.getIu().getComandoNum() > 2){
                gp.getIu().setComandoNum(0);
            }
        } if(code==KeyEvent.VK_ENTER) {
            if (gp.getIu().getComandoNum() == 0) {
                gp.setEstadoJogo(gp.getEstadoPlay());

            }
            if (gp.getIu().getComandoNum() == 1) {

            }
            if (gp.getIu().getComandoNum() == 2) {
                System.exit(0);
            }
        }



         */

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

        if(code==KeyEvent.VK_ESCAPE){
            gp.setEstadoJogo(gp.getEstadoOpcoes());
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
                case 0:gp.getBlocosG().carregarMapa("/maps/forest.txt",0); break;
                case 1:gp.getBlocosG().carregarMapa("/maps/lagoErio.txt",1); break;
                case 2:gp.getBlocosG().carregarMapa("/maps/ruinas.txt",2); break;
                case 3:gp.getBlocosG().carregarMapa("/maps/montanha.txt",3); break;
                case 4:gp.getBlocosG().carregarMapa("/maps/caverna.txt",4); break;
            }

        }




    }

    public void estadoJogoFinalizado(int code){

        if(code==KeyEvent.VK_W){
            gp.playSE(1);
            gp.getIu().setComandoNum(gp.getIu().getComandoNum()-1);
            if(gp.getIu().getComandoNum()<0){
                gp.getIu().setComandoNum(1);
            }
        }

        if(code==KeyEvent.VK_S){
            gp.playSE(1);
            gp.getIu().setComandoNum(gp.getIu().getComandoNum()+1);
            if(gp.getIu().getComandoNum()>1){
                gp.getIu().setComandoNum(0);
            }

        }

        if(code==KeyEvent.VK_ENTER){
            if(gp.getIu().getComandoNum()==0){
                gp.setEstadoJogo(gp.getEstadoPlay());
                gp.retry();
            } else if(gp.getIu().getComandoNum()==1){

                gp.setEstadoJogo(gp.getEstadoTitulo());
                gp.getIu().setTelaMenu(0);
                gp.getIu().setComandoNum(0);
                gp.restart();
            }

        }

    }


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
            gp.playSE(1);

            if (gp.getIu().getSlotLinha() != 0) {
                gp.getIu().setSlotLinha(gp.getIu().getSlotLinha() - 1); // Cima
            }
        }

        if (code == KeyEvent.VK_S) {
            gp.playSE(1);

            if (gp.getIu().getSlotLinha() != 3) {
                gp.getIu().setSlotLinha(gp.getIu().getSlotLinha() + 1); // Baixo
            }
        }

        if (code == KeyEvent.VK_A) {
            gp.playSE(1);

            if (gp.getIu().getSlotCol() != 0) {
                gp.getIu().setSlotCol(gp.getIu().getSlotCol() - 1); // Esquerda
            }
        }

        if (code == KeyEvent.VK_D) {
            gp.playSE(1);

            if (gp.getIu().getSlotCol() != 4) {
                gp.getIu().setSlotCol(gp.getIu().getSlotCol() + 1); // Direita
            }
        }

        if(code==KeyEvent.VK_ENTER){
            gp.jogador.selecaoItem();
        }
    }

    public void estadoOpcoes(int code){
        if(code==KeyEvent.VK_ESCAPE){
            gp.setEstadoJogo(gp.getEstadoPlay());
        }
        if(code==KeyEvent.VK_ENTER){
            setEnterPressionado(true);
        }

        int numMaxComando=0;
        switch(gp.getIu().subEstado){
            case 0: numMaxComando=5; break;
            case 3: numMaxComando=1; break;

        }

        if(code==KeyEvent.VK_W){
            gp.playSE(1);

            gp.getIu().setComandoNum(gp.getIu().getComandoNum()-1);
            if(gp.getIu().getComandoNum()<0){
                gp.getIu().setComandoNum(numMaxComando);
            }
        } if(code==KeyEvent.VK_S){
            gp.playSE(1);

            gp.getIu().setComandoNum(gp.getIu().getComandoNum()+1);
            if(gp.getIu().getComandoNum()>numMaxComando){
                gp.getIu().setComandoNum(0);
            }
        }
    }

    public void estadoAssarAlimento(int code) {

        if (code == KeyEvent.VK_ENTER) {
            setEnterPressionado(true);
        }

        int numMaxComando = 1; // porque temos 2 opções: 0 ("Sim") e 1 ("Não")

        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
            gp.playSE(1);

            gp.getIu().setComandoNum(gp.getIu().getComandoNum()-1);
            if (gp.getIu().getComandoNum() < 0) gp.getIu().setComandoNum(numMaxComando);
        }

        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
            gp.playSE(1);

            gp.getIu().setComandoNum(gp.getIu().getComandoNum()+1);
            if (gp.getIu().getComandoNum() > numMaxComando) gp.getIu().setComandoNum(0);
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