package gui.itens;

import gui.entidades.Entidade;
import gui.system.PainelJogo;

public class ALIMENTO_CarneAssada extends Entidade {

    private PainelJogo gp;
    public ALIMENTO_CarneAssada(PainelJogo gp, String tipoCarneAssada) {

        super(gp);
        this.gp = gp;
        setTipo(getTipo_consumivel());

        setNome(tipoCarneAssada);

        switch (tipoCarneAssada.toLowerCase()) {
            case "carneurso":
                setNome("Carne de Urso Crua");
                setDown1(setup("/alimentos/carneurso", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                setDescricao("[Carne de Urso Crua]\nCarne crua e pesada\nretirada de um urso.");
                break;

            case "carneporco":
                setNome("Carne de Porco Crua");
                setDown1(setup("/alimentos/carneporco", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                setDescricao("[Carne de Porco Crua]\nPedaço cru de carne\nsuína.");
                break;


            case "carnegalinha":
                setNome("Carne de Galinha Crua");
                setDown1(setup("/alimentos/carnegalinha", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                setDescricao("[Carne de Galinha Cria]\nPedaço cru de carne\nde galinha.");
                break;

            case "carnelobo":
                setNome("Carne de Lobo Crua");
                setDown1(setup("/alimentos/carnelobo", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                setDescricao("[Carne de Lobo Crua]\nPedaço cru de carne\nde lobo.");
                break;
        }

    }
}
