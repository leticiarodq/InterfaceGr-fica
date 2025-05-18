package gui.system;

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
        personagemColunaEsquerda = Math.max(0, Math.min(personagemColunaEsquerda, gp.getBlocosG().getNumBlocosMapa().length - 1));
        personagemColunaDireita = Math.max(0, Math.min(personagemColunaDireita, gp.getBlocosG().getNumBlocosMapa().length - 1));
        personagemLinhaCima = Math.max(0, Math.min(personagemLinhaCima, gp.getBlocosG().getNumBlocosMapa()[0].length - 1));
        personagemLinhaBaixo = Math.max(0, Math.min(personagemLinhaBaixo, gp.getBlocosG().getNumBlocosMapa()[0].length - 1));


        int blocoNum1 = 0;
        int blocoNum2 = 0;

        if (personagemColunaEsquerda >= 0 && personagemColunaEsquerda < gp.getBlocosG().getNumBlocosMapa().length &&
                personagemLinhaCima >= 0 && personagemLinhaCima < gp.getBlocosG().getNumBlocosMapa()[0].length) {
            blocoNum1 = gp.getBlocosG().getNumBlocosMapa()[personagemColunaEsquerda][personagemLinhaCima];
        }

        switch (entidade.getDirecao()) {
            case "up":
                // Simula o movimento e verifica quais blocos serão alcançados
                personagemLinhaCima = (personagemMundoYcima - entidade.getVelocidade()) / gp.getTamanhoBloco();

                personagemLinhaCima = Math.max(0, Math.min(personagemLinhaCima, gp.getBlocosG().getNumBlocosMapa()[0].length - 1));

                blocoNum1 = gp.getBlocosG().getNumBlocosMapa()[personagemColunaEsquerda][personagemLinhaCima];
                blocoNum2 = gp.getBlocosG().getNumBlocosMapa()[personagemColunaDireita][personagemLinhaCima];
                // Checa se algum desses blocos tem colisão ativada:
                if (personagemColunaEsquerda >= 0 && personagemColunaEsquerda < gp.getBlocosG().getNumBlocosMapa().length &&
                        personagemColunaDireita >= 0 && personagemColunaDireita < gp.getBlocosG().getNumBlocosMapa().length &&
                        personagemLinhaCima >= 0 && personagemLinhaCima < gp.getBlocosG().getNumBlocosMapa()[0].length) {

                    blocoNum1 = gp.getBlocosG().getNumBlocosMapa()[personagemColunaEsquerda][personagemLinhaCima];
                    blocoNum2 = gp.getBlocosG().getNumBlocosMapa()[personagemColunaDireita][personagemLinhaCima];

                    // Verifica se os índices dos blocos estão dentro dos limites válidos do array de blocos
                    if (blocoNum1 >= 0 && blocoNum1 < gp.getBlocosG().getBlocos().length &&
                            blocoNum2 >= 0 && blocoNum2 < gp.getBlocosG().getBlocos().length) {

                        // Checa se algum desses blocos tem colisão ativada:
                        if (gp.getBlocosG().getBlocos()[blocoNum1].isColisao() || gp.getBlocosG().getBlocos()[blocoNum2].isColisao()) {
                            entidade.setColisaoOn(true);
                        }
                    }
                }
                break;

            case "down":
                personagemLinhaBaixo = (personagemMundoYbaixo + entidade.getVelocidade()) / gp.getTamanhoBloco();

                // Garante que o índice esteja dentro dos limites
                personagemLinhaBaixo = Math.max(0, Math.min(personagemLinhaBaixo, gp.getBlocosG().getNumBlocosMapa()[0].length - 1));

                // Acessa os blocos apenas se os índices forem válidos
                if (personagemColunaEsquerda >= 0 && personagemColunaEsquerda < gp.getBlocosG().getNumBlocosMapa().length &&
                        personagemColunaDireita >= 0 && personagemColunaDireita < gp.getBlocosG().getNumBlocosMapa().length &&
                        personagemLinhaBaixo >= 0 && personagemLinhaBaixo < gp.getBlocosG().getNumBlocosMapa()[0].length) {

                    blocoNum1 = gp.getBlocosG().getNumBlocosMapa()[personagemColunaEsquerda][personagemLinhaBaixo];
                    blocoNum2 = gp.getBlocosG().getNumBlocosMapa()[personagemColunaDireita][personagemLinhaBaixo];

                    // Verifica se os índices dos blocos estão dentro dos limites válidos do array de blocos
                    if (blocoNum1 >= 0 && blocoNum1 < gp.getBlocosG().getBlocos().length &&
                            blocoNum2 >= 0 && blocoNum2 < gp.getBlocosG().getBlocos().length) {

                        if (gp.getBlocosG().getBlocos()[blocoNum1].isColisao() || gp.getBlocosG().getBlocos()[blocoNum2].isColisao()) {
                            entidade.setColisaoOn(true);
                        }
                    }
                }
                break;
            case "right":
                personagemColunaDireita = (personagemMundoXdireita + entidade.getVelocidade()) / gp.getTamanhoBloco();
                personagemColunaDireita = Math.max(0, Math.min(personagemColunaDireita, gp.getBlocosG().getNumBlocosMapa().length - 1));

                if (personagemColunaDireita >= 0 && personagemColunaDireita < gp.getBlocosG().getNumBlocosMapa().length &&
                        personagemLinhaCima >= 0 && personagemLinhaCima < gp.getBlocosG().getNumBlocosMapa()[0].length &&
                        personagemLinhaBaixo >= 0 && personagemLinhaBaixo < gp.getBlocosG().getNumBlocosMapa()[0].length) {

                    blocoNum1 = gp.getBlocosG().getNumBlocosMapa()[personagemColunaDireita][personagemLinhaCima];
                    blocoNum2 = gp.getBlocosG().getNumBlocosMapa()[personagemColunaDireita][personagemLinhaBaixo];

                    if (blocoNum1 >= 0 && blocoNum1 < gp.getBlocosG().getBlocos().length &&
                            blocoNum2 >= 0 && blocoNum2 < gp.getBlocosG().getBlocos().length) {

                        if (gp.getBlocosG().getBlocos()[blocoNum1].isColisao() || gp.getBlocosG().getBlocos()[blocoNum2].isColisao()) {
                            entidade.setColisaoOn(true);
                        }
                    }
                }
                break;
            case "left":
                personagemColunaEsquerda = (personagemMundoXesquerda - entidade.getVelocidade()) / gp.getTamanhoBloco();
                personagemColunaEsquerda = Math.max(0, Math.min(personagemColunaEsquerda, gp.getBlocosG().getNumBlocosMapa().length - 1));

                if (personagemColunaEsquerda >= 0 && personagemColunaEsquerda < gp.getBlocosG().getNumBlocosMapa().length &&
                        personagemLinhaCima >= 0 && personagemLinhaCima < gp.getBlocosG().getNumBlocosMapa()[0].length &&
                        personagemLinhaBaixo >= 0 && personagemLinhaBaixo < gp.getBlocosG().getNumBlocosMapa()[0].length) {

                    blocoNum1 = gp.getBlocosG().getNumBlocosMapa()[personagemColunaEsquerda][personagemLinhaCima];
                    blocoNum2 = gp.getBlocosG().getNumBlocosMapa()[personagemColunaEsquerda][personagemLinhaBaixo];

                    if (blocoNum1 >= 0 && blocoNum1 < gp.getBlocosG().getBlocos().length &&
                            blocoNum2 >= 0 && blocoNum2 < gp.getBlocosG().getBlocos().length) {

                        if (gp.getBlocosG().getBlocos()[blocoNum1].isColisao() || gp.getBlocosG().getBlocos()[blocoNum2].isColisao()) {
                            entidade.setColisaoOn(true);
                        }
                    }
                }
                break;
        }
    }

    // Verifica colisão com objetos (itens) do jogo
    public int checarObjeto(Entidade entidade, boolean jogador) {
        int indice = 999;

        for (int i = 0; i < gp.getObj().length; i++) {
            if (gp.getObj()[i] != null) {
                // Atualiza as posições das áreas sólidas de entidade e objeto
                entidade.getAreaSolida().x = entidade.getMundoX() + entidade.getAreaSolidaPadraoX();
                entidade.getAreaSolida().y = entidade.getMundoY() + entidade.getAreaSolidaPadraoY();

                gp.getObj()[i].getAreaSolida().x = gp.getObj()[i].getMundoX() + gp.getObj()[i].getAreaSolidaPadraoX();
                gp.getObj()[i].getAreaSolida().y = gp.getObj()[i].getMundoY() + gp.getObj()[i].getAreaSolidaPadraoY();

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

                if (entidade.getAreaSolida().intersects(gp.getObj()[i].getAreaSolida())) {
                    if (gp.getObj()[i].isColisao()) {
                        entidade.setColisaoOn(true);
                    }
                    if (jogador == true) {
                        indice = i;
                    }
                }

                // Reset das áreas sólidas
                entidade.getAreaSolida().x = entidade.getAreaSolidaPadraoX();
                entidade.getAreaSolida().y = entidade.getAreaSolidaPadraoY();
                gp.getObj()[i].getAreaSolida().x = gp.getObj()[i].getAreaSolidaPadraoX();
                gp.getObj()[i].getAreaSolida().y = gp.getObj()[i].getAreaSolidaPadraoY();
            }
        }

        return indice;
    }

    // Verifica colisão com outras entidades
    public int checarEntidade(Entidade entidade, Entidade[] alvo) {

        int indice = 999;

        for (int i = 0; i < alvo.length; i++) {
            if (alvo[i] != null) {

                entidade.getAreaSolida().x = entidade.getMundoX() + entidade.getAreaSolidaPadraoX();
                entidade.getAreaSolida().y = entidade.getMundoY() + entidade.getAreaSolidaPadraoY();

                alvo[i].getAreaSolida().x = alvo[i].getMundoX() + alvo[i].getAreaSolidaPadraoX();
                alvo[i].getAreaSolida().y = alvo[i].getMundoY() + alvo[i].getAreaSolidaPadraoY();

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

                if (entidade.getAreaSolida().intersects(alvo[i].getAreaSolida())) {

                    if (alvo[i] != entidade) {
                        entidade.setColisaoOn(true);
                        indice = i;

                    }


                }

                // Reset das áreas sólidas
                entidade.getAreaSolida().x = entidade.getAreaSolidaPadraoX();
                entidade.getAreaSolida().y = entidade.getAreaSolidaPadraoY();
                alvo[i].getAreaSolida().x = alvo[i].getAreaSolidaPadraoX();
                alvo[i].getAreaSolida().y = alvo[i].getAreaSolidaPadraoY();
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
