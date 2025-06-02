package gui.entidades;

import gui.itens.Armas;
import gui.itens.Ferramentas;
import gui.itens.OBJ_Vida;
import gui.system.PainelJogo;
import itens.Arma;

import javax.imageio.ImageIO;
import java.awt.*;
import java.util.Random;

public class Craft extends Entidade {

    PainelJogo gp;

    public Craft(PainelJogo gp) {
        super(gp);
        this.gp = gp;

        //setDown1(setup("/tiles_interativos/mesacraft",gp.getTamanhoBloco()*2, gp.getTamanhoBloco()*2));
        definirDialogo();


        setAreaSolida(new Rectangle(18, 12, 147, 107));
        setAreaSolidaPadraoX(getAreaSolida().x);
        setAreaSolidaPadraoY(getAreaSolida().y);

        setColisao(true);

    }


    public void definirItens(){

        getInventario().add(new Ferramentas(gp, "machado"));
        getInventario().add(new Ferramentas(gp, "picareta"));
        getInventario().add(new Armas(gp, "espada"));
    }


    public void definirDialogo(){

        getDialogos()[0]="Shhh... Eles estão\nobservando.";
        getDialogos()[1]="Você acha mesmo que essa\nfloresta é natural?\nNada aqui é natural.";
        getDialogos()[2]="Já ouviu falar das criaturas \nde olhos brilhantes?\nEu já as vi... à noite.";
        getDialogos()[3]= "Só me prometa...\nque não vai deixar essa\nfloresta te consumir...\ncomo fez comigo.";

    }



}
