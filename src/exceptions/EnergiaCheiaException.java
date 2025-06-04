//Pacote
package exceptions;

//Exceção lançada em tempo de execução
public class EnergiaCheiaException extends RuntimeException {
    public EnergiaCheiaException(String mensagem) {
        super(mensagem);
    }
}
