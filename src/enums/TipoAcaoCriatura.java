//Pacote
package enums;

// Define o estado de tipo de ação da criatura
public enum TipoAcaoCriatura {
    MORDIDA("Ataca com mordida"),
    GARRAS("Ataca com garras"),
    PICA_VENENO("Pica com veneno"),
    VOA("Apenas voa"),
    CAMINHA("Apenas caminha"),
    NADA("Apenas nada"),
    PULA("Apenas se locomove pulando");

    private String descricao;

    TipoAcaoCriatura(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}