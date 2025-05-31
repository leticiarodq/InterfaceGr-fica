package gui.itens;

import gui.entidades.Entidade;
import gui.system.PainelJogo;
import itens.Remedio;

public class REMEDIO_Bandagem extends Entidade {

    private Remedio remedioLogico;

    private PainelJogo gp;
    public REMEDIO_Bandagem(PainelJogo gp) {

        super(gp);
        this.gp=gp;

        remedioLogico=new Remedio("Remédio", 1, 10, "Bandagem", "Estancar sangramentos e proteger ferimentos leves", 1);
        setTipo(getTipo_consumivel());

        setNome(remedioLogico.getTipo());
        setDown1(setup("/objetos/bandagem",gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setColisao(true);
        setDescricao("["+ getNome() +"]\nUsada para estancar\nsangramentos e\nproteger ferimentos\nleves.");


    }
}
