package gui.itens;

import gui.entidades.Entidade;
import gui.system.PainelJogo;

public class Ferramentas extends Entidade {

    public Ferramentas(PainelJogo gp, String tipoFerramenta) {
        super(gp);

        setNome(tipoFerramenta);

        switch (tipoFerramenta.toLowerCase()) {
            case "machado":
                setDown1(setup("/armasFerramentas/machado"));
                setDescricao("[Machado]\nFerramenta pesada,\nútil em combate e\ncoleta.");
                setTipo(getTipo_machado());

                break;

            case "picareta":
                setDown1(setup("/armasFerramentas/picareta"));
                setDescricao("[Picareta]\nIdeal para minerar\ne quebrar rochas.");
                setTipo(getTipo_picareta());
                break;


        }

        setColisao(true);


    }
}


