package gui.itens;

import gui.entidades.Entidade;
import gui.system.PainelJogo;
import itens.Alimento;

public class ALIMENTO_Fruta extends Entidade {

    int valor=5;
    private PainelJogo gp;
    private Alimento frutaLogica;


    public ALIMENTO_Fruta(PainelJogo gp, String tipoFruta) {
        super(gp);
        this.gp=gp;
        setTipo(getTipo_consumivel());

        setNome(tipoFruta);

        switch (tipoFruta.toLowerCase()) {
            case "maca":
                frutaLogica=new Alimento("Maçã", 10, 1, "Fruta", 1, 0);
                setDown1(setup("/alimentos/maca", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                setDescricao("[Maçã]\nMata a fome e é fácil de\nencontrar.\nRica em fibras\ne vitaminas.");
                break;

            case "banana":
                frutaLogica=new Alimento("Banana", 10, 1, "Fruta", 1, 0);
                setDown1(setup("/alimentos/banana", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                setDescricao("[Banana]\nRica em potássio e\nenergia rápida.\nÓtima para recuperar\nforças.");
                break;

            case "laranja":
                frutaLogica=new Alimento("Laranja", 10, 1, "Fruta", 1, 0);
                setDown1(setup("/alimentos/laranja", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                setDescricao("[Laranja]\nCheia de vitamina C!\nAjuda a fortalecer o\nsistema imunológico.");
                break;

            case "tomate":
                frutaLogica=new Alimento("Tomate", 10, 1, "Fruta", 1, 0);
                setDown1(setup("/alimentos/tomate", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                setDescricao("[Tomate]\nFonte de antioxidantes\ne vitamina C.\nBom para a saúde\nda pele.");
                break;

            case "uvaroxa":
                frutaLogica=new Alimento("Uva Roxa", 10, 1, "Fruta", 1, 0);
                setDown1(setup("/alimentos/uva_roxa", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                setDescricao("[Uva roxa]\nCheia de antioxidantes.\nAjuda na circulação sanguínea.");
                break;

            case "uva verde":
                frutaLogica=new Alimento("Uva verde", 10, 1, "Fruta", 1, 0);
                setDown1(setup("/alimentos/uva_verde", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                setDescricao("[Uva verde]\nRefrescante e nutritiva.\nBoa fonte de vitaminas.");
                break;

            default:
                setDown1(setup("/alimentos/fruta_padrao", gp.getTamanhoBloco(), gp.getTamanhoBloco()));
                setDescricao("[Fruta]\nFruta misteriosa.\nDescubra seus benefícios!");
                break;
        }

        setColisao(true);


    }

    public void usar(Entidade entidade){
        gp.setEstadoJogo(gp.getEstadoDialogo());
        gp.getIu().setDialogoAtual("Você comeu "+ getNome());
        entidade.setFome(getFome()+1);
    }

    public void coletar(Entidade entidade){

        int i=0;
        gp.jogador.getInventario().add(gp.getObj()[gp.getMapaAtual()][i]);
        gp.getIu().mostrarMensagem("Carne crua");

    }

}

