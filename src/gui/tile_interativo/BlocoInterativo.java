package gui.tile_interativo;

import gui.entidades.Entidade;
import gui.system.PainelJogo;

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


