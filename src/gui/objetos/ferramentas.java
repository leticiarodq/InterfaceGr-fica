package gui.objetos;

import gui.entidades.Entidade;
import gui.system.PainelJogo;

public class ferramentas extends Entidade {

    public ferramentas(PainelJogo gp, String tipoFerramenta) {
        super(gp);

        setNome(tipoFerramenta);

        switch (tipoFerramenta.toLowerCase()) {
            case "machado":
                setDown1(setup("/armasFerramentas/machado"));
                setDescricao("[Machado]\nFerramenta pesada,\nútil em combate e\ncoleta.");
                break;

            case "espada":
                setDown1(setup("/armasFerramentas/espada"));
                setDescricao("[Espada]\nLeve e afiada,\nfeita para o\ncombate direto.");
                break;

            case "picareta":
                setDown1(setup("/armasFerramentas/picareta"));
                setDescricao("[Picareta]\nIdeal para minerar\ne quebrar rochas.");
                break;


            default:
                setDown1(setup("/alimentos/fruta_padrao"));
                setDescricao("[Fruta]\nFruta misteriosa.\nDescubra seus benefícios!");
                break;
        }

        setColisao(true);


    }
}


