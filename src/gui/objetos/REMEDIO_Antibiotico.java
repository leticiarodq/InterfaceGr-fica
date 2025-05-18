package gui.objetos;

import gui.entidades.Entidade;
import gui.system.PainelJogo;

public class REMEDIO_Antibiotico extends Entidade {

    public REMEDIO_Antibiotico(PainelJogo gp) {

        super(gp);

        setNome("Antibiótico");
        setDown1(setup("/objetos/antibiotico"));
        setColisao(true);
        setDescricao("["+ getNome() +"]\nCombate infecções\ninternas.");


    }
}
