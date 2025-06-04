package gui.entidades;

import gui.system.PainelJogo;

import java.util.Random;

public class NPC_Explorador extends Entidade{

    PainelJogo gp;
    private Random aleatorio = new Random();


    public NPC_Explorador(PainelJogo gp){
        super(gp);
        this.gp = gp;

        setTipo(getTipo_npc());
        setDirecao("down");
        setVelocidade(1);
        carregarImagemExplorador();
        setDialogo();
    }


    public void carregarImagemExplorador() {
        setUp1(setup("/explorador/explorador_up_1", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setUp2(setup("/explorador/explorador_up_2", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setDown1(setup("/explorador/explorador_down_1", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setDown2(setup("/explorador/explorador_down_2", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setLeft1(setup("/explorador/explorador_left_1", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setLeft2(setup("/explorador/explorador_left_2", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setRight1(setup("/explorador/explorador_right_1", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setRight2(setup("/explorador/explorador_right_2", gp.getTamanhoBloco(), gp.getTamanhoBloco()));

    }

    public void setDialogo(){

        getDialogos()[0]="Shhh... Eles estão\nobservando.";
        getDialogos()[1]="Você acha mesmo que essa\nfloresta é natural?\nNada aqui é natural.";
        getDialogos()[2]="Já ouviu falar das criaturas \nde olhos brilhantes?\nEu já as vi... à noite.";
        getDialogos()[3]= "Só me prometa...\nque não vai deixar essa\nfloresta te consumir...\ncomo fez comigo.";

    }

    public void setAcao(){

        setContadorDeBloqueioDeAcao(getContadorDeBloqueioDeAcao() + 1);

        if(getContadorDeBloqueioDeAcao() == 120) {
            int i = aleatorio.nextInt(100) + 1;// Coleta um número de 1 a 100

            if (i <= 25) {
                setDirecao("up");
            }
            if (i > 25 && i <= 50) {
                setDirecao("down");
            }
            if (i > 50 && i <= 75) {
                setDirecao("left");
            }
            if (i > 75 && i <= 100) {
                setDirecao("right");
            }

            setContadorDeBloqueioDeAcao(0);

        }


    }

    public void falar(){

        if(getDialogos()[getIndiceDialogo()]==null){
            setIndiceDialogo(0);
        }
        gp.getIu().setDialogoAtual(getDialogos()[getIndiceDialogo()]);
        setIndiceDialogo(getIndiceDialogo()+1);

        switch(gp.jogador.getDirecao()){
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
