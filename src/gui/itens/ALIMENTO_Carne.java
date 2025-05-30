package gui.itens;

import gui.entidades.Entidade;
import gui.system.PainelJogo;

public class ALIMENTO_Carne extends Entidade {

    public ALIMENTO_Carne(PainelJogo gp, String tipoCarne) {

        super(gp);
        setTipo(getTipo_consumivel());

        setNome(tipoCarne);

        switch (tipoCarne.toLowerCase()) {
            case "Carne crua":
                setDown1(setup("/alimentos/carne_crua"));
                setDescricao("[Carne Crua]\nPode ser consumida,\nmas há risco de contaminação.\nMelhor assar antes.");
                break;

            case "Carne assada":
                setDown1(setup("/alimentos/carne_assada"));
                setDescricao("[Carne Assada]\nSaborosa e segura.\nRecupera bastante fome e\nfornece energia duradoura.");
                break;
        }


    }
}
