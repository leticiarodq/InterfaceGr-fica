package gui.system;


//java.awt é um conjunto de classes do Java que permite criar interfaces gráficas
//java.swing

import gui.blocos.GerenciadorBlocos;
import gui.entidades.*;
import gui.objetos.SuperObjetos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.util.ArrayList;
import java.util.Random;


public class PainelJogo extends JPanel implements Runnable { //GamePanel herda de JPanel, que é a área onde o jogo vai ser desenhado
    //implements Runnable indica que essa classe será executada em uma Thread separada, permitindo que o jogo rode continuamente sem travar a interface


    public class Gota {
        int x, y, velocidade;

        Gota(int x, int y, int velocidade) {
            this.x = x;
            this.y = y;
            this.velocidade = velocidade;
        }
    }

    public void iniciarChuva(int quantidade) {
        gotas.clear();
        for (int i = 0; i < quantidade; i++) {
            int x = random.nextInt(getWidth());
            int y = random.nextInt(getHeight());
            int velocidade = 2 + random.nextInt(3); // entre 2 e 4
            gotas.add(new Gota(x, y, velocidade));
        }
        mostrarChuva = true;
    }

    public class FlocoDeNeve {
        int x, y, tamanho, velocidade;

        public FlocoDeNeve(int x, int y, int tamanho, int velocidade) {
            this.x = x;
            this.y = y;
            this.tamanho = tamanho;
            this.velocidade = velocidade;
        }

    }

    public void iniciarNevasca(int quantidade) {
        flocos.clear(); // Limpa a lista de flocos de neve
        for (int i = 0; i < quantidade; i++) {
            int x = random.nextInt(getWidth()); // Posição aleatória em X
            int y = random.nextInt(getHeight()); // Posição aleatória em Y
            int tamanho = 5 + random.nextInt(5); // Tamanho aleatório entre 5 e 9
            int velocidade = 1 + random.nextInt(3); // Velocidade entre 1 e 3 (aumentada para maior efeito)
            flocos.add(new FlocoDeNeve(x, y, tamanho, velocidade)); // Adiciona o floco de neve à lista
        }
        mostrarNevasca = true; // Ativa a exibição da nevasca
    }




    public ArrayList<Gota> gotas = new ArrayList<>();
    public boolean mostrarChuva = false;
    public ArrayList<FlocoDeNeve> flocos = new ArrayList<>();
    public boolean mostrarNevasca = false;
    Random random = new Random();
    public boolean encerrandoNevasca = false;
    public boolean mostrarEfeitoConfusao=false;



    // Atributos privados


    private final int tamanhoOriginalBloco = 16; //O tamanho de um bloco do jogo é 16 pixels
    private final int escala = 3; //O tamanho do bloco será escalada em 3 vezes, ficando com 48 pixels

    private final int tamanhoBloco = tamanhoOriginalBloco * escala;
    private final int tamanhoColuna = 16; //O jogo terá 16 colunas
    private final int tamanhoLinha = 12; //O jogo terá 12 linhas
    private final int telaLargura = tamanhoBloco * tamanhoColuna;
    private final int telaAltura = tamanhoBloco * tamanhoLinha;

    private final int linhaMundoMax = 50;
    private final int colMundoMax = 50;
    private final int mundoLargura = tamanhoBloco * linhaMundoMax;
    private final int mundoAltura = tamanhoBloco * colMundoMax;

    private String personagemSelecionado;
    private boolean jogoIniciado = false;

    private int FPS = 60;

    // Sistema

    private GerenciadorBlocos blocosG = new GerenciadorBlocos(this);//

    private EventosTeclado eventosTeclado = new EventosTeclado(this); //Cria um objeto que lida com os eventos do teclado.

    private ChecadorColisoes cColisoes = new ChecadorColisoes(this);

    private CriadorAtivos cAtivos = new CriadorAtivos(this);

    //private FerramentasUteis ferramentasUteis=new FerramentasUteis();


    private InterfaceUsuario iu = new InterfaceUsuario(this);

    private ManipuladorDeEventos manipuladorDeEventos=new ManipuladorDeEventos(this);

    Thread threadJogo; //Essa Thread permitirá que o jogo rode continuamente.

