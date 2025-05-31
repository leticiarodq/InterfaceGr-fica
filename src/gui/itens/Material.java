package gui.itens;

import gui.entidades.Entidade;
import gui.system.PainelJogo;

public class Material extends Entidade {

    public Material(PainelJogo gp, String tipoMaterial) {
        super(gp);
        setTipo(getTipo_dropavel());

        setNome(tipoMaterial);

        switch (tipoMaterial.toLowerCase()) {

            case "madeira":
                setDown1(setup("/material/madeira", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                setDescricao("[Madeira]\nIdeal para construções.");
                break;


        }
    }
}


