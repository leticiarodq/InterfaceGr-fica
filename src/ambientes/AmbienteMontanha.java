package ambientes;

public class AmbienteMontanha extends Ambiente {

    private boolean terrenoAcidentado;
    private String climaInstavel;
    private String baixaVegetacao;

    public AmbienteMontanha(){

        super("Montanha",
                "Uma região de difícil acesso, mas rica em minérios e pedras preciosas",
                4,
                new String[]{"Rochas", "Minérios raros", "Pequenos lagos subterrâneos", "Ossos", "Vestígios de exploradores antigos"},
                1,
                "Instável"
        );

        this.terrenoAcidentado=true;
        this.climaInstavel=climaInstavel;
        this.baixaVegetacao=baixaVegetacao;
    }

    public boolean isTerrenoAcidentado() {
        return terrenoAcidentado;
    }
    public String getClimaInstavel(){
        return climaInstavel;
    }
    public String getBaixaVegetacao(){
        return baixaVegetacao;
    }

    public void gerarEvento(){

    }

    public void modificarClima(){

    }
}
