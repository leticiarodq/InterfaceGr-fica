package itens;

import interfaces.AcaoUsar;
import personagens.Personagem;
import exceptions.FerramentaQuebradaException;

public class FerramentaCombinada extends Ferramenta implements AcaoUsar {

    public FerramentaCombinada(String nome, int peso, int durabilidade, String tipo, int eficiencia) {
        super(nome, peso, durabilidade, tipo, eficiencia);
    }


    @Override
    // Metodo usar com exception (Aplicar Try Catch na GUI)
    public void usar(Personagem personagem) {
        if (getDurabilidade() <= 0) {
            throw new FerramentaQuebradaException("A ferramenta combinada " + getNome() + " está quebrada e não pode ser usada.");
        }
        setDurabilidade(getDurabilidade() - 1);
    }
}
