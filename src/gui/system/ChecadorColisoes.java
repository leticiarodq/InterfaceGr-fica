package gui.system;

import gui.criaturas.Aquatico;
import gui.entidades.Entidade;

public class ChecadorColisoes {

    private PainelJogo gp; // armazena a referência ao painel principal do jogo, onde estão os blocos, objetos e entidades.

    // Recebe a referência ao PainelJogo para acessar dados do mapa, objetos e jogador
    public ChecadorColisoes(PainelJogo gp) {
        this.gp = gp;
    }

    // Responsável por verificar se a entidade colidiu com blocos do mapa
    public void checarBloco(Entidade entidade) {

        // Calcula onde a área sólida da entidade está no mundo, isso é usado para saber com qual bloco ela está colidindo
        int personagemMundoXesquerda = entidade.getMundoX() + entidade.getAreaSolida().x;
        int personagemMundoXdireita = entidade.getMundoX() + entidade.getAreaSolida().x + entidade.getAreaSolida().width;
        int personagemMundoYcima = entidade.getMundoY() + entidade.getAreaSolida().y;
        int personagemMundoYbaixo = entidade.getMundoY() + entidade.getAreaSolida().y + entidade.getAreaSolida().height;

        // Divide as coordenadas por tamanho do bloco para obter a posição no mapa de blocos
        int personagemColunaEsquerda = personagemMundoXesquerda / gp.getTamanhoBloco();
        int personagemColunaDireita = personagemMundoXdireita / gp.getTamanhoBloco();
        int personagemLinhaCima = personagemMundoYcima / gp.getTamanhoBloco();
        int personagemLinhaBaixo = personagemMundoYbaixo / gp.getTamanhoBloco();

        // Corrige para não sair da matriz
        int numColunas = gp.getBlocosG().getNumBlocosMapa()[gp.getMapaAtual()].length;
        int numLinhas = gp.getBlocosG().getNumBlocosMapa()[gp.getMapaAtual()][0].length;

        personagemColunaEsquerda = Math.max(0, Math.min(personagemColunaEsquerda, numColunas - 1));
        personagemColunaDireita = Math.max(0, Math.min(personagemColunaDireita, numColunas - 1));
        personagemLinhaCima = Math.max(0, Math.min(personagemLinhaCima, numLinhas - 1));
        personagemLinhaBaixo = Math.max(0, Math.min(personagemLinhaBaixo, numLinhas - 1));

        int blocoNum1 = 0;
        int blocoNum2 = 0;

        if (personagemColunaEsquerda >= 0 && personagemColunaEsquerda < numColunas &&
                personagemLinhaCima >= 0 && personagemLinhaCima < numLinhas) {
            blocoNum1 = gp.getBlocosG().getNumBlocosMapa()[gp.getMapaAtual()][personagemColunaEsquerda][personagemLinhaCima];
        }

        switch (entidade.getDirecao()) {
            case "up":
                personagemLinhaCima = (personagemMundoYcima - entidade.getVelocidade()) / gp.getTamanhoBloco();
                personagemLinhaCima = Math.max(0, Math.min(personagemLinhaCima, numLinhas - 1));

                if (personagemColunaEsquerda >= 0 && personagemColunaEsquerda < numColunas &&
                        personagemColunaDireita >= 0 && personagemColunaDireita < numColunas &&
                        personagemLinhaCima >= 0 && personagemLinhaCima < numLinhas) {

                    blocoNum1 = gp.getBlocosG().getNumBlocosMapa()[gp.getMapaAtual()][personagemColunaEsquerda][personagemLinhaCima];
                    blocoNum2 = gp.getBlocosG().getNumBlocosMapa()[gp.getMapaAtual()][personagemColunaDireita][personagemLinhaCima];

                    if (blocoNum1 >= 0 && blocoNum1 < gp.getBlocosG().getBlocos().length &&
                            blocoNum2 >= 0 && blocoNum2 < gp.getBlocosG().getBlocos().length) {

                        // Verifica se é peixe e se pode atravessar esses tiles
                        boolean peixePodePassar = false;
                        if (entidade instanceof Aquatico) {
                            Aquatico aquatica = (Aquatico) entidade;
                            peixePodePassar = aquatica.podeAtravessar(blocoNum1) && aquatica.podeAtravessar(blocoNum2);
                        }
// Se não é peixe OU peixe não pode passar, então verifica colisão normal
                        if (!peixePodePassar) {
                            if (gp.getBlocosG().getBlocos()[blocoNum1].isColisao() || gp.getBlocosG().getBlocos()[blocoNum2].isColisao()) {
                                entidade.setColisaoOn(true);
                            }
                        }
                    }
                }
                break;

            case "down":
                personagemLinhaBaixo = (personagemMundoYbaixo + entidade.getVelocidade()) / gp.getTamanhoBloco();
                personagemLinhaBaixo = Math.max(0, Math.min(personagemLinhaBaixo, numLinhas - 1));

                if (personagemColunaEsquerda >= 0 && personagemColunaEsquerda < numColunas &&
                        personagemColunaDireita >= 0 && personagemColunaDireita < numColunas &&
                        personagemLinhaBaixo >= 0 && personagemLinhaBaixo < numLinhas) {

                    blocoNum1 = gp.getBlocosG().getNumBlocosMapa()[gp.getMapaAtual()][personagemColunaEsquerda][personagemLinhaBaixo];
                    blocoNum2 = gp.getBlocosG().getNumBlocosMapa()[gp.getMapaAtual()][personagemColunaDireita][personagemLinhaBaixo];

                    if (blocoNum1 >= 0 && blocoNum1 < gp.getBlocosG().getBlocos().length &&
                            blocoNum2 >= 0 && blocoNum2 < gp.getBlocosG().getBlocos().length) {

                        boolean peixePodePassar = false;
                        if (entidade instanceof Aquatico) {
                            Aquatico aquatica = (Aquatico) entidade;
                            peixePodePassar = aquatica.podeAtravessar(blocoNum1) && aquatica.podeAtravessar(blocoNum2);
                        }

                        if (!peixePodePassar) {
                            if (gp.getBlocosG().getBlocos()[blocoNum1].isColisao() || gp.getBlocosG().getBlocos()[blocoNum2].isColisao()) {
                                entidade.setColisaoOn(true);
                            }
                        }
                    }
                }
                break;

            case "right":
                personagemColunaDireita = (personagemMundoXdireita + entidade.getVelocidade()) / gp.getTamanhoBloco();
                personagemColunaDireita = Math.max(0, Math.min(personagemColunaDireita, numColunas - 1));

                if (personagemColunaDireita >= 0 && personagemColunaDireita < numColunas &&
                        personagemLinhaCima >= 0 && personagemLinhaCima < numLinhas &&
                        personagemLinhaBaixo >= 0 && personagemLinhaBaixo < numLinhas) {

                    blocoNum1 = gp.getBlocosG().getNumBlocosMapa()[gp.getMapaAtual()][personagemColunaDireita][personagemLinhaCima];
                    blocoNum2 = gp.getBlocosG().getNumBlocosMapa()[gp.getMapaAtual()][personagemColunaDireita][personagemLinhaBaixo];

                    if (blocoNum1 >= 0 && blocoNum1 < gp.getBlocosG().getBlocos().length &&
                            blocoNum2 >= 0 && blocoNum2 < gp.getBlocosG().getBlocos().length) {

                        boolean peixePodePassar = false;
                        if (entidade instanceof Aquatico) {
                            Aquatico aquatica = (Aquatico) entidade;
                            peixePodePassar = aquatica.podeAtravessar(blocoNum1) && aquatica.podeAtravessar(blocoNum2);
                        }

                        if (!peixePodePassar) {
                            if (gp.getBlocosG().getBlocos()[blocoNum1].isColisao() || gp.getBlocosG().getBlocos()[blocoNum2].isColisao()) {
                                entidade.setColisaoOn(true);
                            }
                        }
                    }
                }
                break;

            case "left":
                personagemColunaEsquerda = (personagemMundoXesquerda - entidade.getVelocidade()) / gp.getTamanhoBloco();
                personagemColunaEsquerda = Math.max(0, Math.min(personagemColunaEsquerda, numColunas - 1));

                if (personagemColunaEsquerda >= 0 && personagemColunaEsquerda < numColunas &&
                        personagemLinhaCima >= 0 && personagemLinhaCima < numLinhas &&
                        personagemLinhaBaixo >= 0 && personagemLinhaBaixo < numLinhas) {

                    blocoNum1 = gp.getBlocosG().getNumBlocosMapa()[gp.getMapaAtual()][personagemColunaEsquerda][personagemLinhaCima];
                    blocoNum2 = gp.getBlocosG().getNumBlocosMapa()[gp.getMapaAtual()][personagemColunaEsquerda][personagemLinhaBaixo];

                    if (blocoNum1 >= 0 && blocoNum1 < gp.getBlocosG().getBlocos().length &&
                            blocoNum2 >= 0 && blocoNum2 < gp.getBlocosG().getBlocos().length) {

                        boolean peixePodePassar = false;
                        if (entidade instanceof Aquatico) {
                            Aquatico aquatica = (Aquatico) entidade;
                            peixePodePassar = aquatica.podeAtravessar(blocoNum1) && aquatica.podeAtravessar(blocoNum2);
                        }

                        if (!peixePodePassar) {
                            if (gp.getBlocosG().getBlocos()[blocoNum1].isColisao() || gp.getBlocosG().getBlocos()[blocoNum2].isColisao()) {
                                entidade.setColisaoOn(true);
                            }
                        }
                    }
                }
                break;
        }
    }

