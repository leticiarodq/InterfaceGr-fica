package gui.system;

import gui.entidades.Entidade;
import gui.objetos.*;
import personagens.Personagem;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class InterfaceUsuario {

    private PainelJogo gp;
    private Font Font05, Font03, Font06;
    private Graphics2D g2;

    private BufferedImage imagem, fundo1, fundo2, fundo3, fundo4, fundo5, vida_cheia, vida_vazia, vida_metade, sede_cheia, sede_vazia, sede_metade, fome_cheio, fome_metade, fome_vazio, sanidade_cheia, sanidade_metade, sanidade_vazia, energia_cheia, energia_metade, energia_vazia;

    private boolean jogoFinalizado = true;

    private int comandoNum = 0;
    private int telaMenu = 0;
    private int telaDesc = 0;
    private int slotCol = 0;
    private int slotLinha = 0;

    private String mensagem = "";
    private boolean mensagemOn = false;
    private int contadorMensagem = 0;

    private String personagemSelecionado;

    private String dialogoAtual = "";

    Personagem personagem;

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


    private String[] dialogos;
    private int indiceDialogo = 0;


    public InterfaceUsuario(PainelJogo gp) {
        this.gp = gp;

        try {
            InputStream is1 = getClass().getResourceAsStream("/font/font05.ttf");
            Font05 = Font.createFont(Font.TRUETYPE_FONT, is1).deriveFont(24f);

            InputStream is2 = getClass().getResourceAsStream("/font/font03.ttf");
            Font03 = Font.createFont(Font.TRUETYPE_FONT, is2).deriveFont(24f);

            InputStream is3 = getClass().getResourceAsStream("/font/font06.ttf");
            Font06 = Font.createFont(Font.TRUETYPE_FONT, is3).deriveFont(24f);


        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        try {
            imagem = ImageIO.read(getClass().getResourceAsStream("/objetos/escudo.png"));
            fundo1 = ImageIO.read(getClass().getResourceAsStream("/fundo/fundo.png"));
            fundo2 = ImageIO.read(getClass().getResourceAsStream("/fundo/fundo2.png"));
            fundo3 = ImageIO.read(getClass().getResourceAsStream("/fundo/fundo3.png"));
            fundo4 = ImageIO.read(getClass().getResourceAsStream("/fundo/fundo4.png"));
            fundo5 = ImageIO.read(getClass().getResourceAsStream("/fundo/fundo5.png"));

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

        }

        if (mensagemOn == true) {

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
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));

        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, gp.getTelaLargura(), gp.getTelaAltura());

        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));

        g2.setFont(Font05.deriveFont(60f));

        // Texto "VOCÊ MORREU!" com borda
        String texto = "VOCÊ MORREU!";
        int x = obterXCentralizarTexto(texto);
        int y = 200;

        g2.setColor(Color.BLACK);
        g2.drawString(texto, x + 4, y + 4);
        g2.setColor(Color.WHITE);
        g2.drawString(texto, x, y);

        // Texto "Tente novamente" com borda
        g2.setFont(Font05.deriveFont(40f));
        texto = "Tentar novamente";
        x = obterXCentralizarTexto(texto);
        y += gp.getTamanhoBloco() * 4;

        g2.setColor(Color.BLACK);
        g2.drawString(texto, x + 4, y + 4);
        if (comandoNum == 0) g2.drawString(">", x - 40 + 4, y + 4);

        g2.setColor(Color.WHITE);
        g2.drawString(texto, x, y);
        if (comandoNum == 0) g2.drawString(">", x - 40, y);

        // Texto "Sair" com borda
        texto = "Sair";
        x = obterXCentralizarTexto(texto);
        y += gp.getTamanhoBloco() * 1;

        g2.setColor(Color.BLACK);
        g2.drawString(texto, x + 4, y + 4);
        if (comandoNum == 1) g2.drawString(">", x - 40 + 4, y + 4);

        g2.setColor(Color.WHITE);
        g2.drawString(texto, x, y);
        if (comandoNum == 1) g2.drawString(">", x - 40, y);
    }


    public void desenharStatusPersonagem() {

        final int frameX = gp.getTamanhoBloco() * 2;
        final int frameY = gp.getTamanhoBloco();
        final int frameLargura = gp.getTamanhoBloco() * 5;
        final int frameAltura = gp.getTamanhoBloco() * 10;

        desenharJanela(frameX, frameY, frameAltura, frameLargura);

        g2.setColor(Color.white);
        g2.setFont(Font03.deriveFont(15f));

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

        int dFrameX = frameX;
        int dFrameY = frameY + frameAltura;
        int dFrameLargura = frameLargura;
        int dFrameAltura = gp.getTamanhoBloco() * 4;


        int textoX = dFrameX + 20;
        int textoY = frameY + gp.getTamanhoBloco() + 230;
        g2.setFont(Font03.deriveFont(13f));

        int itemIndice = pegarItemSlot();

        if (itemIndice < gp.jogador.getInventario().size()) {

            desenharJanela(dFrameX, dFrameY, dFrameAltura, dFrameLargura);

            for (String linha : gp.jogador.getInventario().get(itemIndice).getDescricao().split("\n")) {
                g2.drawString(linha, textoX, textoY);
                textoY += 26;

            }


        }


    }

    public int pegarItemSlot() {

        int itemIndice = slotCol + (slotLinha * 5);
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
    // Atributo para guardar a mensagem a ser exibida

    public void desenharTelaDialogo() {

        int x = gp.getTamanhoBloco() / 2;
        int y = gp.getTamanhoBloco() / 2;
        int altura = gp.getTamanhoBloco() * 8;
        int largura = gp.getTamanhoBloco() * 4;


        desenharJanela(x, y, largura, altura);

        g2.setFont(Font03.deriveFont(14f));
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


    public void desenharTelaTitulo() {

        if (telaMenu == 0) {
            // Desenha o fundo na tela
            g2.drawImage(fundo1, 0, 0, gp.getTelaLargura(), gp.getTelaAltura(), null); // Ajusta a imagem de fundo à tela

            //g2.setColor(new Color(0, 0, 0));
            //g2.fillRect(0, 0, gp.getTelaLargura(), gp.getTelaAltura());

            // Título
            g2.setColor(Color.GRAY);
            g2.setFont(Font05.deriveFont(70f));
            g2.drawString("ÚLTIMA FRONTEIRA", obterXCentralizarTexto("ÚLTIMA FRONTEIRA") + 3, 150 + 2);

            g2.setColor(Color.WHITE);
            g2.setFont(Font05.deriveFont(70f));
            g2.drawString("ÚLTIMA FRONTEIRA", obterXCentralizarTexto("ÚLTIMA FRONTEIRA"), 150);

            // Imagem centralizada
            int novaLargura = imagem.getWidth() * 2;
            int novaAltura = imagem.getHeight() * 2;

            int xImagem = gp.getTelaLargura() / 2 - novaLargura / 2;
            int yImagem = 190;

            //g2.drawImage(imagem, xImagem, yImagem, novaLargura, novaAltura, null);

            // Opções do menu
            g2.setFont(Font03.deriveFont(25f));
            g2.setColor(Color.WHITE);

            String[] opcoes = {"NOVO JOGO", "CARREGAR JOGO", "SAIR"};


            for (int i = 0; i < opcoes.length; i++) {
                int yTexto = gp.getTamanhoBloco() * (8 + i);
                String texto = opcoes[i];

                // Desenha o texto centralizado
                int xTexto = obterXCentralizarTexto(texto);
                g2.drawString(texto, xTexto, yTexto);
                desenharTextoComBorda(texto, xTexto, yTexto);

                // Se essa é a opção selecionada, desenha a setinha
                if (comandoNum == i) {
                    g2.drawString(">", xTexto - gp.getTamanhoBloco(), yTexto);
                    desenharTextoComBorda(">", xTexto - gp.getTamanhoBloco(), yTexto);
                    g2.setColor(Color.yellow);
                    g2.drawString(texto, xTexto, yTexto);
                    g2.drawString(">", xTexto - gp.getTamanhoBloco(), yTexto);
                }
            }
        } else if (telaMenu == 1) {

            //gp.telaMenuPersonagens.paintComponent(g2);

            //gp.telaMenuPersonagens.desenhar(g2);

            g2.drawImage(fundo1, 0, 0, gp.getTelaLargura(), gp.getTelaAltura(), null); // Ajusta a imagem de fundo à tela

            g2.setColor(Color.WHITE);
            g2.setFont(Font03.deriveFont(20f));

            String texto = "SELECIONE SEU PERSONAGEM:";
            int x = obterXCentralizarTexto(texto);
            int y = gp.getTamanhoBloco() * 3;
            g2.drawString(texto, x, y);
            desenharTextoComBorda(texto, x, y);

            texto = "O RASTREADOR";
            x = obterXCentralizarTexto(texto);
            y += gp.getTamanhoBloco() * 2;
            g2.drawString(texto, x, y);
            desenharTextoComBorda(texto, x, y);
            if (comandoNum == 0) {
                g2.drawString(">", x - gp.getTamanhoBloco(), y);
                desenharTextoComBorda(">", x - gp.getTamanhoBloco(), y);
                g2.setColor(Color.yellow);
                g2.drawString(texto, x, y);
                g2.drawString(">", x - gp.getTamanhoBloco(), y);

            }

            texto = "O MÉDICO";
            x = obterXCentralizarTexto(texto);
            y += gp.getTamanhoBloco() * 1;
            g2.drawString(texto, x, y);
            desenharTextoComBorda(texto, x, y);
            if (comandoNum == 1) {
                g2.drawString(">", x - gp.getTamanhoBloco(), y);
                desenharTextoComBorda(">", x - gp.getTamanhoBloco(), y);
                g2.setColor(Color.yellow);
                g2.drawString(texto, x, y);
                g2.drawString(">", x - gp.getTamanhoBloco(), y);

            }

            texto = "A MECÂNICA";
            x = obterXCentralizarTexto(texto);
            y += gp.getTamanhoBloco() * 1;
            g2.drawString(texto, x, y);
            desenharTextoComBorda(texto, x, y);
            if (comandoNum == 2) {
                g2.drawString(">", x - gp.getTamanhoBloco(), y);
                desenharTextoComBorda(">", x - gp.getTamanhoBloco(), y);
                g2.setColor(Color.yellow);
                g2.drawString(texto, x, y);
                g2.drawString(">", x - gp.getTamanhoBloco(), y);
            }

            texto = "A SOBREVIVENTE";
            x = obterXCentralizarTexto(texto);
            y += gp.getTamanhoBloco() * 1;
            g2.drawString(texto, x, y);
            desenharTextoComBorda(texto, x, y);
            if (comandoNum == 3) {
                g2.drawString(">", x - gp.getTamanhoBloco(), y);
                desenharTextoComBorda(">", x - gp.getTamanhoBloco(), y);
                g2.setColor(Color.yellow);
                g2.drawString(texto, x, y);
                g2.drawString(">", x - gp.getTamanhoBloco(), y);
            }

            texto = "VOLTAR";
            x = obterXCentralizarTexto(texto);
            y += gp.getTamanhoBloco() * 2;
            g2.drawString(texto, x, y);
            desenharTextoComBorda(texto, x, y);
            if (comandoNum == 4) {
                g2.drawString(">", x - gp.getTamanhoBloco(), y);
                desenharTextoComBorda(">", x - gp.getTamanhoBloco(), y);
                g2.setColor(Color.yellow);
                g2.drawString(texto, x, y);
                g2.drawString(">", x - gp.getTamanhoBloco(), y);
            }


        } else if (telaMenu == 2) { // Tela de Descrição do Personagem
            // Definindo o fundo
            //g2.setColor(Color.BLACK);
            //g2.fillRect(0, 0, gp.getTelaLargura(), gp.getTelaAltura());
            g2.drawImage(fundo1, 0, 0, gp.getTelaLargura(), gp.getTelaAltura(), null); // Ajusta a imagem de fundo à tela


            // Definindo a cor e a fonte do texto
            g2.setColor(Color.WHITE);
            g2.setFont(Font03.deriveFont(18f)); // Ajuste de tamanho da fonte

            // Descrição e vantagens de cada personagem
            String descricao = "";
            String nome = "";
            if (personagemSelecionado.equals("O RASTREADOR")) {
                descricao = "Kael Thorn é um rastreador experiente, conhecido por seu instinto quase sobrenatural para encontrar comida e água em qualquer ambiente. Seus olhos atentos e seu faro aguçado o tornam essencial para qualquer expedição perigosa. Ágil, silencioso e resiliente, Kael aprendeu a ler os menores sinais da natureza para sobreviver onde poucos conseguiriam."
                ;
                nome = "O RASTREADOR";
                g2.drawImage(fundo1, 0, 0, gp.getTelaLargura(), gp.getTelaAltura(), null);
            } else if (personagemSelecionado.equals("O MÉDICO")) {
                descricao = "Lysander Curavita é um médico habilidoso, capaz de curar ferimentos com os recursos que a natureza oferece. Sua experiência o torna capaz de restaurar a saúde mesmo sem o uso de itens raros. Astuto e compassivo, ele transforma o comum em remédio, sendo uma fonte de esperança em tempos de necessidade.";
                nome = "O MÉDICO";
                g2.drawImage(fundo1, 0, 0, gp.getTelaLargura(), gp.getTelaAltura(), null); // Ajusta a imagem de fundo à tela
            } else if (personagemSelecionado.equals("A MECÂNICA")) {
                descricao = "Kaela Forjaterra é uma mecânica determinada, com o dom de reparar ferramentas danificadas e criar novas armas a partir do que tiver em mãos. Com poucas peças e muita engenhosidade, Kaela garante que os equipamentos estejam sempre prontos para o próximo desafio.";
                nome = "A MECÂNICA";
                g2.drawImage(fundo1, 0, 0, gp.getTelaLargura(), gp.getTelaAltura(), null); // Ajusta a imagem de fundo à tela
            } else if (personagemSelecionado.equals("A SOBREVIVENTE")) {
                descricao = "Elyra Sylvanis é uma elfa sobrevivente , cuja conexão com a natureza a torna menos vulnerável às necessidades de comida e água. Sua resistência a esses elementos lhe permite explorar os ambientes mais áridos e selvagens sem sofrer tanto com a escassez. Elyra navega pelos terrenos mais hostis com graça e eficácia, sempre atenta ao que o ambiente tem a oferecer.";
                nome = "A SOBREVIVENTE";
                g2.drawImage(fundo1, 0, 0, gp.getTelaLargura(), gp.getTelaAltura(), null); // Ajusta a imagem de fundo à tela
            }

            // Calcular a largura máxima para o texto (por exemplo, 80% da largura total)
            int larguraMaxima = (int) (gp.getTelaLargura() * 0.8);

            // Definir uma margem esquerda fixa (em vez de centralizar)
            int margemEsquerda = gp.getTamanhoBloco() * 2; // Por exemplo, 2 blocos da margem esquerda

            // Quebrar o texto em múltiplas linhas
            ArrayList<String> linhas = quebrarTexto(descricao, larguraMaxima);

            // Posicionamento inicial
            int y = gp.getTamanhoBloco() * 4; // Começando com um espaçamento confortável
            int espacoEntreLinhas = 25; // Ajuste conforme necessário

            // Desenhe cada linha centralizada
            for (String linha : linhas) {
                int x = obterXCentralizarTexto(linha);
                g2.drawString(linha, margemEsquerda, y);
                desenharTextoComBorda(linha, margemEsquerda, y);

                y += espacoEntreLinhas;
            }

            g2.setColor(Color.white);
            g2.setFont(Font03.deriveFont(20f)); // Ajuste de tamanho da fonte
            int x = obterXCentralizarTexto(nome);
            y += gp.getTamanhoBloco(); // Espaço adicional antes das instruçõe

            g2.drawString(nome, x, 120);
            desenharTextoComBorda(nome, x, 120);


            // Instruções para avançar
            g2.setColor(Color.WHITE);
            g2.setFont(Font03.deriveFont(13f)); // Ajuste de tamanho da fonte
            String instrucoes = "Pressione ENTER para confirmar ou ESC para voltar";
            x = obterXCentralizarTexto(instrucoes);
            y += gp.getTamanhoBloco(); // Espaço adicional antes das instruções

            // Desenhando as instruções
            g2.drawString(instrucoes, x, 500);
            desenharTextoComBorda(instrucoes, x, 500);

        }
    }

    public void desenharTelaPausa() {

        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));

        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, gp.getTelaLargura(), gp.getTelaAltura());

        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));

        g2.setFont(Font05.deriveFont(60f));

        // Texto "VOCÊ MORREU!" com borda
        String texto = "JOGO PAUSADO";
        int x = obterXCentralizarTexto(texto);
        int y = 150;

        g2.setColor(Color.BLACK);
        g2.drawString(texto, x + 4, y + 4);
        g2.setColor(Color.WHITE);
        g2.drawString(texto, x, y);

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


    public void desenharTextoComBordaPreta(String texto, int x, int y) {
        // Cor da borda (preta)
        g2.setColor(Color.BLACK);
        // Desenha o texto deslocado em várias direções para criar o efeito de borda
        g2.drawString(texto, x - 2, y - 2);
        g2.drawString(texto, x + 2, y - 2);
        g2.drawString(texto, x - 2, y + 2);
        g2.drawString(texto, x + 2, y + 2);

        // Cor principal (branca)
        g2.setColor(Color.WHITE);
        g2.drawString(texto, x, y);
    }


    public void mostrarMensagem(String texto) {

        mensagem = texto;
        mensagemOn = true;

    }




}