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
                setDescricao("[Maçã]\nMata a fome e é fácil de\nencontrar.\nRica em fibras\ne vitaminas.");
                break;

            case "banana":
                setDown1(setup("/alimentos/banana"));
                setDescricao("[Banana]\nRica em potássio e\nenergia rápida.\nÓtima para recuperar\nforças.");
                break;

            case "laranja":
                setDown1(setup("/alimentos/laranja"));
                setDescricao("[Laranja]\nCheia de vitamina C!\nAjuda a fortalecer o sistema imunológico.");
                break;

            case "tomate":
                setDown1(setup("/alimentos/tomate"));
                setDescricao("[Tomate]\nFonte de antioxidantes\ne vitamina C.\nBom para a saúde\nda pele.");
                break;

            case "uva roxa":
                setDown1(setup("/alimentos/uva_roxa"));
                setDescricao("[Uva roxa]\nCheia de antioxidantes.\nAjuda na circulação sanguínea.");
                break;

            case "uva verde":
                setDown1(setup("/alimentos/uva_verde"));
                setDescricao("[Uva verde]\nRefrescante e nutritiva.\nBoa fonte de vitaminas.");
                break;

            default:
                setDown1(setup("/alimentos/fruta_padrao"));
                setDescricao("[Fruta]\nFruta misteriosa.\nDescubra seus benefícios!");
                break;
        }

        setColisao(true);


    }
}

