package gui.entidades;



import gui.system.EventosTeclado;
import gui.system.PainelJogo;
import personagens.Mecanico;
import personagens.Personagem;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Mechanic extends Jogador {

    private Mecanico mecanico;

    private PainelJogo gp;

    public Mechanic(PainelJogo gp, EventosTeclado eventosTeclado) {
        super(gp, eventosTeclado);
        this.gp = gp;
        this.mecanico = new Mecanico("Mecânica", 100, 100, 100, 100, 100, null, gp.getBlocosG().getAmbienteAtual().getNomeAmbiente(), 36.5);
        definirImagemJogador();
  ;
    }

    @Override
    public void definirImagemJogador() {
        setUp1(setup("/mechanic/mecanica_up_01", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setUp2(setup("/mechanic/mecanica_up_02", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setDown1(setup("/mechanic/mecanica_down_01", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setDown2(setup("/mechanic/mecanica_down_02", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setLeft1(setup("/mechanic/mecanica_left_01", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setLeft2(setup("/mechanic/mecanica_left_02", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setRight1(setup("/mechanic/mecanica_right_01", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setRight2(setup("/mechanic/mecanica_right_02", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
    }

    @Override
    public void definirImagemAtaque() {
        if (getArmaAtual().getTipo() == getTipo_espada()) {
            setAtaqueUp1(setup("/mechanic/mecanica_up_01_ataque", gp.getTamanhoBloco(), gp.getTamanhoBloco() * 2));
            setAtaqueUp2(setup("/mechanic/mecanica_up_02_ataque", gp.getTamanhoBloco(), gp.getTamanhoBloco() * 2));
            setAtaqueDown1(setup("/mechanic/mecanica_down_01_ataque", gp.getTamanhoBloco(), gp.getTamanhoBloco() * 2));
            setAtaqueDown2(setup("/mechanic/mecanica_down_02_ataque", gp.getTamanhoBloco(), gp.getTamanhoBloco() * 2));
            setAtaqueLeft1(setup("/mechanic/mecanica_left_01_ataque", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco()));
            setAtaqueLeft2(setup("/mechanic/mecanica_left_02_ataque", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco()));
            setAtaqueRight1(setup("/mechanic/mecanica_right_01_ataque", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco()));
            setAtaqueRight2(setup("/mechanic/mecanica_right_02_ataque", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco()));
        } else if (getArmaAtual().getTipo() == getTipo_machado()) {
            setAtaqueUp1(setup("/mechanic/mecanica_up_01_machado", gp.getTamanhoBloco(), gp.getTamanhoBloco() * 2));
            setAtaqueUp2(setup("/mechanic/mecanica_up_02_machado", gp.getTamanhoBloco(), gp.getTamanhoBloco() * 2));
            setAtaqueDown1(setup("/mechanic/mecanica_down_01_machado", gp.getTamanhoBloco(), gp.getTamanhoBloco() * 2));
            setAtaqueDown2(setup("/mechanic/mecanica_down_02_machado", gp.getTamanhoBloco(), gp.getTamanhoBloco() * 2));
            setAtaqueLeft1(setup("/mechanic/mecanica_left_01_machado", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco()));
            setAtaqueLeft2(setup("/mechanic/mecanica_left_02_machado", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco()));
            setAtaqueRight1(setup("/mechanic/mecanica_right_01_machado", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco()));
            setAtaqueRight2(setup("/mechanic/mecanica_right_02_machado", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco()));
        }
    }
}