package gui.itens;

import gui.entidades.Entidade;
import gui.system.PainelJogo;

public class ALIMENTO_Carne extends Entidade {
    PainelJogo gp;
    int valor=1;
    public ALIMENTO_Carne(PainelJogo gp, String tipoCarne) {

        super(gp);
        this.gp = gp;
        setTipo(getTipo_dropavel());

        setNome(tipoCarne);

        switch (tipoCarne.toLowerCase()) {
            case "carneurso":
                setNome("Carne de Urso Crua");
                setDown1(setup("/alimentos/carneurso"));
                setDescricao("[Carne de Urso Crua]\nCarne crua e pesada\nretirada de um urso.");
                break;



            case "carneporco":
                setNome("Carne de Porco Crua");
                setDown1(setup("/alimentos/carneporco"));
                setDescricao("[Carne de orco Crua]\nPedaço cru de carne\nsuína.");
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