    // Verifica colisão com objetos (itens) do jogo
    public int checarObjeto(Entidade entidade, boolean jogador) {
        int indice = 999;

        for (int i = 0; i < gp.getObj()[1].length; i++) {
            if (gp.getObj()[gp.getMapaAtual()][i] != null) {
                // Atualiza as posições das áreas sólidas de entidade e objeto
                entidade.getAreaSolida().x = entidade.getMundoX() + entidade.getAreaSolidaPadraoX();
                entidade.getAreaSolida().y = entidade.getMundoY() + entidade.getAreaSolidaPadraoY();

                gp.getObj()[gp.getMapaAtual()][i].getAreaSolida().x = gp.getObj()[gp.getMapaAtual()][i].getMundoX() + gp.getObj()[gp.getMapaAtual()][i].getAreaSolidaPadraoX();
                gp.getObj()[gp.getMapaAtual()][i].getAreaSolida().y = gp.getObj()[gp.getMapaAtual()][i].getMundoY() + gp.getObj()[gp.getMapaAtual()][i].getAreaSolidaPadraoY();

                switch (entidade.getDirecao()) {
                    case "up":
                        // Simula o movimento e verifica interseção
                        entidade.getAreaSolida().y -= entidade.getVelocidade();

                        break;

                    case "down":
                        entidade.getAreaSolida().y += entidade.getVelocidade();

                        break;

                    case "left":
                        entidade.getAreaSolida().x -= entidade.getVelocidade();

                        break;

                    case "right":
                        entidade.getAreaSolida().x += entidade.getVelocidade();

                        break;
                }

                if (entidade.getAreaSolida().intersects(gp.getObj()[gp.getMapaAtual()][i].getAreaSolida())) {
                    if (gp.getObj()[gp.getMapaAtual()][i].isColisao()) {
                        entidade.setColisaoOn(true);
                    }
                    if (jogador == true) {
                        indice = i;
                    }
                }

                // Reset das áreas sólidas
                entidade.getAreaSolida().x = entidade.getAreaSolidaPadraoX();
                entidade.getAreaSolida().y = entidade.getAreaSolidaPadraoY();
                gp.getObj()[gp.getMapaAtual()][i].getAreaSolida().x = gp.getObj()[gp.getMapaAtual()][i].getAreaSolidaPadraoX();
                gp.getObj()[gp.getMapaAtual()][i].getAreaSolida().y = gp.getObj()[gp.getMapaAtual()][i].getAreaSolidaPadraoY();
            }
        }

        return indice;
    }

