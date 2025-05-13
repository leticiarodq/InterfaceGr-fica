package gui.objetos;

import gui.system.FerramentasUteis;
import gui.system.PainelJogo;
import itens.Item;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObjetos {

    private BufferedImage imagem, imagem2, imagem3, imagem4, imagem5, imagem6, imagem7, imagem8, imagem9, imagem10, imagem11, imagem12, imagem13, imagem14, imagem15;
    private String nome;
    private boolean colisao=false;
    private int mundoX, mundoY;
    private Rectangle areaSolida= new Rectangle(0,0,48,48);
    private int areaSolidaPadraoX=0;
    private int areaSolidaPadraoY=0;
    private Item objetoLogico;

    FerramentasUteis ferramentasUteis = new FerramentasUteis();

    public Item getObjetoLogico(){
        return objetoLogico;
    }
    public void setObjetoLogico(Item objetoLogico){
        this.objetoLogico=objetoLogico;
    }




    // Métodos setters

    public void setImagem(BufferedImage imagem){
        this.imagem=imagem;
    }

    public void setNome(String nome){
        this.nome=nome;
    }

    public void setColisao(boolean colisao){
        this.colisao=colisao;
    }

    public void setMundoX(int mundoX){
        this.mundoX=mundoX;
    }

    public void setMundoY(int mundoY){
        this.mundoY=mundoY;
    }

    public void setImagem2(BufferedImage imagem2){
        this.imagem2=imagem2;
    }

    public void setImagem3(BufferedImage imagem3){
        this.imagem3=imagem3;
    }

    public void setImagem4(BufferedImage imagem4){
        this.imagem4=imagem4;
    }

    public void setImagem5(BufferedImage imagem5){
        this.imagem5=imagem5;
    }

    public void setImagem6(BufferedImage imagem6){
        this.imagem6=imagem6;
    }

    public BufferedImage getImagem(){
        return imagem;
    }
    public BufferedImage getImagem2(){
        return imagem2;
    }
    public BufferedImage getImagem3(){
        return imagem3;
    }
    public BufferedImage getImagem4(){
        return imagem4;
    }
    public BufferedImage getImagem5(){
        return imagem5;
    }
    public BufferedImage getImagem6(){
        return imagem6;
    }

    public BufferedImage getImagem7() {
        return imagem7;
    }

    public BufferedImage getImagem8() {
        return imagem8;
    }

    public BufferedImage getImagem9() {
        return imagem9;
    }

    public void setImagem7(BufferedImage imagem7) {
        this.imagem7 = imagem7;
    }

    public void setImagem8(BufferedImage imagem8) {
        this.imagem8 = imagem8;
    }

    public void setImagem9(BufferedImage imagem9) {
        this.imagem9 = imagem9;
    }

    public void setImagem10(BufferedImage imagem10) {
        this.imagem10 = imagem10;
    }

    public void setImagem11(BufferedImage imagem11) {
        this.imagem11 = imagem11;
    }

    public void setImagem12(BufferedImage imagem12) {
        this.imagem12 = imagem12;
    }

    public BufferedImage getImagem10() {
        return imagem10;
    }

    public BufferedImage getImagem11() {
        return imagem11;
    }

    public BufferedImage getImagem12() {
        return imagem12;
    }

    public BufferedImage getImagem13() {
        return imagem13;
    }

    public BufferedImage getImagem14() {
        return imagem14;
    }

    public BufferedImage getImagem15() {
        return imagem15;
    }

    public void setImagem13(BufferedImage imagem13) {
        this.imagem13 = imagem13;
    }

    public void setImagem14(BufferedImage imagem14) {
        this.imagem14 = imagem14;
    }

    public void setImagem15(BufferedImage imagem15) {
        this.imagem15 = imagem15;
    }

    public void setAreaSolida(Rectangle areaSolida){
        this.areaSolida=areaSolida;
    }
    public void setAreaSolidaPadraoX(int areaSolidaPadraoX){
        this.areaSolidaPadraoX=areaSolidaPadraoX;
    }
    public void setAreaSolidaPadraoy(int areaSolidaPadraoY){
        this.areaSolidaPadraoY=areaSolidaPadraoY;
    }


    // Métodos getter

    public String getNome(){
        return nome;
    }

    public boolean isColisao() {
        return colisao;
    }

    public int getMundoX() {
        return mundoX;
    }

    public int getMundoY() {
        return mundoY;
    }
    public Rectangle getAreaSolida(){
        return areaSolida;
    }

    public int getAreaSolidaPadraoX(){
        return areaSolidaPadraoX;
    }
    public int getAreaSolidaPadraoY(){
        return areaSolidaPadraoY;
    }



    public void desenhar(Graphics2D g2, PainelJogo gp) {

        int telaX = mundoX - gp.jogador.getMundoX() + gp.jogador.getTelaX();
        int telaY = mundoY - gp.jogador.getMundoY() + gp.jogador.getTelaY();

        if (mundoX + gp.getTamanhoBloco() > gp.jogador.getMundoX() - gp.jogador.getTelaX() &&
                mundoX - gp.getTamanhoBloco() < gp.jogador.getMundoX() + gp.jogador.getTelaX() &&
                mundoY + gp.getTamanhoBloco() > gp.jogador.getMundoY() - gp.jogador.getTelaY() &&
                mundoY - gp.getTamanhoBloco() < gp.jogador.getMundoY() + gp.jogador.getTelaY()) {

            g2.drawImage(imagem, telaX, telaY, gp.getTamanhoBloco(), gp.getTamanhoBloco(), null);
        }
    }
}
