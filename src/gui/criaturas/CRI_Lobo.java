package gui.criaturas;

import eventos.EventoCriatura;
import gui.entidades.Entidade;
import gui.itens.ALIMENTO_Carne;
import gui.system.PainelJogo;

import java.awt.*;
import java.util.Random;

public class CRI_Lobo extends Entidade {

    private PainelJogo gp;

    private EventoCriatura criaturaLogica;
    private Random aleatorio = new Random();

    public CRI_Lobo(PainelJogo gp){

        super(gp);
        this.gp=gp;
        setTipo(getTipo_criatura());
        setNome("Lobo");
        setVelocidade(1);
        setVidaMaxima(6);
        setVida(getVidaMaxima());

        setAreaSolida(new Rectangle(3, 18, 42, 30));
        setAreaSolidaPadraoX(getAreaSolida().x);
        setAreaSolidaPadraoY(getAreaSolida().y);

        carregarImagemLobo();

    }

    public void carregarImagemLobo() {

        setUp1(setup("/animais/lobo_up_01", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setUp2(setup("/animais/lobo_up_02", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setDown1(setup("/animais/lobo_down_01", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setDown2(setup("/animais/lobo_down_02", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setLeft1(setup("/animais/lobo_left_01", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setLeft2(setup("/animais/lobo_left_02", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setRight1(setup("/animais/lobo_right_01", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setRight2(setup("/animais/lobo_right_02", gp.getTamanhoBloco(), gp.getTamanhoBloco()));


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


    public void checarDrop() {

        droparItem(new ALIMENTO_Carne(gp, "carnelobo"));

    }
}
