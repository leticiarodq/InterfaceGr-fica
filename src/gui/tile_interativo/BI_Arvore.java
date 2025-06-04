package gui.tile_interativo;

import gui.entidades.Entidade;
import gui.itens.ALIMENTO_Fruta;
import gui.itens.Material;
import gui.system.PainelJogo;

import java.awt.*;

public class BI_Arvore extends BlocoInterativo {

    PainelJogo gp;

    public BI_Arvore(PainelJogo gp, int coluna, int linha) {

        super(gp, coluna, linha);
        this.gp = gp;
        setVida(4);

        setDown1(setup("/tiles_interativos/arvore_maca", gp.getTamanhoBloco() * 2, gp.getTamanhoBloco() * 2));
        setDestrutivel(true);

        this.setMundoX(gp.getTamanhoBloco()*coluna);
        this.setMundoY(gp.getTamanhoBloco()*linha);

        setAreaSolida(new Rectangle(3, 18, 48, 48));
        setAreaSolidaPadraoX(getAreaSolida().x);
        setAreaSolidaPadraoY(getAreaSolida().y);
    }

    public boolean itemCorreto(Entidade entidade) {
        boolean itemCorreto = false;

        if (entidade.getArmaAtual() != null) {
            if (entidade.getArmaAtual().getTipo()==getTipo_machado()) {
                itemCorreto = true;
            } else {
                System.out.println("A arma atual não é um machado.");
            }
        } else {
            System.out.println("Você não está segurando nenhuma arma.");
        }

        return itemCorreto;
    }

    public void checarDrop() {

        droparItem(new Material(gp, "madeira"));
        droparItem(new ALIMENTO_Fruta(gp, "maca"));
        coletar(gp.jogador);

    }

    public void coletar(Entidade entidade) {
        System.out.println("Tentando coletar item...");
        System.out.println("Tamanho atual do inventário: " + gp.jogador.getInventario().size());

        Material madeira = new Material(gp, "madeira");
        gp.jogador.getInventario().add(madeira);

        System.out.println("Item adicionado! Novo tamanho: " + gp.jogador.getInventario().size());
        gp.getIu().mostrarMensagem("Coletou " + madeira.getNome() + "!");
    }


}