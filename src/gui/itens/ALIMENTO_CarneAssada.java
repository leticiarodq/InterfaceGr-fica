package gui.itens;

import gui.entidades.Entidade;
import gui.system.PainelJogo;
import itens.Alimento;

public class ALIMENTO_CarneAssada extends Entidade {

    private PainelJogo gp;
    private Alimento alimentoLogico;


    public ALIMENTO_CarneAssada(PainelJogo gp, String tipoCarneAssada) {

        super(gp);
        this.gp = gp;
        setTipo(getTipo_consumivel());


        setNome(tipoCarneAssada);

        switch (tipoCarneAssada.toLowerCase()) {
            case "carneurso":
                setNome("Carne de Urso Assada");
                alimentoLogico=new Alimento("Carne de Urso Assada", 1, 5, "Carne assada", 2, 0);
                alimentoLogico.setValorNutricional(2);
                setDown1(setup("/alimentos/carneursoassada", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                setDescricao("[Carne de Urso Assada]\nCarne crua e pesada\nretirada de um urso.");
                break;

            case "carneporco":
                setNome("Carne de Porco Assada");
                alimentoLogico=new Alimento("Carne de Porco Assada", 1, 5, "Carne assada", 2, 0);
                alimentoLogico.setValorNutricional(2);
                setDown1(setup("/alimentos/carneporcoassada", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                setDescricao("[Carne de Porco Assada]\nPedaço cru de carne\nsuína.");
                break;


            case "carnegalinha":
                setNome("Carne de Galinha Assada");
                alimentoLogico=new Alimento("Carne de Galinha Assada", 1, 5, "Carne assada", 2, 0);
                alimentoLogico.setValorNutricional(2);
                setDown1(setup("/alimentos/carnegalinhaassada", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                setDescricao("[Carne de Galinha Assada]\nPedaço cru de carne\nde galinha.");
                break;

            case "carnelobo":
                setNome("Carne de Lobo Assada");
                alimentoLogico=new Alimento("Carne de Lobo Assada", 1, 5, "Carne assada", 2, 0);
                alimentoLogico.setValorNutricional(2);
                setDown1(setup("/alimentos/carneloboassada", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                setDescricao("[Carne de Lobo Crua]\nPedaço cru de carne\nde lobo.");
                break;
        }

    }
}
