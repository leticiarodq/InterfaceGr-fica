package turnos;

import personagens.Personagem;
import java.util.Timer;
import java.util.TimerTask;

public class ControladorDeTurnos {
    private SistemaDeTurnos sistemaDeTurnos;
    private Personagem personagem;
    private Timer timer;
    private int maxTurnos;
    private long intervaloMillis;

    public ControladorDeTurnos(SistemaDeTurnos sistemaDeTurnos, Personagem personagem, long intervaloMillis) {
        this.sistemaDeTurnos = sistemaDeTurnos;
        this.personagem = personagem;
        this.intervaloMillis = intervaloMillis;
        this.timer = new Timer();
    }

    public void iniciar() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                sistemaDeTurnos.avancarTurno(personagem);

                if (sistemaDeTurnos.getNumeroDoTurno() >= maxTurnos) {
                    parar();
                }
            }
        }, 0, intervaloMillis);
    }

    public void parar() {
        timer.cancel();
        timer.purge();
    }
}
