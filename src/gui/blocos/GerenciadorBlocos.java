package gui.blocos;

import ambientes.*;
import gui.system.FerramentasUteis;
import gui.system.PainelJogo;

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
        ambientesMapeados.put(5, new AmbienteInterior());


        carregarMapa("/maps/floresta.txt", 0);
        carregarMapa("/maps/lagoErio.txt", 1);
        carregarMapa("/maps/ruinas.txt", 2);
        carregarMapa("/maps/montanha.txt", 3);
        carregarMapa("/maps/caverna.txt", 4);
        carregarMapa("/maps/interior_feiticeira.txt",5);
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
        setup(124, "124", true);
        setup(125, "125", true);
        setup(126, "126", true);
        setup(127, "127", true);
        setup(128, "128", true);
        setup(129, "129", true);
        setup(130, "130", true);
        setup(131, "131", true);
        setup(132, "132", true);
        setup(133, "133", true);
        setup(134, "134", false);
        setup(135, "135", false);
        setup(136, "136", true);
        setup(137, "137", true);
        setup(138, "138", true);
        setup(139, "139", true);
        setup(140, "140", true);
        setup(141, "141", true);
        setup(142, "142", true);
        setup(143, "143", true);
        setup(144, "144", true);
        setup(145, "145", true);
        setup(146, "146", true);
        setup(147, "147", true);
        setup(148, "148", true);
        setup(149, "149", true);
        setup(150, "150", true);
        setup(151, "151", false);
        setup(152, "152", true);
        setup(153, "153", true);
        setup(154, "154", true);
        setup(155, "155", true);
        setup(156, "156", true);
        setup(157, "157", true);
        setup(158, "158", true);
        setup(159, "159", true);
        setup(160, "160", true);
        setup(161, "161", true);
        setup(162, "162", true);

        setup(163, "163", false);
        setup(164, "164", true);
        setup(165, "165", true);
        setup(166, "166", true);
        setup(167, "167", true);
        setup(168, "168", true);
        setup(169, "169", true);
        setup(170, "170", true);
        setup(171, "171", true);
        setup(172, "172", true);
        setup(173, "173", true);
        setup(174, "174", true);
        setup(175, "175", true);
        setup(176, "176", true);
        setup(177, "177", true);
        setup(178, "178", true);
        setup(179, "179", true);
        setup(180, "180", true);
        setup(181, "181", true);
        setup(182, "182", true);
        setup(183, "183", true);
        setup(184, "184", true);
        setup(185, "185", true);
        setup(186, "186", true);
        setup(187, "187", true);
        setup(187, "187", true);

        setup(188, "188", true);
        setup(189, "189", false);
        setup(190, "190", true);
        setup(191, "191", true);
        setup(192, "192", true);
        setup(193, "193", true);
        setup(194, "194", true);
        setup(195, "195", true);
        setup(196, "196", true);
        setup(197, "197", true);
        setup(198, "198", true);
        setup(199, "199", true);
        setup(200, "200", true);
        setup(201, "201", true);
        setup(202, "202", true);
        setup(203, "203", true);
        setup(204, "204", true);
        setup(205, "205", true);
        setup(206, "206", true);
        setup(207, "207", true);
        setup(208, "208", true);
        setup(209, "209", false);
        setup(210, "210", false);
        setup(211, "211", false);
        setup(212, "212", false);
        setup(213, "213", true);
        setup(214, "214", true);
        setup(215, "215", true);
        setup(216, "216", true);
        setup(217, "217", true);
        setup(218, "218", true);
        setup(219, "219", true);
        setup(220, "220", true);
        setup(221, "221", true);
        setup(222, "222", true);
        setup(223, "223", false);
        setup(224, "224", true);
        setup(225, "225", true);
        setup(226, "226", true);
        setup(227, "227", true);
        setup(228, "228", true);
        setup(229, "229", true);
        setup(230, "230", true);
        setup(231, "231", true);
        setup(232, "232", true);
        setup(233, "233", true);
        setup(234, "234", true);
        setup(235, "235", true);
        setup(236, "236", true);
        setup(237, "237", true);
        setup(238, "238", true);
        setup(239, "239", true);
        setup(240, "240", true);
        setup(241, "241", true);
        setup(242, "242", true);
        setup(243, "243", true);
        setup(244, "244", true);
        setup(245, "245", true);
        setup(246, "246", true);
        setup(247, "247", true);
        setup(248, "248", true);
        setup(249, "249", true);
        setup(250, "250", true);
        setup(251, "251", true);
        setup(252, "252", true);
        setup(253, "253", true);
        setup(254, "254", true);
        setup(255, "255", true);
        setup(256, "256", true);
        setup(257, "257", true);
        setup(258, "258", true);
        setup(259, "259", true);
        setup(260, "260", true);
        setup(261, "261", true);
        setup(262, "262", true);
        setup(263, "263", true);
        setup(264, "264", true);
        setup(265, "265", true);
        setup(266, "266", true);
        setup(267, "267", true);
        setup(268, "268", true);
        setup(269, "269", true);
        setup(270, "270", true);
        setup(271, "271", true);
        setup(272, "272", true);
        setup(273, "273", true);
        setup(274, "274", true);
        setup(275, "275", true);
        setup(276, "276", true);
        setup(277, "277", true);
        setup(278, "278", true);
        setup(279, "279", true);

        setup(280, "280", true);
        setup(281, "281", true);
        setup(282, "282", true);

        setup(283, "283", false);
        setup(284, "284", true);
        setup(285, "285", true);
        setup(286, "286", true);
        setup(287, "287", true);
        setup(288, "288", true);
        setup(289, "289", true);
        setup(290, "290", true);
        setup(291, "291", true);
        setup(292, "292", true);
        setup(293, "293", true);
        setup(294, "294", true);
        setup(295, "295", true);
        setup(296, "296", true);
        setup(297, "297", true);
        setup(298, "298", true);
        setup(299, "299", true);
        setup(300, "300", true);
        setup(301, "301", true);
        setup(302, "302", true);
        setup(303, "303", true);
        setup(304, "304", true);
        setup(305, "305", true);
        setup(306, "306", true);
        setup(307, "307", true);
        setup(308, "308", true);
        setup(309, "309", true);
        setup(310, "310", true);
        setup(311, "311", true);
        setup(312, "312", false);
        setup(313, "313", false);
        setup(314, "314", false);
        setup(315, "315", false);
        setup(316, "316", false);
        setup(317, "317", false);
        setup(318, "318", false);
        setup(319, "319", false);
        setup(320, "320", false);
        setup(321, "321", false);
        setup(322, "322", false);
        setup(323, "323", false);
        setup(324, "324", false);
        setup(325, "325", false);
        setup(326, "326", false);
        setup(327, "327", false);
        setup(328, "328", false);
        setup(329, "329", true);
        setup(330, "330", true);
        setup(331, "331", true);
        setup(332, "332", true);
        setup(333, "333", true);
        setup(334, "334", true);
        setup(335, "335", true);
        setup(336, "336", true);
        setup(337, "337", true);
        setup(338, "338", false);
        setup(339, "339", true);
        setup(340, "340", true);
        setup(341, "341", true);
        setup(342, "342", true);
        setup(343, "343", true);
        setup(344, "344", true);
        setup(345, "345", true);
        setup(346, "346", true);
        setup(347, "347", true);
        setup(348, "348", true);
        setup(349, "349", true);
        setup(350, "350", true);
        setup(351, "351", true);
        setup(352, "352", true);
        setup(353, "353", true);
        setup(354, "354", true);
        setup(355, "355", true);
        setup(356, "356", true);
        setup(357, "357", true);
        setup(358, "358", true);
        setup(359, "359", true);
        setup(360, "360", true);
        setup(361, "361", true);
        setup(362, "362", true);
        setup(363, "363", true);
        setup(364, "364", false);
        setup(365, "365", true);
        setup(366, "366", true);
        setup(367, "367", true);
        setup(368, "368", true);
        setup(369, "369", true);
        setup(370, "370", true);
        setup(371, "371", true);
        setup(372, "372", true);
        setup(373, "373", true);
        setup(374, "374", true);

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