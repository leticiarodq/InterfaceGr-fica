package gui.criaturas;

import gui.entidades.Entidade;
import gui.system.PainelJogo;

import java.awt.*;
import java.util.Random;

public class CRI_Raia extends Entidade implements Aquatico {

    private PainelJogo gp;
    private Random aleatorio = new Random();

    public CRI_Raia(PainelJogo gp){
        super(gp);
        this.gp = gp;

        setTipo(getTipo_presa());
        setNome("Peixe");
        setVelocidade(1);
        setVidaMaxima(2);
        setVida(getVidaMaxima());

        setAreaSolida(new Rectangle(3, 18, 42, 30));
        setAreaSolidaPadraoX(getAreaSolida().x);
        setAreaSolidaPadraoY(getAreaSolida().y);

        carregarImagemRaia();
    }

    public boolean podeAtravessar(int tileId) {

        int[] tilesQueOPeixePodeAtravessar = {59};


        for (int tile : tilesQueOPeixePodeAtravessar) {
            if (tile == tileId) {
                return true;
            }
        }
        return false;
    }

    public void carregarImagemRaia() {
        setUp1(setup("/animais/raia_up_01", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setUp2(setup("/animais/raia_up_02", gp.getTamanhoBloco(), gp.getTamanhoBloco()));

        setDown1(setup("/animais/raia_down_01", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setDown2(setup("/animais/raia_down_02", gp.getTamanhoBloco(), gp.getTamanhoBloco()));

        setLeft1(setup("/animais/raia_left_01", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setLeft2(setup("/animais/raia_left_02", gp.getTamanhoBloco(), gp.getTamanhoBloco()));

        setRight1(setup("/animais/raia_right_01", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setRight2(setup("/animais/raia_right_02", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
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

 
}
