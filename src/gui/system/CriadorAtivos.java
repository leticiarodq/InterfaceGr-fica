package gui.system;

import gui.criaturas.*;
import gui.entidades.Entidade;
import gui.entidades.NPC_Explorador;
import gui.itens.ALIMENTO_Fruta;

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

          /* int i=0;
           int numMapa=0;

           gp.getObj()[numMapa][i] = new ALIMENTO_Fruta(gp, "banana");
           gp.getObj()[numMapa][i].setMundoX(21 * gp.getTamanhoBloco());
           gp.getObj()[numMapa][i].setMundoY(34 * gp.getTamanhoBloco());

           i++;


           */
    }

    public void setPorco() {
        int i = 0;
        int numMapa = 0;

        CRI_Porco porco = new CRI_Porco(gp);
        gp.getPresa()[numMapa][i] = porco;

        // Passa a entidade e a posição desejada (em blocos, não em pixels!)
        posicionarEntidadeLimitada(porco, 25, 33);
    }



    public void setNPC() {

        int i=0;
        int numMapa=0;

        NPC_Explorador explorador=new NPC_Explorador(gp);
        gp.getNpc()[numMapa][i] = explorador;
        posicionarEntidadeLimitada(explorador, 37, 27);

    }

    public void setCOELHO() {
        int i = 1;
        int numMapa = 0;

        NPC_Coelho coelho = new NPC_Coelho(gp);
        gp.getNpc()[numMapa][i] = coelho;

        // Define a posição dentro da área 40x40 blocos
        posicionarEntidadeLimitada(coelho, 21, 26);
        i++;
    }



    public void setLobo() {
        int i = 1;
        int numMapa = 0;

        CRI_Lobo lobo = new CRI_Lobo(gp);
        gp.getCriatura()[numMapa][i] = lobo;

        // Define a posição dentro da área 40x40 blocos
        posicionarEntidadeLimitada(lobo, 11, 17);
        i++;
    }


    public void setMorcego(){
        int i=0;
        int numMapa=4;

        gp.getCriatura()[numMapa][i]=new CRI_Morcego(gp);
        gp.getCriatura()[numMapa][i].setMundoX(25 * gp.getTamanhoBloco());
        gp.getCriatura()[numMapa][i].setMundoY(25 * gp.getTamanhoBloco());

        gp.getCriatura()[numMapa][1]=new CRI_Morcego(gp);
        gp.getCriatura()[numMapa][1].setMundoX(30 * gp.getTamanhoBloco());
        gp.getCriatura()[numMapa][1].setMundoY(21 * gp.getTamanhoBloco());
        i++;

        gp.getCriatura()[numMapa][2]=new CRI_Morcego(gp);
        gp.getCriatura()[numMapa][2].setMundoX(16 * gp.getTamanhoBloco());
        gp.getCriatura()[numMapa][2].setMundoY(13 * gp.getTamanhoBloco());
        i++;

    }

    public void setAranha(){
        int i=0;
        int numMapa=4;

        gp.getCriatura()[numMapa][i]=new CRI_Aranha(gp);
        gp.getCriatura()[numMapa][i].setMundoX(23 * gp.getTamanhoBloco());
        gp.getCriatura()[numMapa][i].setMundoY(21 * gp.getTamanhoBloco());
        i++;

    }

    public void setUrso(){
        int i=0;
        int numMapa=0;

        gp.getCriatura()[numMapa][i]=new CRI_Urso(gp);
        gp.getCriatura()[numMapa][i].setMundoX(20 * gp.getTamanhoBloco());
        gp.getCriatura()[numMapa][i].setMundoY(20 * gp.getTamanhoBloco());
        i++;

    }




}
