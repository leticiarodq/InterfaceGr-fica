package exceptions;

public class EnergiaInsuficienteException extends Exception {
    public EnergiaInsuficienteException() {
        super("Energia insuficiente para realizar a ação!");
    }
}
