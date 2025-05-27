package gui.system;

import gui.criaturas.CRI_Lobo;
import gui.entidades.Entidade;
import gui.entidades.NPC_Coelho;
import gui.entidades.NPC_Explorador;
import gui.objetos.*;
import eventos.*;

import java.util.Random;

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

        String personagem = gp.getPersonagemSelecionado();

        // Define a quantidade de objetos para cada personagem escolhido
        if ("médico".equals(personagem)) {

            // Médico começa com mais remédios
            gp.getObj()[numMapa][i] = new REMEDIO_Antibiotico(gp);
            gp.getObj()[numMapa][i].setMundoX(35 * gp.getTamanhoBloco());
            gp.getObj()[numMapa][i].setMundoY(21 * gp.getTamanhoBloco());
            i++;

            gp.getObj()[numMapa][i] = new REMEDIO_Analgesico(gp);
            gp.getObj()[numMapa][i].setMundoX(32 * gp.getTamanhoBloco());
            gp.getObj()[numMapa][i].setMundoY(45 * gp.getTamanhoBloco());
            i++;

            gp.getObj()[numMapa][i] = new REMEDIO_Bandagem(gp);
            gp.getObj()[numMapa][i].setMundoX(32 * gp.getTamanhoBloco());
            gp.getObj()[numMapa][i].setMundoY(32 * gp.getTamanhoBloco());
            i++;


        } else if ("mecânico".equals(personagem)) {


            // Mecânico começa com ferramentas, por exemplo
            gp.getObj()[numMapa][i] = new REMEDIO_Bandagem(gp);
            gp.getObj()[numMapa][i].setMundoX(29 * (gp.getTamanhoBloco()));
            gp.getObj()[numMapa][i].setMundoY(30 * gp.getTamanhoBloco());
            i++;

            gp.getObj()[numMapa][i] = new ferramentas(gp, "machado");
            gp.getObj()[numMapa][i].setMundoX(24 * gp.getTamanhoBloco());
            gp.getObj()[numMapa][i].setMundoY(21 * gp.getTamanhoBloco());
            i++;

            gp.getObj()[numMapa][i] = new ferramentas(gp, "picareta");
            gp.getObj()[numMapa][i].setMundoX(23 * gp.getTamanhoBloco());
            gp.getObj()[numMapa][i].setMundoY(22 * gp.getTamanhoBloco());
            i++;

            gp.getObj()[numMapa][i] = new ferramentas(gp, "espada");
            gp.getObj()[numMapa][i].setMundoX(26 * gp.getTamanhoBloco());
            gp.getObj()[numMapa][i].setMundoY(27 * gp.getTamanhoBloco());
            i++;

        } else if ("rastreador".equals(personagem)) {


            gp.getObj()[numMapa][i] = new ALIMENTO_Fruta(gp, "banana");
            gp.getObj()[numMapa][i].setMundoX(33 * gp.getTamanhoBloco());
            gp.getObj()[numMapa][i].setMundoY(23 * gp.getTamanhoBloco());
            i++;


            gp.getObj()[numMapa][i] = new ALIMENTO_Fruta(gp, "laranja");
            gp.getObj()[numMapa][i].setMundoX(32 * gp.getTamanhoBloco());
            gp.getObj()[numMapa][i].setMundoY(24 * gp.getTamanhoBloco());
            i++;





        } else {

            gp.getObj()[numMapa][i] = new ALIMENTO_Fruta(gp, "maçã");
            gp.getObj()[numMapa][i].setMundoX(30 * gp.getTamanhoBloco());
            gp.getObj()[numMapa][i].setMundoY(25 * gp.getTamanhoBloco());
            i++;

            gp.getObj()[numMapa][i] = new ALIMENTO_Fruta(gp, "banana");
            gp.getObj()[numMapa][i].setMundoX(31 * gp.getTamanhoBloco());
            gp.getObj()[numMapa][i].setMundoY(26 * gp.getTamanhoBloco());
            i++;




        }


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

        gp.getNpc()[numMapa][i] = new NPC_Coelho(gp);
        gp.getNpc()[numMapa][i].setMundoX(21 * gp.getTamanhoBloco());
        gp.getNpc()[numMapa][i].setMundoY(26 * gp.getTamanhoBloco());
        i++;


    }



  public void setCriatura(){

          int i=0;
          int numMapa=0;

          gp.getCriatura()[numMapa][i]=new CRI_Lobo(gp);
          gp.getCriatura()[numMapa][i].setMundoX(21 * gp.getTamanhoBloco());
          gp.getCriatura()[numMapa][i].setMundoY(25 * gp.getTamanhoBloco());
          i++;



    }



}
