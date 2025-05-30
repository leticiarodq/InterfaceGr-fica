package gui.system;

import gui.criaturas.*;
import gui.entidades.NPC_Explorador;
import gui.itens.ALIMENTO_Fruta;

public class CriadorAtivos {

    private PainelJogo gp;
    //private Random random;

    public CriadorAtivos(PainelJogo gp) {
        this.gp = gp;
        //this.random = new Random();
    }

    public void setObjeto() {

           int i=0;
           int numMapa=0;

           gp.getObj()[numMapa][i] = new ALIMENTO_Fruta(gp, "banana");
           gp.getObj()[numMapa][i].setMundoX(21 * gp.getTamanhoBloco());
           gp.getObj()[numMapa][i].setMundoY(34 * gp.getTamanhoBloco());

           i++;

    }



    public void setNPC() {

        int i=0;
        int numMapa=0;

        gp.getNpc()[numMapa][i] = new NPC_Explorador(gp);
        gp.getNpc()[numMapa][i].setMundoX(42 * gp.getTamanhoBloco());
        gp.getNpc()[numMapa][i].setMundoY(29 * gp.getTamanhoBloco());

        i++;
    }

    public void setCOELHO() {

        int i=0;
        int numMapa=0;

        gp.getCriatura()[numMapa][i] = new NPC_Coelho(gp);
        gp.getCriatura()[numMapa][i].setMundoX(21 * gp.getTamanhoBloco());
        gp.getCriatura()[numMapa][i].setMundoY(26 * gp.getTamanhoBloco());
        i++;


    }



  public void setLobo(){

          int i=0;
          int numMapa=0;

          gp.getCriatura()[numMapa][i]=new CRI_Lobo(gp);
          gp.getCriatura()[numMapa][i].setMundoX(21 * gp.getTamanhoBloco());
          gp.getCriatura()[numMapa][i].setMundoY(25 * gp.getTamanhoBloco());
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
