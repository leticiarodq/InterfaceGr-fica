//Pacote
package exceptions;

//Exceção lançada em tempo de execução
public class SedeCheiaException extends RuntimeException {
    public SedeCheiaException(String mensagem) {
        super(mensagem);
    }
}
