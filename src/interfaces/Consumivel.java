package interfaces;

import exceptions.FomeCheiaException;
import personagens.Personagem;

public interface Consumivel {
    String consumir(Personagem personagem) throws FomeCheiaException;
}
