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

    private int contadorDias;
    float filterAlpha=0f;

    private int ciclosCompletos = 0;
    private final int MAX_DIAS_SOBREVIVENCIA=5;
    private final int dia=0;
    private final int anoitecendo=1;
    private final int noite=2;
    private final int amanhecendo=3;
    private int estadoDia=dia;


    public Iluminacao(PainelJogo gp, int tamanhoCirculo, int centroX, int centroY) {

        this.gp = gp;

        filtroEscuro = new BufferedImage(gp.getTelaLargura(), gp.getTelaAltura(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = (Graphics2D) filtroEscuro.getGraphics();

        Area telaArea = new Area(new Rectangle2D.Double(0, 0, gp.getTelaLargura(), gp.getTelaAltura()));

        double x = centroX - (tamanhoCirculo / 2);
        double y = centroY - (tamanhoCirculo / 2);

        Shape circuloShape = new Ellipse2D.Double(x, y, tamanhoCirculo, tamanhoCirculo);
        Area areaLuz = new Area(circuloShape);

        telaArea.subtract(areaLuz);

        Color cor[]=new Color[12];
        float fracao[]=new float[12];

        cor[0]= new Color(0,0,0,0.1f);
        cor[1]= new Color(0,0,0,0.42f);
        cor[2]= new Color(0,0,0,0.52f);
        cor[3]= new Color(0,0,0,0.61f);
        cor[4]= new Color(0,0,0,0.69f);
        cor[5]= new Color(0,0,0,0.76f);
        cor[6]= new Color(0,0,0,0.82f);
        cor[7]= new Color(0,0,0,0.87f);
        cor[8]= new Color(0,0,0,0.91f);
        cor[9]= new Color(0,0,0,0.94f);
        cor[10]= new Color(0,0,0,0.96f);
        cor[11]= new Color(0,0,0,0.98f);

        fracao[0]=0f;
        fracao[1]=0.4f;
        fracao[2]=0.5f;
        fracao[3]=0.6f;
        fracao[4]=0.65f;
        fracao[5]=0.7f;
        fracao[6]=0.75f;
        fracao[7]=0.8f;
        fracao[8]=0.85f;
        fracao[9]=0.9f;
        fracao[10]=0.95f;
        fracao[11]=1f;


        RadialGradientPaint gPaint=new RadialGradientPaint(centroX, centroY, (tamanhoCirculo/2), fracao, cor);

        g2.setPaint(gPaint);

        g2.fill(areaLuz);

        //g2.setColor(new Color(0, 0, 0, 0.95f));

        g2.fill(telaArea);

        g2.dispose();
    }

    public void update() {
        if(estadoDia == dia) {
            contadorDias++;
            if(contadorDias > 12600) {
                estadoDia = anoitecendo;
                contadorDias = 0;
            }
        }
        else if(estadoDia == anoitecendo) {
            filterAlpha += 0.001f;
            if(filterAlpha > 1f) {
                filterAlpha = 1f;
                estadoDia = noite;
            }
        }
        else if(estadoDia == noite) {
            contadorDias++;
            if(contadorDias > 12600) {
                estadoDia = amanhecendo;
                contadorDias = 0;
            }
        }
        else if(estadoDia == amanhecendo) {
            filterAlpha -= 0.001f;
            if(filterAlpha < 0f) {
                filterAlpha = 0;
                estadoDia = dia;
                ciclosCompletos++;

                String personagem=gp.getPersonagemSelecionado();

                if("médico".equals(personagem)){
                    gp.jogador.setVida(gp.jogador.getVida()+1);
                    gp.jogador.setFome(gp.jogador.getFome()-1);
                    gp.jogador.setSede(gp.jogador.getSede()-1);
                    gp.jogador.setSanidade(gp.jogador.getSanidade()-2);

                } else{
                    gp.jogador.setFome(gp.jogador.getFome()-2);
                    gp.jogador.setSede(gp.jogador.getSede()-2);
                    gp.jogador.setSanidade(gp.jogador.getSanidade()-1);
                }

                if(ciclosCompletos >= MAX_DIAS_SOBREVIVENCIA) {
                    gp.setEstadoJogo(gp.getEstadoJogoVencido());
                }
            }
        }
    }
    public void desenhar(Graphics2D g2) {
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, filterAlpha));
        g2.drawImage(filtroEscuro, 0, 0, null);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

        String situacao="";

        switch(estadoDia){
            case dia: situacao="Dia"; break;
            case anoitecendo: situacao="Anoitecendo"; break;
            case noite: situacao="Noite";
            case amanhecendo: situacao="Amanhecendo";break;
        }

        //g2.setColor(Color.WHITE);
        //g2.setFont(g2.getFont().deriveFont(50f));
        //g2.drawString(situacao, 800, 500);
    }
}
