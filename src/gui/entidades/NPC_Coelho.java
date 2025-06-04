package gui.entidades;

import gui.system.PainelJogo;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class NPC_Coelho extends Entidade{

    PainelJogo gp;
    private Random aleatorio = new Random();

    private int limiteEsquerda;
    private int limiteDireita;
    private int limiteTopo;
    private int limiteFundo;


    public NPC_Coelho(PainelJogo gp){
        super(gp);
        this.gp = gp;

        int inicioColuna = 10;
        int inicioLinha = 10;

        this.limiteEsquerda = inicioColuna * gp.getTamanhoBloco();
        this.limiteDireita  = (inicioColuna + 35) * gp.getTamanhoBloco();
        this.limiteTopo     = inicioLinha * gp.getTamanhoBloco();
        this.limiteFundo    = (inicioLinha + 35) * gp.getTamanhoBloco();

        setDirecao("down");
        setVelocidade(1);
        carregarImagemCoelho();
        setDialogo();
    }


    public void carregarImagemCoelho() {
        try {
            setUp1(ImageIO.read(getClass().getResourceAsStream("/animais/coelho_up_01.png")));
            setUp2(ImageIO.read(getClass().getResourceAsStream("/animais/coelho_up_02.png")));
            setDown1(ImageIO.read(getClass().getResourceAsStream("/animais/coelho_down_01.png")));
            setDown2(ImageIO.read(getClass().getResourceAsStream("/animais/coelho_down_02.png")));
            setLeft1(ImageIO.read(getClass().getResourceAsStream("/animais/coelho_left_01.png")));
            setLeft2(ImageIO.read(getClass().getResourceAsStream("/animais/coelho_left_02.png")));
            setRight1(ImageIO.read(getClass().getResourceAsStream("/animais/coelho_right_01.png")));
            setRight2(ImageIO.read(getClass().getResourceAsStream("/animais/coelho_right_02.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

   public void setDialogo(){

        getDialogos()[0]="Snif snif";

    }



    public void setAcao(){

        setContadorDeBloqueioDeAcao(getContadorDeBloqueioDeAcao() + 1);

        if(getContadorDeBloqueioDeAcao() == 120) {
            int i = aleatorio.nextInt(100) + 1;// Coleta um número de 1 a 100

            if (i <= 25) {
                setDirecao("up");
            }
            if (i > 25 && i <= 50) {
                setDirecao("down");
            }
            if (i > 50 && i <= 75) {
                setDirecao("left");
            }
            if (i > 75 && i <= 100) {
                setDirecao("right");
            }

            setContadorDeBloqueioDeAcao(0);

        }


    }

    public void falar() {
        if(getDialogos()[getIndiceDialogo()] == null){
            setIndiceDialogo(0);
        }

        gp.getIu().setDialogoAtual(getDialogos()[getIndiceDialogo()]);
        setIndiceDialogo(getIndiceDialogo() + 1);

        if (gp.jogador.getSanidade() < gp.jogador.getSanidadeMaxima()) {
            gp.jogador.setSanidade(gp.jogador.getSanidadeMaxima());
        }

        switch(gp.jogador.getDirecao()) {
            case "up":
                setDirecao("down");
                break;
            case "down":
                setDirecao("up");
                break;
            case "left":
                setDirecao("right");
                break;
            case "right":
                setDirecao("left");
                break;
        }
    }

    @Override
    public void update() {
        setAcao();

        setColisaoOn(false);
        gp.getcColisoes().checarBloco(this);
        gp.getcColisoes().checarObjeto(this, false);
        gp.getcColisoes().checarJogador(this);

        if (!isColisaoOn()) {
            int novoX = getMundoX();
            int novoY = getMundoY();

            switch (getDirecao()) {
                case "up":
                    novoY -= getVelocidade();
                    break;
                case "down":
                    novoY += getVelocidade();
                    break;
                case "left":
                    novoX -= getVelocidade();
                    break;
                case "right":
                    novoX += getVelocidade();
                    break;
            }

            // Só move se estiver dentro da área permitida
            if (novoX >= limiteEsquerda && novoX <= limiteDireita &&
                    novoY >= limiteTopo && novoY <= limiteFundo) {
                setMundoX(novoX);
                setMundoY(novoY);
            }

            // Animação
            setContadorSprite(getContadorSprite() + 1);
            if (getContadorSprite() > 20) {
                setNumSprite(getNumSprite() == 1 ? 2 : 1);
                setContadorSprite(0);
            }
        }
    }



}
