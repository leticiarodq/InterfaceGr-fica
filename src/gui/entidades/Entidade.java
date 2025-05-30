package gui.entidades;

import gui.system.FerramentasUteis;
import gui.system.PainelJogo;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Entidade {


    public boolean tocou=false;

    // Referência ao jogo
    private final PainelJogo gp;

    // Posição e movimento
    private int mundoX, mundoY;
    private int velocidade;
    private String direcao = "down";
    private int contadorSprite = 0;
    private int numSprite = 1;

    // Invisibilidade
    private int contadorInvisibilidade;
    private boolean invisibilidade=false;

    // Ataque
    private int tipo; //0=player, 1=npc, 2=criatura
    private final int tipo_jogador=0;
    private final int tipo_npc=1;
    private final int tipo_criatura=2;
    private final int tipo_consumivel=3;
    private final int tipo_espada=4;
    private final int tipo_machado=5;
    private final int tipo_picareta=6;
    private final int tipo_escudo=7;





    private boolean ataque=false;
    private boolean vivo=true;
    private boolean morto=false;
    private int contadorMorto=0;

    // Imagens do personagem
    private BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    private BufferedImage ataqueUp1, ataqueUp2, ataqueDown1, ataqueDown2, ataqueLeft1, ataqueLeft2, ataqueRight1, ataqueRight2;

    // Colisão
    private Rectangle areaSolida = new Rectangle(0, 0, 64, 64);
    private int areaSolidaPadraoX, areaSolidaPadraoY;
    private boolean colisaoOn = false;
    public Rectangle areaAtaque=new Rectangle(0,0,0,0);

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

    private String descricao="";

    // Objetos

    private BufferedImage imagem, imagem2, imagem3;
    private String nome;
    private boolean colisao = false;


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

    // Inventário

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    // Invisibilidade

    public boolean isInvisibilidade() {
        return invisibilidade;
    }

    public void setInvisibilidade(boolean invisibilidade) {
        this.invisibilidade = invisibilidade;
    }

    public void setContadorInvisibilidade(int contadorInvisibilidade) {
        this.contadorInvisibilidade = contadorInvisibilidade;
    }

    public int getContadorInvisibilidade() {
        return contadorInvisibilidade;
    }

    public int getTipo() {
        return tipo;
    }

    public int getTipo_criatura() {
        return tipo_criatura;
    }

    public int getTipo_consumivel() {
        return tipo_consumivel;
    }

    public int getTipo_escudo() {
        return tipo_escudo;
    }

    public int getTipo_espada() {
        return tipo_espada;
    }

    public int getTipo_jogador() {
        return tipo_jogador;
    }

    public int getTipo_machado() {
        return tipo_machado;
    }

    public int getTipo_picareta() {
        return tipo_picareta;
    }

    public int getTipo_npc() {
        return tipo_npc;
    }

    public boolean isAtaque() {
        return ataque;
    }

    public boolean isMorto() {
        return morto;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public boolean isTocou() {
        return tocou;
    }

    public void setMorto(boolean morto) {
        this.morto = morto;
    }

    public void setTocou(boolean tocou) {
        this.tocou = tocou;
    }

    public void setAtaque(boolean ataque) {
        this.ataque = ataque;
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
    public BufferedImage getUp1() {
        return up1;
    }

    public BufferedImage getUp2() {
        return up2;
    }

    public BufferedImage getDown1() {
        return down1;
    }

    public BufferedImage getDown2() {
        return down2;
    }

    public BufferedImage getLeft1() {
        return left1;
    }

    public BufferedImage getLeft2() {
        return left2;
    }

    public BufferedImage getRight1() {
        return right1;
    }

    public BufferedImage getRight2() {
        return right2;
    }

    public BufferedImage getAtaqueDown1() {
        return ataqueDown1;
    }

    public BufferedImage getAtaqueDown2() {
        return ataqueDown2;
    }

    public BufferedImage getAtaqueLeft1() {
        return ataqueLeft1;
    }

    public BufferedImage getAtaqueLeft2() {
        return ataqueLeft2;
    }

    public BufferedImage getAtaqueRight1() {
        return ataqueRight1;
    }

    public BufferedImage getAtaqueRight2() {
        return ataqueRight2;
    }

    public BufferedImage getAtaqueUp1() {
        return ataqueUp1;
    }

    public BufferedImage getAtaqueUp2() {
        return ataqueUp2;
    }

    // Imagens setters
    public void setUp1(BufferedImage up1) {
        this.up1 = up1;
    }

    public void setUp2(BufferedImage up2) {
        this.up2 = up2;
    }

    public void setDown1(BufferedImage down1) {
        this.down1 = down1;
    }

    public void setDown2(BufferedImage down2) {
        this.down2 = down2;
    }

    public void setLeft1(BufferedImage left1) {
        this.left1 = left1;
    }

    public void setLeft2(BufferedImage left2) {
        this.left2 = left2;
    }

    public void setRight1(BufferedImage right1) {
        this.right1 = right1;
    }

    public void setRight2(BufferedImage right2) {
        this.right2 = right2;
    }

    public void setAtaqueDown1(BufferedImage ataqueDown1) {
        this.ataqueDown1 = ataqueDown1;
    }

    public void setAtaqueDown2(BufferedImage ataqueDown2) {
        this.ataqueDown2 = ataqueDown2;
    }

    public void setAtaqueLeft1(BufferedImage ataqueLeft1) {
        this.ataqueLeft1 = ataqueLeft1;
    }

    public void setAtaqueLeft2(BufferedImage ataqueLeft2) {
        this.ataqueLeft2 = ataqueLeft2;
    }

    public void setAtaqueRight1(BufferedImage ataqueRight1) {
        this.ataqueRight1 = ataqueRight1;
    }

    public void setAtaqueRight2(BufferedImage ataqueRight2) {
        this.ataqueRight2 = ataqueRight2;
    }

    public void setAtaqueUp1(BufferedImage ataqueUp1) {
        this.ataqueUp1 = ataqueUp1;
    }

    public void setAtaqueUp2(BufferedImage ataqueUp2) {
        this.ataqueUp2 = ataqueUp2;
    }
    // Objetos getters

    public BufferedImage getImagem() {
        return imagem;
    }

    public BufferedImage getImagem2() {
        return imagem2;
    }

    public BufferedImage getImagem3() {
        return imagem3;
    }

    public String getNome() {
        return nome;
    }

    public boolean isColisao() {
        return colisao;
    }


    // Objetos setters

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setColisao(boolean colisao) {
        this.colisao = colisao;
    }

    public void setImagem(BufferedImage imagem) {
        this.imagem = imagem;
    }

    public void setImagem2(BufferedImage imagem2) {
        this.imagem2 = imagem2;
    }

    public void setImagem3(BufferedImage imagem3) {
        this.imagem3 = imagem3;
    }

    public Entidade(PainelJogo gp) {
        this.gp = gp;
    }

    public void setAcao() {
    }

    public void falar() {
    }

    public void update() {

        setAcao();

        setColisaoOn(false);
        gp.getcColisoes().checarBloco(this);
        gp.getcColisoes().checarObjeto(this, false);
        gp.getcColisoes().checarEntidade(this, gp.getNpc());
        gp.getcColisoes().checarEntidade(this, gp.getCriatura());
        boolean contatoJogador = gp.getcColisoes().checarJogador(this);

        if (this.getTipo() == 2 && contatoJogador) {
            if (!gp.jogador.isInvisibilidade()) {
                gp.jogador.setVida(gp.jogador.getVida() - 1);
                gp.jogador.setInvisibilidade(true);
            }
        }

        // Movimento
        if (!isColisaoOn()) {
            switch (getDirecao()) {
                case "up":
                    if (getMundoY() - getVelocidade() >= 0) {
                        setMundoY(getMundoY() - getVelocidade());
                    }
                    break;
                case "down":
                    if (getMundoY() + getVelocidade() <= gp.getMundoAltura() - gp.getTamanhoBloco()) {
                        setMundoY(getMundoY() + getVelocidade());
                    }
                    break;
                case "left":
                    if (getMundoX() - getVelocidade() >= 0) {
                        setMundoX(getMundoX() - getVelocidade());
                    }
                    break;
                case "right":
                    if (getMundoX() + getVelocidade() <= gp.getMundoLargura() - gp.getTamanhoBloco()) {
                        setMundoX(getMundoX() + getVelocidade());
                    }
                    break;
            }

            setContadorSprite(getContadorSprite() + 1);
            if (getContadorSprite() > 20) {
                setNumSprite(getNumSprite() == 1 ? 2 : 1);
                setContadorSprite(0);
            }
        }

        // Invisibilidade deve ser contada SEMPRE
        if (invisibilidade) {
            contadorInvisibilidade++;
            if (contadorInvisibilidade > 60) {
                invisibilidade = false;
                contadorInvisibilidade = 0;
            }
        }
    }

    public void desenhar(Graphics2D g2) {
        BufferedImage imagem = null;

        int telaX = mundoX - gp.jogador.getMundoX() + gp.jogador.getTelaX();
        int telaY = mundoY - gp.jogador.getMundoY() + gp.jogador.getTelaY();

        if (mundoX + gp.getTamanhoBloco() > gp.jogador.getMundoX() - gp.jogador.getTelaX() &&
                mundoX - gp.getTamanhoBloco() < gp.jogador.getMundoX() + gp.jogador.getTelaX() &&
                mundoY + gp.getTamanhoBloco() > gp.jogador.getMundoY() - gp.jogador.getTelaY() &&
                mundoY - gp.getTamanhoBloco() < gp.jogador.getMundoY() + gp.jogador.getTelaY()) {

            switch (getDirecao()) {
                case "up":
                    imagem = (getNumSprite() == 1) ? getUp1() : getUp2();
                    break;
                case "down":
                    imagem = (getNumSprite() == 1) ? getDown1() : getDown2();
                    break;
                case "left":
                    imagem = (getNumSprite() == 1) ? getLeft1() : getLeft2();
                    break;
                case "right":
                    imagem = (getNumSprite() == 1) ? getRight1() : getRight2();
                    break;
            }

            // barra

            if(tipo==2){

                double umaEscala= (double)gp.getTamanhoBloco()/vidaMaxima;
                double barraHpValor= umaEscala*vida;

                g2.setColor(new Color(35,35,35));
                g2.fillRect(telaX-1, telaY-21, gp.getTamanhoBloco()+2, 10);
                g2.setColor(new Color(255, 0, 30));
                g2.fillRect(telaX, telaY-20, (int) barraHpValor, 8);

            }



            if (isInvisibilidade()) {
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
            }
            if(isMorto()){
                mortoAnimacao(g2);

            }

            g2.drawImage(imagem, telaX, telaY, gp.getTamanhoBloco(), gp.getTamanhoBloco(), null);

            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        }


    }
    public void usar(Entidade entidade){}

    public void mortoAnimacao(Graphics2D g2){

        contadorMorto++;

        int i = 5;

        if(contadorMorto <= i){
            mudarOpacidade(g2, 0f);
        }
        else if(contadorMorto <= i*2){
            mudarOpacidade(g2, 1f);
        }
        else if(contadorMorto <= i*3){
            mudarOpacidade(g2, 0f);
        }
        else if(contadorMorto <= i*4){
            mudarOpacidade(g2, 1f);
        }
        else if(contadorMorto <= i*5){
            mudarOpacidade(g2, 0f);
        }
        else if(contadorMorto <= i*6){
            mudarOpacidade(g2, 1f);
        }
        else if(contadorMorto <= i*7){
            mudarOpacidade(g2, 0f);
        }
        else if(contadorMorto <= i*8){
            mudarOpacidade(g2, 1f);
        }
        else {
            morto = false;
            vivo = false;
        }
    }


    public void mudarOpacidade(Graphics2D g2, float valorOpacidade){

        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, valorOpacidade));

    }


    public BufferedImage setup(String imagemPath){
    FerramentasUteis ferramentasUteis = new FerramentasUteis();
    BufferedImage imagem = null;

    try

    {
        imagem = ImageIO.read(getClass().getResourceAsStream(imagemPath + ".png"));
        imagem = ferramentasUteis.escalar(imagem, gp.getTamanhoBloco(), gp.getTamanhoBloco());

    }catch(
            IOException e)

    {
        e.printStackTrace();
    }return imagem;


    }


}