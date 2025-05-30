package gui.ambientacao;

import gui.system.PainelJogo;

import java.awt.*;

public class GerenciadorAmbientacao {

    private PainelJogo gp;
    Iluminacao iluminacao;

    public GerenciadorAmbientacao(PainelJogo gp){
        this.gp=gp;
    }
    public void setup(){

        iluminacao=new Iluminacao(gp,350);

    }
    public void desenhar(Graphics2D g2){

        iluminacao.desenhar(g2);
    }


}
