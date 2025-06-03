package gui.entidades;

import gui.itens.REMEDIO_Analgesico;
import gui.itens.REMEDIO_Antibiotico;
import gui.itens.REMEDIO_Bandagem;
import gui.system.PainelJogo;

import java.util.Random;

public class NPC_Feiticeira extends Entidade {

    PainelJogo gp;
    private Random aleatorio = new Random();


    public NPC_Feiticeira(PainelJogo gp) {
        super(gp);
        this.gp = gp;

        setTipo(getTipo_npc());
        setDirecao("down");
        setVelocidade(1);
        carregarImagemFeiticeira();
        setDialogo();
        definirItens();
    }


    public void carregarImagemFeiticeira() {
        setUp1(setup("/feiticeira/feiticeira_down_01", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setUp2(setup("/feiticeira/feiticeira_down_02", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setDown1(setup("/feiticeira/feiticeira_down_01", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setDown2(setup("/feiticeira/feiticeira_down_02", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setLeft1(setup("/feiticeira/feiticeira_down_01", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setLeft2(setup("/feiticeira/feiticeira_down_02", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setRight1(setup("/feiticeira/feiticeira_down_01", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setRight2(setup("/feiticeira/feiticeira_down_02", gp.getTamanhoBloco(), gp.getTamanhoBloco()));

    }

    public void setDialogo() {

        getDialogos()[0] = "Ah, visitante...\nVejo que precisa de algo\nmais do que coragem.";

    }

    public void definirItens() {

        getInventario().add(new REMEDIO_Analgesico(gp));
        getInventario().add(new REMEDIO_Antibiotico(gp));
        getInventario().add(new REMEDIO_Bandagem(gp));

    }

    @Override
    public void falar() {
        if (getDialogos()[getIndiceDialogo()] == null) {
            setIndiceDialogo(0);
        }
        gp.getIu().setDialogoAtual(getDialogos()[getIndiceDialogo()]);
        setIndiceDialogo(getIndiceDialogo() + 1);

        gp.setEstadoJogo(gp.getEstadoSistemaDeTroca());
        gp.getIu().setNpc(this);

        switch (gp.jogador.getDirecao()) {
            case "up":
                setDirecao("down");
                break;
            case "down":
                setDirecao("up");
                break;
            case "left":
                setDirecao("right");
                break;
            case "right":
                setDirecao("left");
                break;
        }
    }
}
