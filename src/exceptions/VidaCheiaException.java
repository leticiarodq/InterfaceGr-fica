//Pacote
package exceptions;

//Exceção lançada em tempo de execução
public class VidaCheiaException extends RuntimeException {
    public VidaCheiaException(String message) {
        super(message);
    }
}
