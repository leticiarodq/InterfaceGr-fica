package gui.objetos;

import gui.system.PainelJogo;
import personagens.Personagem;

import javax.imageio.ImageIO;

public class OBJ_Vida extends SuperObjetos{

    Personagem personagem;

    PainelJogo gp;


    public OBJ_Vida(PainelJogo gp){

        this.gp=gp;

        setNome("Vida");
        try{
            setImagem(ImageIO.read(getClass().getResourceAsStream("/objetos/vida_cheia.png")));
            setImagem2(ImageIO.read(getClass().getResourceAsStream("/objetos/vida_metade.png")));
            setImagem3(ImageIO.read(getClass().getResourceAsStream("/objetos/vida_vazia.png")));
            setImagem(ferramentasUteis.escalar(getImagem(), gp.getTamanhoBloco(), gp.getTamanhoBloco()));
            setImagem2(ferramentasUteis.escalar(getImagem2(), gp.getTamanhoBloco(), gp.getTamanhoBloco()));
            setImagem3(ferramentasUteis.escalar(getImagem3(), gp.getTamanhoBloco(), gp.getTamanhoBloco()));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
