package gui.criaturas;

import eventos.EventoCriatura;
import gui.entidades.Entidade;
import gui.itens.ALIMENTO_Carne;
import gui.system.PainelJogo;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class CRI_Galinha extends Entidade {

    private PainelJogo gp;
    private EventoCriatura criaturaLogica;
    private Random aleatorio = new Random();

    public CRI_Galinha(PainelJogo gp){
        super(gp);
        this.gp = gp;

        setTipo(getTipo_presa());
        setNome("Galinha");
        setVelocidade(1);
        setVidaMaxima(2);
        setVida(getVidaMaxima());

        setAreaSolida(new Rectangle(3, 18, 42, 30));
        setAreaSolidaPadraoX(getAreaSolida().x);
        setAreaSolidaPadraoY(getAreaSolida().y);

        carregarImagemGalinha();
    }

    public void carregarImagemGalinha() {
        try {
            setUp1(ImageIO.read(getClass().getResourceAsStream("/animais/galinha_up_01.png")));
            setUp2(ImageIO.read(getClass().getResourceAsStream("/animais/galinha_up_02.png")));
            setDown1(ImageIO.read(getClass().getResourceAsStream("/animais/galinha_down_01.png")));
            setDown2(ImageIO.read(getClass().getResourceAsStream("/animais/galinha_down_02.png")));
            setLeft1(ImageIO.read(getClass().getResourceAsStream("/animais/galinha_left_01.png")));
            setLeft2(ImageIO.read(getClass().getResourceAsStream("/animais/galinha_left_02.png")));
            setRight1(ImageIO.read(getClass().getResourceAsStream("/animais/galinha_right_01.png")));
            setRight2(ImageIO.read(getClass().getResourceAsStream("/animais/galinha_right_02.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setAcao(){
        setContadorDeBloqueioDeAcao(getContadorDeBloqueioDeAcao() + 1);

        if(getContadorDeBloqueioDeAcao() == 120) {
            int i = aleatorio.nextInt(100) + 1;

            if (i <= 25) {
                setDirecao("up");
            } else if (i <= 50) {
                setDirecao("down");
            } else if (i <= 75) {
                setDirecao("left");
            } else {
                setDirecao("right");
            }

            setContadorDeBloqueioDeAcao(0);
        }
    }

    public void checarDrop() {
        droparItem(new ALIMENTO_Carne(gp, "carnegalinha"));
    }
}
