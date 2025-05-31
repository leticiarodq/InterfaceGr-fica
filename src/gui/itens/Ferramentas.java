package gui.itens;

import gui.entidades.Entidade;
import gui.system.PainelJogo;

public class Ferramentas extends Entidade {

    public Ferramentas(PainelJogo gp, String tipoFerramenta) {
        super(gp);

        areaAtaque.width=32;
        areaAtaque.height=32;

        setNome(tipoFerramenta);

        switch (tipoFerramenta.toLowerCase()) {
            case "machado":
                setDown1(setup("/armasFerramentas/machado", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                setDescricao("[Machado]\nFerramenta pesada,\nútil em combate e\ncoleta.");
                setTipo(getTipo_machado());
                setValorAtaque(1);
                setDurabilidade(100);


                break;

            case "picareta":
                setDown1(setup("/armasFerramentas/picareta", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                setDescricao("[Picareta]\nIdeal para minerar\ne quebrar rochas.");
                setTipo(getTipo_picareta());
                break;


        }

        setColisao(true);


    }
}


