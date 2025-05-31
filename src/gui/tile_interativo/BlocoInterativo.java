package gui.tile_interativo;

import eventos.EventoCriatura;
import gui.entidades.Entidade;
import gui.itens.ALIMENTO_Carne;
import gui.itens.Material;
import gui.system.PainelJogo;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class BlocoInterativo extends Entidade {

    private PainelJogo gp;

    private boolean destrutivel=false;



    public boolean isDestrutivel() {
        return destrutivel;
    }

    public void setDestrutivel(boolean destrutivel) {
        this.destrutivel = destrutivel;
    }

    public BlocoInterativo(PainelJogo gp, int coluna, int linha){
        super(gp);
        this.gp = gp;


    }

    public boolean itemCorreto(Entidade entidade){
        boolean itemCorreto=false;
        return itemCorreto;
    }



    public void update(){

        if(isInvisibilidade()){
            setContadorInvisibilidade(getContadorInvisibilidade()+1);
            if(getContadorInvisibilidade()>20){
                setInvisibilidade(false);
                setContadorInvisibilidade(0);


            }
        }

    }

    public void checarDrop() {

    }

    public void coletar(Entidade entidade) {



    }


}


