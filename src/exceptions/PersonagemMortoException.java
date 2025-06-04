//Pacote
package exceptions;

//Exceção lançada em tempo de execução
public class PersonagemMortoException extends RuntimeException {
    public PersonagemMortoException() {
        super("Personagem morreu!");
    }
}