    // Entidade e objeto
    public Jogador jogador = new Jogador(this, eventosTeclado);
    private SuperObjetos obj[] = new SuperObjetos[100];
    private Entidade npc[] = new Entidade[100];
    private Entidade coelho[]=new Entidade[10];


    //Estado do jogo

    private int estadoJogo;

    private final int estadoTitulo = 0;

    private final int estadoPlay = 1;
    private final int estadoPausa = 2;
    private final int estadoDialogo=4;
    private int estadoDescricao = 3;
    private int estadoPersonagem=5;

    // Métodos de acesso getters


    public int getEstadoPersonagem() {
        return estadoPersonagem;
    }

    public void setEstadoPersonagem(int estadoPersonagem){
        this.estadoPersonagem=estadoPersonagem;
    }

    public final int getTamanhoBloco() {
        return tamanhoBloco;
    }
    public final int getTamanhoColuna() {
        return tamanhoColuna;
    }
    public final int getTamanhoLinha() {
        return tamanhoLinha;
    }
    public final int getTelaLargura() {
        return telaLargura;
    }
    public final int getTelaAltura() {
        return telaAltura;
    }
    public final int getLinhaMundoMax() {
        return linhaMundoMax;
    }
    public final int getColMundoMax() {
        return colMundoMax;
    }
    public final int getMundoLargura() {
        return mundoLargura;
    }
    public final int getMundoAltura() {
        return mundoAltura;
    }
    public ChecadorColisoes getcColisoes() {
        return cColisoes;
    }
    public InterfaceUsuario getIu() {
        return iu;
    }

    public String getPersonagemSelecionado() {
        return personagemSelecionado;
    }
    public int getEstadoTitulo(){
        return estadoTitulo;
    }
    public GerenciadorBlocos getBlocosG() {
        return blocosG;
    }
    public SuperObjetos[] getObj() {
        return obj;
    }
    public boolean isJogoIniciado() {
        return jogoIniciado;
    }
    public int getEstadoJogo() {
        return estadoJogo;
    }

    public final int getEstadoPlay() {
        return estadoPlay;
    }
    public final int getEstadoPausa() {
        return estadoPausa;
    }
    public Entidade[] getNpc() {
        return npc;
    }
    public ManipuladorDeEventos getManipuladorDeEventos(){
        return manipuladorDeEventos;
    }

    public int getEstadoDialogo() {
        return estadoDialogo;
    }
    public EventosTeclado getEventosTeclado(){
        return eventosTeclado;
    }

    public void setEventosTeclado(EventosTeclado eventosTeclado){
        this.eventosTeclado=eventosTeclado;
    }


    public int getEstadoDescricao() {
        return estadoDescricao;
    }


    // Métodos setters

    public void setPersonagemSelecionado(String personagemSelecionado) {
        this.personagemSelecionado = personagemSelecionado;
    }
    public void setObj(SuperObjetos[] obj) {
        this.obj = obj;
    }
    public void setEstadoJogo(int estadoJogo) {
        this.estadoJogo = estadoJogo;
    }
    public void setEstadoPlay(int estadoPlay) {
        this.estadoJogo = estadoPlay;
    }
    public void setEstadoPausa(int estadoPausa) {
        this.estadoJogo = estadoPausa;
    }

    public void setBlocosG(GerenciadorBlocos blocosG) {
        this.blocosG = blocosG;
    }
    public void setManipuladorDeEventos(){
        this.manipuladorDeEventos=manipuladorDeEventos;
    }

