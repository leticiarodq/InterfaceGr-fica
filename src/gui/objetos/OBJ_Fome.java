package gui.objetos;

import gui.system.PainelJogo;
import personagens.Personagem;

import javax.imageio.ImageIO;

public class OBJ_Fome extends SuperObjetos{

    Personagem personagem;

    PainelJogo gp;


    public OBJ_Fome(PainelJogo gp){

        this.gp=gp;

        setNome("Fome");
        try{
            setImagem7(ImageIO.read(getClass().getResourceAsStream("/status/fome_cheio.png")));
            setImagem8(ImageIO.read(getClass().getResourceAsStream("/status/fome_metade.png")));
            setImagem9(ImageIO.read(getClass().getResourceAsStream("/status/fome_vazio.png")));
            setImagem7(ferramentasUteis.escalar(getImagem7(), gp.getTamanhoBloco(), gp.getTamanhoBloco()));
            setImagem8(ferramentasUteis.escalar(getImagem8(), gp.getTamanhoBloco(), gp.getTamanhoBloco()));
            setImagem9(ferramentasUteis.escalar(getImagem9(), gp.getTamanhoBloco(), gp.getTamanhoBloco()));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}