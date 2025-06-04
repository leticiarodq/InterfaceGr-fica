package gui.criaturas;

import eventos.EventoCriatura;
import gui.entidades.Entidade;
import gui.itens.ALIMENTO_Carne;
import gui.system.PainelJogo;

import java.awt.*;
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
        setVelocidade(2);
        setVidaMaxima(10);
        setVida(getVidaMaxima());

        setAreaSolida(new Rectangle(3, 18, 64, 64));
        setAreaSolidaPadraoX(getAreaSolida().x);
        setAreaSolidaPadraoY(getAreaSolida().y);

        carregarImagemUrso();
    }

    public void carregarImagemUrso() {
        setUp1(setup("/animais/urso_up_01", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco() * 2));
        setUp2(setup("/animais/urso_up_02", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco() * 2));
        setDown1(setup("/animais/urso_down_01", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco() * 2));
        setDown2(setup("/animais/urso_down_02", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco() * 2));
        setLeft1(setup("/animais/urso_left_01", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco() * 2));
        setLeft2(setup("/animais/urso_left_02", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco() * 2));
        setRight1(setup("/animais/urso_right_01", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco() * 2));
        setRight2(setup("/animais/urso_right_02", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco() * 2));


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
