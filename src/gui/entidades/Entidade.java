package gui.entidades;

import gui.system.PainelJogo;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entidade {


    // Referência ao jogo
    private final PainelJogo gp;

    // Posição e movimento
    private int mundoX, mundoY;
    private int velocidade;
    private String direcao;
    private int contadorSprite = 0;
    private int numSprite = 1;

    // Imagens do personagem
    private BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;

    // Colisão
    private Rectangle areaSolida = new Rectangle(0, 0, 40, 40);
    private int areaSolidaPadraoX, areaSolidaPadraoY;
    private boolean colisaoOn = false;

    // Controle de ações
    private int contadorDeBloqueioDeAcao = 0;

    // Diálogos
    private String dialogos[] = new String[20];
    private int indiceDialogo = 0;

    // Status do personagem
    private int vidaMaxima;
    private int vida;

    private int sedeMaxima;
    private int sede;

    private int fomeMaxima;
    private int fome;

    private int sanidadeMaxima;
    private int sanidade;

    private int energiaMaxima;
    private int energia;



    // Métodos de acesso

    // Vida
    public int getVida() {
        return vida;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    // Sede
    public int getSede() {
        return sede;
    }

    public int getSedeMaxima() {
        return sedeMaxima;
    }

    public void setSede(int sede) {
        this.sede = sede;
    }

    public void setSedeMaxima(int sedeMaxima) {
        this.sedeMaxima = sedeMaxima;
    }

    // Fome
    public int getFome() {
        return fome;
    }

    public int getFomeMaxima() {
        return fomeMaxima;
    }

    public void setFome(int fome) {
        this.fome = fome;
    }

    public void setFomeMaxima(int fomeMaxima) {
        this.fomeMaxima = fomeMaxima;
    }

    // Sanidade
    public int getSanidade() {
        return sanidade;
    }

    public int getSanidadeMaxima() {
        return sanidadeMaxima;
    }

    public void setSanidade(int sanidade) {
        this.sanidade = sanidade;
    }

    public void setSanidadeMaxima(int sanidadeMaxima) {
        this.sanidadeMaxima = sanidadeMaxima;
    }

    // Energia
    public int getEnergia() {
        return energia;
    }

    public int getEnergiaMaxima() {
        return energiaMaxima;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public void setEnergiaMaxima(int energiaMaxima) {
        this.energiaMaxima = energiaMaxima;
    }

    // Posição e movimento
    public int getMundoX() {
        return mundoX;
    }

    public void setMundoX(int mundoX) {
        this.mundoX = mundoX;
    }

    public int getMundoY() {
        return mundoY;
    }

    public void setMundoY(int mundoY) {
        this.mundoY = mundoY;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public int getContadorSprite() {
        return contadorSprite;
    }

    public void setContadorSprite(int contadorSprite) {
        this.contadorSprite = contadorSprite;
    }

    public int getNumSprite() {
        return numSprite;
    }

    public void setNumSprite(int numSprite) {
        this.numSprite = numSprite;
    }

    // Colisao
    public boolean isColisaoOn() {
        return colisaoOn;
    }

    public void setColisaoOn(boolean colisaoOn) {
        this.colisaoOn = colisaoOn;
    }

    public Rectangle getAreaSolida() {
        return areaSolida;
    }

    public void setAreaSolida(Rectangle areaSolida) {
        this.areaSolida = areaSolida;
    }

    public int getAreaSolidaPadraoX() {
        return areaSolidaPadraoX;
    }

    public void setAreaSolidaPadraoX(int areaSolidaPadraoX) {
        this.areaSolidaPadraoX = areaSolidaPadraoX;
    }

    public int getAreaSolidaPadraoY() {
        return areaSolidaPadraoY;
    }

    public void setAreaSolidaPadraoY(int areaSolidaPadraoY) {
        this.areaSolidaPadraoY = areaSolidaPadraoY;
    }

    // Ações e bloqueios
    public int getContadorDeBloqueioDeAcao() {
        return contadorDeBloqueioDeAcao;
    }

    public void setContadorDeBloqueioDeAcao(int contadorDeBloqueioDeAcao) {
        this.contadorDeBloqueioDeAcao = contadorDeBloqueioDeAcao;
    }

    // Diálogos
    public String[] getDialogos() {
        return dialogos;
    }

    public void setDialogos(String[] dialogos) {
        this.dialogos = dialogos;
    }

    public int getIndiceDialogo() {
        return indiceDialogo;
    }

    public void setIndiceDialogo(int indiceDialogo) {
        this.indiceDialogo = indiceDialogo;
    }

    // Imagens getters
    public BufferedImage getUp1() { return up1; }
    public BufferedImage getUp2() { return up2; }
    public BufferedImage getDown1() { return down1; }
    public BufferedImage getDown2() { return down2; }
    public BufferedImage getLeft1() { return left1; }
    public BufferedImage getLeft2() { return left2; }
    public BufferedImage getRight1() { return right1; }
    public BufferedImage getRight2() { return right2; }

    // Imagens setters
    public void setUp1(BufferedImage up1) { this.up1 = up1; }
    public void setUp2(BufferedImage up2) { this.up2 = up2; }
    public void setDown1(BufferedImage down1) { this.down1 = down1; }
    public void setDown2(BufferedImage down2) { this.down2 = down2; }
    public void setLeft1(BufferedImage left1) { this.left1 = left1; }
    public void setLeft2(BufferedImage left2) { this.left2 = left2; }
    public void setRight1(BufferedImage right1) { this.right1 = right1; }
    public void setRight2(BufferedImage right2) { this.right2 = right2; }

    public Entidade(PainelJogo gp) {
        this.gp = gp;
    }

    public void setAcao() {
    }

    public void falar(){}

    public void update() {

        setAcao();

        setColisaoOn(false);
        gp.getcColisoes().checarBloco(this);
        gp.getcColisoes().checarObjeto(this, false);
        gp.getcColisoes().checarJogador(this);

        if (!isColisaoOn()) {

            switch (getDirecao()) {
                case "up":
                    if (getMundoY() - getVelocidade() >= 0) { //Verifica se não vai além do topo
                        setMundoY(getMundoY() - getVelocidade());
                    }
                    break;
                case "down":
                    if (getMundoY() + getVelocidade() <= gp.getMundoAltura() - gp.getTamanhoBloco()) { //Verifica se não vai além do fundo
                        setMundoY(getMundoY() + getVelocidade());
                    }
                    break;
                case "left":
                    if (getMundoX() - getVelocidade() >= 0) { //Verifica se não vai além da esquerda
                        setMundoX(getMundoX() - getVelocidade());
                    }
                    break;
                case "right":
                    if (getMundoX() + getVelocidade() <= gp.getMundoLargura() - gp.getTamanhoBloco()) { //Verifica se não vai além da direita
                        setMundoX(getMundoX() + getVelocidade());
                    }
                    break;
            }

            setContadorSprite(getContadorSprite() + 1); //Conta quantas vezes o jogador se move e, quando atinge 20, troca a animação
            if (getContadorSprite() > 20) {
                if (getNumSprite() == 1) {
                    setNumSprite(2);
                } else if (getNumSprite() == 2) {
                    setNumSprite(1);
                }
                setContadorSprite(0);
            }

        }

    }

    public void desenhar (Graphics2D g2){

        BufferedImage imagem = null;

        int telaX = mundoX - gp.jogador.getMundoX() + gp.jogador.getTelaX();
        int telaY = mundoY - gp.jogador.getMundoY() + gp.jogador.getTelaY();

        if (mundoX + gp.getTamanhoBloco() > gp.jogador.getMundoX() - gp.jogador.getTelaX() &&
                mundoX - gp.getTamanhoBloco() < gp.jogador.getMundoX() + gp.jogador.getTelaX() &&
                mundoY + gp.getTamanhoBloco() > gp.jogador.getMundoY() - gp.jogador.getTelaY() &&
                mundoY - gp.getTamanhoBloco() < gp.jogador.getMundoY() + gp.jogador.getTelaY()) {


            switch (getDirecao()) { //Verifica a direção atural e escolhe a imagem correspondente
                case "up":
                    if (getNumSprite() == 1) {
                        imagem = getUp1();
                    }
                    if (getNumSprite() == 2) {
                        imagem = getUp2();
                    }
                    break;
                case "down":
                    if (getNumSprite() == 1) {
                        imagem = getDown1();
                    }
                    if (getNumSprite() == 2) {
                        imagem = getDown2();
                    }
                    break;
                case "left":
                    if (getNumSprite() == 1) {
                        imagem = getLeft1();
                    }
                    if (getNumSprite() == 2) {
                        imagem = getLeft2();
                    }
                    break;
                case "right":
                    if (getNumSprite() == 1) {
                        imagem = getRight1();
                    }
                    if (getNumSprite() == 2) {
                        imagem = getRight2();
                    }
                    break;
            }

            g2.drawImage(imagem, telaX, telaY, gp.getTamanhoBloco(), gp.getTamanhoBloco(), null);
        }

    }
}