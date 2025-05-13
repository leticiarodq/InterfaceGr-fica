package ambientes; // Define que a classe 'Ambiente' pertence ao pacote 'ambientes'

import eventos.Evento;

import java.util.Arrays;
import java.util.List;

public abstract class Ambiente { // Define a classe abstrata 'Ambiente' que servirá como base para outras classes

    // Atributos privados que definem as características do ambiente
    private String nomeAmbiente;
    private String descricaoAmbiente;
    private int dificuldadeExploracao;
    private List<String> recursosDisponiveis;
    private double probabilidadeEventos;
    private String condicoesClimaticas;
    private List<Evento> eventosPossiveis;




    // Construtor que inicializa os atributos do ambiente
    public Ambiente(String nomeAmbiente, String descricaoAmbiente, int dificuldadeExploracao, String[] recursos, double probabilidadeEventos, String condicoesClimaticas){
        this.nomeAmbiente=nomeAmbiente;
        this.descricaoAmbiente=descricaoAmbiente;
        this.dificuldadeExploracao=dificuldadeExploracao;
        this.recursosDisponiveis=Arrays.asList(recursos);
        this.probabilidadeEventos=probabilidadeEventos;
        this.condicoesClimaticas=condicoesClimaticas;
    }



    // Métodos que permitem acessar os valores dos atributos
    public String getNomeAmbiente(){
        return nomeAmbiente;
    }

    public String getDescricaoAmbiente(){
        return descricaoAmbiente;
    }

    public int getDificuldadeExploracao(){
        return dificuldadeExploracao;
    }

    public List<String> getRecursosDisponiveis() {
        return recursosDisponiveis;
    }

    public double getProbabilidadeEventos(){
        return probabilidadeEventos;
    }

    public String getCondicoesClimaticas(){
        return condicoesClimaticas;
    }


    // Métodos que serão construídos em breve
    public void explorar(){
    }

    public void gerarEvento(){
    }

    public void modificarClima(){
    }

}
