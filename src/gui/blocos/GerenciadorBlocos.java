package gui.blocos;

import gui.system.FerramentasUteis;
import gui.system.PainelJogo;
import personagens.Personagem;
import ambientes.*;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;



// Classe responsável por carregar, gerenciar e desenhar os blocos no mundo do jogo

public class GerenciadorBlocos {

    private PainelJogo gp; // referência ao painel principal de jogo, para acessar os dados do painel
    private Blocos[] blocos; // vetor que armazena todos os tipos diferentes de blocos
    private int numBlocosMapa[][][]; // uma matriz que representa o mapa inteiro, cada valor nela é um índice do vetor blocos
    Personagem personagem;


    // Métodos de acesso getters

    public int[][][] getNumBlocosMapa() {
        return numBlocosMapa;
    }
    public Blocos[] getBlocos() {
        return blocos;
    }

    public GerenciadorBlocos(PainelJogo gp){ //Construtor

        this.gp=gp; //O this se refere ao atributo da instância da classe e não ao parâmetro do método

        blocos = new Blocos[200]; //Quantidade dos tipos de bloco

        numBlocosMapa= new int[gp.getMapaMax()][gp.getColMundoMax()][gp.getLinhaMundoMax()];

        pegarImagemBloco(); //Chamando o método no construtor
        carregarMapa("/maps/floresta.txt",0);
        carregarMapa("/maps/ruinas.txt",1);
    }


    public void pegarImagemBloco(){ // Construtor que chama o método setup várias vezes passando o índice no vetor 'blocos', o nome da imagem e se o bloco tem colisão ou não


        // Floresta
        setup(0,"grass00", false);


        setup(1,"arvore01", true);
        setup(2,"arvore02", true);
        setup(3,"arvore03", true);
        setup(4,"arvore04", true);
        setup(5,"arvore05", true);
        setup(6,"arvore06", true);


        setup(7,"arvores01", true);
        setup(8,"arvores02", true);
        setup(9,"arvores03", true);
        setup(10,"arvores04", true);
        setup(11,"arvores05", true);
        setup(12,"arvores06", true);
        setup(13,"arvores07", true);
        setup(14,"arvores08", true);
        setup(15,"arvores09", true);
        setup(16,"arvores10", true);
        setup(17,"arvores11", true);
        setup(18,"arvores12", true);
        setup(19,"arvores13", true);
        setup(20,"arvores14", true);
        setup(21,"arvores15", true);

        setup(22,"casa01", true);
        setup(23,"casa02", true);
        setup(24,"casa03", true);
        setup(25,"casa04", true);
        setup(26,"casa05", true);
        setup(27,"casa06", true);
        setup(28,"casa07", true);
        setup(29,"casa08", true);
        setup(30,"casa09", true);
        setup(31,"casa10", true);
        setup(32,"casa11", true);
        setup(33,"casa12", true);
        setup(34,"casa13", true);
        setup(35,"casa14", false);
        setup(36,"casa15", false);

        setup(37,"cogumelo_venenoso_01", true);
        setup(38,"cogumelo_venenoso_02", true);
        setup(39,"cogumelo_benigno_01", true);
        setup(40, "raiz_venenosa_01", true);
        //setup(41, "raiz_venenosa_02", true);

        setup(42, "lago_01", true);
        setup(43, "lago_02", true);
        setup(44, "lago_03", true);
        setup(45, "lago_04", true);
        setup(46, "lago_agua_05", true);
        setup(47, "lago_06", true);
        setup(48, "lago_07", true);
        setup(49, "lago_08", true);
        setup(50, "lago_09", true);

        setup(51, "lago_contaminado_01", true);
        setup(52, "lago_contaminado_02", true);
        setup(53, "lago_contaminado_03", true);
        setup(54, "lago_contaminado_04", true);
        setup(55, "lago_contaminado_agua_05", true);
        setup(56, "lago_contaminado_06", true);
        setup(57, "lago_contaminado_07", true);
        setup(58, "lago_contaminado_08", true);
        setup(59, "lago_contaminado_09", true);

        setup(60, "terra_01", false);
        setup(61, "terra_02", false);
        setup(62, "terra_03", false);
        setup(63, "terra_04", false);
        setup(64, "terra_05", false);
        setup(65, "terra_06", false);
        setup(66, "terra_07", false);
        setup(67, "terra_08", false);
        setup(68, "terra_09", false);

        setup(69, "placa", true);

        // Ruínas

        setup(70, "ruinas01", true);
        setup(71, "ruinas02", true);
        setup(72, "ruinas03", true);
        setup(73, "ruinas04", true);
        setup(74, "ruinas05", true);
        setup(75, "ruinas06", true);
        setup(76, "ruinas07", true);
        setup(77, "ruinas08", true);
        setup(78, "ruinas09", true);


        // ilha
        setup(100, "ilha01", false);
        setup(101,"ilha02", false);
        setup(102,"ilha03", false);




    }

