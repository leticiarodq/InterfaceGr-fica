package gui.objetos;

import gui.entidades.Entidade;
import gui.system.PainelJogo;

public class REMEDIO_Analgesico extends Entidade {

    public REMEDIO_Analgesico(PainelJogo gp) {

        super(gp);

        setNome("Analgésico");
        setDown1(setup("/objetos/analgesico"));
        setColisao(true);
        setDescricao("["+ getNome() +"]\nAlivia a dor rapidamente.\nÚtil em situações de\nemergência.");

    }
}
