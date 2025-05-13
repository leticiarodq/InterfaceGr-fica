package gui.objetos;

import gui.system.PainelJogo;
import personagens.Personagem;

import javax.imageio.ImageIO;

public class OBJ_Sanidade extends SuperObjetos{

    Personagem personagem;

    PainelJogo gp;


    public OBJ_Sanidade(PainelJogo gp){



        this.gp=gp;

        setNome("Sanidade");
        try{
            setImagem10(ImageIO.read(getClass().getResourceAsStream("/status/sanidade_cheia.png")));
            setImagem11(ImageIO.read(getClass().getResourceAsStream("/status/sanidade_metade.png")));
            setImagem12(ImageIO.read(getClass().getResourceAsStream("/status/sanidade_vazia.png")));
            setImagem10(ferramentasUteis.escalar(getImagem10(), gp.getTamanhoBloco(), gp.getTamanhoBloco()));
            setImagem11(ferramentasUteis.escalar(getImagem11(), gp.getTamanhoBloco(), gp.getTamanhoBloco()));
            setImagem12(ferramentasUteis.escalar(getImagem12(), gp.getTamanhoBloco(), gp.getTamanhoBloco()));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
