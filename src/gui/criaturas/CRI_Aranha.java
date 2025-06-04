package gui.criaturas;

import enums.TipoAcaoCriatura;
import eventos.EventoCriatura;
import gui.entidades.Entidade;
import gui.system.PainelJogo;
import personagens.Criatura;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class CRI_Aranha extends Entidade {

    private PainelJogo gp;

    private Criatura criaturaLogica;
    private Random aleatorio = new Random();

    public CRI_Aranha(PainelJogo gp) {

        super(gp);
        setTipo(getTipo_criatura());
        this.criaturaLogica=new Criatura("Aranha", 2, 8, TipoAcaoCriatura.PICA_VENENO );

        setNome(criaturaLogica.getNome());
        setVelocidade(1);
        setVidaMaxima(criaturaLogica.getVida());
        setVida(criaturaLogica.getVida());

        setAreaSolida(new Rectangle(3, 18, 42, 30));
        setAreaSolidaPadraoX(getAreaSolida().x);
        setAreaSolidaPadraoY(getAreaSolida().y);

        carregarImagemAranha();
    }

    public void carregarImagemAranha() {
        try {
            setUp1(ImageIO.read(getClass().getResourceAsStream("/animais/aranha_up_01.png")));
            setUp2(ImageIO.read(getClass().getResourceAsStream("/animais/aranha_up_02.png")));
            setDown1(ImageIO.read(getClass().getResourceAsStream("/animais/aranha_down_01.png")));
            setDown2(ImageIO.read(getClass().getResourceAsStream("/animais/aranha_down_02.png")));
            setLeft1(ImageIO.read(getClass().getResourceAsStream("/animais/aranha_left_01.png")));
            setLeft2(ImageIO.read(getClass().getResourceAsStream("/animais/aranha_left_02.png")));
            setRight1(ImageIO.read(getClass().getResourceAsStream("/animais/aranha_right_01.png")));
            setRight2(ImageIO.read(getClass().getResourceAsStream("/animais/aranha_right_02.png")));
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
}
