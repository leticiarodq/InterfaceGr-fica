//Pacote
package personagens;

//Imports
import itens.Arma;

// A classe Medico é uma subclasse da classe Personagem
public class Medico extends Personagem {

    //Construtor
    public Medico(String nome, int vida, int fome, int sede, int energia, int sanidade,
                      Inventario inventario, String localizacao,
                      int sedeMaxima, int velocidade, boolean desidratado, boolean infectado, boolean delirio, Arma armaEquipada) {
            super(nome, vida, fome, sede, energia, sanidade, inventario, localizacao, sedeMaxima, velocidade, desidratado, infectado, delirio, armaEquipada);
        }

        //Método boolean para aplicação da skill do medico (recupera vida a cada turno(diretamente relacionado com o metodo do sistema de turnos de aplicação de efeitos))
        public boolean recuperarVidaTurno() {
        try {
            this.recuperarVida(5);
            return true;
        } catch (exceptions.VidaCheiaException e) {
            return false;
        }
    }
}

