package gui.blocos;

import java.awt.image.BufferedImage;

// Classe responsável por representar cada bloco do jogo
public class Blocos {

    private BufferedImage imagem; // Guarda a imagem do bloco
    private boolean colisao = false; // Indica se tem colisão

    // Métodos de acesso getters
    public BufferedImage getImagem() {
        return imagem;
    }
    public boolean isColisao() {
        return colisao;
    }

    // Métodos de acesso setters
    public void setImagem(BufferedImage imagem) {
        this.imagem = imagem;
    }
    public void setColisao(boolean colisao) {
        this.colisao = colisao;
    }
}

