package gui.entidades;

import gui.system.EventosTeclado;
import gui.system.PainelJogo;
import personagens.Medico;

public class Doctor extends Jogador {

    private Medico medico;
    private PainelJogo gp;

    public Medico getMedico() {
        return medico;
    }

    public Doctor(PainelJogo gp, EventosTeclado eventosTeclado) {
        super(gp, eventosTeclado);
        this.gp=gp;

        //this.medico = new Medico("Curandeiro", getVida(), getFome(), getSede(), getEnergia(), getSanidade(), null, gp.getBlocosG().getAmbienteAtual().getNomeAmbiente(), 36.5);

        definirImagemJogador();

    }

    @Override
    public void definirImagemJogador() {
        setUp1(setup("/doctor/curandeiro_up_01", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setUp2(setup("/doctor/curandeiro_up_02", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setDown1(setup("/doctor/curandeiro_down_01", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setDown2(setup("/doctor/curandeiro_down_02", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setLeft1(setup("/doctor/curandeiro_left_01", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setLeft2(setup("/doctor/curandeiro_left_02", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setRight1(setup("/doctor/curandeiro_right_01", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setRight2(setup("/doctor/curandeiro_right_02", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
    }

    @Override
    public void definirImagemAtaque() {
        if (getArmaAtual().getTipo() == getTipo_espada()) {
            setAtaqueUp1(setup("/doctor/curandeiro_up_01_ataque", gp.getTamanhoBloco(), gp.getTamanhoBloco() * 2));
            setAtaqueUp2(setup("/doctor/curandeiro_up_02_ataque", gp.getTamanhoBloco(), gp.getTamanhoBloco() * 2));
            setAtaqueDown1(setup("/doctor/curandeiro_down_01_ataque", gp.getTamanhoBloco(), gp.getTamanhoBloco() * 2));
            setAtaqueDown2(setup("/doctor/curandeiro_down_02_ataque", gp.getTamanhoBloco(), gp.getTamanhoBloco() * 2));
            setAtaqueLeft1(setup("/doctor/curandeiro_left_01_ataque", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco()));
            setAtaqueLeft2(setup("/doctor/curandeiro_left_02_ataque", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco()));
            setAtaqueRight1(setup("/doctor/curandeiro_right_01_ataque", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco()));
            setAtaqueRight2(setup("/doctor/curandeiro_right_02_ataque", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco()));
        } else if (getArmaAtual().getTipo() == getTipo_machado()) {
            setAtaqueUp1(setup("/doctor/curandeiro_up_01_machado", gp.getTamanhoBloco(), gp.getTamanhoBloco() * 2));
            setAtaqueUp2(setup("/doctor/curandeiro_up_02_machado", gp.getTamanhoBloco(), gp.getTamanhoBloco() * 2));
            setAtaqueDown1(setup("/doctor/curandeiro_down_01_machado", gp.getTamanhoBloco(), gp.getTamanhoBloco() * 2));
            setAtaqueDown2(setup("/doctor/curandeiro_down_02_machado", gp.getTamanhoBloco(), gp.getTamanhoBloco() * 2));
            setAtaqueLeft1(setup("/doctor/curandeiro_left_01_machado", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco()));
            setAtaqueLeft2(setup("/doctor/curandeiro_left_02_machado", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco()));
            setAtaqueRight1(setup("/doctor/curandeiro_right_01_machado", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco()));
            setAtaqueRight2(setup("/doctor/curandeiro_right_02_machado", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco()));
        } else if (getArmaAtual().getTipo() == getTipo_picareta()) {
        setAtaqueUp1(setup("/doctor/curandeiro_up_01_picareta", gp.getTamanhoBloco(), gp.getTamanhoBloco() * 2));
        setAtaqueUp2(setup("/doctor/curandeiro_up_02_picareta", gp.getTamanhoBloco(), gp.getTamanhoBloco() * 2));
        setAtaqueDown1(setup("/doctor/curandeiro_down_01_picareta", gp.getTamanhoBloco(), gp.getTamanhoBloco() * 2));
        setAtaqueDown2(setup("/doctor/curandeiro_down_02_picareta", gp.getTamanhoBloco(), gp.getTamanhoBloco() * 2));
        setAtaqueLeft1(setup("/doctor/curandeiro_left_01_picareta", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco()));
        setAtaqueLeft2(setup("/doctor/curandeiro_left_02_picareta", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco()));
        setAtaqueRight1(setup("/doctor/curandeiro_right_01_picareta", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco()));
        setAtaqueRight2(setup("/doctor/curandeiro_right_02_picareta", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco()));
    }

}


}
