package turnos;

import enums.FaseDoTurno;

public class Turno {
    private int numeroDoTurno;
    private FaseDoTurno faseAtual;

    public Turno() {
        this.numeroDoTurno = 1;
        this.faseAtual = FaseDoTurno.DIA;
    }

    // Método para avançar a fase
    public void avancarFase() {
        if (faseAtual == FaseDoTurno.DIA) {
            faseAtual = FaseDoTurno.NOITE;
        } else {
            faseAtual = FaseDoTurno.DIA;
            numeroDoTurno++;
        }
    }

    // Getter para o número do turno
    public int getNumeroDoTurno() {
        return numeroDoTurno;
    }

    // Getter para a fase atual
    public FaseDoTurno getFaseAtual() {
        return faseAtual;
    }

    // Método para mostrar a fase que o jogador estará no momento
    public String getDescricao() {
        return "Turno " + numeroDoTurno + " - Fase: " + faseAtual;
    }
}

