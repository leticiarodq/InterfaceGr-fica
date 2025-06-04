//Pacote
package ambientes;

//AmbienteCaverna é uma subclasse de Ambiente
public class AmbienteCaverna extends Ambiente {

    private boolean poucaLuz;
    private String criaturasDesconhecidas;
    private boolean aguaGotejamento;

    //Construtor
    public AmbienteCaverna() {
        super("Caverna",
                "Um ambiente subterrâneo que pode oferecer abrigo contra o clima, mas esconde perigos desconhecidos.",
                3,
                new String[]{"Rochas", "Minérios raros", "Pequenos lagos subterrâneos", "Ossos", "Vestígios de exploradores antigos"},
                0.6,
                "Frio e Úmido",
                "/maps/caverna.txt" // Caminho para o layout do mapa
        );

        this.poucaLuz = true;
        this.criaturasDesconhecidas = "Presentes"; // Valor definido
        this.aguaGotejamento = true;
    }

    public boolean isPoucaLuz() {
        return poucaLuz;
    }

    public String getCriaturasDesconhecidas() {
        return criaturasDesconhecidas;
    }

    public boolean isAguaGotejamento() {
        return aguaGotejamento;
    }

}