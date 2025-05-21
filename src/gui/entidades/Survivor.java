package gui.entidades;

import gui.system.EventosTeclado;
import gui.system.PainelJogo;
import personagens.Personagem;
import personagens.SobreviventeNato;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Survivor extends Jogador {

    private SobreviventeNato sobreviventeNato;

    public Survivor(PainelJogo gp, EventosTeclado eventosTeclado) {
        super(gp, eventosTeclado);
        this.sobreviventeNato = new SobreviventeNato("Elfa", 100, 100, 100, 100, 100, null, "Floresta", 36.5);
        getImagemJogador();
        sobreviventeNato.exibirStatus();
    }
    @Override
    public void getImagemJogador() {
        try {
            setUp1(ImageIO.read(getClass().getResourceAsStream("/survivor/sobrevivente_up_1.png")));
            setUp2(ImageIO.read(getClass().getResourceAsStream("/survivor/sobrevivente_up_2.png")));
            setDown1(ImageIO.read(getClass().getResourceAsStream("/survivor/sobrevivente_down_1.png")));
            setDown2(ImageIO.read(getClass().getResourceAsStream("/survivor/sobrevivente_down_2.png")));
            setLeft1(ImageIO.read(getClass().getResourceAsStream("/survivor/sobrevivente_left_1.png")));
            setLeft2(ImageIO.read(getClass().getResourceAsStream("/survivor/sobrevivente_left_2.png")));
            setRight1(ImageIO.read(getClass().getResourceAsStream("/survivor/sobrevivente_right_1.png")));
            setRight2(ImageIO.read(getClass().getResourceAsStream("/survivor/sobrevivente_right_2.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
