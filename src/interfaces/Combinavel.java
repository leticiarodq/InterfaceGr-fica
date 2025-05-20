package interfaces;

import exceptions.CombinarException;
import itens.Item;
import itens.Material;

import java.util.List;

public interface Combinavel {
    Item combinar(List<Material> materiais) throws CombinarException;
}
