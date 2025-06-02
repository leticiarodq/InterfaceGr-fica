package gui.ambientacao;

import gui.system.PainelJogo;
import java.awt.*;

public class GerenciadorAmbientacao {
    private PainelJogo gp;
    private Iluminacao iluminacao;

    public GerenciadorAmbientacao(PainelJogo gp) {
        this.gp = gp;
    }

    public void setup(int tamanhoCirculo, int centroX, int centroY) {
        iluminacao = new Iluminacao(gp, 550, centroX, centroY);

    }

    public void update(){
        iluminacao.update();
    }

    public void desenhar(Graphics2D g2) {
        if (iluminacao != null) {
            iluminacao.desenhar(g2);
        }
    }
}