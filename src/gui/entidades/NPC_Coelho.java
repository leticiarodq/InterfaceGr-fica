package gui.entidades;

import gui.system.PainelJogo;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Random;

public class NPC_Coelho extends Entidade{

    PainelJogo gp;
    private Random aleatorio = new Random();


    public NPC_Coelho(PainelJogo gp){
        super(gp);
        this.gp = gp;




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


}
