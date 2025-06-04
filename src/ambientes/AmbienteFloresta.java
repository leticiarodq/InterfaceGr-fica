//Pacote
package ambientes;

//AmbienteFloresta é uma subclasse de Ambiente
public class AmbienteFloresta extends Ambiente {

    private boolean vegetacaoDensa;
    private boolean faunaAbundante;
    private boolean climaUmido;

    //Construtor
    public AmbienteFloresta() {
        super(
                "Floresta",
                "Uma área densa e úmida, rica em recursos naturais, cheia de vida selvagem.",
                3,
                new String[]{"Frutas", "Raízes", "Cogumelos", "Madeira", "Pequenos animais para caça"},
                0.6,
                "Úmido",
                "/maps/floresta.txt" // Caminho para o layout do mapa
        );

        this.vegetacaoDensa = true;
        this.faunaAbundante = true;
        this.climaUmido = true;
    }

    public boolean isVegetacaoDensa() {
        return vegetacaoDensa;
    }

    public boolean isFaunaAbundante() {
        return faunaAbundante;
    }

    public boolean isClimaUmido() {
        return climaUmido;
    }

}