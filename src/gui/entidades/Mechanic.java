package gui.entidades;



import gui.system.EventosTeclado;
import gui.system.PainelJogo;
import personagens.Mecanico;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Mechanic extends Jogador {

    private Mecanico mecanico;

    public Mechanic(PainelJogo gp, EventosTeclado eventosTeclado) {
        super(gp, eventosTeclado);
        this.mecanico = new Mecanico("Laila", 100, 100, 100, 100, 100, null, "Floresta");
        getImagemJogador();
        mecanico.exibirStatus(); // <-- Aqui a chamada!
    }

    @Override
    public void  getImagemJogador() {
        try {
            setUp1(ImageIO.read(getClass().getResourceAsStream("/mechanic/mecanica_up_01.png")));
            setUp2(ImageIO.read(getClass().getResourceAsStream("/mechanic/mecanica_up_02.png")));
            setDown1(ImageIO.read(getClass().getResourceAsStream("/mechanic/mecanica_down_01.png")));
            setDown2(ImageIO.read(getClass().getResourceAsStream("/mechanic/mecanica_down_02.png")));
            setLeft1(ImageIO.read(getClass().getResourceAsStream("/mechanic/mecanica_left_01.png")));
            setLeft2(ImageIO.read(getClass().getResourceAsStream("/mechanic/mecanica_left_02.png")));
            setRight1(ImageIO.read(getClass().getResourceAsStream("/mechanic/mecanica_right_01.png")));
            setRight2(ImageIO.read(getClass().getResourceAsStream("/mechanic/mecanica_right_02.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
