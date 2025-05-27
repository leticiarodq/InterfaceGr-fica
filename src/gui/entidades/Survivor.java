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
        pegarImagemAtaque();
        sobreviventeNato.exibirStatus();
    }
    @Override
    public void getImagemJogador() {
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
    public void pegarImagemAtaque(){

        setAtaqueUp1(setup("/survivor/sobrevivente_up_1_ataque"));
        setAtaqueUp2(setup("/survivor/sobrevivente_up_2_ataque"));
        setAtaqueDown1(setup("/survivor/sobrevivente_down_1_ataque"));
        setAtaqueDown2(setup("/survivor/sobrevivente_down_2_ataque"));
        setAtaqueLeft1(setup("/survivor/sobrevivente_left_1_ataque"));
        setAtaqueLeft2(setup("/survivor/sobrevivente_left_2_ataque"));
        setAtaqueRight1(setup("/survivor/sobrevivente_right_1_ataque"));
        setAtaqueRight2(setup("/survivor/sobrevivente_right_2_ataque"));

    }
}
