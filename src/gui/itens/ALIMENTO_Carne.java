package gui.itens;

import gui.entidades.Entidade;
import gui.system.PainelJogo;
import itens.Alimento;

public class ALIMENTO_Carne extends Entidade {
    PainelJogo gp;

    private Alimento alimentoLogico;

    public ALIMENTO_Carne(PainelJogo gp, String tipoCarne) {

        super(gp);
        this.gp = gp;
        setTipo(getTipo_dropavelConsumivel());

        setNome(tipoCarne);

        switch (tipoCarne.toLowerCase()) {
            case "carneurso":
                setNome("Carne de Urso Crua");
                alimentoLogico=new Alimento("Carne de urso", 1, 5, "Carne crua", 1, 0);
                alimentoLogico.setValorNutricional(1);
                setDown1(setup("/alimentos/carneurso", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                setDescricao("[Carne de Urso Crua]\nCarne crua e pesada\nretirada de um urso.");
                break;

            case "carneporco":
                setNome("Carne de Porco Crua");
                alimentoLogico=new Alimento("Carne de porco crua", 1, 5, "Carnne crua", 1, 0);
                alimentoLogico.setValorNutricional(1);
                setDown1(setup("/alimentos/carneporco", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                setDescricao("[Carne de Porco Crua]\nPedaço cru de carne\nsuína.");
                break;


            case "carnegalinha":
                setNome("Carne de Galinha Crua");
                alimentoLogico= new Alimento("Carne de galinha crua", 1, 5, "Carne crua", 1, 0);
                alimentoLogico.setValorNutricional(1);
                setDown1(setup("/alimentos/carnegalinha", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                setDescricao("[Carne de Galinha Crua]\nPedaço cru de carne\nde galinha.");
                break;

            case "carnelobo":
                setNome("Carne de Lobo Crua");
                alimentoLogico=new Alimento("Carne de lobo crua", 1, 5, "Carne crua", 1, 0);
                alimentoLogico.setValorNutricional(1);
                setDown1(setup("/alimentos/carnelobo", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                setDescricao("[Carne de Lobo Crua]\nPedaço cru de carne\nde lobo.");
                break;
        }

    }

    public void usar(Entidade entidade) {
           entidade.setFome(entidade.getFome() + alimentoLogico.getValorNutricional());

    }

    public void coletar(Entidade entidade) {
        int i = 0;
        gp.jogador.getInventario().add(gp.getObj()[gp.getMapaAtual()][i]);
        gp.getIu().mostrarMensagem("Coletou "+alimentoLogico.getNome()+"!");

    }

}
