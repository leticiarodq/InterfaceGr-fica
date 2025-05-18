package gui.system;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FerramentasUteis {


    private BufferedImage redimensionarImagem(BufferedImage original, int largura, int altura) {
        BufferedImage imagemEscalada = new BufferedImage(largura, altura, original.getType());
        Graphics2D g2 = imagemEscalada.createGraphics();
        g2.drawImage(original, 0, 0, largura, altura, null);
        g2.dispose();
        return imagemEscalada;
    }


    public BufferedImage escalar(BufferedImage original, int novaLargura, int novaAltura) {
        return redimensionarImagem(original, novaLargura, novaAltura);
    }
}
