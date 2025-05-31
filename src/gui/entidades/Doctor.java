package gui.entidades;

import gui.system.EventosTeclado;
import gui.system.PainelJogo;
import personagens.Medico;
import personagens.Personagem;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Doctor extends Jogador {

    private Medico medico;

    public Medico getMedico() {
        return medico;
    }

    public Doctor(PainelJogo gp, EventosTeclado eventosTeclado) {
        super(gp, eventosTeclado);

        this.medico = new Medico("Dr. Eduardo",100, 100, 100, 100, 100, null, gp.getBlocosG().getAmbienteAtual().getNomeAmbiente(), 36.5);
        definirImagemJogador();
        definirImagemAtaque();
    }


    @Override
    public void definirImagemJogador() {
            setUp1(setup("/doctor/curandeiro_up_01"));
            setUp2(setup("/doctor/curandeiro_up_02"));
            setDown1(setup("/doctor/curandeiro_down_01"));
            setDown2(setup("/doctor/curandeiro_down_02"));
            setLeft1(setup("/doctor/curandeiro_left_01"));
            setLeft2(setup("/doctor/curandeiro_left_02"));
            setRight1(setup("/doctor/curandeiro_right_01"));
            setRight2(setup("/doctor/curandeiro_right_02"));

    }
    @Override
    public void definirImagemAtaque(){
            setAtaqueUp1(setup("/doctor/curandeiro_up_01_ataque"));
            setAtaqueUp2(setup("/doctor/curandeiro_up_02_ataque"));
            setAtaqueDown1(setup("/doctor/curandeiro_down_01_ataque"));
            setAtaqueDown2(setup("/doctor/curandeiro_down_02_ataque"));
            setAtaqueLeft1(setup("/doctor/curandeiro_left_01_ataque"));
            setAtaqueLeft2(setup("/doctor/curandeiro_left_02_ataque"));
            setAtaqueRight1(setup("/doctor/curandeiro_right_01_ataque"));
            setAtaqueRight2(setup("/doctor/curandeiro_right_02_ataque"));

    }

}
