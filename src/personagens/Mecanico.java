//Pacote
package personagens;

//Imports
import itens.Arma;

// A classe Mecanico é uma subclasse da classe Personagem
public class Mecanico extends Personagem {

    //Construtor
    public Mecanico(String nome, int vida, int fome, int sede, int energia, int sanidade,
                      Inventario inventario, String localizacao, double temperaturaCorporal,
                      int sedeMaxima, int velocidade, boolean desidratado, boolean infectado, boolean delirio, Arma armaEquipada) {
        super(nome, vida, fome, sede, energia, sanidade, inventario, localizacao, temperaturaCorporal, sedeMaxima, velocidade, desidratado, infectado, delirio, armaEquipada);
    }

    //Sua é skill é a inicialização do personagem com uma espada

}


