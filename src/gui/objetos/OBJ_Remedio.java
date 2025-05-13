package gui.objetos;

import gui.system.PainelJogo;
import itens.Remedio;

import javax.imageio.ImageIO;

public class OBJ_Remedio extends SuperObjetos {


    public OBJ_Remedio(){

        setNome("Remedio");
        try{
            setImagem(ImageIO.read(getClass().getResourceAsStream("/objetos/analgesico.png")));;

        } catch (Exception e) {
            e.printStackTrace();
        }
        setColisao(true);

        Remedio analgesicoLogico=new Remedio(
            "Analgésico", // nome
                    1,           // peso
                    5,           // durabilidade
                    "Analgésico", // tipo
                    "Alivia a dor", // efeito
                    20           // cura
        );

            // Associar o objeto lógico à representação visual
            setObjetoLogico(analgesicoLogico);
        }

        // Método de conveniência para acessar o objeto lógico como Remedio
        public Remedio getRemedioLogico() {
            return (Remedio) getObjetoLogico();
        }
    }



