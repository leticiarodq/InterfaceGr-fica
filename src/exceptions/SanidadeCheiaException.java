//Pacote
package exceptions;

//Exceção lançada em tempo de execução
public class SanidadeCheiaException extends RuntimeException {
    public SanidadeCheiaException(String mensagem) {
        super(mensagem);
    }
}
