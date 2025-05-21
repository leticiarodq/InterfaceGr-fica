package gui.objetos;

import gui.entidades.Entidade;
import gui.system.FerramentasUteis;
import gui.system.PainelJogo;
import itens.Alimento;

public class ALIMENTO_Enlatado extends Entidade {

    private Alimento alimentoLogica;


    public ALIMENTO_Enlatado(PainelJogo gp) {

        super(gp);

        setNome("Lata de feijão");
        setDown1(setup("/alimentos/enlatado01"));
        setDescricao("["+ getNome() +"]\nMata a fome e é fácil de\nencontrar.");

        setColisao(true);
    }
}
