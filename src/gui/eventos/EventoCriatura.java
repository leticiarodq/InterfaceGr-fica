package gui.eventos;

import gui.criaturas.*;
import gui.entidades.Entidade;
import gui.entidades.NPC_Explorador;
import gui.entidades.NPC_Feiticeira;
import gui.itens.ALIMENTO_Enlatado;
import gui.itens.Armas;
import gui.itens.Ferramentas;
import gui.itens.Fogueira;
import gui.system.PainelJogo;
import gui.tile_interativo.*;

public class EventoCriatura {

    private PainelJogo gp;


    public EventoCriatura(PainelJogo gp) {
        this.gp = gp;;
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


    public void definirPresa() {
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

    public void definirAquatico(){

        CRI_Peixe peixe = new CRI_Peixe(gp);
        gp.getPresa()[1][0] = peixe;
        posicionarEntidadeLimitada(peixe, 29, 28);

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




}
