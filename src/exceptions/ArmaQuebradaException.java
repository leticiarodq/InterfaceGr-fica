//Pacote
package exceptions;

//Exceção lançada em tempo de execução
public class ArmaQuebradaException extends RuntimeException {
    public ArmaQuebradaException(String message) {
        super(message);
    }
}
