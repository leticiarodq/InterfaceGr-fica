//Pacote
package ambientes;

//AmbienteMontanha é uma subclasse de Ambiente
public class AmbienteMontanha extends Ambiente {

    private boolean terrenoAcidentado;
    private String climaInstavel;
    private String baixaVegetacao;

    //Construtor
    public AmbienteMontanha() {
        super("Montanha",
                "Uma região de difícil acesso, mas rica em minérios e pedras preciosas.",
                4,
                new String[]{"Minérios", "Pedras preciosas", "Água de degelo", "Refúgios naturais"},
                1,
                "Instável",
                "/maps/montanha.txt" // Caminho para o layout do mapa
        );

        this.terrenoAcidentado = true;
        this.climaInstavel = "Instável"; // Valor definido
        this.baixaVegetacao = "Baixa"; // Valor definido
    }

    public boolean isTerrenoAcidentado() {
        return terrenoAcidentado;
    }

    public String getClimaInstavel() {
        return climaInstavel;
    }

    public String getBaixaVegetacao() {
        return baixaVegetacao;
    }

}