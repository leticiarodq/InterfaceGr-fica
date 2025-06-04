package gui.itens;

import gui.entidades.Entidade;
import gui.system.PainelJogo;
import itens.Alimento;
import itens.Ferramenta;

public class Ferramentas extends Entidade {

    private Ferramenta ferramentaLogica;
    private PainelJogo gp;

    public Ferramentas(PainelJogo gp, String tipoFerramenta) {
        super(gp);
        this.gp=gp;
        areaAtaque.width=32;
        areaAtaque.height=32;

        setNome(tipoFerramenta);

        switch (tipoFerramenta.toLowerCase()) {
            case "machado":
                setDown1(setup("/armasFerramentas/machado", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                ferramentaLogica=new Ferramenta("Machado", 1, 100, "Cortar madeira", 100);
                setDescricao("[Machado]\nFerramenta pesada,\nútil em combate e\ncoleta.");
                setTipo(getTipo_machado());
                setValorAtaque(1);
                setDurabilidade(100);


                break;

            case "picareta":
                setDown1(setup("/armasFerramentas/picareta", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                ferramentaLogica=new Ferramenta("Picareta", 1, 150, "Minerar", 100);
                setDescricao("[Picareta]\nIdeal para minerar\ne quebrar rochas.");
                setTipo(getTipo_picareta());
                setDurabilidade(150);
                break;


        }

        setColisao(true);


    }
}


