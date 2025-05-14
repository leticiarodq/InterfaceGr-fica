package gui.system;

import gui.entidades.NPC_Coelho;
import gui.entidades.NPC_Explorador;
import gui.objetos.OBJ_Remedio;

public class CriadorAtivos {

    private PainelJogo gp;
    //private Random random;

    public CriadorAtivos(PainelJogo gp) {
        this.gp = gp;
        //this.random = new Random();
    }

    public void setObjeto() {

        String personagem = gp.getPersonagemSelecionado();

        // Define a quantidade de objetos para cada personagem escolhido
        if ("médico".equals(personagem)) {

            // Médico começa com mais remédios
            gp.getObj()[0] = new OBJ_Remedio();
            gp.getObj()[0].setMundoX(35 * gp.getTamanhoBloco());
            gp.getObj()[0].setMundoY(21 * gp.getTamanhoBloco());

            gp.getObj()[1] = new OBJ_Remedio();
            gp.getObj()[1].setMundoX(32 * gp.getTamanhoBloco());
            gp.getObj()[1].setMundoY(45 * gp.getTamanhoBloco());

            gp.getObj()[2] = new OBJ_Remedio();
            gp.getObj()[2].setMundoX(32 * gp.getTamanhoBloco());
            gp.getObj()[2].setMundoY(32 * gp.getTamanhoBloco());


        } else if ("mecânico".equals(personagem)) {


            // Mecânico começa com ferramentas, por exemplo
            gp.getObj()[0] = new OBJ_Remedio();
            gp.getObj()[0].setMundoX(29 * gp.getTamanhoBloco());
            gp.getObj()[0].setMundoY(30 * gp.getTamanhoBloco());


        } else if ("rastreador".equals(personagem)) {

            gp.getObj()[0] = new OBJ_Remedio();
            gp.getObj()[0].setMundoX(28 * gp.getTamanhoBloco());
            gp.getObj()[0].setMundoY(25 * gp.getTamanhoBloco());


        } else {

            gp.getObj()[0] = new OBJ_Remedio();
            gp.getObj()[0].setMundoX(11 * gp.getTamanhoBloco());
            gp.getObj()[0].setMundoY(50 * gp.getTamanhoBloco());

        }


    }


    public void setNPC() {
        gp.getNpc()[0] = new NPC_Explorador(gp);
        gp.getNpc()[0].setMundoX(12 * gp.getTamanhoBloco());
        ;
        gp.getNpc()[0].setMundoY(10 * gp.getTamanhoBloco());
        System.out.println("NPC criado em: " + gp.getNpc()[0].getMundoX() + ", " + gp.getNpc()[0].getMundoY());

    }

    public void setCOELHO() {
        gp.getNpc()[1] = new NPC_Coelho(gp);
        gp.getNpc()[1].setMundoX(25 * gp.getTamanhoBloco());
        gp.getNpc()[1].setMundoY(25 * gp.getTamanhoBloco());
        gp.getNpc()[2] = new NPC_Coelho(gp);
        gp.getNpc()[2].setMundoX(30 * gp.getTamanhoBloco());
        gp.getNpc()[2].setMundoY(35 * gp.getTamanhoBloco());
        System.out.println("Coelho criado em: " + gp.getNpc()[0].getMundoX() + ", " + gp.getNpc()[0].getMundoY());

    }

}
