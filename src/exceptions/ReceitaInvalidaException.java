//Pacote
package exceptions;

//Exceção lançada em tempo de execução
public class ReceitaInvalidaException extends RuntimeException {
    public ReceitaInvalidaException(String message) {
        super(message);
    }
}
