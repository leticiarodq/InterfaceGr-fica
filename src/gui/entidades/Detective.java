package gui.entidades;

import gui.system.EventosTeclado;
import gui.system.PainelJogo;
import personagens.Rastreador;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Detective extends Jogador { //

    private Rastreador rastreador;

    public Detective(PainelJogo gp, EventosTeclado eventosTeclado) {
        super(gp, eventosTeclado);
        this.rastreador = new Rastreador("Luiz", 100, 100, 100, 100, 100, null, "Floresta");
        getImagemJogador();
        rastreador.exibirStatus(); // <-- Aqui a chamada!
    }

    @Override
    public void getImagemJogador() {
        try {
            setUp1(ImageIO.read(getClass().getResourceAsStream("/detective/ninja_up_01.png")));
            setUp2(ImageIO.read(getClass().getResourceAsStream("/detective/ninja_up_02.png")));
            setDown1(ImageIO.read(getClass().getResourceAsStream("/detective/ninja_down_01.png")));
            setDown2(ImageIO.read(getClass().getResourceAsStream("/detective/ninja_down_02.png")));
            setLeft1(ImageIO.read(getClass().getResourceAsStream("/detective/ninja_left_01.png")));
            setLeft2(ImageIO.read(getClass().getResourceAsStream("/detective/ninja_left_02.png")));
            setRight1(ImageIO.read(getClass().getResourceAsStream("/detective/ninja_right_01.png")));
            setRight2(ImageIO.read(getClass().getResourceAsStream("/detective/ninja_right_02.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}