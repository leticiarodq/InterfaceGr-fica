package gui.itens;

import gui.entidades.Entidade;
import gui.system.PainelJogo;
import itens.Remedio;

public class REMEDIO_PocaoSanidade extends Entidade {

    private Remedio remedioLogico;

    private PainelJogo gp;

    public REMEDIO_PocaoSanidade(PainelJogo gp) {

        super(gp);
        this.gp=gp;

        remedioLogico=new Remedio("Remédio", 10, 10, "Antibiótico", "Combate infecções internas", 1);
        setTipo(getTipo_remedio());

        setNome(remedioLogico.getTipo());
        setDown1(setup("/objetos/pocao2", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setColisao(true);
        setDescricao("["+ getNome() +"]\nCombate infecções\ninternas.");


    }

    public void usar(Entidade entidade){
        gp.setEstadoJogo(gp.getEstadoDialogo());
        gp.getIu().setDialogoAtual("Você recuperou 1 ponto de sanidade!");
        entidade.setSanidade(entidade.getSanidade()+1);
    }
}
