package gui.objetos;

import gui.entidades.Entidade;
import gui.system.PainelJogo;

public class REMEDIO_Bandagem extends Entidade {

    public REMEDIO_Bandagem(PainelJogo gp) {

        super(gp);

        setNome("Bandagem");
        setDown1(setup("/objetos/bandagem"));
        setColisao(true);
        setDescricao("["+ getNome() +"]\nUsada para estancar\nsangramentos e\nproteger ferimentos\nleves.");


    }
}