    // Verifica colisão com outras entidades
    public int checarEntidade(Entidade entidade, Entidade[][] alvo) {

        int indice = 999;

        for (int i = 0; i < alvo[1].length; i++) {
            if (alvo[gp.getMapaAtual()][i] != null) {

                entidade.getAreaSolida().x = entidade.getMundoX() + entidade.getAreaSolidaPadraoX();
                entidade.getAreaSolida().y = entidade.getMundoY() + entidade.getAreaSolidaPadraoY();

                alvo[gp.getMapaAtual()][i].getAreaSolida().x = alvo[gp.getMapaAtual()][i].getMundoX() + alvo[gp.getMapaAtual()][i].getAreaSolidaPadraoX();
                alvo[gp.getMapaAtual()][i].getAreaSolida().y = alvo[gp.getMapaAtual()][i].getMundoY() + alvo[gp.getMapaAtual()][i].getAreaSolidaPadraoY();

                switch (entidade.getDirecao()) {
                    case "up":
                        entidade.getAreaSolida().y -= entidade.getVelocidade();
                        break;

                    case "down":
                        entidade.getAreaSolida().y += entidade.getVelocidade();
                        break;

                    case "left":
                        entidade.getAreaSolida().x -= entidade.getVelocidade();

                        break;

                    case "right":
                        entidade.getAreaSolida().x += entidade.getVelocidade();
                        break;

                }

                if (entidade.getAreaSolida().intersects(alvo[gp.getMapaAtual()][i].getAreaSolida())) {

                    if (alvo[gp.getMapaAtual()][i] != entidade) {
                        entidade.setColisaoOn(true);
                        indice = i;

                    }


                }

                // Reset das áreas sólidas
                entidade.getAreaSolida().x = entidade.getAreaSolidaPadraoX();
                entidade.getAreaSolida().y = entidade.getAreaSolidaPadraoY();
                alvo[gp.getMapaAtual()][i].getAreaSolida().x = alvo[gp.getMapaAtual()][i].getAreaSolidaPadraoX();
                alvo[gp.getMapaAtual()][i].getAreaSolida().y = alvo[gp.getMapaAtual()][i].getAreaSolidaPadraoY();
            }

        }

        return indice;
    }

