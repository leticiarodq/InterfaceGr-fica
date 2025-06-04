package ambientes;

import personagens.Personagem;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeAmbientes {

    private List<Ambiente> ambientesDisponiveis;
    private Ambiente ambienteAtual;
    private int indiceAmbienteAtual;

    public GerenciadorDeAmbientes() {
        this.ambientesDisponiveis = new ArrayList<>();

        // Popula a lista com todas as implementações de Ambiente
        ambientesDisponiveis.add(new AmbienteFloresta());   // Índice 0
        ambientesDisponiveis.add(new AmbienteLagoRio());    // Índice 1
        ambientesDisponiveis.add(new AmbienteRuinas());     // Índice 2
        ambientesDisponiveis.add(new AmbienteMontanha());   // Índice 3
        ambientesDisponiveis.add(new AmbienteCaverna());    // Índice 4

        // Define o ambiente inicial do jogo
        this.indiceAmbienteAtual = 0;
        this.ambienteAtual = ambientesDisponiveis.get(this.indiceAmbienteAtual);
    }

    public Ambiente getAmbienteAtual() {
        return ambienteAtual;
    }

    public int getIndiceAmbienteAtual() {
        return indiceAmbienteAtual;
    }

    public List<Ambiente> getAmbientesDisponiveis() {
        return ambientesDisponiveis;
    }

    public void mudarAmbiente(int novoIndice, Personagem personagem) {
        if (novoIndice >= 0 && novoIndice < ambientesDisponiveis.size()) {
            Ambiente novoAmbiente = ambientesDisponiveis.get(novoIndice);

            this.indiceAmbienteAtual = novoIndice;
            this.ambienteAtual = novoAmbiente;

            if (personagem != null) {
                personagem.setLocalizacao(ambienteAtual.getNomeAmbiente());
            }
        }
    }
}