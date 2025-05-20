package gui.system;

import gui.criaturas.CRI_Lobo;
import gui.entidades.Entidade;
import gui.entidades.NPC_Coelho;
import gui.entidades.NPC_Explorador;
import gui.objetos.*;
import eventos.*;

public class CriadorAtivos {

    private PainelJogo gp;
    //private Random random;

    public CriadorAtivos(PainelJogo gp) {
        this.gp = gp;
        //this.random = new Random();
    }

    public void setObjeto() {

        int i=0;

        String personagem = gp.getPersonagemSelecionado();

        // Define a quantidade de objetos para cada personagem escolhido
        if ("médico".equals(personagem)) {

            // Médico começa com mais remédios
            gp.getObj()[i] = new REMEDIO_Antibiotico(gp);
            gp.getObj()[i].setMundoX(35 * gp.getTamanhoBloco());
            gp.getObj()[i].setMundoY(21 * gp.getTamanhoBloco());
            i++;

            gp.getObj()[i] = new REMEDIO_Analgesico(gp);
            gp.getObj()[i].setMundoX(32 * gp.getTamanhoBloco());
            gp.getObj()[i].setMundoY(45 * gp.getTamanhoBloco());
            i++;

            gp.getObj()[i] = new REMEDIO_Bandagem(gp);
            gp.getObj()[i].setMundoX(32 * gp.getTamanhoBloco());
            gp.getObj()[i].setMundoY(32 * gp.getTamanhoBloco());
            i++;


        } else if ("mecânico".equals(personagem)) {


            // Mecânico começa com ferramentas, por exemplo
            gp.getObj()[i] = new REMEDIO_Bandagem(gp);
            gp.getObj()[i].setMundoX(29 * gp.getTamanhoBloco());
            gp.getObj()[i].setMundoY(30 * gp.getTamanhoBloco());
            i++;

            gp.getObj()[i] = new ferramentas(gp, "machado");
            gp.getObj()[i].setMundoX(24 * gp.getTamanhoBloco());
            gp.getObj()[i].setMundoY(21 * gp.getTamanhoBloco());
            i++;

            gp.getObj()[i] = new ferramentas(gp, "picareta");
            gp.getObj()[i].setMundoX(23 * gp.getTamanhoBloco());
            gp.getObj()[i].setMundoY(22 * gp.getTamanhoBloco());
            i++;

            gp.getObj()[i] = new ferramentas(gp, "espada");
            gp.getObj()[i].setMundoX(26 * gp.getTamanhoBloco());
            gp.getObj()[i].setMundoY(27 * gp.getTamanhoBloco());
            i++;

        } else if ("rastreador".equals(personagem)) {


            gp.getObj()[i] = new REMEDIO_Antibiotico(gp);
            gp.getObj()[i].setMundoX(28 * gp.getTamanhoBloco());
            gp.getObj()[i].setMundoY(25 * gp.getTamanhoBloco());
            i++;



            gp.getObj()[i] = new ALIMENTO_Fruta(gp, "laranja");
            gp.getObj()[i].setMundoX(30 * gp.getTamanhoBloco());
            gp.getObj()[i].setMundoY(25 * gp.getTamanhoBloco());
            i++;


        } else {

            gp.getObj()[i] = new ALIMENTO_Fruta(gp, "maçã");
            gp.getObj()[i].setMundoX(30 * gp.getTamanhoBloco());
            gp.getObj()[i].setMundoY(25 * gp.getTamanhoBloco());
            i++;

            gp.getObj()[i] = new ALIMENTO_Fruta(gp, "banana");
            gp.getObj()[i].setMundoX(31 * gp.getTamanhoBloco());
            gp.getObj()[i].setMundoY(26 * gp.getTamanhoBloco());
            i++;




        }


    }



    public void setNPC() {

        int i=0;
        gp.getNpc()[i] = new NPC_Explorador(gp);
        gp.getNpc()[i].setMundoX(42 * gp.getTamanhoBloco());
        gp.getNpc()[i].setMundoY(29 * gp.getTamanhoBloco());
        System.out.println("NPC criado em: " + gp.getNpc()[0].getMundoX() + ", " + gp.getNpc()[0].getMundoY());
        i++;
    }

    public void setCOELHO() {


        gp.getNpc()[1] = new NPC_Coelho(gp);
        gp.getNpc()[1].setMundoX(21 * gp.getTamanhoBloco());
        gp.getNpc()[1].setMundoY(26 * gp.getTamanhoBloco());

        System.out.println("Coelho criado em: " + gp.getNpc()[0].getMundoX() + ", " + gp.getNpc()[0].getMundoY());

    }

  public void setCriatura(){

        int i=0;
        gp.getCriatura()[i]=new CRI_Lobo(gp);
        gp.getCriatura()[i].setMundoX(21 * gp.getTamanhoBloco());
        gp.getCriatura()[i].setMundoY(25 * gp.getTamanhoBloco());
        i++;

    }



}
