package gui.ambientacao;

import gui.system.PainelJogo;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Iluminacao {

    private PainelJogo gp;
    private BufferedImage filtroEscuro;

    public Iluminacao(PainelJogo gp, int tamanhoCirculo){

        filtroEscuro=new BufferedImage(gp.getTelaLargura(), gp.getTelaAltura(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2= (Graphics2D) filtroEscuro.getGraphics();

        Area telaArea= new Area(new Rectangle2D.Double(0,0,gp.getTelaLargura(), gp.getTelaAltura()));

        int centroX= gp.jogador.getTelaX()+(gp.getTamanhoBloco())/2;
        int centroY=gp.jogador.getTelaY()+(gp.getTamanhoBloco())/2;

        double x=centroX-(tamanhoCirculo/2);
        double y=centroY-(tamanhoCirculo/2);

        Shape circuloShape=new Ellipse2D.Double(x,y,tamanhoCirculo, tamanhoCirculo);

        Area areaLuz=new Area(circuloShape);

        telaArea.subtract(areaLuz);

        g2.setColor(new Color(0,0,0,95f));

        g2.fill(telaArea);

        g2.dispose();

    }

    public void desenhar(Graphics2D g2){

        g2.drawImage(filtroEscuro, 0,0, null);
    }
}
