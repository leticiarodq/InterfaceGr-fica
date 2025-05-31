package gui.tile_interativo;

import gui.system.PainelJogo;

public class BI_Arvore extends BlocoInterativo {

    PainelJogo gp;

    public BI_Arvore(PainelJogo gp){

        super(gp);
        this.gp=gp;

        setDown1(setup("/tiles_interativos/arvore"));
        setDestrutivel(true);
    }
}
