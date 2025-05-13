package personagens; // Define que esta classe pertence ao pacote 'itens'

import java.util.ArrayList;

// A classe Rastreador é uma subclasse da classe Personagem
public class Rastreador extends Personagem {

    //Construtor
    public Rastreador(String nome, int vida, int fome, int sede, int energia, int sanidade, ArrayList inventario, String localizacao) {
        super(nome, vida, fome, sede, energia, sanidade, inventario, localizacao);
    }



    //pretendo criar metodos com as skills dos itens por aqui
}
