package criaturas;

import gui.entidades.Entidade;
import gui.system.PainelJogo;

import java.awt.*;

public class CRI_Urso extends Entidade {

    private PainelJogo gp;

    public CRI_Urso(PainelJogo gp){

        super(gp);

        setVelocidade(1);
        setVidaMaxima(8);
        setVida(getVidaMaxima());

        setAreaSolida(new Rectangle(3, 18, 42, 30));
        setAreaSolidaPadraoX(getAreaSolida().x);
        setAreaSolidaPadraoY(getAreaSolida().y);

    }

    public void pegarImagem(){
        
    }
}
