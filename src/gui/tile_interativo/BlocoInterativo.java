package gui.tile_interativo;

import eventos.EventoCriatura;
import gui.entidades.Entidade;
import gui.itens.ALIMENTO_Carne;
import gui.system.PainelJogo;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class BlocoInterativo extends Entidade {

    private PainelJogo gp;

    private boolean destrutivel=false;

    public boolean isDestrutivel() {
        return destrutivel;
    }

    public void setDestrutivel(boolean destrutivel) {
        this.destrutivel = destrutivel;
    }

    public BlocoInterativo(PainelJogo gp){
        super(gp);
        this.gp = gp;

        setTipo(getTipo_presa());
        //setDown1(setup("/tiles_interativos_arvore"));
        setNome("Árvore");
        setVidaMaxima(4);
        setVida(getVidaMaxima());

        setAreaSolida(new Rectangle(3, 18, 42, 30));
        setAreaSolidaPadraoX(getAreaSolida().x);
        setAreaSolidaPadraoY(getAreaSolida().y);
    }

    public void update(){

    }


    public void checarDrop() {
        droparItem(new ALIMENTO_Carne(gp, "carnegalinha"));
    }
}


