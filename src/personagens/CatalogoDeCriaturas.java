//Pacote
package personagens;

//Import
import enums.TipoAcaoCriatura;

import java.util.ArrayList;
import java.util.List;

//Classe CatalogoDeCriaturas (Necessário para aplicar na GUI)
public class CatalogoDeCriaturas {
    private List<Criatura> criaturas;

    //Construtor
    public CatalogoDeCriaturas() {
        this.criaturas = new ArrayList<>();
        inicializarCriaturas();
    }

    //Método para inicializar(instanciar) todas as criaturas do jogo
    private void inicializarCriaturas() {
        criaturas.add(new Criatura("Lobo", 2, 6, TipoAcaoCriatura.MORDIDA));
        criaturas.add(new Criatura("Urso", 4, 10, TipoAcaoCriatura.GARRAS ));
        criaturas.add(new Criatura("Aranha", 2, 8, TipoAcaoCriatura.PICA_VENENO ));
        criaturas.add(new Criatura("Morcego", 1, 2, TipoAcaoCriatura.VOA ));
        criaturas.add(new Criatura("Porco", 0, 4, TipoAcaoCriatura.CAMINHA ));
        criaturas.add(new Criatura("Galinha", 0, 2, TipoAcaoCriatura.CAMINHA ));
        criaturas.add(new Criatura("Peixe", 0, 2, TipoAcaoCriatura.NADA ));
        criaturas.add(new Criatura("Coelho", 0, 2, TipoAcaoCriatura.PULA ));
    }

    //Retorna a lista de criaturas(para exibir na GUI)
    public List<Criatura> getCriaturas() {
        return criaturas;
    }

    //Getter especifico para pegar cada criatura pelo seu nome
    public Criatura getCriaturaPorNome(String nome) {
        for (Criatura c : criaturas) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        return null;
    }
}
