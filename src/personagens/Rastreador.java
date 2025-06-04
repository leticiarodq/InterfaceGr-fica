//Pacote
package personagens;

//Import
import itens.Arma;

// A classe Medico é uma subclasse da classe Personagem
public class Rastreador extends Personagem {

    // Construtor
    public Rastreador(String nome, int vida, int fome, int sede, int energia, int sanidade,
                      Inventario inventario, String localizacao, double temperaturaCorporal,
                      int sedeMaxima, int velocidade, boolean desidratado, boolean infectado, boolean delirio, Arma armaEquipada) {
        super(nome, vida, fome, sede, energia, sanidade, inventario, localizacao, temperaturaCorporal, sedeMaxima, velocidade, desidratado, infectado, delirio, armaEquipada);

    }

    //Skill em desenvolvimento

}
