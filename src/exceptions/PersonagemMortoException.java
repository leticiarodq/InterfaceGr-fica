package exceptions;

public class PersonagemMortoException extends Exception {
    public PersonagemMortoException() {
        super("Personagem morreu!");
    }
}
