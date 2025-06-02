package gui.criaturas;

import eventos.EventoCriatura;
import gui.entidades.Entidade;
import gui.itens.ALIMENTO_Carne;
import gui.system.PainelJogo;

import java.awt.*;
import java.util.Random;

public class BI_Peixe extends Entidade implements Aquatico {

    private PainelJogo gp;
    private EventoCriatura criaturaLogica;
    private Random aleatorio = new Random();

    public BI_Peixe(PainelJogo gp){
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

        carregarImagemPeixe();
    }

    public boolean podeAtravessar(int tileId) {
        // Lista dos IDs dos tiles que o peixe pode atravessar
        // Exemplo: se água = tile 5, areia = tile 3
        int[] tilesQueOPeixePodeAtravessar = {59}; // Mude esses números pelos IDs corretos


        for (int tile : tilesQueOPeixePodeAtravessar) {
            if (tile == tileId) {
                return true; // Pode atravessar
            }
        }
        return false; // Não pode atravessar
    }






    public void carregarImagemPeixe() {
        setUp1(setup("/animais/peixe01_up_01", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setUp2(setup("/animais/peixe01_up_02", gp.getTamanhoBloco(), gp.getTamanhoBloco()));

        setDown1(setup("/animais/peixe01_down_01", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setDown2(setup("/animais/peixe01_down_02", gp.getTamanhoBloco(), gp.getTamanhoBloco()));

        setLeft1(setup("/animais/peixe01_left_01", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setLeft2(setup("/animais/peixe01_left_02", gp.getTamanhoBloco(), gp.getTamanhoBloco()));

        setRight1(setup("/animais/peixe01_right_01", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setRight2(setup("/animais/peixe01_right_02", gp.getTamanhoBloco(), gp.getTamanhoBloco()));

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
