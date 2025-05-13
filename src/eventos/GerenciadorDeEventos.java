package eventos;

import java.util.Arrays;
import java.util.List;

public class GerenciadorDeEventos {

    private List<String> eventosPossiveis;
    private int frequenciaEventos;

    public GerenciadorDeEventos(String[] eventos, int frequenciaEventos){
        this.eventosPossiveis= Arrays.asList(eventos);
        this.frequenciaEventos=frequenciaEventos;

    }

    public List<String> getEventosPossiveis(){
        return eventosPossiveis;
    }

    public int getFrequenciaEventos(){
        return frequenciaEventos;
    }

    public void sortearEvento(){

    }

    public void aplicarEvento(){

    }

    public void removerEvento(Evento evento){

    }

}
