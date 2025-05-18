package gui.system;

import gui.criaturas.CRI_Lobo;
import gui.entidades.NPC_Coelho;
import gui.entidades.NPC_Explorador;
import gui.objetos.ALIMENTO_Enlatado;
import gui.objetos.REMEDIO_Analgesico;
import gui.objetos.REMEDIO_Antibiotico;
import gui.objetos.REMEDIO_Bandagem;

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
            gp.getObj()[0] = new REMEDIO_Antibiotico(gp);
            gp.getObj()[0].setMundoX(35 * gp.getTamanhoBloco());
            gp.getObj()[0].setMundoY(21 * gp.getTamanhoBloco());

            gp.getObj()[1] = new REMEDIO_Analgesico(gp);
            gp.getObj()[1].setMundoX(32 * gp.getTamanhoBloco());
            gp.getObj()[1].setMundoY(45 * gp.getTamanhoBloco());

            gp.getObj()[2] = new REMEDIO_Bandagem(gp);
            gp.getObj()[2].setMundoX(32 * gp.getTamanhoBloco());
            gp.getObj()[2].setMundoY(32 * gp.getTamanhoBloco());


        } else if ("mecânico".equals(personagem)) {


            // Mecânico começa com ferramentas, por exemplo
            gp.getObj()[0] = new REMEDIO_Bandagem(gp);
            gp.getObj()[0].setMundoX(29 * gp.getTamanhoBloco());
            gp.getObj()[0].setMundoY(30 * gp.getTamanhoBloco());


        } else if ("rastreador".equals(personagem)) {

            gp.getObj()[0] = new REMEDIO_Antibiotico(gp);
            gp.getObj()[0].setMundoX(28 * gp.getTamanhoBloco());
            gp.getObj()[0].setMundoY(25 * gp.getTamanhoBloco());


        } else {



        }


    }

    public void setAlimento(){
        gp.getAlimento()[0] = new ALIMENTO_Enlatado(gp);
        gp.getAlimento()[0].setMundoX(28 * gp.getTamanhoBloco());
        gp.getAlimento()[0].setMundoY(25 * gp.getTamanhoBloco());

        gp.getAlimento()[0] = new ALIMENTO_Enlatado(gp);
        gp.getAlimento()[0].setMundoX(26 * gp.getTamanhoBloco());
        gp.getAlimento()[0].setMundoY(12 * gp.getTamanhoBloco());


    }


    public void setNPC() {
        gp.getNpc()[0] = new NPC_Explorador(gp);
        gp.getNpc()[0].setMundoX(12 * gp.getTamanhoBloco());
        ;
        gp.getNpc()[0].setMundoY(10 * gp.getTamanhoBloco());
        System.out.println("NPC criado em: " + gp.getNpc()[0].getMundoX() + ", " + gp.getNpc()[0].getMundoY());

    }

    public void setCOELHO() {
        gp.getNpc()[0] = new NPC_Coelho(gp);
        gp.getNpc()[0].setMundoX(21 * gp.getTamanhoBloco());
        gp.getNpc()[0].setMundoY(26 * gp.getTamanhoBloco());

        System.out.println("Coelho criado em: " + gp.getNpc()[0].getMundoX() + ", " + gp.getNpc()[0].getMundoY());

    }

  public void setCriatura(){
        gp.getCriatura()[0]=new CRI_Lobo(gp);
        gp.getCriatura()[0].setMundoX(21 * gp.getTamanhoBloco());
        gp.getCriatura()[0].setMundoY(25 * gp.getTamanhoBloco());


    }



}
