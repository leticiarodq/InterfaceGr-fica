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


        this.rastreador = new Rastreador("Rastreador", getVida(), getFome(), getSede(), getEnergia(), getSanidade(), null, gp.getBlocosG().getAmbienteAtual().getNomeAmbiente(), 36.5);
        definirImagemJogador();
        //definirImagemAtaque();
    }

    @Override
    public void definirImagemJogador() {
        setUp1(setup("/detective/ninja_up_01"));
        setUp2(setup("/detective/ninja_up_02"));
        setDown1(setup("/detective/ninja_down_01"));
        setDown2(setup("/detective/ninja_down_02"));
        setLeft1(setup("/detective/ninja_left_01"));
        setLeft2(setup("/detective/ninja_left_02"));
        setRight1(setup("/detective/ninja_right_01"));
        setRight2(setup("/detective/ninja_right_02"));
    }

    @Override
    public void definirImagemAtaque() {
        

        if (getArmaAtual().getTipo() == getTipo_espada()) {

            setAtaqueUp1(setup("/detective/ninja_up_01_ataque"));
            setAtaqueUp2(setup("/detective/ninja_up_02_ataque"));
            setAtaqueDown1(setup("/detective/ninja_down_01_ataque"));
            setAtaqueDown2(setup("/detective/ninja_down_02_ataque"));
            setAtaqueLeft1(setup("/detective/ninja_left_01_ataque"));
            setAtaqueLeft2(setup("/detective/ninja_left_02_ataque"));
            setAtaqueRight1(setup("/detective/ninja_right_01_ataque"));
            setAtaqueRight2(setup("/detective/ninja_right_02_ataque"));

        }

        else if (getArmaAtual().getTipo() == getTipo_machado()) {
            setAtaqueUp1(setup("/detective/ninja_up_01_machado"));
            setAtaqueUp2(setup("/detective/ninja_up_02_machado"));
            setAtaqueDown1(setup("/detective/ninja_down_01_machado"));
            setAtaqueDown2(setup("/detective/ninja_down_02_machado"));
            setAtaqueLeft1(setup("/detective/ninja_left_01_machado"));
            setAtaqueLeft2(setup("/detective/ninja_left_02_machado"));
            setAtaqueRight1(setup("/detective/ninja_right_01_machado"));
            setAtaqueRight2(setup("/detective/ninja_right_02_machado"));
        }



    }
}