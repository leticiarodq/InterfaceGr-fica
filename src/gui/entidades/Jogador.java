package gui.entidades;

import gui.objetos.ALIMENTO_Enlatado;
import gui.objetos.REMEDIO_Analgesico;
import gui.objetos.REMEDIO_Antibiotico;
import gui.objetos.REMEDIO_Bandagem;
import gui.system.CriadorAtivos;
import gui.system.EventosTeclado;
import gui.system.InterfaceUsuario;
import gui.system.PainelJogo;
import personagens.Mecanico;
import personagens.Personagem;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Jogador extends Entidade {

    PainelJogo gp; //gp é uma referência para o painel de jogo onde o jogador será desenhado e onde o jogo será atualizado.
    EventosTeclado eventosTeclado; //keyH é uma referência para o manipulador de teclas, que controla as teclas pressionadas para movimentação.

    private final int telaX;
    private final int telaY;
    private int temRemedio=0;
    private Personagem personagem;



    public final int getTelaX(){
        return telaX;
    }
    public final int getTelaY(){
        return telaY;
    }
    public int getTemRemedio(){
        return temRemedio;
    }

    private boolean desidratado = false;
    private boolean infectado=false;


    private ArrayList<Entidade> inventario=new ArrayList<>();
    private final int tamanhoMaxInventario=20;

    // Inventário
    public final int getTamanhoMaxInventario(){
        return tamanhoMaxInventario;
    }

    public ArrayList<Entidade> getInventario(){
        return inventario;
    }


    public boolean isDesidratado() {
        return desidratado;
    }

    public void setDesidratado(boolean desidratado) {
        this.desidratado = desidratado;
    }


    public boolean isInfectado() {
        return infectado;
    }

    public void setInfectado(boolean infectado){
        this.infectado=infectado;
    }

    private int counter2=0;

    CriadorAtivos criadorDeAtivos;

    public Jogador(PainelJogo gp, EventosTeclado eventosTeclado) { //Construtor da classe que recebe o painel de jogo e manipulador de teclas

        super(gp);

        this.gp = gp;
        this.eventosTeclado = eventosTeclado;


        telaX=gp.getTelaLargura()/2 - (gp.getTamanhoBloco()/2);
        telaY=gp.getTelaAltura()/2 - (gp.getTamanhoBloco()/2);

        setAreaSolida(new Rectangle(8, 16, 32, 32));
        setAreaSolidaPadraoX(getAreaSolida().x);
        setAreaSolidaPadraoY(getAreaSolida().y);

        setValoresPadrao(); //Chama o método que vai configurar valores padrão para o jogador
        getImagemJogador(); //Aqui garantimos que as imagens do jogador sejam carregadas

        definirItens();
    }

    public void setValoresPadrao() {
        // Define valores iniciais para a posição do jogador, velocidade e direção

        setMundoX(gp.getTamanhoBloco() * 26);
        setMundoY(gp.getTamanhoBloco() * 9);
        setVelocidade(2);
        setDirecao("down");

        // Status do jogador
        setVidaMaxima(6);
        setVida(getVidaMaxima());

        setSedeMaxima(8);
        setSede(getSedeMaxima());

        setFomeMaxima(8);
        setFome(getFomeMaxima());

        setSanidadeMaxima(6);
        setSanidade(getSanidadeMaxima());

        setEnergiaMaxima(6);
        setEnergia(getEnergiaMaxima());



    }
    public void definirItens(){



    }



    public void getImagemJogador(){}

    public void update() { //Este método atualiza a posição e a animação do jogador com base nas teclas pressionadas

        if (eventosTeclado.isCimaPressionado() == true || eventosTeclado.isBaixoPressionado() == true || eventosTeclado.isEsquerdaPressionado() == true || eventosTeclado.isDireitaPressionado() == true) {

            if (eventosTeclado.isCimaPressionado()) {
                setDirecao("up");
            } else if (eventosTeclado.isBaixoPressionado()) {
                setDirecao("down");
            } else if (eventosTeclado.isEsquerdaPressionado()) {
                setDirecao("left");
            } else if (eventosTeclado.isDireitaPressionado()) {
                setDirecao("right");
            }

            setColisaoOn(false);

            gp.getcColisoes().checarBloco(this);

            // Checar colisao objeto
            int objIndice=gp.getcColisoes().checarObjeto(this, true);
            pegarObjeto(objIndice);


            // Checar colisao NPC
            int npcIndice=gp.getcColisoes().checarEntidade(this, gp.getNpc());
            interagirNPC(npcIndice);

            //Checar colisao criatura
            int criaturaIndice=gp.getcColisoes().checarEntidade(this, gp.getCriatura());
            contatoCriatura(criaturaIndice);


            // Checar evento
            gp.getManipuladorDeEventos().checarEvento();



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

            if (isInvisibilidade()==true){

                setContadorInvisibilidade(getContadorInvisibilidade()+1);

                if(getContadorInvisibilidade()>60){
                    setInvisibilidade(false);
                    setContadorInvisibilidade(0);
                }

            }


        }
    }



    public void pegarObjeto(int i){

        if(i !=999){

            String texto;

            if(inventario.size()!=tamanhoMaxInventario){

                inventario.add(gp.getObj()[i]);
                texto="Pegou "+gp.getObj()[i].getNome()+"!";


            }
            else {
                texto="Você antingiu o limite máximo no inventário!";
            }
            gp.getIu().mostrarMensagem(texto);
            gp.getObj()[i]=null;
        }

    }


    public void interagirNPC(int i){
        if(i!=999){

            if (gp.getEventosTeclado().isEnterPressionado()) {
                gp.setEstadoJogo(gp.getEstadoDialogo());
                gp.getNpc()[i].falar();
            }
        }
        gp.getEventosTeclado().setEnterPressionado(false);
    }


    public void contatoCriatura(int i){
        if(i!=999){

            if(isInvisibilidade()==false){
                setVida(getVida()-1);
                setInvisibilidade(true);

            }

        }

    }



    public void desenhar(Graphics2D g2){ //Este método desenha o jogador na tela
        BufferedImage imagem = null;

            switch (getDirecao()) { //Verifica a direção atual e escolhe a imagem correspondente
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

            int x = telaX;
            int y = telaY;

            if (telaX > getMundoX()) {
                x = getMundoX();
            }
            if (telaY > getMundoY()) {
                y = getMundoY();
            }
            int rightOffset = gp.getTelaLargura() - telaX;
            if (rightOffset > gp.getMundoLargura() - getMundoX()) {
                x = gp.getTelaLargura() - (gp.getMundoLargura() - getMundoX());
            }
            int bottomOffset = gp.getTelaAltura() - telaY;
            if (bottomOffset > gp.getMundoAltura() - getMundoY()) {
                y = gp.getTelaAltura() - (gp.getMundoAltura() - getMundoY());
            }

            if(isInvisibilidade()==true){
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));


            }

            g2.drawImage(imagem, x, y, gp.getTamanhoBloco(), gp.getTamanhoBloco(), null); //O jogador é desenhado na posição (x, y) com o tamanho da célula (tileSize), que está definido no GamePanel.

        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

        // g2.setFont(new Font("Arial", Font.PLAIN, 26));
        // g2.setColor(Color.white);
        // g2.drawString("Invisibilidade:"+getContadorInvisibilidade(), 10, 400);



    }
}