    public PainelJogo() {


        Timer timer = new Timer(16, e -> repaint()); // 60 vezes por segundo
        timer.start();

        this.setPreferredSize(new Dimension(telaLargura, telaAltura)); //Define o tamanho da tela
        this.setBackground(Color.black); //Define o fundo como preto
        this.setDoubleBuffered(true); //Ativa o "Double Buffering"(Isso ajuda a evitar que a tela fique piscando ao desenhar elementos)
        this.addKeyListener(eventosTeclado); //Adiciona o KeyListener para capturar teclas pressionadas
        this.setFocusable(true); //Permite que o painel capture eventos de teclado
        this.requestFocus(); //Garante que o painel receba o foco do teclado:
        //this.ferramentasUteis=new FerramentasUteis();
        //telaMenuPersonagens = new MenuPersonagens(this);
        //add(telaMenuPersonagens); //Adiciona a tela de seleção de personagem
        //addKeyListener(telaMenuPersonagens); //Escuta os comandos para a seleção

    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public void iniciarJogo() {

        //Criar o personagem baseado na escolha do jogador
        if (personagemSelecionado.equals("médico")) {
            jogador = new Doctor(this, eventosTeclado);
        } else if (personagemSelecionado.equals("mecânico")) {
            jogador = new Mechanic(this, eventosTeclado);
        } else if (personagemSelecionado.equals("rastreador")) {
            jogador = new Detective(this, eventosTeclado);
        } else {
            jogador = new Survivor(this, eventosTeclado);
        }

        //estadoJogo = estadoPlay;

        //addKeyListener(eventosTeclado);
        requestFocusInWindow();
        jogoIniciado = true;

        setupJogo(); // Adicionado para os objetos de cada personagem
        iniciarThreadJogo();
    }

    public void setupJogo() {

        cAtivos.setObjeto();
        cAtivos.setNPC();
        cAtivos.setCOELHO();

        //estadoJogo = estadoPlay;
        //estadoJogo=estadoSelecaoPersonagem;
        estadoJogo=estadoTitulo;


    }

    public void iniciarThreadJogo() { //Cria e inicia a Thread do jogo, chamando o método run()
        threadJogo = new Thread(this);
        threadJogo.start();

    }

    @Override
    public void run() { // Loop principal do jogo (mantém o jogo rodando enquanto a threadJogo estiver ativa)

        double intervaloDesenho = 1000000000 / FPS; // Tempo ideal entre os quadros
        double delta = 0;
        long ultimoTempo = System.nanoTime();
        long tempoAtual;
        long cronometro = 0;
        int contadorQuadros = 0;

        while (threadJogo != null) {
            tempoAtual = System.nanoTime();

            delta += (tempoAtual - ultimoTempo) / intervaloDesenho;
            cronometro += (tempoAtual - ultimoTempo);

            ultimoTempo = tempoAtual;

            if (delta >= 1) { // Só atualiza o jogo quando delta ≥ 1
                update();    // Atualiza a lógica do jogo
                repaint();      // Requisição para redesenhar a tela
                delta--;        // Evita múltiplas atualizações por quadro
                contadorQuadros++;
            }

      /*      if (cronometro >= 1000000000) { // A cada 1 segundo...
                System.out.println("FPS: " + contadorQuadros);
                contadorQuadros = 0;
                cronometro = 0;
            }

       */

            try {
                Thread.sleep(1); // Pequena pausa para reduzir o uso da CPU
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void desenharChuva(Graphics2D g2) {
        // Desenha o fundo escuro semi-transparente para a chuva
        g2.setColor(new Color(0, 0, 0, 100)); // Preto com transparência
        g2.fillRect(0, 0, getWidth(), getHeight());

        // Desenhar as gotas de chuva
        g2.setColor(new Color(150, 150, 255, 100)); // Azul claro com transparência
        for (Gota gota : gotas) {
            g2.drawLine(gota.x, gota.y, gota.x, gota.y + 10);
            gota.y += gota.velocidade;

            // Resetar a gota quando sair da tela
            if (gota.y > getHeight()) {
                gota.y = 0;
                gota.x = random.nextInt(getWidth());
            }
        }
    }

    // Variáveis globais no seu painel ou classe principal
    float angulo = 0;
    BufferedImage telaBuffer;

    public void desenharEfeitoConfusao(Graphics2D g2) {

        if(jogador.getSanidade()<=2){
            int largura = getWidth();
            int altura = getHeight();

            // Escurece levemente a tela
            g2.setColor(new Color(0, 0, 0, 100)); // preto com transparência
            g2.fillRect(0, 0, largura, altura);

            // Aumenta a velocidade do giro
            angulo += 0.05f;
            if (angulo > 2 * Math.PI) angulo = 0;

            // Cálculo para tremor do círculo maior
            double tremor = Math.sin(System.currentTimeMillis() * 0.01) * 50; // controle de tremor

            // Primeiro círculo giratório (Maior e Vermelho)
            g2.setColor(new Color(255, 0, 0, 100)); // vermelho com transparência
            g2.rotate(angulo, largura / 2, altura / 2);
            g2.fillOval(largura / 2 - 200 + (int)tremor, altura / 2 - 200 + (int)tremor, 400, 400); // Tamanho maior e tremor
            g2.rotate(-angulo, largura / 2, altura / 2);

            // Segundo círculo girando no sentido contrário
            g2.setColor(new Color(255, 100, 100, 80));
            g2.rotate(-angulo * 1.5, largura / 2, altura / 2);
            g2.fillOval(largura / 2 - 100, altura / 2 - 100, 200, 200);
            g2.rotate(angulo * 1.5, largura / 2, altura / 2);

        }

    }

    private float opacidadeNevasca = 1.0f; // 1.0 (totalmente visível) até 0.0 (totalmente invisível)
    private float taxaDesvanecimento = 0.05f;

    public void encerrarNevasca() {
        if (opacidadeNevasca > 0) {
            // Reduz a opacidade gradualmente
            opacidadeNevasca -= taxaDesvanecimento;
            if (opacidadeNevasca < 0) {
                opacidadeNevasca = 0; // Garante que não fique abaixo de 0
            }
        } else {
            // Nevasca já foi completamente encerrada, pode resetar ou fazer outra ação
            encerrandoNevasca = false; // Marca como encerrada
            mostrarNevasca = false;   // Opcional: esconder a nevasca
        }
    }


    public void desenharNevasca(Graphics2D g2) {

        // Desenha o fundo escuro semi-transparente para a nevasca
        g2.setColor(new Color(169, 169, 169, 200)); // Cor cinza (RGB: 169, 169, 169) com transparência
        g2.fillRect(0, 0, getWidth(), getHeight()); // Preenchendo toda a área com o fundo cinza

        // Desenha os flocos de neve
        g2.setColor(new Color(255, 255, 255, 150)); // Branco com transparência
        for (FlocoDeNeve floco : flocos) {
            g2.fillOval(floco.x, floco.y, 5, 5); // Desenha o floco de neve como um círculo pequeno
            floco.y += floco.velocidade;

            // Resetar o floco de neve quando sair da tela
            if (floco.y > getHeight()) {
                floco.y = 0;
                floco.x = random.nextInt(getWidth());
            }
        }
    }




    public void update() {

        if (estadoJogo == estadoPlay) {

            jogador.update();


            // NPC
            for (int i = 0; i < npc.length; i++) {
                if (npc[i] != null) {
                    npc[i].update();
                }
            }
        }
        if (estadoJogo == estadoPausa) {
            // nada
        }
    }




    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        long drawStart = 0;
        if (eventosTeclado.isChecarDesenhoTempo()) {
            drawStart = System.nanoTime();
        }

        // TITLE SCREEN
        if (estadoJogo == estadoTitulo) {
            iu.desenhar(g2);
        } else {
            blocosG.draw(g2); // Desenhar mapa antes do personagem

            // Objetos
            for (int i = 0; i < obj.length; i++) {
                if (obj[i] != null) {
                    obj[i].desenhar(g2, this);
                }
            }

            // NPCs
            for (int i = 0; i < npc.length; i++) {
                if (npc[i] != null) {
                    npc[i].desenhar(g2);
                }
            }

            // Coelhos
            for (int i = 0; i < coelho.length; i++) {
                if (coelho[i] != null) {
                    coelho[i].desenhar(g2);
                }
            }

            // Jogador
            jogador.desenhar(g2);


            iu.desenhar(g2); // Primeiro desenha a interface

            if (mostrarEfeitoConfusao) {
                desenharEfeitoConfusao(g2);// Depois desenha o efeito por cima
            }

            // Chuva
            if (mostrarChuva) {
                desenharChuva(g2);
            }

            // Nevasca
            if (mostrarNevasca) {
                desenharNevasca(g2);
            }
            g2.dispose();
        }
    }
    }




