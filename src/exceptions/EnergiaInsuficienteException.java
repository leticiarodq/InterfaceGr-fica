//Pacote
package exceptions;

//Exceção lançada em tempo de execução
public class EnergiaInsuficienteException extends RuntimeException {
    public EnergiaInsuficienteException() {
        super("Energia insuficiente para realizar a ação!");
    }
}
