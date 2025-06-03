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
            case "ouro":
                setDown1(setup("/objetos/ouro", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                setDescricao("[Ouro]\nIdeal para construções.");
                break;

            case "prata":
                setDown1(setup("/objetos/prata", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                setDescricao("[Prata]\nIdeal para construções.");
                break;

            case "esmeralda":
                setDown1(setup("/objetos/esmeralda", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                setDescricao("[Esmeralda]\nIdeal para constru.");
                break;

            case "carvao":
                setDown1(setup("/objetos/carvao", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                setDescricao("[Carvão]\nIdeal para constru.");
                break;


        }
    }
}


