package gui.system;

import gui.criaturas.*;
import gui.entidades.Entidade;
import gui.entidades.NPC_Explorador;
import gui.itens.ALIMENTO_Fruta;
import gui.itens.Armas;
import gui.itens.Ferramentas;
import gui.tile_interativo.BI_Arvore;
import gui.tile_interativo.BI_Minerio;

public class CriadorAtivos {

    private PainelJogo gp;
    //private Random random;

    public CriadorAtivos(PainelJogo gp) {
        this.gp = gp;
        //this.random = new Random();
    }

    public void posicionarEntidadeLimitada(Entidade entidade, int blocoX, int blocoY) {
        int limite = 40;

        // Garante que a entidade não seja colocada fora dos limites 0–39
        if (blocoX >= 0 && blocoX < limite && blocoY >= 0 && blocoY < limite) {
            entidade.setMundoX(blocoX * gp.getTamanhoBloco());
            entidade.setMundoY(blocoY * gp.getTamanhoBloco());
        } else {
            System.out.println("Tentativa de posicionar fora da área 40x40: (" + blocoX + ", " + blocoY + ")");
        }
    }


    public void setObjeto() {

          int i=0;
          int numMapa=0;
/*
           gp.getObj()[numMapa][i] = new ALIMENTO_Fruta(gp, "banana");
           gp.getObj()[numMapa][i].setMundoX(21 * gp.getTamanhoBloco());
           gp.getObj()[numMapa][i].setMundoY(34 * gp.getTamanhoBloco());

           i++;


           */
        gp.getObj()[numMapa][i] = new Armas(gp, "espada");
        gp.getObj()[numMapa][i].setMundoX(21 * gp.getTamanhoBloco());
        gp.getObj()[numMapa][i].setMundoY(33 * gp.getTamanhoBloco());

        i=1;

        gp.getObj()[numMapa][i] = new Ferramentas(gp, "machado");
        gp.getObj()[numMapa][i].setMundoX(21 * gp.getTamanhoBloco());
        gp.getObj()[numMapa][i].setMundoY(34 * gp.getTamanhoBloco());


    }

    public void definirPresa() {
        int i = 0;
        int numMapa = 0;

        CRI_Porco porco = new CRI_Porco(gp);
        gp.getPresa()[numMapa][i] = porco;

        posicionarEntidadeLimitada(porco, 25, 33);

        i=1;
        CRI_Galinha galinha=new CRI_Galinha(gp);
        gp.getPresa()[numMapa][i] = galinha;
        posicionarEntidadeLimitada(galinha, 23, 25);
    }



    public void definirNPC() {

        int i=0;
        int numMapa=0;

        NPC_Explorador explorador=new NPC_Explorador(gp);
        gp.getNpc()[numMapa][i] = explorador;
        posicionarEntidadeLimitada(explorador, 37, 27);

        i=1;
        NPC_Coelho coelho = new NPC_Coelho(gp);
        gp.getNpc()[numMapa][i] = coelho;

        posicionarEntidadeLimitada(coelho, 21, 26);

    }


    public void definirCriatura() {
        int i = 0;
        int numMapa = 0;

        CRI_Lobo lobo = new CRI_Lobo(gp);
        gp.getCriatura()[numMapa][i] = lobo;
        posicionarEntidadeLimitada(lobo, 11, 17);

        i=1;

        CRI_Urso urso=new CRI_Urso(gp);
        gp.getCriatura()[numMapa][i] = urso;
        posicionarEntidadeLimitada(urso, 30, 30);

        numMapa=4;
        i=2;
        CRI_Morcego morcego=new CRI_Morcego(gp);
        gp.getCriatura()[numMapa][i] = morcego;
        posicionarEntidadeLimitada(morcego, 25, 25);

        numMapa=4;
        i=3;
        CRI_Aranha aranha=new CRI_Aranha(gp);
        gp.getCriatura()[numMapa][i] = aranha;
        posicionarEntidadeLimitada(aranha, 23, 21);

    }

    public void definirBlocoInterativo(){

        int i=0;
        int numMapa=0;

        gp.getBloco()[numMapa][i]=new BI_Arvore(gp, 38,15);
        gp.getBloco()[numMapa][1]=new BI_Arvore(gp, 38,17);
        gp.getBloco()[numMapa][2]=new BI_Arvore(gp, 38,19);
        gp.getBloco()[numMapa][3]=new BI_Arvore(gp, 38,21);
        gp.getBloco()[numMapa][4]=new BI_Arvore(gp, 31,24);


        gp.getBloco()[4][5]=new BI_Minerio(gp, 26,28);



    }





}
