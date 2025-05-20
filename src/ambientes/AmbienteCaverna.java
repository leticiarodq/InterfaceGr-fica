package ambientes; // Define que a classe 'Ambiente' pertence ao pacote 'ambientes'

public class AmbienteCaverna extends Ambiente { // Cria uma subclasse que herda os atributos e métodos da classe abstrata 1Ambientes'

    // Atributos específicos do ambiente caverna
    private boolean poucaLuz;
    private String criaturasDesconhecidas;
    private boolean aguaGotejamento;

    public AmbienteCaverna() {
        // 'super' serve para chamar o construtor da classe 'Ambiente' e passar as informações comuns
        super("Caverna",
                "Uma abiente subterrâneo que pode oferecer abrigo contra o clima, mas esconde perigos desconhecidos.",
                3,
                new String[]{"Rochas", "Minérios raros", "Pequenos lagos subterrâneos", "Ossos", "Vestígios de exploradores antigos"},
                0.6,
                "Frias"
        );

        // Define os atributos específicos do ambiente
        this.poucaLuz=true;
        this.criaturasDesconhecidas=criaturasDesconhecidas;
        this.aguaGotejamento=true;
    }

    // Métodos que permitem acessar os valores dos atributos
    public boolean isPoucaLuz(){
        return poucaLuz;
    }
    public String getCriaturasDesconhecidas(){
        return criaturasDesconhecidas;
    }
    public boolean isAguaGotejamento(){
        return aguaGotejamento;
    }

    public void gerarEvento(){

    }

    public void modificarClima(){

    }

}


