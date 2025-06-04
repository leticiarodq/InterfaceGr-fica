package gui.itens;

import gui.entidades.Entidade;
import gui.system.PainelJogo;

public class Material extends Entidade {

    private itens.Material materialLogico;

    public Material(PainelJogo gp, String tipoMaterial) {
        super(gp);
        setTipo(getTipo_dropavel());

        setNome(tipoMaterial);

        switch (tipoMaterial.toLowerCase()) {

            case "madeira":
                setDown1(setup("/material/madeira", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                materialLogico=new itens.Material("Madeira", 1, 0, "Construção", 1);
                setDescricao("[Madeira]\nIdeal para construções.");
                break;
            case "ouro":
                setDown1(setup("/objetos/ouro", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                materialLogico=new itens.Material("Ouro", 1, 0, "Troca", 1);
                setDescricao("[Ouro]\nIdeal para construções.");
                break;

            case "prata":
                setDown1(setup("/objetos/prata", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                materialLogico=new itens.Material("Prata", 1, 0, "Troca", 1);
                setDescricao("[Prata]\nIdeal para construções.");
                break;

            case "esmeralda":
                setDown1(setup("/objetos/esmeralda", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                materialLogico=new itens.Material("Esmeralda", 1, 0, "Troca", 1);
                setDescricao("[Esmeralda]\nIdeal para constru.");
                break;

            case "carvao":
                setDown1(setup("/objetos/carvao", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                materialLogico=new itens.Material("Carvao", 1, 0, "Troca", 1);
                setDescricao("[Carvão]\nIdeal para constru.");
                break;


        }
    }
}


