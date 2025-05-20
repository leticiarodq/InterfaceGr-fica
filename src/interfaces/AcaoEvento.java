package interfaces;

import ambientes.Ambiente;
import personagens.Personagem;

public interface AcaoEvento {
    void executar(Personagem personagem, Ambiente local);
}
