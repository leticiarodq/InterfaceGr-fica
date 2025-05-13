package gui.objetos;

import gui.system.PainelJogo;
import personagens.Personagem;

import javax.imageio.ImageIO;

public class OBJ_Energia extends SuperObjetos{

    Personagem personagem;

    PainelJogo gp;


    public OBJ_Energia(PainelJogo gp){



        this.gp=gp;

        setNome("Energia");
        try{
            setImagem13(ImageIO.read(getClass().getResourceAsStream("/status/energia_cheia.png")));
            setImagem14(ImageIO.read(getClass().getResourceAsStream("/status/energia_metade.png")));
            setImagem15(ImageIO.read(getClass().getResourceAsStream("/status/energia_vazia.png")));
            setImagem13(ferramentasUteis.escalar(getImagem13(), gp.getTamanhoBloco(), gp.getTamanhoBloco()));
            setImagem14(ferramentasUteis.escalar(getImagem14(), gp.getTamanhoBloco(), gp.getTamanhoBloco()));
            setImagem15(ferramentasUteis.escalar(getImagem15(), gp.getTamanhoBloco(), gp.getTamanhoBloco()));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
