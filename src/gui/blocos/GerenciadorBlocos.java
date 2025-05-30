package gui.blocos;

import gui.system.FerramentasUteis;
import gui.system.PainelJogo;
import ambientes.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// Classe responsável por carregar, gerenciar e desenhar os blocos no mundo do jogo

public class GerenciadorBlocos {

    private PainelJogo gp;
    private Blocos[] blocos;
    private int[][][] numBlocosMapa;
    private Map<Integer, Ambiente> ambientesMapeados = new HashMap<>();

    private Ambiente ambienteAtual;


    public GerenciadorBlocos(PainelJogo gp) {
        this.gp = gp;

        blocos = new Blocos[400];
        numBlocosMapa = new int[gp.getMapaMax()][gp.getColMundoMax()][gp.getLinhaMundoMax()];

        pegarImagemBloco();

        // Associa os mapas com seus respectivos ambientes
        ambientesMapeados.put(0, new AmbienteFloresta());
        ambientesMapeados.put(1, new AmbienteLagoRio());
        ambientesMapeados.put(2, new AmbienteMontanha());
        ambientesMapeados.put(3, new AmbienteRuinas());
        ambientesMapeados.put(4, new AmbienteCaverna());


        carregarMapa("/maps/floresta.txt", 0);
        carregarMapa("/maps/lagoErio.txt", 1);
        carregarMapa("/maps/montanha.txt", 2);
        carregarMapa("/maps/ruinas.txt", 3);
        carregarMapa("/maps/caverna.txt", 4);
    }


    // Métodos de acesso getters

    public int[][][] getNumBlocosMapa() {
        return numBlocosMapa;
    }
    public Blocos[] getBlocos() {
        return blocos;
    }

    public Ambiente getAmbienteAtual() {
        return ambienteAtual;
    }

