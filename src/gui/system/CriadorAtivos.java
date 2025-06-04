package gui.system;

import gui.criaturas.*;
import gui.entidades.Entidade;
import gui.entidades.NPC_Explorador;
import gui.entidades.NPC_Feiticeira;
import gui.itens.ALIMENTO_Enlatado;
import gui.itens.Armas;
import gui.itens.Ferramentas;
import gui.itens.Fogueira;
import gui.tile_interativo.*;

public class CriadorAtivos {

   /* private PainelJogo gp;
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

    public void posicionarLimitada(Entidade e, int col, int lin) {
        if (col >= 28 && col <= 30 && lin >= 27 && lin <= 29) {
            e.setMundoX(col);
            e.setMundoY(lin);
        } else {
            System.out.println("Tentativa de posicionar fora dos limites!");
        }
    }



    public void setObjeto() {

          int i=0;
          int numMapa=0;

        gp.getObj()[numMapa][i] = new Armas(gp, "espada");
        gp.getObj()[numMapa][i].setMundoX(21 * gp.getTamanhoBloco());
        gp.getObj()[numMapa][i].setMundoY(33 * gp.getTamanhoBloco());

        i=1;

        gp.getObj()[numMapa][i] = new Ferramentas(gp, "machado");
        gp.getObj()[numMapa][i].setMundoX(21 * gp.getTamanhoBloco());
        gp.getObj()[numMapa][i].setMundoY(34 * gp.getTamanhoBloco());

        gp.getObj()[numMapa][2]=new Fogueira(gp);
        gp.getObj()[numMapa][2].setMundoX(25 * gp.getTamanhoBloco());
        gp.getObj()[numMapa][2].setMundoY(24 * gp.getTamanhoBloco());

        gp.getObj()[2][3]=new ALIMENTO_Enlatado(gp, "ervilhavenciada");
        gp.getObj()[2][3].setMundoX(25 * gp.getTamanhoBloco());
        gp.getObj()[2][3].setMundoY(24 * gp.getTamanhoBloco());

        gp.getObj()[2][4]=new ALIMENTO_Enlatado(gp, "lataervilha");
        gp.getObj()[2][4].setMundoX(21 * gp.getTamanhoBloco());
        gp.getObj()[2][4].setMundoY(22 * gp.getTamanhoBloco());

        gp.getObj()[4][5]=new Ferramentas(gp, "picareta");
        gp.getObj()[4][5].setMundoX(26 * gp.getTamanhoBloco());
        gp.getObj()[4][5].setMundoY(22 * gp.getTamanhoBloco());
    }


   /* public void definirAquatico(){

        CRI_Peixe peixe = new CRI_Peixe(gp);
        gp.getPresa()[1][0] = peixe;
        posicionarEntidadeLimitada(peixe, 29, 28);

    }

    */
    /*public void definirPresa() {
        int i = 0;
        int numMapa = 0;

        CRI_Porco porco = new CRI_Porco(gp);
        gp.getPresa()[numMapa][i] = porco;

        posicionarEntidadeLimitada(porco, 25, 33);

        i = 1;
        CRI_Galinha galinha = new CRI_Galinha(gp);
        gp.getPresa()[numMapa][i] = galinha;
        posicionarEntidadeLimitada(galinha, 23, 25);


        CRI_Siri siri=new CRI_Siri(gp);
        gp.getPresa()[1][2]=siri;
        posicionarEntidadeLimitada(siri, 26, 31);

        CRI_Raia raia=new CRI_Raia(gp);
        gp.getPresa()[1][3]=raia;
        gp.getPresa()[1][3].setMundoX(40 * gp.getTamanhoBloco());
        gp.getPresa()[1][3].setMundoY(33 * gp.getTamanhoBloco());

    }


     */
       /* public void definirNPC() {

        int i=0;
        int numMapa=0;

        NPC_Explorador explorador=new NPC_Explorador(gp);
        gp.getNpc()[numMapa][i] = explorador;
        posicionarEntidadeLimitada(explorador, 37, 27);

        i=1;
        NPC_Coelho coelho = new NPC_Coelho(gp);
        gp.getNpc()[numMapa][i] = coelho;
        posicionarEntidadeLimitada(coelho, 21, 26);

        NPC_Feiticeira feiticeira=new NPC_Feiticeira(gp);
        gp.getNpc()[5][2]=feiticeira;
        posicionarEntidadeLimitada(feiticeira, 26, 22);


        }


        */

    /*public void definirCriatura() {
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


     */
   /* public void definirBlocoInterativo(){

        int i=0;
        int numMapa=0;

        gp.getBloco()[numMapa][i]=new BI_Arvore(gp, 38,15);
        gp.getBloco()[numMapa][1]=new BI_Arvore(gp, 38,17);
        gp.getBloco()[numMapa][2]=new BI_Arvore(gp, 38,19);
        gp.getBloco()[numMapa][3]=new BI_Arvore(gp, 38,21);
        gp.getBloco()[numMapa][4]=new BI_Arvore(gp, 31,24);



        gp.getBloco()[2][5]=new BI_Armadilha(gp, 31,26);


        gp.getBloco()[4][6]=new MINERIO_Esmeralda(gp, 29,26);
        gp.getBloco()[4][7]=new MINERIO_Esmeralda(gp, 28,32);
        gp.getBloco()[4][8]=new MINERIO_Esmeralda(gp, 24,12);
        gp.getBloco()[4][9]=new MINERIO_Esmeralda(gp, 23,24);
        gp.getBloco()[4][10]=new MINERIO_Prata(gp, 22,36);
        gp.getBloco()[4][11]=new MINERIO_Prata(gp, 22,21);
        gp.getBloco()[4][13]=new MINERIO_Prata(gp, 23,32);
        gp.getBloco()[4][14]=new MINERIO_Prata(gp, 24,36);
        gp.getBloco()[4][15]=new MINERIO_Prata(gp, 25,21);
        gp.getBloco()[4][16]=new Carvao(gp, 12,12);
        gp.getBloco()[4][17]=new Carvao(gp, 13,12);
        gp.getBloco()[4][18]=new Carvao(gp, 14,12);
        gp.getBloco()[4][19]=new Carvao(gp, 15,12);



    }




    */


}
