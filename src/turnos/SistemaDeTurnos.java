package turnos;

import enums.FaseDoTurno;
import personagens.Medico;
import personagens.Personagem;
import personagens.SobreviventeNato;

public class SistemaDeTurnos {
    private Turno turno;

    public SistemaDeTurnos() {
        this.turno = new Turno();
    }

    // Método para mostrar a fase que o jogador estará no momento
    public String getDescricaoDoTurno() {
        return turno.getDescricao();
    }

    // Método para obter a fase atual
    public FaseDoTurno getFaseAtual() {
        return turno.getFaseAtual();
    }

    // Método para obter o número do turno
    public int getNumeroDoTurno() {
        return turno.getNumeroDoTurno();
    }

    // Método para avançar o turno
    public void avancarTurno(Personagem personagem) {
        turno.avancarFase();
        efeitosDaFase(personagem);
    }

    // Método para aplicar efeitos da fase
    public void efeitosDaFase(Personagem personagem){
        personagem.reduzirSede(2);
        personagem.reduzirFome(2);
        personagem.reduzirEnergia(2);

        if (personagem instanceof Medico) {
            ((Medico) personagem).recuperarVidaTurno();
        }

        if (personagem instanceof SobreviventeNato) {
            ((SobreviventeNato) personagem).recuperarSedeTurno();
            ((SobreviventeNato) personagem).recuperarFomeTurno();
        }
    }
}