    public void pegarImagemBloco(){ // Construtor que chama o método setup várias vezes passando o índice no vetor 'blocos', o nome da imagem e se o bloco tem colisão ou não


        setup(0, "000", false);
        setup(1, "001", true);
        setup(2, "002", true);
        setup(3, "003", true);
        setup(4, "004", true);
        setup(5, "005", true);
        setup(6, "006", true);
        setup(7, "007", true);
        setup(8, "008", true);
        setup(9, "009", true);
        setup(10, "010", true);
        setup(11, "011", true);
        setup(12, "012", true);
        setup(13, "013", true);
        setup(14, "014", true);
        setup(15, "015", true);
        setup(16, "016", true);
        setup(17, "017", true);
        setup(18, "018", true);
        setup(19, "019", true);
        setup(20, "020", true);
        setup(21, "021", true);
        setup(22, "022", true);
        setup(23, "023", true);
        setup(24, "024", true);
        setup(25, "025", true);
        setup(26, "026", true);
        setup(27, "027", true);
        setup(28, "028", true);
        setup(29, "029", true);
        setup(30, "030", true);
        setup(31, "031", true);
        setup(32, "032", true);
        setup(33, "033", true);
        setup(34, "034", true);
        setup(35, "035", false);
        setup(36, "036", false);
        setup(37, "037", false);
        setup(38, "038", true);
        setup(39, "039", true);
        setup(40, "040", true);
        setup(41, "041", true);
        setup(42, "042", false);
        setup(43, "043", false);
        setup(44, "044", false);
        setup(45, "045", false);
        setup(46, "046", false);
        setup(47, "047", false);
        setup(48, "048", false);
        setup(49, "049", false);
        setup(50, "050", false);
        setup(51, "051", true);
        setup(52, "052", true);
        setup(53, "053", true);
        setup(54, "054", true);
        setup(55, "055", true);
        setup(56, "056", true);
        setup(57, "057", true);
        setup(58, "058", true);
        setup(59, "059", true);
        setup(60, "060", true);
        setup(61, "061", true);
        setup(62, "062", true);
        setup(63, "063", true);
        setup(64, "064", true);
        setup(65, "065", true);
        setup(66, "066", true);
        setup(67, "067", true);
        setup(68, "068", true);
        setup(69, "069", true);
        setup(70, "070", true);
        setup(71, "071", false);
        setup(72, "072", false);
        setup(73, "073", false);
        setup(74, "074", false);
        setup(75, "075", false);
        setup(76, "076", false);
        setup(77, "077", false);
        setup(78, "078", false);
        setup(79, "079", false);
        setup(80, "080", false);
        setup(81, "081", false);
        setup(82, "082", false);
        setup(83, "083", false);
        setup(84, "084", false);
        setup(85, "085", false);
        setup(86, "086", false);
        setup(87, "087", false);
        setup(88, "088", false);
        setup(89, "089", false);
        setup(90, "090", false);
        setup(91, "091", false);
        setup(92, "092", false);
        setup(93, "093", false);
        setup(94, "094", true);
        setup(95, "095", true);
        setup(96, "096", true);
        setup(97, "097", true);
        setup(98, "098", true);
        setup(99, "099", true);
        setup(100, "100", true);
        setup(101, "101", true);
        setup(102, "102", true);
        setup(103, "103", false);
        setup(104, "104", false);
        setup(105, "105", true);
        setup(106, "106", true);
        setup(107, "107", true);
        setup(108, "108", false);
        setup(109, "109", false);
        setup(110, "110", false);
        setup(111, "111", false);
        setup(112, "112", false);
        setup(113, "113", false);
        setup(114, "114", false);
        setup(115, "115", false);
        setup(116, "116", false);
        setup(117, "117", true);
        setup(118, "118", true);
        setup(119, "119", true);
        setup(120, "120", true);
        setup(121, "121", true);
        setup(122, "122", true);
        setup(123, "123", true);
        setup(124, "124", false);
        setup(125, "125", false);
        setup(126, "126", false);
        setup(127, "127", false);
        setup(128, "128", false);
        setup(129, "129", false);
        setup(130, "130", false);
        setup(131, "131", false);
        setup(132, "132", false);
        setup(133, "133", false);
        setup(134, "134", false);
        setup(135, "135", false);
        setup(136, "136", false);
        setup(137, "137", false);
        setup(138, "138", false);
        setup(139, "139", false);
        setup(140, "140", false);
        setup(141, "141", false);
        setup(142, "142", false);
        setup(143, "143", false);
        setup(144, "144", false);
        setup(145, "145", false);
        setup(146, "146", false);
        setup(147, "147", false);
        setup(148, "148", false);
        setup(149, "149", false);
        setup(150, "150", false);
        setup(151, "151", false);
        setup(152, "152", false);
        setup(153, "153", false);
        setup(154, "154", false);
        setup(155, "155", false);
        setup(156, "156", false);
        setup(157, "157", false);
        setup(158, "158", false);
        setup(159, "159", false);
        setup(160, "160", false);
        setup(161, "161", false);
        setup(162, "162", false);
        setup(163, "163", false);
        setup(164, "164", false);
        setup(165, "165", false);
        setup(166, "166", false);
        setup(167, "167", false);
        setup(168, "168", false);
        setup(169, "169", false);
        setup(170, "170", false);
        setup(171, "171", false);
        setup(172, "172", false);
        setup(173, "173", false);
        setup(174, "174", false);
        setup(175, "175", false);
        setup(176, "176", false);
        setup(177, "177", false);
        setup(178, "178", false);
        setup(179, "179", false);
        setup(180, "180", false);
        setup(181, "181", false);
        setup(182, "182", false);
        setup(183, "183", false);
        setup(184, "184", false);
        setup(185, "185", false);
        setup(186, "186", false);
        setup(187, "187", false);
        setup(187, "187", false);
        setup(188, "188", false);
        setup(189, "189", false);
        setup(190, "190", false);
        setup(191, "191", false);
        setup(192, "192", false);
        setup(193, "193", false);
        setup(194, "194", false);
        setup(195, "195", false);
        setup(196, "196", false);
        setup(197, "197", false);
        setup(198, "198", false);
        setup(199, "199", false);
        setup(200, "200", false);
        setup(201, "201", false);
        setup(202, "202", false);
        setup(203, "203", false);
        setup(204, "204", false);
        setup(205, "205", false);
        setup(206, "206", false);
        setup(207, "207", false);
        setup(208, "208", false);
        setup(209, "209", false);
        setup(210, "210", false);
        setup(211, "211", false);
        setup(212, "212", false);
        setup(213, "213", false);
        setup(214, "214", false);
        setup(215, "215", false);
        setup(216, "216", false);
        setup(217, "217", false);
        setup(218, "218", false);
        setup(219, "219", false);
        setup(220, "220", false);
        setup(221, "221", false);
        setup(222, "222", false);
        setup(223, "223", false);
        setup(224, "224", false);
        setup(225, "225", false);
        setup(226, "226", false);
        setup(227, "227", false);
        setup(228, "228", false);
        setup(229, "229", false);
        setup(230, "230", false);
        setup(231, "231", false);
        setup(232, "232", false);
        setup(233, "233", false);
        setup(234, "234", false);
        setup(235, "235", false);
        setup(236, "236", false);
        setup(237, "237", false);
        setup(238, "238", false);
        setup(239, "239", false);
        setup(240, "240", false);
        setup(241, "241", false);
        setup(242, "242", false);
        setup(243, "243", false);
        setup(244, "244", false);
        setup(245, "245", false);
        setup(246, "246", false);
        setup(247, "247", false);
        setup(248, "248", false);
        setup(249, "249", false);
        setup(250, "250", false);
        setup(251, "251", false);
        setup(252, "252", false);
        setup(253, "253", false);
        setup(254, "254", false);
        setup(255, "255", false);
        setup(256, "256", false);
        setup(257, "257", false);
        setup(258, "258", false);
        setup(259, "259", false);
        setup(260, "260", false);
        setup(261, "261", false);
        setup(262, "262", false);
        setup(263, "263", false);
        setup(264, "264", false);
        setup(265, "265", false);
        setup(266, "266", false);
        setup(267, "267", false);
        setup(268, "268", false);
        setup(269, "269", false);
        setup(270, "270", false);
        setup(271, "271", false);
        setup(272, "272", false);
        setup(273, "273", false);
        setup(274, "274", false);
        setup(275, "275", false);
        setup(276, "276", false);
        setup(277, "277", false);
        setup(278, "278", false);
        setup(279, "279", false);
        setup(280, "280", false);
        setup(281, "281", false);
        setup(282, "282", false);
        setup(283, "283", false);
        setup(284, "284", false);
        setup(285, "285", false);
        setup(286, "286", false);
        setup(287, "287", false);
        setup(288, "288", false);
        setup(289, "289", false);
        setup(290, "290", false);
        setup(291, "291", false);
        setup(292, "292", false);
        setup(293, "293", false);
        setup(294, "294", false);
        setup(295, "295", false);
        setup(296, "296", false);
        setup(297, "297", false);
        setup(298, "298", false);
        setup(299, "299", false);
        setup(300, "300", false);



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
            if (is == null) {
                throw new IOException("Arquivo não encontrado: " + caminhoArquivo);
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int linha = 0;

            while (linha < gp.getLinhaMundoMax()) {
                String line = br.readLine();
                if (line == null) break;

                String[] numeros = line.split(" ");

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

            // Associa o ambiente atual ao mapa carregado
            ambienteAtual = ambientesMapeados.get(mapa);

        } catch (Exception e) {
            System.err.println("Erro ao carregar o mapa: " + e.getMessage());
            e.printStackTrace();
            return false;
        }

        return true;
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