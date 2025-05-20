package ambientes;

public class AmbienteRuinas extends Ambiente{

    private boolean estruturaInstavel;
    private boolean outrosSobreviventes;
    private boolean baixoRiscoClimatico;

    public AmbienteRuinas() {
        super("Ruinas",
                "Restos de antigas construções que podem conter suprimentos valiosos ou armadilhas.",
                3,
            new String[]{"Ferramentas antigas", "Munição", "Alimentos enlatados", "Mapas e pistas sobre o ambiente"},
                0.6,
                "Ventos uivantes"
        );

        this.estruturaInstavel=true;
        this.outrosSobreviventes=true;
        this.baixoRiscoClimatico=true;
    }

    public boolean isEstruturaInstavel(){
        return estruturaInstavel;
    }
    public boolean isOutrosSobreviventes() {
        return outrosSobreviventes;
    }
    public boolean isBaixoRiscoClimatico() {
        return baixoRiscoClimatico;
    }

    public void gerarEvento(){

    }

    public void modificarClima(){

    }
}
