package gui.itens;

import gui.entidades.Entidade;
import gui.system.PainelJogo;

public class ALIMENTO_Carne extends Entidade {
    PainelJogo gp;

    public ALIMENTO_Carne(PainelJogo gp, String tipoCarne) {

        super(gp);
        this.gp=gp;
        setTipo(getTipo_consumivel());

        setNome(tipoCarne);

        switch (tipoCarne.toLowerCase()) {
            case "carnecrua":
                setDown1(setup("/alimentos/carnecrua"));
                setDescricao("[Carne Crua]\nPode ser consumida,\nmas há risco de contaminação.\nMelhor assar antes.");
                break;

            case "carneassada":
                setDown1(setup("/alimentos/carne_assada"));
                setDescricao("[Carne Assada]\nSaborosa e segura.\nRecupera bastante fome e\nfornece energia duradoura.");
                break;
        }

    }

    public void usar(Entidade entidade){
        gp.setEstadoJogo(gp.getEstadoDialogo());
        gp.getIu().setDialogoAtual("Você comeu "+ getNome());
        gp.jogador.setFome(getFome()+1);
    }

    public void coletar(Entidade entidade){

        int i=0;
        gp.jogador.getInventario().add(gp.getObj()[gp.getMapaAtual()][i]);
        gp.getIu().mostrarMensagem("Carne crua");

    }

}
