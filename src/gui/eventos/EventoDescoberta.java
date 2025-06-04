package gui.eventos;

import gui.criaturas.NPC_Coelho;
import gui.entidades.Entidade;
import gui.entidades.NPC_Explorador;
import gui.entidades.NPC_Feiticeira;
import gui.itens.ALIMENTO_Enlatado;
import gui.itens.Armas;
import gui.itens.Ferramentas;
import gui.itens.Fogueira;
import gui.system.PainelJogo;
import gui.tile_interativo.*;

public class EventoDescoberta {

    private PainelJogo gp;

    public EventoDescoberta(PainelJogo gp) {
        this.gp = gp;
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

        NPC_Feiticeira feiticeira=new NPC_Feiticeira(gp);
        gp.getNpc()[5][2]=feiticeira;
        posicionarEntidadeLimitada(feiticeira, 26, 22);


    }

    public void definirObjeto() {

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

        gp.getObj()[0][6]=new ALIMENTO_Enlatado(gp, "latafeijao");
        gp.getObj()[0][6].setMundoX(25 * gp.getTamanhoBloco());
        gp.getObj()[0][6].setMundoY(22 * gp.getTamanhoBloco());
    }

    public void definirBlocoInterativo(){

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



}
