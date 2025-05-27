package gui.eventos;

import java.awt.*;

public class EventoRetangulo extends Rectangle {

    private int eventoRetanguloPadraoX,eventoRetanguloPadraoY;
    private boolean eventoTerminado=false;

    public int getEventoRetanguloPadraoX() {
        return eventoRetanguloPadraoX;
    }

    public int getEventoRetanguloPadraoY() {
        return eventoRetanguloPadraoY;
    }

    public boolean isEventoTerminado() {
        return eventoTerminado;
    }

    public void setEventoRetanguloPadraoX(int eventoRetanguloPadraoX) {
        this.eventoRetanguloPadraoX = eventoRetanguloPadraoX;
    }

    public void setEventoRetanguloPadraoY(int eventoRetanguloPadraoY) {
        this.eventoRetanguloPadraoY = eventoRetanguloPadraoY;
    }

    public void setEventoTerminado(boolean eventoTerminado) {
        this.eventoTerminado = eventoTerminado;
    }
}
