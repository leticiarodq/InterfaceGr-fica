package gui.tile_interativo;

import gui.system.PainelJogo;

import java.awt.*;

public class Caldeirao extends BlocoInterativo {

    private PainelJogo gp;

    public Caldeirao(PainelJogo gp, int coluna, int linha) {

        super(gp, coluna, linha);
        this.gp = gp;
        setVelocidade(1);
        setTipo(getTipo_armadilha());

        setDown1(setup("/objetos/caldeirao", gp.getTamanhoBloco()*2, gp.getTamanhoBloco()*2));
        setDown2(setup("/tiles_interativos/armadilha_02", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco() * 2));

        setAreaSolida(new Rectangle(8, 8, 16, 16));
        setAreaSolidaPadraoX(getAreaSolida().x);
        setAreaSolidaPadraoY(getAreaSolida().y);

        setDestrutivel(true);

        this.setMundoX(gp.getTamanhoBloco() * coluna);
        this.setMundoY(gp.getTamanhoBloco() * linha);

    }
}
