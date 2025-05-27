package gui.entidades;

import ambientes.Ambiente;
import ambientes.GerenciadorDeAmbientes;
import gui.objetos.ALIMENTO_Enlatado;
import gui.objetos.REMEDIO_Analgesico;
import gui.objetos.REMEDIO_Antibiotico;
import gui.objetos.REMEDIO_Bandagem;
import gui.system.CriadorAtivos;
import gui.system.EventosTeclado;
import gui.system.InterfaceUsuario;
import gui.system.PainelJogo;
import personagens.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Jogador extends Entidade {

    PainelJogo gp; //gp é uma referência para o painel de jogo onde o jogador será desenhado e onde o jogo será atualizado.
    EventosTeclado eventosTeclado; //keyH é uma referência para o manipulador de teclas, que controla as teclas pressionadas para movimentação.

    private final int telaX;
    private final int telaY;
    private Personagem personagemLogico;

    public final int getTelaX() {
        return telaX;
    }

    public final int getTelaY() {
        return telaY;
    }

    private boolean desidratado = false;
    private boolean infectado = false;

    private ArrayList<Entidade> inventario = new ArrayList<>();
    private final int tamanhoMaxInventario = 20;

    // Inventário
    public final int getTamanhoMaxInventario() {
        return tamanhoMaxInventario;
    }

    public ArrayList<Entidade> getInventario() {
        return inventario;
    }


    public boolean isDesidratado() {
        return desidratado;
    }

    public void setDesidratado(boolean desidratado) {
        this.desidratado = desidratado;
    }


    public boolean isInfectado() {
        return infectado;
    }

    public void setInfectado(boolean infectado) {
        this.infectado = infectado;
    }

    private int counter2 = 0;

    CriadorAtivos criadorDeAtivos;

    public Jogador(PainelJogo gp, EventosTeclado eventosTeclado) { //Construtor da classe que recebe o painel de jogo e manipulador de teclas

        super(gp);

        this.gp = gp;
        this.eventosTeclado = eventosTeclado;


        this.personagemLogico = new Personagem(
                "Jogador",
                6,
                8,
                8,
                6,
                6,
                new Inventario(40),
                gp.getBlocosG().getAmbienteAtual().getNomeAmbiente(),
                36.5
        );


        telaX = gp.getTelaLargura() / 2 - (gp.getTamanhoBloco() / 2);
        telaY = gp.getTelaAltura() / 2 - (gp.getTamanhoBloco() / 2);

        setAreaSolida(new Rectangle(8, 16, 32, 32));
        setAreaSolidaPadraoX(getAreaSolida().x);
        setAreaSolidaPadraoY(getAreaSolida().y);

        setValoresPadrao(); //Chama o método que vai configurar valores padrão para o jogador
        getImagemJogador(); //Aqui garantimos que as imagens do jogador sejam carregadas

        definirItens();
    }

    public void setValoresPadrao() {
        // Define valores iniciais para a posição do jogador, velocidade e direção

        //setMundoX(gp.getTamanhoBloco() * 26);
        //setMundoY(gp.getTamanhoBloco() * 9);
        setMundoX(gp.getTamanhoBloco() * 31);
        setMundoY(gp.getTamanhoBloco() * 20);
        setVelocidade(2);
        setDirecao("down");

        // Status do jogador

        /*setVidaMaxima(6);
        setVida(getVidaMaxima());

        setSedeMaxima(8);
        setSede(getSedeMaxima());

        setFomeMaxima(8);
        setFome(getFomeMaxima());

        setSanidadeMaxima(6);
        setSanidade(getSanidadeMaxima());

        setEnergiaMaxima(6);
        setEnergia(getEnergiaMaxima());
         */

        setVida(personagemLogico.getVida());
        setSede(personagemLogico.getSede());
        setFome(personagemLogico.getFome());
        setSanidade(personagemLogico.getSanidade());
        setEnergia(personagemLogico.getEnergia());

        setVidaMaxima(6);
        setSedeMaxima(8);
        setFomeMaxima(8);
        setSanidadeMaxima(6);
        setEnergiaMaxima(6);


    }

    public void definirItens() {


    }

    public void getImagemJogador() {
    }

    public void pegarImagemAtaque() {
    }

    public void update() { //Este método atualiza a posição e a animação do jogador com base nas teclas pressionadas


        if (isAtaque() == true) {
            ataque();

        } else if (eventosTeclado.isCimaPressionado() == true || eventosTeclado.isBaixoPressionado() == true || eventosTeclado.isEsquerdaPressionado() == true || eventosTeclado.isDireitaPressionado() == true) {

            if (eventosTeclado.isCimaPressionado()) {
                setDirecao("up");
            } else if (eventosTeclado.isBaixoPressionado()) {
                setDirecao("down");
            } else if (eventosTeclado.isEsquerdaPressionado()) {
                setDirecao("left");
            } else if (eventosTeclado.isDireitaPressionado()) {
                setDirecao("right");
            }

            setColisaoOn(false);

            gp.getcColisoes().checarBloco(this);

            // Checar colisao objeto
            int objIndice = gp.getcColisoes().checarObjeto(this, true);
            pegarObjeto(objIndice);


            // Checar colisao NPC
            int npcIndice = gp.getcColisoes().checarEntidade(this, gp.getNpc());
            interagirNPC(npcIndice);

            //Checar colisao criatura
            int criaturaIndice = gp.getcColisoes().checarEntidade(this, gp.getCriatura());
            //contatoCriatura(criaturaIndice);
            damageCriatura(criaturaIndice);


            // Checar evento
            gp.getManipuladorDeEventos().checarEvento();


            if (!isColisaoOn()) {

                switch (getDirecao()) {
                    case "up":
                        if (getMundoY() - getVelocidade() >= 0) { //Verifica se não vai além do topo
                            setMundoY(getMundoY() - getVelocidade());
                        }
                        break;
                    case "down":
                        if (getMundoY() + getVelocidade() <= gp.getMundoAltura() - gp.getTamanhoBloco()) { //Verifica se não vai além do fundo
                            setMundoY(getMundoY() + getVelocidade());
                        }
                        break;
                    case "left":
                        if (getMundoX() - getVelocidade() >= 0) { //Verifica se não vai além da esquerda
                            setMundoX(getMundoX() - getVelocidade());
                        }
                        break;
                    case "right":
                        if (getMundoX() + getVelocidade() <= gp.getMundoLargura() - gp.getTamanhoBloco()) { //Verifica se não vai além da direita
                            setMundoX(getMundoX() + getVelocidade());
                        }
                        break;
                }

                gp.getEventosTeclado().setEnterPressionado(false);

                setContadorSprite(getContadorSprite() + 1); //Conta quantas vezes o jogador se move e, quando atinge 20, troca a animação
                if (getContadorSprite() > 12) {
                    if (getNumSprite() == 1) {
                        setNumSprite(2);
                    } else if (getNumSprite() == 2) {
                        setNumSprite(1);
                    }
                    setContadorSprite(0);
                }
            }

        }


        if (isInvisibilidade()) {
            setContadorInvisibilidade(getContadorInvisibilidade() + 1);

            if (getContadorInvisibilidade() > 60) {
                setInvisibilidade(false);
                setContadorInvisibilidade(0);
            }
        } else {
            setContadorInvisibilidade(0);
        }

        if (getVida() <= 0) {
            gp.setEstadoJogo(gp.getEstadoJogoFinalizado());
        }


    }

    public void ataque() {

        setContadorSprite(getContadorSprite() + 1);

        if (getContadorSprite() <= 5) {
            setNumSprite(1);
        }
        if (getContadorSprite() > 5 && getContadorSprite() <= 25) {
            setNumSprite(2);
        }
        if (getContadorSprite() > 25) {
            setNumSprite(1);
            setContadorSprite(0);
            setAtaque(false);
        }
    }


    public void pegarObjeto(int i) {

        if (i != 999) {

            String texto;

            if (inventario.size() != tamanhoMaxInventario) {

                inventario.add(gp.getObj()[gp.getMapaAtual()][i]);
                texto = "Pegou " + gp.getObj()[gp.getMapaAtual()][i].getNome() + "!";

                gp.getObj()[gp.getMapaAtual()][i] = null;  // corrigido aqui

            } else {
                texto = "Você atingiu o limite máximo no inventário!";
            }
            gp.getIu().mostrarMensagem(texto);
        }

    }


    public void interagirNPC(int i) {
        if (gp.getEventosTeclado().isEnterPressionado()) {
            if (i != 999) {
                gp.setEstadoJogo(gp.getEstadoDialogo());
                gp.getNpc()[gp.getMapaAtual()][i].falar();
            } else {
                // Se Enter não está pressionado, ativa ataque
                setAtaque(true);
            }
        }
    }


    public void contatoCriatura(int i) {
        if (i != 999) {

            if (isInvisibilidade() == false) {
                setVida(getVida() - 1);
                setInvisibilidade(true);

            }

        }

    }

    public void damageCriatura(int i) {
        if (i != 999) {
            Entidade criatura = gp.getCriatura()[gp.getMapaAtual()][i];

            if (!criatura.isInvisibilidade()) {
                criatura.setVida(criatura.getVida() - 1); // Corrigido aqui
                criatura.setInvisibilidade(true);

                if (criatura.getVida() <= 0) {
                    gp.getCriatura()[gp.getMapaAtual()][i].setMorto(true);
                }
            }
        }
    }


    public void desenhar(Graphics2D g2) { //Este método desenha o jogador na tela
        BufferedImage imagem = null;

        // Escolha da imagem conforme direção e ataque
        switch (getDirecao()) {
            case "up":
                if (!isAtaque()) {
                    imagem = (getNumSprite() == 1) ? getUp1() : getUp2();
                } else {
                    imagem = (getNumSprite() == 1) ? getAtaqueUp1() : getAtaqueUp2();
                }
                break;

            case "down":
                if (!isAtaque()) {
                    imagem = (getNumSprite() == 1) ? getDown1() : getDown2();
                } else {
                    imagem = (getNumSprite() == 1) ? getAtaqueDown1() : getAtaqueDown2();
                }
                break;

            case "left":
                if (!isAtaque()) {
                    imagem = (getNumSprite() == 1) ? getLeft1() : getLeft2();
                } else {
                    imagem = (getNumSprite() == 1) ? getAtaqueLeft1() : getAtaqueLeft2();
                }
                break;

            case "right":
                if (!isAtaque()) {
                    imagem = (getNumSprite() == 1) ? getRight1() : getRight2();
                } else {
                    imagem = (getNumSprite() == 1) ? getAtaqueRight1() : getAtaqueRight2();
                }
                break;
        }

        // Ajuste das posições para evitar que o personagem "saia" da tela
        int x = telaX;
        int y = telaY;

        if (telaX > getMundoX()) {
            x = getMundoX();
        }
        if (telaY > getMundoY()) {
            y = getMundoY();
        }
        int rightOffset = gp.getTelaLargura() - telaX;
        if (rightOffset > gp.getMundoLargura() - getMundoX()) {
            x = gp.getTelaLargura() - (gp.getMundoLargura() - getMundoX());
        }
        int bottomOffset = gp.getTelaAltura() - telaY;
        if (bottomOffset > gp.getMundoAltura() - getMundoY()) {
            y = gp.getTelaAltura() - (gp.getMundoAltura() - getMundoY());
        }

        // Se estiver invisível, aplica transparência
        if (isInvisibilidade()) {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
        }

        // Desenha a imagem com tamanho correto conforme ataque e direção
        if (isAtaque()) {
            if (getDirecao().equals("up") || getDirecao().equals("down")) {
                g2.drawImage(imagem, x, y, gp.getTamanhoBloco(), gp.getTamanhoBloco() * 2, null); // 32x64
            } else {
                g2.drawImage(imagem, x, y, gp.getTamanhoBloco() * 2, gp.getTamanhoBloco(), null); // 64x32
            }
        } else {
            g2.drawImage(imagem, x, y, gp.getTamanhoBloco(), gp.getTamanhoBloco(), null);
        }

        // Reseta a opacidade para 100% (não transparente)
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
    }
}