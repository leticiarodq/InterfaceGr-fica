package gui.entidades;



import gui.system.EventosTeclado;
import gui.system.PainelJogo;
import personagens.Mecanico;
import personagens.Personagem;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Mechanic extends Jogador {

    private Mecanico mecanico;

    public Mechanic(PainelJogo gp, EventosTeclado eventosTeclado) {
        super(gp, eventosTeclado);
        this.mecanico = new Mecanico("Mecanico", 100, 100, 100, 100, 100, null, gp.getBlocosG().getAmbienteAtual().getNomeAmbiente(), 36.5);
        getImagemJogador();
        pegarImagemAtaque();

        mecanico.exibirStatus();
    }

    @Override
    public void getImagemJogador() {
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

    public void pegarImagemAtaque(){
        try {
            setAtaqueUp1(ImageIO.read(getClass().getResourceAsStream("/mechanic/mecanica_up_01_ataque.png")));
            setAtaqueUp2(ImageIO.read(getClass().getResourceAsStream("/mechanic/mecanica_up_02_ataque.png")));
            setAtaqueDown1(ImageIO.read(getClass().getResourceAsStream("/mechanic/mecanica_down_01_ataque.png")));
            setAtaqueDown2(ImageIO.read(getClass().getResourceAsStream("/mechanic/mecanica_down_02_ataque.png")));
            setAtaqueLeft1(ImageIO.read(getClass().getResourceAsStream("/mechanic/mecanica_left_01_ataque.png")));
            setAtaqueLeft2(ImageIO.read(getClass().getResourceAsStream("/mechanic/mecanica_left_02_ataque.png")));
            setAtaqueRight1(ImageIO.read(getClass().getResourceAsStream("/mechanic/mecanica_right_01_ataque.png")));
            setAtaqueRight2(ImageIO.read(getClass().getResourceAsStream("/mechanic/mecanica_right_02_ataque.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
