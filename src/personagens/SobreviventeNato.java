package personagens; // Define que esta classe pertence ao pacote 'itens'

import java.util.ArrayList;

// A classe SobreviventeNato é uma subclasse da classe Personagem
public class SobreviventeNato extends Personagem {

    //Construtor
    public SobreviventeNato(String nome, int vida, int fome, int sede, int energia, int sanidade, Inventario inventario, String localizacao, double temperaturaCorporal) {
        super(nome, vida, fome, sede, energia, sanidade, inventario, localizacao, temperaturaCorporal);
    }

    //pretendo criar metodos com as skills dos itens por aqui
}
