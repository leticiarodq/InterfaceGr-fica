//Pacote
package exceptions;

//Exceção lançada em tempo de execução
public class CombinarException extends RuntimeException {
    public CombinarException(String message) {
        super(message);
    }
}
