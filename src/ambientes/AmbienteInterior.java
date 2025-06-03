package ambientes;

public class AmbienteInterior extends Ambiente {

    public AmbienteInterior() {
        // 'super' serve para chamar o construtor da classe 'Ambiente' e passar as informações comuns
        super("Interior da casa da feiticeira",
                "Uma abiente subterrâneo que pode oferecer abrigo contra o clima, mas esconde perigos desconhecidos.",
                3,
                new String[]{"Rochas", "Minérios raros", "Pequenos lagos subterrâneos", "Ossos", "Vestígios de exploradores antigos"},
                0.6,
                "Frias"
        );
    }

    public void gerarEvento(){

    }

    public void modificarClima(){

    }

}


