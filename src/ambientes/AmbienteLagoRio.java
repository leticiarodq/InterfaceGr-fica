package ambientes;

public class AmbienteLagoRio extends Ambiente {

    public String aguaAbundante;
    public boolean possibilidadePesca;
    public boolean terrenoLamacento;

    public AmbienteLagoRio(){

        super(
                "Lago e Rio",
                "Regiões ricas em água, mas que podem esconder riscos como afogamento ou criaturas aquáticas.",
                3,
                new String[]{"Peixes", "Algas comestíveis","Água doce", "Vegetação ribeirinha"},
                1,
                "Úmido"
        );

        this.aguaAbundante=aguaAbundante;
        this.possibilidadePesca=true;
        this.possibilidadePesca=true;
    }

    public String getAguaAbundante(){
        return aguaAbundante;
    }
    public boolean isPossibilidadePesca(){
        return possibilidadePesca;
    }
    public boolean isTerrenoLamacento() {
        return terrenoLamacento;
    }
}
