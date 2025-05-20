package interfaces;

import exceptions.SedeCheiaException;
import personagens.Personagem;

public interface AcaoBeber {
    String beber(Personagem personagem) throws SedeCheiaException;
}
