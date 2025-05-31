package gui.itens;

import gui.entidades.Entidade;
import gui.system.PainelJogo;
import itens.Remedio;

public class REMEDIO_Antibiotico extends Entidade {

    private Remedio remedioLogico;

    private PainelJogo gp;

    public REMEDIO_Antibiotico(PainelJogo gp) {

        super(gp);
        this.gp=gp;

        remedioLogico=new Remedio("Remédio", 10, 10, "Antibiótico", "Combate infecções internas", 1);
        setTipo(getTipo_consumivel());

        setNome(remedioLogico.getTipo());
        setDown1(setup("/objetos/antibiotico", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setColisao(true);
        setDescricao("["+ getNome() +"]\nCombate infecções\ninternas.");


    }
}
