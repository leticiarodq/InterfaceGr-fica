package gui.entidades;

import gui.system.EventosTeclado;
import gui.system.PainelJogo;
import personagens.Medico;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Doctor extends Jogador {

    private Medico medico;

    public Medico getMedico() {
        return medico;
    }

    public Doctor(PainelJogo gp, EventosTeclado eventosTeclado) {
        super(gp, eventosTeclado);
        this.medico = new Medico("Dr. Eduardo",100, 100, 100, 100, 100, null, "Floresta");
        getImagemJogador();
        medico.exibirStatus(); // <-- Aqui a chamada!
    }


    @Override
    public void  getImagemJogador() {
        try {
            setUp1(ImageIO.read(getClass().getResourceAsStream("/doctor/curandeiro_up_01.png")));
            setUp2(ImageIO.read(getClass().getResourceAsStream("/doctor/curandeiro_up_02.png")));
            setDown1(ImageIO.read(getClass().getResourceAsStream("/doctor/curandeiro_down_01.png")));
            setDown2(ImageIO.read(getClass().getResourceAsStream("/doctor/curandeiro_down_02.png")));
            setLeft1(ImageIO.read(getClass().getResourceAsStream("/doctor/curandeiro_left_01.png")));
            setLeft2(ImageIO.read(getClass().getResourceAsStream("/doctor/curandeiro_left_02.png")));
            setRight1(ImageIO.read(getClass().getResourceAsStream("/doctor/curandeiro_right_01.png")));
            setRight2(ImageIO.read(getClass().getResourceAsStream("/doctor/curandeiro_right_02.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