    // Verifica colisão de uma entidade qualquer com o jogador

    public boolean checarJogador(Entidade entidade) {

        boolean contatoJogador = false;

        entidade.getAreaSolida().x = entidade.getMundoX() + entidade.getAreaSolidaPadraoX();
        entidade.getAreaSolida().y = entidade.getMundoY() + entidade.getAreaSolidaPadraoY();

        gp.jogador.getAreaSolida().x = gp.jogador.getMundoX() + gp.jogador.getAreaSolidaPadraoX();
        gp.jogador.getAreaSolida().y = gp.jogador.getMundoY() + gp.jogador.getAreaSolidaPadraoY();

        switch (entidade.getDirecao()) {
            case "up":
                entidade.getAreaSolida().y -= entidade.getVelocidade();

                break;

            case "down":
                entidade.getAreaSolida().y += entidade.getVelocidade();

                break;

            case "left":
                entidade.getAreaSolida().x -= entidade.getVelocidade();

                break;

            case "right":
                entidade.getAreaSolida().x += entidade.getVelocidade();

                break;

        }

        if (entidade.getAreaSolida().intersects(gp.jogador.getAreaSolida())) {
            entidade.setColisaoOn(true);
            contatoJogador = true;

        }

        entidade.getAreaSolida().x = entidade.getAreaSolidaPadraoX();
        entidade.getAreaSolida().y = entidade.getAreaSolidaPadraoY();
        gp.jogador.getAreaSolida().x = gp.jogador.getAreaSolidaPadraoX();
        gp.jogador.getAreaSolida().y = gp.jogador.getAreaSolidaPadraoY();


        return contatoJogador;
    }

}
