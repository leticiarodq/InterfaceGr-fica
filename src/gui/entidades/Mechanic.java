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

        this.mecanico = new Mecanico("Mecânica", 100, 100, 100, 100, 100, null, gp.getBlocosG().getAmbienteAtual().getNomeAmbiente(), 36.5);
        definirImagemJogador();
        definirImagemAtaque();
    }

    @Override
    public void definirImagemJogador() {
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

    public void definirImagemAtaque(){
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

    public void definirImagemMachado() {
        setMachadoUp1(setup("/mecanica/mecanica_up_01_machado"));
        setMachadoUp2(setup("/mecanica/mecanica_up_02_machado"));
        setMachadoDown1(setup("/mecanica/mecanica_down_01_machado"));
        setMachadoDown2(setup("/mecanica/mecanica_down_02_machado"));
        setMachadoLeft1(setup("/mecanica/mecanica_left_01_machado"));
        setMachadoLeft2(setup("/mecanica/mecanica_left_02_machado"));
        setMachadoRight1(setup("/mecanica/mecanica_right_01_machado"));
        setMachadoRight2(setup("/mecanica/mecanica_right_02_machado"));
    }

}
