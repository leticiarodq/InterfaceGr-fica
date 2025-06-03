package gui.tile_interativo;

import gui.entidades.Entidade;
import gui.itens.Material;
import gui.system.PainelJogo;

import java.awt.*;

public class MINERIO_Ouro extends BlocoInterativo{

    PainelJogo gp;

    public MINERIO_Ouro(PainelJogo gp, int coluna, int linha) {

        super(gp, coluna, linha);
        this.gp = gp;
        setVida(15);

        setDown1(setup("/tiles_interativos/minerio_ouro", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
        setDestrutivel(true);

        this.setMundoX(gp.getTamanhoBloco()*coluna);
        this.setMundoY(gp.getTamanhoBloco()*linha);

        setAreaSolida(new Rectangle(6, 18, 48, 48));
        setAreaSolidaPadraoX(getAreaSolida().x);
        setAreaSolidaPadraoY(getAreaSolida().y);
    }

    public boolean itemCorreto(Entidade entidade) {
        boolean itemCorreto = false;

        if (entidade.getArmaAtual() != null) {
            if (entidade.getArmaAtual().getTipo()==getTipo_picareta()) {
                itemCorreto = true;
            } else {
                System.out.println("A arma atual não é uma picareta.");
            }
        } else {
            System.out.println("Você não está segurando nenhuma arma.");
        }

        return itemCorreto;
    }

    public void checarDrop() {

        droparItem(new Material(gp, "ouro"));
        coletar(gp.jogador);

    }

    public void coletar(Entidade entidade) {
        System.out.println("Tentando coletar item...");
        System.out.println("Tamanho atual do inventário: " + gp.jogador.getInventario().size());

        Material ouro = new Material(gp, "ouro");
        gp.jogador.getInventario().add(ouro);

        System.out.println("Item adicionado! Novo tamanho: " + gp.jogador.getInventario().size());
        gp.getIu().mostrarMensagem("Coletou " + ouro.getNome() + "!");
    }



}
