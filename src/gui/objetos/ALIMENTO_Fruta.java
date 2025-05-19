package gui.objetos;

import gui.entidades.Entidade;
import gui.system.PainelJogo;

public class ALIMENTO_Fruta extends Entidade {

    public ALIMENTO_Fruta(PainelJogo gp, String tipoFruta) {
        super(gp);

        setNome(tipoFruta);

        switch (tipoFruta.toLowerCase()) {
            case "maçã":
                setDown1(setup("/alimentos/maca"));
                setDescricao("[Maçã]\nMata a fome e é fácil de\nencontrar.");
                break;
            case "banana":
                setDown1(setup("/alimentos/banana"));
                setDescricao("[Banana]\nRica em potássio.");
                break;
            case "laranja":
                setDown1(setup("/alimentos/laranja"));
                setDescricao("[Laranja]\nCheia de vitamina C!");
                break;
            case "tomate":
                setDown1(setup("/alimentos/tomate"));
                setDescricao("[Tomate]\nCheia de vitamina C!");
            case "uva roxa":
                setDown1(setup("/alimentos/uva_roxa"));
                setDescricao("[Uva roxa]\nCheia de vitamina C!");
            case "uva verde":
                setDown1(setup("/alimentos/uva_verde"));
                setDescricao("[Uva verde]\nCheia de vitamina C!");
            default:
                setDown1(setup("/alimentos/fruta_padrao"));
                setDescricao("[Fruta]\nFruta misteriosa.");
                break;


        }

        setColisao(true);
    }
}

