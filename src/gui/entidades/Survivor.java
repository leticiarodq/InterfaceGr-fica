package gui.entidades;

import gui.system.EventosTeclado;
import gui.system.PainelJogo;
import personagens.Personagem;
import personagens.SobreviventeNato;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Survivor extends Jogador {

    private SobreviventeNato sobreviventeNato;
    private PainelJogo gp;

    public Survivor(PainelJogo gp, EventosTeclado eventosTeclado) {
        super(gp, eventosTeclado);

        this.sobreviventeNato = new SobreviventeNato("Elfa", 100, 100, 100, 100, 100, null, "Floresta", 36.5);
        definirImagemJogador();
        definirImagemAtaque();

    }

    @Override
    public void definirImagemJogador() {
        setUp1(setup("/survivor/sobrevivente_up_1", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setUp2(setup("/survivor/sobrevivente_up_2", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setDown1(setup("/survivor/sobrevivente_down_1", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setDown2(setup("/survivor/sobrevivente_down_2", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setLeft1(setup("/survivor/sobrevivente_left_1", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setLeft2(setup("/survivor/sobrevivente_left_2", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setRight1(setup("/survivor/sobrevivente_right_1", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setRight2(setup("/survivor/sobrevivente_right_2", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
    }

    @Override
    public void definirImagemAtaque() {

        if (getArmaAtual().getTipo() == getTipo_espada()) {

            setAtaqueUp1(setup("/survivor/sobrevivente_up_01_ataque", gp.getTamanhoBloco(), gp.getTamanhoBloco() * 2));
            setAtaqueUp2(setup("/survivor/sobrevivente_up_02_ataque", gp.getTamanhoBloco(), gp.getTamanhoBloco() * 2));
            setAtaqueDown1(setup("/survivor/sobrevivente_down_01_ataque", gp.getTamanhoBloco(), gp.getTamanhoBloco() * 2));
            setAtaqueDown2(setup("/survivor/sobrevivente_down_02_ataque", gp.getTamanhoBloco(), gp.getTamanhoBloco() * 2));
            setAtaqueLeft1(setup("/survivor/sobrevivente_left_01_ataque", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco()));
            setAtaqueLeft2(setup("/survivor/sobrevivente_left_02_ataque", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco()));
            setAtaqueRight1(setup("/survivor/sobrevivente_right_01_ataque", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco()));
            setAtaqueRight2(setup("/survivor/sobrevivente_right_02_ataque", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco()));

        } else if (getArmaAtual().getTipo() == getTipo_machado()) {

            setAtaqueUp1(setup("/survivor/sobrevivente_up_01_machado", gp.getTamanhoBloco(), gp.getTamanhoBloco() * 2));
            setAtaqueUp2(setup("/survivor/sobrevivente_up_02_machado", gp.getTamanhoBloco(), gp.getTamanhoBloco() * 2));
            setAtaqueDown1(setup("/survivor/sobrevivente_down_01_machado", gp.getTamanhoBloco(), gp.getTamanhoBloco() * 2));
            setAtaqueDown2(setup("/survivor/sobrevivente_down_02_machado", gp.getTamanhoBloco(), gp.getTamanhoBloco() * 2));
            setAtaqueLeft1(setup("/survivor/sobrevivente_left_01_machado", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco()));
            setAtaqueLeft2(setup("/survivor/sobrevivente_left_02_machado", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco()));
            setAtaqueRight1(setup("/survivor/sobrevivente_right_01_machado", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco()));
            setAtaqueRight2(setup("/survivor/sobrevivente_right_02_machado", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco()));
        }
    }
}
