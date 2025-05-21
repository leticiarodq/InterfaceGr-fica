package gui.objetos;

import gui.entidades.Entidade;
import gui.system.PainelJogo;
import itens.Remedio;

public class REMEDIO_Antibiotico extends Entidade {

    private Remedio remedioLogico;

    public REMEDIO_Antibiotico(PainelJogo gp) {

        super(gp);

        remedioLogico=new Remedio("Remédio", 10, 10, "Antibiótico", "Combate infecções internas", 1);

        setNome(remedioLogico.getTipo());
        setDown1(setup("/objetos/antibiotico"));
        setColisao(true);
        setDescricao("["+ getNome() +"]\nCombate infecções internas.");


    }
}
