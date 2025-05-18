package gui.objetos;

import gui.entidades.Entidade;
import gui.system.PainelJogo;
import personagens.Personagem;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class OBJ_Vida extends Entidade {

    PainelJogo gp;

    public OBJ_Vida(PainelJogo gp) {
        super(gp);

        this.gp = gp;

        setNome("Vida");
        setImagem(setup("/status/vida_cheia"));
        setImagem2(setup("/status/vida_metade"));
        setImagem3(setup("/status/vida_vazia"));
    }
}
