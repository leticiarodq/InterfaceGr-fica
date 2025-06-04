package gui.tile_interativo;

import gui.entidades.Entidade;
import gui.system.PainelJogo;

public class BI_Armadilha extends BlocoInterativo {
    private int contadorAnimacao = 0;
    private int intervaloAnimacao = 20; // número de frames para trocar de imagem
    private boolean usandoSprite1 = true;

    private PainelJogo gp;

    public BI_Armadilha(PainelJogo gp, int coluna, int linha) {

        super(gp, coluna, linha);
        this.gp = gp;
        setVelocidade(1);
        setTipo(getTipo_armadilha());

        setDown1(setup("/tiles_interativos/armadilha_01", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco() * 2));
        setDown2(setup("/tiles_interativos/armadilha_02", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco() * 2));
        //setUp1(setup("/tiles_interativos/armadilha_03", gp.getTamanhoBloco()*2, gp.getTamanhoBloco()*2));
        //setUp2(setup("/tiles_interativos/armadilha_04", gp.getTamanhoBloco()*2, gp.getTamanhoBloco()*2));
        //setLeft1(setup("/tiles_interativos/armadilha_01", gp.getTamanhoBloco()*2 , gp.getTamanhoBloco()*2));
        //setLeft2(setup("/tiles_interativos/armadilha_02", gp.getTamanhoBloco()*2 , gp.getTamanhoBloco()*2));
        //setRight1(setup("/tiles_interativos/armadilha_03", gp.getTamanhoBloco()*2 , gp.getTamanhoBloco()*2));
        //setRight2(setup("/tiles_interativos/armadilha_04", gp.getTamanhoBloco()*2 , gp.getTamanhoBloco()*2));
        setDestrutivel(true);

        this.setMundoX(gp.getTamanhoBloco() * coluna);
        this.setMundoY(gp.getTamanhoBloco() * linha);

    }

    public void cairArmadilha(Entidade entidade){

        entidade.setVida(getVida()-1);

    }

}




