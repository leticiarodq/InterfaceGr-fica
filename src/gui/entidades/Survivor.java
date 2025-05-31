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
        definirImagemJogador();
        definirImagemAtaque();

    }
    @Override
    public void definirImagemJogador() {
        setUp1(setup("/survivor/sobrevivente_up_1"));
        setUp2(setup("/survivor/sobrevivente_up_2"));
        setDown1(setup("/survivor/sobrevivente_down_1"));
        setDown2(setup("/survivor/sobrevivente_down_2"));
        setLeft1(setup("/survivor/sobrevivente_left_1"));
        setLeft2(setup("/survivor/sobrevivente_left_2"));
        setRight1(setup("/survivor/sobrevivente_right_1"));
        setRight2(setup("/survivor/sobrevivente_right_2"));

    }
    @Override
    public void definirImagemAtaque(){

        setAtaqueUp1(setup("/survivor/sobrevivente_up_1_ataque"));
        setAtaqueUp2(setup("/survivor/sobrevivente_up_2_ataque"));
        setAtaqueDown1(setup("/survivor/sobrevivente_down_1_ataque"));
        setAtaqueDown2(setup("/survivor/sobrevivente_down_2_ataque"));
        setAtaqueLeft1(setup("/survivor/sobrevivente_left_1_ataque"));
        setAtaqueLeft2(setup("/survivor/sobrevivente_left_2_ataque"));
        setAtaqueRight1(setup("/survivor/sobrevivente_right_1_ataque"));
        setAtaqueRight2(setup("/survivor/sobrevivente_right_2_ataque"));

    }

    public void definirImagemMachado() {
        setMachadoUp1(setup("/sobrevivente/sobrevivente_up_01_machado"));
        setMachadoUp2(setup("/sobrevivente/sobrevivente_up_02_machado"));
        setMachadoDown1(setup("/sobrevivente/sobrevivente_down_01_machado"));
        setMachadoDown2(setup("/sobrevivente/sobrevivente_down_02_machado"));
        setMachadoLeft1(setup("/sobrevivente/sobrevivente_left_01_machado"));
        setMachadoLeft2(setup("/sobrevivente/sobrevivente_left_02_machado"));
        setMachadoRight1(setup("/sobrevivente/sobrevivente_right_01_machado"));
        setMachadoRight2(setup("/sobrevivente/sobrevivente_right_02_machado"));
    }

}
