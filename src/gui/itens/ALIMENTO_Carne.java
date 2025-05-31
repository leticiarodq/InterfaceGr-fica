package gui.itens;

import gui.entidades.Entidade;
import gui.system.PainelJogo;

public class ALIMENTO_Carne extends Entidade {
    PainelJogo gp;
    int valor=1;
    public ALIMENTO_Carne(PainelJogo gp, String tipoCarne) {

        super(gp);
        this.gp = gp;
        setTipo(getTipo_dropavelConsumivel());

        setNome(tipoCarne);

        switch (tipoCarne.toLowerCase()) {
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
        }

    }

    public void usar(Entidade entidade) {

            gp.setEstadoJogo(gp.getEstadoDialogo());
            gp.getIu().setDialogoAtual("Você comeu" + getNome()+"!");
            entidade.setFome(entidade.getFome() + valor);



    }

    public void coletar(Entidade entidade) {

        int i = 0;
        gp.jogador.getInventario().add(gp.getObj()[gp.getMapaAtual()][i]);
        gp.getIu().mostrarMensagem("Coletou "+getNome()+"!");


    }

}