    public void setup(int indice, String nomeImagem, boolean colisao) {

        FerramentasUteis ferramentasUteis = new FerramentasUteis();

        try {
            blocos[indice] = new Blocos();

            BufferedImage imagem = ImageIO.read(getClass().getResourceAsStream("/tiles/" + nomeImagem + ".png"));
            imagem = ferramentasUteis.escalar(imagem, gp.getTamanhoBloco(), gp.getTamanhoBloco());



            blocos[indice].setImagem(imagem);
            blocos[indice].setColisao(colisao);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public boolean carregarMapa(String caminhoArquivo, int mapa) {
        try {
            InputStream is = getClass().getResourceAsStream(caminhoArquivo);

            // Verifique se o arquivo foi carregado corretamente
            if (is == null) {
                throw new IOException("Arquivo não encontrado: " + caminhoArquivo);
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int linha = 0;

            while (linha < gp.getLinhaMundoMax()) {
                String line = br.readLine();
                if (line == null) break; // Evita NullPointerException

                String[] numeros = line.split(" ");

                // Verifica se o número de colunas é consistente
                if (numeros.length != gp.getColMundoMax()) {
                    throw new IOException("Número incorreto de colunas na linha " + (linha + 1));
                }

                for (int coluna = 0; coluna < gp.getColMundoMax(); coluna++) {
                    int num = Integer.parseInt(numeros[coluna]);
                    numBlocosMapa[mapa][coluna][linha] = num;
                }
                linha++;
            }

            br.close();

        } catch (Exception e) {
            // Exibe uma mensagem detalhada sobre a exceção
            System.err.println("Erro ao carregar o mapa: " + e.getMessage());
            e.printStackTrace(); // Imprime o erro para depuração
            return false; // Retorna false em caso de erro
        }

        if (mapa == 0) {
            System.out.println("Floresta");
        }

        return true; // Retorna true se o mapa for carregado com sucesso
    }




    public void draw(Graphics2D g2) { // desenha os blocos na tela, baseando-se na posição do jogador

        int mundoCol=0; // representa a coluna atual no mundo
        int mundoLinha=0; // representa a linha atual no mundo

        // percorre cada coluna e linha do mundo (ou seja, cada bloco do mapa).
        while(mundoCol<gp.getColMundoMax() && mundoLinha<gp.getLinhaMundoMax()){

            int numBloco= numBlocosMapa[gp.getMapaAtual()][mundoCol][mundoLinha]; // número que representa o tipo do bloco naquela posição

            // posição exata desse bloco no mundo, calculado multiplicando a posição na matriz pelo tamanho de cada bloco
            int mundoX= mundoCol * gp.getTamanhoBloco();
            int mundoY= mundoLinha * gp.getTamanhoBloco();

            // posição do bloco na tela, ou seja, onde ele deve ser desenhado em relação ao jogador
            int telaX = mundoX - gp.jogador.getMundoX() + gp.jogador.getTelaX();
            int telaY= mundoY - gp.jogador.getMundoY() + gp.jogador.getTelaY();
            // gp.jogador.getMundoX() e getMundoY() são a posição do jogador no mundo
            // gp.jogador.getTelaX() e getTelaY() são a posição do jogador fixa na tela

            // Parar de mover câmera no final
            if(gp.jogador.getTelaX()>gp.jogador.getMundoX()){
                telaX = mundoX;
            }
            if(gp.jogador.getTelaY()>gp.jogador.getMundoY()){
                telaY = mundoY;
            }

            // calcula o espaço da tela do lado direito do jogador
            int deslocamentoDireito=gp.getTelaLargura()-gp.jogador.getTelaX();
            if(deslocamentoDireito>gp.getMundoLargura()-gp.jogador.getMundoX()){
                telaX = gp.getTelaLargura()-(gp.getMundoLargura()-mundoX);
            }
            int deslocamentoInferior=gp.getTelaAltura()-gp.jogador.getTelaY();
            if(deslocamentoInferior>gp.getMundoAltura()-gp.jogador.getMundoY()){
                telaY = gp.getTelaAltura()-(gp.getMundoAltura()-mundoY);
            }

            // verifica se o bloco está dentro da área visível na tela.

            if (mundoX + gp.getTamanhoBloco() >gp.jogador.getMundoX() - gp.jogador.getTelaX() &&
                    mundoX - gp.getTamanhoBloco() < gp.jogador.getMundoX() + gp.jogador.getTelaX() &&
                    mundoY + gp.getTamanhoBloco() > gp.jogador.getMundoY() - gp.jogador.getTelaY()  &&
                    mundoY - gp.getTamanhoBloco() < gp.jogador.getMundoY() + gp.jogador.getTelaY() ) {

                g2.drawImage(blocos[numBloco].getImagem(), telaX, telaY, null); //add gp.tileSize
            }
            else if(gp.jogador.getTelaX()>gp.jogador.getMundoX() || gp.jogador.getTelaY() > gp.jogador.getMundoY() || deslocamentoDireito>gp.getMundoLargura()-gp.jogador.getMundoX() || deslocamentoInferior>gp.getMundoAltura()-gp.jogador.getMundoY()){
                g2.drawImage(blocos[numBloco].getImagem(), telaX, telaY, null);
            }

            // após desenhar uma coluna inteira, vai para a próxima linha, como em uma matriz
            mundoCol++;

            if (mundoCol == gp.getColMundoMax()) {
                mundoCol = 0;
                mundoLinha++;

            }

        }
    }
}