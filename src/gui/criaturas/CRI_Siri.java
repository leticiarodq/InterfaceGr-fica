package gui.criaturas;

import eventos.EventoCriatura;
import gui.entidades.Entidade;
import gui.itens.ALIMENTO_Carne;
import gui.system.PainelJogo;

import java.awt.*;
import java.util.Random;

public class CRI_Siri extends Entidade {

    private PainelJogo gp;
    private EventoCriatura criaturaLogica;
    private Random aleatorio = new Random();

    public CRI_Siri(PainelJogo gp) {
        super(gp);
        this.gp = gp;

        setTipo(getTipo_presa());
        setNome("Siri");
        setVelocidade(1);
        setVidaMaxima(2);
        setVida(getVidaMaxima());

        setAreaSolida(new Rectangle(3, 18, 42, 30));
        setAreaSolidaPadraoX(getAreaSolida().x);
        setAreaSolidaPadraoY(getAreaSolida().y);

        carregarImagemSiri();
    }

    public void carregarImagemSiri() {
        setUp1(setup("/animais/siri_01", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setUp2(setup("/animais/siri_02", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setDown1(setup("/animais/siri_01", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setDown2(setup("/animais/siri_02", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setLeft1(setup("/animais/siri_01", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setLeft2(setup("/animais/siri_02", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setRight1(setup("/animais/siri_01", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setRight2(setup("/animais/siri_02", gp.getTamanhoBloco(), gp.getTamanhoBloco()));

    }

    public void setAcao() {
        setContadorDeBloqueioDeAcao(getContadorDeBloqueioDeAcao() + 1);

        if (getContadorDeBloqueioDeAcao() == 120) {
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

}

