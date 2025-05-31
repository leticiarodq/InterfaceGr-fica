package gui.criaturas;

import eventos.EventoCriatura;
import gui.entidades.Entidade;
import gui.itens.ALIMENTO_Carne;
import gui.itens.ALIMENTO_Fruta;
import gui.itens.REMEDIO_Analgesico;
import gui.system.PainelJogo;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class CRI_Urso extends Entidade {

    private PainelJogo gp;

    private EventoCriatura criaturaLogica;
    private Random aleatorio = new Random();

    public CRI_Urso(PainelJogo gp) {

        super(gp);
        this.gp = gp;
        setTipo(getTipo_criatura());
        setNome("Urso");
        setVelocidade(1);
        setVidaMaxima(8);
        setVida(getVidaMaxima());

        setAreaSolida(new Rectangle(3, 18, 42, 30));
        setAreaSolidaPadraoX(getAreaSolida().x);
        setAreaSolidaPadraoY(getAreaSolida().y);

        carregarImagemUrso();
    }

    public void carregarImagemUrso() {
        try {
            setUp1(ImageIO.read(getClass().getResourceAsStream("/animais/urso_up_01.png")));
            setUp2(ImageIO.read(getClass().getResourceAsStream("/animais/urso_up_02.png")));
            setDown1(ImageIO.read(getClass().getResourceAsStream("/animais/urso_down_01.png")));
            setDown2(ImageIO.read(getClass().getResourceAsStream("/animais/urso_down_02.png")));
            setLeft1(ImageIO.read(getClass().getResourceAsStream("/animais/urso_left_01.png")));
            setLeft2(ImageIO.read(getClass().getResourceAsStream("/animais/urso_left_02.png")));
            setRight1(ImageIO.read(getClass().getResourceAsStream("/animais/urso_right_01.png")));
            setRight2(ImageIO.read(getClass().getResourceAsStream("/animais/urso_right_02.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setAcao() {

        setContadorDeBloqueioDeAcao(getContadorDeBloqueioDeAcao() + 1);

        if (getContadorDeBloqueioDeAcao() == 120) {
            int i = aleatorio.nextInt(100) + 1; // Coleta um número de 1 a 100

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

    public void checarDrop() {

        droparItem(new ALIMENTO_Carne(gp, "carneurso"));

    }

}
