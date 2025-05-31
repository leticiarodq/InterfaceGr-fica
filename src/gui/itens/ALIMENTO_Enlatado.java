package gui.itens;

import gui.entidades.Entidade;
import gui.system.PainelJogo;
import itens.Alimento;

public class ALIMENTO_Enlatado extends Entidade {

    private Alimento alimentoLogica;


    public ALIMENTO_Enlatado(PainelJogo gp, String tipoEnlatado) {

        super(gp);
        setTipo(getTipo_consumivel());

        setNome(tipoEnlatado);

        switch (tipoEnlatado.toLowerCase()) {
            case "Lata de feijão":
                setDown1(setup("/alimentos/enalatado01", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                setDescricao("[Lata de Feijão]\nAlimento nutritivo e durável.\nRecupera bastante fome.\nIdeal para longas jornadas.");
                break;

            case "Lata de feijão vencida":
                setDown1(setup("/alimentos/enlatado02", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                setDescricao("[Feijão Vencido]\nAinda com valor nutritivo,\nmas pode causar efeitos\ncolaterais leves.");
                break;

            case "Lata de ervilha":
                setDown1(setup("/alimentos/enlatado03", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                setDescricao("[Lata de Ervilha]\nLeve e saudável.\nRecupera um pouco de fome\nsem pesar no estômago.");
                break;

            case "Lata de ervilha vencida":
                setDown1(setup("/alimentos/enlatado04", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                setDescricao("[Ervilha Vencida]\nComestível, mas com gosto\nestranho. Use só em emergências.");
                break;

        }
    }
}
