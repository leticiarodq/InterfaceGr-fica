//Pacote
package personagens;

//Import
import itens.Arma;

// A classe SobreviventeNato é uma subclasse da classe Personagem
public class SobreviventeNato extends Personagem {

    //Construtor
    public SobreviventeNato(String nome, int vida, int fome, int sede, int energia, int sanidade,
                      Inventario inventario, String localizacao, double temperaturaCorporal,
                      int sedeMaxima, int velocidade, boolean desidratado, boolean infectado, boolean delirio, Arma armaEquipada) {
        super(nome, vida, fome, sede, energia, sanidade, inventario, localizacao, temperaturaCorporal, sedeMaxima, velocidade, desidratado, infectado, delirio, armaEquipada);

    }

    //Método boolean para aplicação da skill do SobreviventeNato (recupera vida a cada turno(diretamente relacionado com o metodo do sistema de turnos de aplicação de efeitos))
    public boolean recuperarSedeTurno() {
        try {
            this.recuperarSede(1);
            return true;
        } catch (exceptions.SedeCheiaException e) {
            return false;
        }
    }

    //Método boolean para aplicação da skill do SobreviventeNato (recupera vida a cada turno(diretamente relacionado com o metodo do sistema de turnos de aplicação de efeitos))
    public boolean recuperarFomeTurno() {
        try {
            this.recuperarFome(1);
            return true;
        } catch (exceptions.FomeCheiaException e) {
            return false;
        }
    }

}
