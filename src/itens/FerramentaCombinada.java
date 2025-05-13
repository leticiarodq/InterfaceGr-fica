package itens;

import personagens.Personagem;

public class FerramentaCombinada extends Ferramenta {

    // Construtor da FerramentaCombinada
    public FerramentaCombinada(String nome, int peso, int durabilidade, String tipo, int eficiencia) {
        super(nome, peso, durabilidade, tipo, eficiencia);
    }

    public void usar(Personagem personagem) {
        // Diminui a durabilidade a cada uso
        setDurabilidade(getDurabilidade() - 1);
        System.out.println("Você usou a ferramenta combinada: " + getNome());
    }
}
