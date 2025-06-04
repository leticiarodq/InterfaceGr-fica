//Pacote
package exceptions;

//Exceção lançada em tempo de execução
public class FomeCheiaException extends RuntimeException {
  public FomeCheiaException(String mensagem) {
    super(mensagem);
  }
}
