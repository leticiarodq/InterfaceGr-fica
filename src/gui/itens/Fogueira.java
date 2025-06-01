package gui.itens;

import gui.entidades.Entidade;
import gui.system.PainelJogo;

public class Fogueira extends Entidade {

    private PainelJogo gp;

    public Fogueira(PainelJogo gp) {

        super(gp);
        this.gp=gp;

        setTipo(tipo_fogueira);
        setNome("Fogueira");
        setDown1(setup("/objetos/fogueira", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setColisao(true);
        setDescricao("[Fogueira]");

    }

}
