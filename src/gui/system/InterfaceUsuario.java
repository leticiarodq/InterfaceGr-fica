package gui.system;

import gui.entidades.*;
import gui.itens.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class InterfaceUsuario {


    private PainelJogo gp;
    private Font Font05, Font03;
    private Graphics2D g2;

    private BufferedImage fundo2, fundoHistoria, vida_cheia, vida_vazia, vida_metade;

    //private boolean jogoFinalizado = true;

    private int comandoNum = 0;
    private int telaMenu = 0;
    //private int telaDesc = 0;
    private int slotCol = 0;
    private int slotLinha = 0;

    private String personagemSelecionado;

    private String dialogoAtual = "";
    private String[] dialogos;
    private int indiceDialogo = 0;

    private String mensagem = "";
    private boolean mensagemOn = false;
    private int contadorMensagem = 0;

    //private Personagem personagem;

    // Métodos de acesso

    public int getSlotCol() {
        return slotCol;
    }

    public int getSlotLinha() {
        return slotLinha;
    }

    public void setSlotLinha(int slotLinha) {
        this.slotLinha = slotLinha;
    }

    public void setSlotCol(int slotCol) {
        this.slotCol = slotCol;
    }

    public int getComandoNum() {
        return comandoNum;
    }

    public int getTelaMenu() {
        return telaMenu;
    }

    public String getDialogoAtual() {
        return dialogoAtual;
    }

    public void setTelaMenu(int telaMenu) {
        this.telaMenu = telaMenu;
    }

    public void setComandoNum(int comandoNum) {
        this.comandoNum = comandoNum;

    }

    public void setPersonagemSelecionado(String personagem) {
        this.personagemSelecionado = personagem;
    }

    public String getPersonagemSelecionado() {
        return personagemSelecionado;
    }

    public void setDialogoAtual(String dialogoAtual) {
        this.dialogoAtual = dialogoAtual;
    }


    public InterfaceUsuario(PainelJogo gp) {
        this.gp = gp;

        try {
            InputStream is1 = getClass().getResourceAsStream("/font/font05.ttf");
            Font05 = Font.createFont(Font.TRUETYPE_FONT, is1).deriveFont(24f);

            InputStream is2 = getClass().getResourceAsStream("/font/font03.ttf");
            Font03 = Font.createFont(Font.TRUETYPE_FONT, is2).deriveFont(24f);


        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        try {
            fundo2 = ImageIO.read(getClass().getResourceAsStream("/fundo/fundo02.png"));
            fundoHistoria=ImageIO.read(getClass().getResourceAsStream("/fundo/fundoHistoria.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }

        Entidade vida = new OBJ_Vida(gp);
        vida_cheia = vida.getImagem();
        vida_metade = vida.getImagem2();
        vida_vazia = vida.getImagem3();


    }



    public void desenhar(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(Font03);
        g2.setColor(Color.white);

        // TITLE STATE
        if (gp.getEstadoJogo() == gp.getEstadoTitulo()) {
            desenharTelaTitulo();
        } else if (gp.getEstadoJogo() == gp.getEstadoPlay()) {
            desenharVidaJogador();

        } else if (gp.getEstadoJogo() == gp.getEstadoPausa()) {
            desenharTelaPausa();
        } else if (gp.getEstadoJogo() == gp.getEstadoDialogo()) {
            desenharVidaJogador();
            desenharTelaDialogo();

        } else if (gp.getEstadoJogo() == gp.getEstadoPersonagem()) {
            desenharStatusPersonagem();
            desenharInventario();

        } else if (gp.getEstadoJogo() == gp.getEstadoJogoFinalizado()) {
            desenharTelaJogoFinalizado();

        } else if(gp.getEstadoJogo()==gp.getEstadoJogoDescricao()){
            desenharTelaDescricao();
        }

        desenharNomeMapa(g2);

        if(mensagemOn == true) {
            g2.setColor(Color.BLACK);
            g2.setFont(Font05.deriveFont(25f));
            g2.drawString(mensagem, (gp.getTamanhoBloco() / 2) + 3, 300 + 2);

            g2.setFont(Font05.deriveFont(25f));
            g2.setColor(Color.white);
            g2.drawString(mensagem, gp.getTamanhoBloco() / 2, 300);
            g2.drawString(mensagem, gp.getTamanhoBloco() / 2, 300);

            contadorMensagem++;

            if (contadorMensagem > 200) {

                contadorMensagem = 0;
                mensagemOn = false;

            }


        }



    }

    // Variáveis que você pode declarar na sua classe PainelJogo ou onde desenha:
    private int alphaMensagem = 0;
    private int contadorFade = 0;
    private boolean mostrandoMensagem = false;
    private String textoMapaAtual = "";
    private int ultimoMapa = -1;  // <- novo
    // Tempo total: 60 + 180 + 60 = 300 frames (~5 segundos se 60 fps)


    public void desenharNomeMapa(Graphics2D g2) {
        int mapaAtual = gp.getMapaAtual();

        if (gp.getEstadoJogo() == gp.getEstadoPlay()) {

            if (mapaAtual != ultimoMapa) {
                ultimoMapa = mapaAtual;
                mostrandoMensagem = true;
                contadorFade = 0;
                alphaMensagem = 0;

                if (mapaAtual == 0) {
                    textoMapaAtual = "Floresta";
                } else if (mapaAtual == 1) {
                    textoMapaAtual = "Lago e Rio";
                } else if (mapaAtual == 2) {
                    textoMapaAtual = "Ruínas";
                } else if(mapaAtual==3){
                    textoMapaAtual="Montanha";
                } else if(mapaAtual==4) {
                    textoMapaAtual="Caverna";
                }

            }

            if (mostrandoMensagem) {
                int duracaoFadeIn = 150;
                int duracaoFixo = 360;
                int duracaoFadeOut = 150;

                // Fade-in
                if (contadorFade <= duracaoFadeIn) {
                    alphaMensagem = (int)((contadorFade / (float)duracaoFadeIn) * 255);
                }
                // Mensagem fixa
                else if (contadorFade <= duracaoFadeIn + duracaoFixo) {
                    alphaMensagem = 255;
                }
                // Fade-out
                else if (contadorFade <= duracaoFadeIn + duracaoFixo + duracaoFadeOut) {
                    int fadeOutContador = contadorFade - duracaoFadeIn - duracaoFixo;
                    alphaMensagem = 255 - (int)((fadeOutContador / (float)duracaoFadeOut) * 255);
                } else {
                    mostrandoMensagem = false;
                }

                contadorFade++;


                int x = 40; // margem à esquerda
                int y = gp.getTelaAltura() - 60; // 20 pixels acima da parte inferior

                g2.setFont(Font05.deriveFont(30f));

                g2.setColor(new Color(0f, 0f, 0f, alphaMensagem / 255f)); // sombra preta com alpha
                g2.drawString(textoMapaAtual, x + 2, y + 2); // deslocamento leve para dar efeito


                g2.setColor(new Color(1f, 1f, 1f, alphaMensagem / 255f)); // branco com alpha
                g2.drawString(textoMapaAtual, x, y);

            }
        }
    }




    public void setDialogos(String[] dialogos) {
        this.dialogos = dialogos;
        this.indiceDialogo = 0;
        this.dialogoAtual = dialogos[0];
    }

    public void avancarDialogo() {
        if (dialogos != null && indiceDialogo < dialogos.length - 1) {
            indiceDialogo++;
            dialogoAtual = dialogos[indiceDialogo];
        } else {
            dialogos = null; // Fim do diálogo
            dialogoAtual = null;
            // Aqui você pode mudar o estado do jogo, por exemplo:
            // gp.setEstadoJogo(gp.JOGO_NORMAL);
        }
    }

    private ArrayList<String> quebrarTexto(String texto, int larguraMaxima) {
        ArrayList<String> linhas = new ArrayList<>();
        FontMetrics metricas = g2.getFontMetrics();

        String[] palavras = texto.split(" ");
        StringBuilder linhaAtual = new StringBuilder();

        for (String palavra : palavras) {
            if (metricas.stringWidth(linhaAtual + " " + palavra) < larguraMaxima) {
                if (linhaAtual.length() > 0) {
                    linhaAtual.append(" ");
                }
                linhaAtual.append(palavra);
            } else {
                linhas.add(linhaAtual.toString());
                linhaAtual = new StringBuilder(palavra);
            }
        }

        if (linhaAtual.length() > 0) {
            linhas.add(linhaAtual.toString());
        }

        return linhas;
    }
    public void desenharTelaJogoFinalizado() {
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));

        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, gp.getTelaLargura(), gp.getTelaAltura());

        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));

        g2.setFont(Font05.deriveFont(65f));

        // Texto "VOCÊ MORREU!" com borda
        String texto = "VOCÊ MORREU!";
        int x = obterXCentralizarTexto(texto);
        int y = 200;

        g2.setColor(Color.BLACK);
        g2.drawString(texto, x + 4, y + 4);
        g2.setColor(Color.WHITE);
        g2.drawString(texto, x, y);

        // Texto "Tente novamente" com borda
        g2.setFont(Font03.deriveFont(45f));
        texto = "Tentar novamente";
        x = obterXCentralizarTexto(texto);
        y += gp.getTamanhoBloco() * 4;
        desenharTextoSombra(texto,x,y);


        g2.setColor(Color.WHITE);
        g2.drawString(texto, x, y);
        desenharTextoSombra(texto,x,y);
        if (comandoNum == 0) g2.drawString(">", x - 40, y);


        // Texto "Sair" com borda
        texto = "Sair";
        x = obterXCentralizarTexto(texto);
        y += gp.getTamanhoBloco() * 1;

        desenharTextoSombra(texto,x,y);


        g2.setColor(Color.WHITE);
        g2.drawString(texto, x, y);
        desenharTextoSombra(texto,x,y);
        if (comandoNum == 1) g2.drawString(">", x - 40, y);


    }



    public void desenharStatusPersonagem() {

        final int frameX = gp.getTamanhoBloco() * 2;
        final int frameY = gp.getTamanhoBloco();
        final int frameLargura = gp.getTamanhoBloco() * 5;
        final int frameAltura = gp.getTamanhoBloco() * 10;

        desenharJanela(frameX, frameY, frameAltura, frameLargura);

        g2.setColor(Color.white);
        g2.setFont(Font03.deriveFont(30f));

        int textoX = frameX + 20;
        int textoY = frameY + gp.getTamanhoBloco();

        final int linhaAltura = 36;

        g2.drawString("Vida", textoX, textoY);
        g2.drawString(gp.jogador.getVida() + "/" + gp.jogador.getVidaMaxima(), frameX + frameLargura - 70, textoY);
        textoY += linhaAltura;

        g2.drawString("Sanidade", textoX, textoY);
        g2.drawString(gp.jogador.getSanidade() + "/" + gp.jogador.getSanidadeMaxima(), frameX + frameLargura - 70, textoY);
        textoY += linhaAltura;

        g2.drawString("Energia", textoX, textoY);
        g2.drawString(gp.jogador.getEnergia() + "/" + gp.jogador.getEnergiaMaxima(), frameX + frameLargura - 70, textoY);
        textoY += linhaAltura;

        g2.drawString("Fome", textoX, textoY);
        g2.drawString(gp.jogador.getFome() + "/" + gp.jogador.getFomeMaxima(), frameX + frameLargura - 70, textoY);
        textoY += linhaAltura;

        g2.drawString("Sede", textoX, textoY);
        g2.drawString(gp.jogador.getSede() + "/" + gp.jogador.getSedeMaxima(), frameX + frameLargura - 70, textoY);

    }

    public void mostrarMensagem(String texto) {

        mensagem=texto;
        mensagemOn=true;
        mensagem = texto;
        mensagemOn = true;

    }

    public void desenharInventario() {

        // Frame
        int frameX = gp.getTamanhoBloco() * 9;
        int frameY = gp.getTamanhoBloco();
        int frameLargura = gp.getTamanhoBloco() * 6;
        int frameAltura = gp.getTamanhoBloco() * 5;

        desenharJanela(frameX, frameY, frameAltura, frameLargura);

        // Slot
        final int slotXstart = frameX + 20;
        final int slotYstart = frameY + 20;
        int slotX = slotXstart;
        int slotY = slotYstart;

        // Itens

        for (int i = 0; i < gp.jogador.getInventario().size(); i++) {

            if(gp.jogador.getInventario().get(i)==gp.jogador.getArmaAtual()){

                g2.setColor(new Color(240,190,90));
                g2.fillRoundRect(slotX, slotY, gp.getTamanhoBloco(), gp.getTamanhoBloco(), 10, 10);
            }

            g2.drawImage(gp.jogador.getInventario().get(i).getDown1(), slotX, slotY, null);

            slotX += gp.getTamanhoBloco();

            if (i == 4 || i == 9 || i == 14) {
                slotX = slotXstart;
                slotY += gp.getTamanhoBloco();
            }

        }


        // Cursor

        int cursorX = slotXstart + (gp.getTamanhoBloco() * slotCol);
        int cursorY = slotYstart + (gp.getTamanhoBloco() * slotLinha);
        int cursorAltura = gp.getTamanhoBloco();
        int cursorLargura = gp.getTamanhoBloco();

        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(cursorX, cursorY, cursorLargura, cursorAltura, 10, 10);

        // Tela descricao

        int dFrameX=frameX;
        int dFrameY=frameY + frameAltura;
        int dFrameLargura=frameLargura;
        int dFrameAltura=gp.getTamanhoBloco()*4;


        int textoX= dFrameX+20;
        int textoY=frameY+gp.getTamanhoBloco()+230;
        g2.setFont(Font03.deriveFont(25f));

        int itemIndice=pegarItemSlot();

        if (itemIndice < gp.jogador.getInventario().size()) {

            desenharJanela(dFrameX, dFrameY, dFrameAltura, dFrameLargura);

            for(String linha:gp.jogador.getInventario().get(itemIndice).getDescricao().split("\n")){
                g2.drawString(linha, textoX, textoY);
                textoY+=26;

            }


        }


    }

    public int pegarItemSlot(){

        int itemIndice= slotCol+(slotLinha*5);
        return itemIndice;
    }


    public void desenharVidaJogador() {
        int x = gp.getTamanhoBloco() / 2;
        int y = gp.getTamanhoBloco() / 2;
        int i = 0;

        // Desenhar as vidas vazias
        while (i < gp.jogador.getVidaMaxima() / 2) {
            g2.drawImage(vida_vazia, x, y, null);
            i++;
            x += gp.getTamanhoBloco();
        }

        // Desenhar a vida atual (metade e cheia)
        x = gp.getTamanhoBloco() / 2;  // Resetando o valor de x para a posição inicial
        y = gp.getTamanhoBloco() / 2;  // Resetando o valor de y para a posição inicial
        i = 0;

        while (i < gp.jogador.getVida()) {
            // Desenhar uma vida cheia
            g2.drawImage(vida_metade, x, y, null);
            i++;

            // Se for necessário desenhar a metade da vida
            if (i < gp.jogador.getVida()) {
                g2.drawImage(vida_cheia, x, y, null);

            }
            i++;
            x += gp.getTamanhoBloco();
        }

    }


    public void desenharTelaDialogo() {

        int x = gp.getTamanhoBloco() / 2;
        int y = gp.getTamanhoBloco() / 2;
        int altura = gp.getTamanhoBloco() * 8;
        int largura = gp.getTamanhoBloco() * 4;


        desenharJanela(x, y, largura, altura);

        g2.setFont(Font03.deriveFont(25f));
        x += gp.getTamanhoBloco() / 2;
        y += gp.getTamanhoBloco();

        for (String linha : getDialogoAtual().split("\n")) {
            g2.drawString(linha, x, y);
            y += 30; // Ajuste a distância entre as linhas
        }


    }

    public void desenharJanela(int x, int y, int altura, int largura) {
        {

            Color c = new Color(0, 0, 0, 200);
            g2.setColor(c);
            g2.fillRoundRect(x, y, largura, altura, 35, 35);


            c = new Color(255, 255, 255);
            g2.setColor(c);
            g2.setStroke(new BasicStroke(5));
            g2.drawRoundRect(x + 5, y + 5, largura - 10, altura - 10, 25, 25);
        }

    }


    private String historiaCompleta = "Num mundo devastado, onde a natureza resiste\n"
            + "e a tecnologia ruiu, poucos permanecem.\n"
            + "Você é parte dos últimos sobreviventes\n"
            + "em busca de um novo começo na Última Fronteira.\n\n"
            + "Escolha com sabedoria. Cada passo será decisivo.";

    private String textoAtual = "";  // Vai crescendo letra por letra
    private int contadorLetra = 0;
    private long ultimoTempo = 0;
    private long intervalo = 60; // milissegundos
    private boolean historiaCompletaExibida = false;
    float alpha = 0.0f;
    boolean fadeInAtivo = false;


    public void desenharTelaTitulo() {

        if (telaMenu == 0) {

            // Desenha o fundo na tela
            g2.drawImage(fundo2, 0, 0, gp.getTelaLargura(), gp.getTelaAltura(), null); // Ajusta a imagem de fundo à tela

            // Título
            g2.setColor(Color.BLACK);
            g2.setFont(Font05.deriveFont(70f));
            g2.drawString("ÚLTIMA FRONTEIRA", obterXCentralizarTexto("ÚLTIMA FRONTEIRA") + 4, 220 + 5);

            g2.setColor(Color.WHITE);
            g2.setFont(Font05.deriveFont(70f));
            g2.drawString("ÚLTIMA FRONTEIRA", obterXCentralizarTexto("ÚLTIMA FRONTEIRA"), 220);

            // Opções do menu
            g2.setFont(Font03.deriveFont(45f));
            g2.setColor(Color.WHITE);

            String[] opcoes = {"NOVO JOGO", "CARREGAR JOGO", "SAIR"};

            for (int i = 0; i < opcoes.length; i++) {
                int yTexto = gp.getTamanhoBloco() * (7 + i);
                String texto = opcoes[i];

                // Desenha o texto centralizado
                int xTexto = obterXCentralizarTexto(texto);
                g2.drawString(texto, xTexto, yTexto);
                desenharTextoSombra(texto, xTexto, yTexto);

                // Se essa é a opção selecionada, desenha a setinha
                if (comandoNum == i) {
                    g2.drawString(">", xTexto - gp.getTamanhoBloco(), yTexto);
                    desenharTextoSombra(">", xTexto - gp.getTamanhoBloco(), yTexto);
                    g2.setColor(Color.yellow);
                    g2.drawString(texto, xTexto, yTexto);
                    g2.drawString(">", xTexto - gp.getTamanhoBloco(), yTexto);
                }
            }
        } else if (telaMenu == 1) { // Tela da história do jogo

            g2.drawImage(fundoHistoria, 0, 0, gp.getTelaLargura(), gp.getTelaAltura(), null); // Fundo

            g2.setColor(Color.WHITE);
            g2.setFont(Font03.deriveFont(32f));

            String historia =
                    "Num mundo devastado, onde a natureza resiste\n" +
                            "e a tecnologia ruiu, poucos permanecem.\n" +
                            "Você é parte dos últimos sobreviventes\n" +
                            "em busca de um novo começo na Última Fronteira.\n\n" +
                            "Escolha com sabedoria. Cada passo será decisivo.";

            String[] linhas = historia.split("\n");
            int y = gp.getTamanhoBloco() * 4;

            long agora = System.currentTimeMillis();
            if (!historiaCompletaExibida && contadorLetra < historiaCompleta.length()) {
                if (agora - ultimoTempo >= intervalo) {
                    textoAtual += historiaCompleta.charAt(contadorLetra);
                    contadorLetra++;
                    ultimoTempo = agora;
                }
            }

            if (contadorLetra >= historiaCompleta.length()) {
                historiaCompletaExibida = true;
            }

            linhas = textoAtual.split("\n");
            y = gp.getTamanhoBloco() * 4;
            for (String linha : linhas) {
                int x = obterXCentralizarTexto(linha);
                g2.drawString(linha, x, y);
                desenharTextoSombra(linha, x, y);
                y += 40;
            }}else if (telaMenu == 2) {

            g2.drawImage(fundo2, 0, 0, gp.getTelaLargura(), gp.getTelaAltura(), null); // Ajusta a imagem de fundo à tela

            g2.setColor(Color.WHITE);
            g2.setFont(Font03.deriveFont(40f));

            String texto = "SELECIONE SEU PERSONAGEM:";
            int x = obterXCentralizarTexto(texto);
            int y = gp.getTamanhoBloco() * 3;
            g2.drawString(texto, x, y);
            desenharTextoSombra(texto, x, y);

            texto = "O RASTREADOR";
            x = obterXCentralizarTexto(texto);
            y += gp.getTamanhoBloco() * 2;
            g2.drawString(texto, x, y);
            desenharTextoSombra(texto, x, y);
            if (comandoNum == 0) {
                g2.drawString(">", x - gp.getTamanhoBloco(), y);
                desenharTextoSombra(">", x - gp.getTamanhoBloco(), y);
                g2.setColor(Color.yellow);
                g2.drawString(texto, x, y);
                g2.drawString(">", x - gp.getTamanhoBloco(), y);

            }

            texto = "O MÉDICO";
            x = obterXCentralizarTexto(texto);
            y += gp.getTamanhoBloco() * 1;
            g2.drawString(texto, x, y);
            desenharTextoSombra(texto, x, y);
            if (comandoNum == 1) {
                g2.drawString(">", x - gp.getTamanhoBloco(), y);
                desenharTextoSombra(">", x - gp.getTamanhoBloco(), y);
                g2.setColor(Color.yellow);
                g2.drawString(texto, x, y);
                g2.drawString(">", x - gp.getTamanhoBloco(), y);

            }

            texto = "A MECÂNICA";
            x = obterXCentralizarTexto(texto);
            y += gp.getTamanhoBloco() * 1;
            g2.drawString(texto, x, y);
            desenharTextoSombra(texto, x, y);
            if (comandoNum == 2) {
                g2.drawString(">", x - gp.getTamanhoBloco(), y);
                desenharTextoSombra(">", x - gp.getTamanhoBloco(), y);
                g2.setColor(Color.yellow);
                g2.drawString(texto, x, y);
                g2.drawString(">", x - gp.getTamanhoBloco(), y);
            }

            texto = "A SOBREVIVENTE";
            x = obterXCentralizarTexto(texto);
            y += gp.getTamanhoBloco() * 1;
            g2.drawString(texto, x, y);
            desenharTextoSombra(texto, x, y);
            if (comandoNum == 3) {
                g2.drawString(">", x - gp.getTamanhoBloco(), y);
                desenharTextoSombra(">", x - gp.getTamanhoBloco(), y);
                g2.setColor(Color.yellow);
                g2.drawString(texto, x, y);
                g2.drawString(">", x - gp.getTamanhoBloco(), y);
            }

            texto = "VOLTAR";
            x = obterXCentralizarTexto(texto);
            y += gp.getTamanhoBloco() * 2;
            g2.drawString(texto, x, y);
            desenharTextoSombra(texto, x, y);
            if (comandoNum == 4) {
                g2.drawString(">", x - gp.getTamanhoBloco(), y);
                desenharTextoSombra(">", x - gp.getTamanhoBloco(), y);
                g2.setColor(Color.yellow);
                g2.drawString(texto, x, y);
                g2.drawString(">", x - gp.getTamanhoBloco(), y);
            }


        } else if (telaMenu == 3) { // Tela de Descrição do Personagem

            g2.drawImage(fundo2, 0, 0, gp.getTelaLargura(), gp.getTelaAltura(), null); // Ajusta a imagem de fundo à tela


            // Definindo a cor e a fonte do texto
            g2.setColor(Color.WHITE);
            g2.setFont(Font03.deriveFont(35f)); // Ajuste de tamanho da fonte


            // Descrição e vantagens de cada personagem
            String descricao = "";
            String nome = "";
            if (personagemSelecionado.equals("O RASTREADOR")) {
                descricao = "Kael Thorn é um rastreador experiente, conhecido por seu instinto quase sobrenatural para encontrar comida e água em qualquer ambiente. Seus olhos atentos e seu faro aguçado o tornam essencial para qualquer expedição perigosa. Ágil, silencioso e resiliente, Kael aprendeu a ler os menores sinais da natureza para sobreviver onde poucos conseguiriam."
                ;
                nome = "O RASTREADOR";
                g2.drawImage(fundo2, 0, 0, gp.getTelaLargura(), gp.getTelaAltura(), null);
            } else if (personagemSelecionado.equals("O MÉDICO")) {
                descricao = "Lysander Curavita é um médico habilidoso, capaz de curar ferimentos com os recursos que a natureza oferece. Sua experiência o torna capaz de restaurar a saúde mesmo sem o uso de itens raros. Astuto e compassivo, ele transforma o comum em remédio, sendo uma fonte de esperança em tempos de necessidade.";
                nome = "O MÉDICO";
                g2.drawImage(fundo2, 0, 0, gp.getTelaLargura(), gp.getTelaAltura(), null); // Ajusta a imagem de fundo à tela
            } else if (personagemSelecionado.equals("A MECÂNICA")) {
                descricao = "Kaela Forjaterra é uma mecânica determinada, com o dom de reparar ferramentas danificadas e criar novas armas a partir do que tiver em mãos. Com poucas peças e muita engenhosidade, Kaela garante que os equipamentos estejam sempre prontos para o próximo desafio.";
                nome = "A MECÂNICA";
                g2.drawImage(fundo2, 0, 0, gp.getTelaLargura(), gp.getTelaAltura(), null); // Ajusta a imagem de fundo à tela
            } else if (personagemSelecionado.equals("A SOBREVIVENTE")) {
                descricao = "Elyra Sylvanis é uma elfa sobrevivente , cuja conexão com a natureza a torna menos vulnerável às necessidades de comida e água. Sua resistência a esses elementos lhe permite explorar os ambientes mais áridos e selvagens sem sofrer tanto com a escassez. Elyra navega pelos terrenos mais hostis com graça e eficácia, sempre atenta ao que o ambiente tem a oferecer.";
                nome = "A SOBREVIVENTE";
                g2.drawImage(fundo2, 0, 0, gp.getTelaLargura(), gp.getTelaAltura(), null); // Ajusta a imagem de fundo à tela
            }



            // Calcular a largura máxima para o texto (por exemplo, 80% da largura total)
            int larguraMaxima = (int) (gp.getTelaLargura() * 0.9);

            // Definir uma margem esquerda fixa (em vez de centralizar)
            int margemEsquerda = gp.getTamanhoBloco() * 1; // Por exemplo, 2 blocos da margem esquerda

            // Quebrar o texto em múltiplas linhas
            ArrayList<String> linhas = quebrarTexto(descricao, larguraMaxima);

            // Posicionamento inicial
            int y = (gp.getTamanhoBloco() * 5)-10; // Começando com um espaçamento confortável
            int espacoEntreLinhas = 25; // Ajuste conforme necessário

            // Desenhe cada linha centralizada
            for (String linha : linhas) {
                int x = obterXCentralizarTexto(linha);
                g2.drawString(linha, margemEsquerda, y);
                desenharTextoSombra(linha, margemEsquerda, y);

                y += espacoEntreLinhas;
            }

            g2.setColor(Color.white);
            g2.setFont(Font03.deriveFont(45f)); // Ajuste de tamanho da fonte
            int x = obterXCentralizarTexto(nome);
            y += gp.getTamanhoBloco(); // Espaço adicional antes das instruçõe

            g2.drawString(nome, x, 150);
            desenharTextoSombra(nome, x, 150);


            // Instruções para avançar
            g2.setColor(Color.WHITE);
            g2.setFont(Font03.deriveFont(25f)); // Ajuste de tamanho da fonte
            String instrucoes = "Pressione ENTER para confirmar ou ESC para voltar";
            x = obterXCentralizarTexto(instrucoes);
            y += gp.getTamanhoBloco(); // Espaço adicional antes das instruções

            // Desenhando as instruções
            g2.drawString(instrucoes, x, 500);
            desenharTextoSombra(instrucoes, x, 500);

        }

    }

    public void reiniciarEfeitoDigitacao() {
        textoAtual = "";
        contadorLetra = 0;
        ultimoTempo = 0;
        historiaCompletaExibida = false;
    }


    public void desenharTextoSombra(String texto, int x, int y) {
        // Cor da borda (preta)
        g2.setColor(Color.BLACK);
        // Desenha o texto deslocado em várias direções para criar o efeito de borda
        g2.drawString(texto, x +2, y +3);

        // Cor principal (branca)
        g2.setColor(Color.WHITE);
        g2.drawString(texto, x, y);
    }


    public void desenharTelaPausa() {

        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));

        // Desenha o fundo transparente
        g2.setColor(Color.BLACK);  // Cor do fundo (pode ser qualquer cor)
        g2.fillRect(0, 0, gp.getTelaLargura(), gp.getTelaAltura()); // Preenche a tela inteira com o fundo transparente

        // Restaura a opacidade para desenhar o texto com total visibilidade
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));  // Total opacidade


        g2.setColor(Color.WHITE);
        g2.setFont(Font05.deriveFont(40f));  // Defina sua fonte como Font03 ou substitua com a fonte desejada


        String texto = "JOGO PAUSADO";


        // Obter a posição X para centralizar
        int x = obterXCentralizarTexto(texto);

        // Obter a posição Y para centralizar verticalmente
        int y = gp.getTelaAltura() / 2 + g2.getFontMetrics().getHeight() / 4; // Ajuste o valor para um melhor alinhamento vertical

        // Desenha o texto
        g2.drawString(texto, x, y);
        desenharTextoSombra(texto, x, y);

    }

    public void exibirInformacoesDoMapa(Graphics2D g2, String titulo, String descricao, String atributos, String recursos, String eventos) {
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, gp.getTelaLargura(), gp.getTelaAltura());
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));

        g2.setColor(Color.WHITE);
        g2.setFont(Font05.deriveFont(35f));

        int x = obterXCentralizarTexto(titulo);
        int y = 90;
        g2.drawString(titulo, x, y);
        desenharTextoSombra(titulo, x, y);

        int larguraMaxima = (int) (gp.getTelaLargura() * 0.9);
        int margemEsquerda = gp.getTamanhoBloco();
        y = gp.getTelaAltura() - 380;
        int espacoEntreLinhas = 25;

        g2.setFont(Font03.deriveFont(25f));

        for (String linha : quebrarTexto(descricao, larguraMaxima)) {
            g2.drawString(linha, margemEsquerda, y);
            y += espacoEntreLinhas;
        }

        y += 20;
        for (String linha : quebrarTexto(atributos, larguraMaxima)) {
            g2.drawString(linha, margemEsquerda, y);
            y += espacoEntreLinhas;
        }

        y += 20;
        for (String linha : quebrarTexto(recursos, larguraMaxima)) {
            g2.drawString(linha, margemEsquerda, y);
            y += espacoEntreLinhas;
        }

        y += 20;
        for (String linha : quebrarTexto(eventos, larguraMaxima)) {
            g2.drawString(linha, margemEsquerda, y);
            y += espacoEntreLinhas;
        }
    }


    public void desenharTelaDescricao() {

        if(gp.getMapaAtual()==0){
            exibirInformacoesDoMapa(
                    g2,
                    "FLORESTA",
                    "Uma área rica em recursos naturais, mas também habitada por predadores.",
                    "Atributos adicionais: [Vegetação densa] [Fauna abundante] [Clima úmido]",
                    "Recursos disponíveis: [Frutas, raízes e cogumelos] [Madeira para fogueiras e ferramentas] [Pequenos animais para caça]",
                    "Eventos comuns: [Ataque de lobo] [Encontro com um explorador perdido] [Chuva intensa, dificultando a exploração]"
            );


        } else if(gp.getMapaAtual()==1){
            exibirInformacoesDoMapa(g2,
                    "LAGO E RIO",
                    "Regiões ricas em água, mas que podem esconder riscos como afogamento ou\n" +
                            "criaturas aquáticas.",
                    "Atributos adicionais: [Água abundante] [Possibilidade de pesca] [Terreno lamacento]",
                    "Recursos disponíveis: [Peixes e algas comestíveis] [Água doce] [Vegetação ribeirinha]",
                    "Eventos comuns: [Ataque de criatura aquática] [Tempestade] [Encontro de um barco abandonado]"
                    );

        } else if(gp.getMapaAtual()==2){
            exibirInformacoesDoMapa(g2,
                    "RUÍNAS ABANDONADAS",
                    "Restos de antigas construções que podem conter suprimentos valiosos ou armadilhas.",
                    "Atributos adicionais: [Estruturas instáveis] [Presença de outros sobreviventes] [Baixo risco climático]",
                    "Recursos disponíveis: [Ferramentas antigas e munição] [Alimentos enlatados ainda comestíveis] [Mapas e pistas sobre o ambiente ao redor]",
                    "Eventos comuns: [Encontrar um grupo de sobreviventes] [Armadilhas deixadas por antigos ocupantes] [Descoberta de uma passagem secreta para outra área]"
                    );
        } else if(gp.getMapaAtual()==3){
            exibirInformacoesDoMapa(g2,
                    "MONTANHA",
                    "Uma região de difícil acesso, mas rica em minérios e pedras preciosas.",
                    "Atributos adicionais: [Terreno acidentado] [Clima instável] [Baixa vegetação]",
                    "Recursos disponíveis: [Minérios e pedras preciosas] [Água de degelo] [Refúgios naturais em cavernas",
                    "Eventos comuns: [Nevasca repentina] [Deslizamento de pedras] [Descoberta de uma caverna segura]");
        } else if(gp.getMapaAtual()==4){
            exibirInformacoesDoMapa(g2,
                    "CAVERNA",
                    "Um ambiente subterrâneo que pode oferecer abrigo contra o clima, mas esconde\n" +
                            "perigos desconhecidos.",
                    "Atributos adicionais: [Pouca luz] [Presença de criaturas desconhecidas] [Água de gotejamento]",
                    "Recursos disponíveis: [Rochas e minérios raros] [Pequenos lagos subterrâneos] [Ossos e vestígios de exploradores antigos]",
                    "Eventos comuns: [Encontro com uma criatura hostil] [Descoberta de um túnel oculto] [Desmoronamento parcial]");
        }


    }


    public int obterXCentralizarTexto(String texto) {

        int comprimento = (int) g2.getFontMetrics().getStringBounds(texto, g2).getWidth();
        int x = gp.getTelaLargura() / 2 - comprimento / 2;
        return x;
    }


    public void desenharTextoComBorda(String texto, int x, int y) {
        // Cor da borda (preta)
        g2.setColor(Color.GRAY);
        // Desenha o texto deslocado em várias direções para criar o efeito de borda
        g2.drawString(texto, x - 1, y - 1);
        g2.drawString(texto, x + 1, y - 1);
        g2.drawString(texto, x - 1, y + 1);
        g2.drawString(texto, x + 1, y + 1);

        // Cor principal (branca)
        g2.setColor(Color.WHITE);
        g2.drawString(texto, x, y);
    }



}