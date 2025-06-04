//Pacote
package exceptions;

//Exceção lançada em tempo de execução
public class FerramentaQuebradaException extends RuntimeException {
    public FerramentaQuebradaException(String message) {
        super(message);
    }
}
