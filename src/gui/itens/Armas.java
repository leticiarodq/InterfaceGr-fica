package gui.itens;

import gui.entidades.Entidade;
import gui.system.PainelJogo;

public class Armas extends Entidade {

    public Armas(PainelJogo gp, String tipoArma) {
        super(gp);
        setTipo(getTipo_espada());

        setNome(tipoArma);

        switch (tipoArma.toLowerCase()) {

            case "espada":
                setDown1(setup("/armasFerramentas/espada"));
                setDescricao("[Espada]\nLeve e afiada,\nfeita para o\ncombate direto.");
                setValorAtaque(2);
                break;


        }
    }
}
