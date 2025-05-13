package gui.objetos;

import gui.system.PainelJogo;
import personagens.Personagem;

import javax.imageio.ImageIO;

public class OBJ_Sede extends SuperObjetos{

    Personagem personagem;

    PainelJogo gp;


    public OBJ_Sede(PainelJogo gp){



        this.gp=gp;

        setNome("Sede");
        try{
            setImagem4(ImageIO.read(getClass().getResourceAsStream("/status/sede_cheia.png")));
            setImagem5(ImageIO.read(getClass().getResourceAsStream("/status/sede_metade.png")));
            setImagem6(ImageIO.read(getClass().getResourceAsStream("/status/sede_vazia.png")));
            setImagem4(ferramentasUteis.escalar(getImagem4(), gp.getTamanhoBloco(), gp.getTamanhoBloco()));
            setImagem5(ferramentasUteis.escalar(getImagem5(), gp.getTamanhoBloco(), gp.getTamanhoBloco()));
            setImagem6(ferramentasUteis.escalar(getImagem6(), gp.getTamanhoBloco(), gp.getTamanhoBloco()));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
