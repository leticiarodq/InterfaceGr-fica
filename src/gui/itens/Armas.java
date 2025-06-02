package gui.itens;

import gui.entidades.Entidade;
import gui.system.PainelJogo;
import itens.Arma;

public class Armas extends Entidade {

    private Arma armaLogica;

    public Armas(PainelJogo gp, String tipoArma) {
        super(gp);
        setTipo(getTipo_espada());

        setNome(tipoArma);

        switch (tipoArma.toLowerCase()) {

            case "espada":
                armaLogica=new Arma("Espada", 10, 100, "Ataque", 2, 10);
                setDown1(setup("/armasFerramentas/espada", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                setDescricao("[Espada]\nLeve e afiada,\nfeita para o\ncombate direto.");
                setValorAtaque(2);
                setDurabilidade(100);
                break;


        }

    }
}
