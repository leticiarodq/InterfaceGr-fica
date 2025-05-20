package personagens; // Define que esta classe pertence ao pacote 'itens'

import itens.Item;

import java.util.ArrayList;
import java.util.Random;

// A classe Rastreador é uma subclasse da classe Personagem
public class Rastreador extends Personagem {

    //Construtor
    public Rastreador(String nome, int vida, int fome, int sede, int energia, int sanidade, Inventario inventario, String localizacao, double temperaturaCorporal) {
        super(nome, vida, fome, sede, energia, sanidade, inventario, localizacao, temperaturaCorporal);
    }


}
