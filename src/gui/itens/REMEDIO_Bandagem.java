package gui.itens;

import gui.entidades.Entidade;
import gui.system.PainelJogo;
import itens.Remedio;

public class REMEDIO_Bandagem extends Entidade {

    private Remedio remedioLogico;

    public REMEDIO_Bandagem(PainelJogo gp) {

        super(gp);

        remedioLogico=new Remedio("Remédio", 1, 10, "Bandagem", "Estancar sangramentos e proteger ferimentos leves", 1);
        setTipo(getTipo_consumivel());

        setNome(remedioLogico.getTipo());
        setDown1(setup("/objetos/bandagem"));
        setColisao(true);
        setDescricao("["+ getNome() +"]\nUsada para estancar\nsangramentos e\nproteger ferimentos\nleves.");


    }
}
