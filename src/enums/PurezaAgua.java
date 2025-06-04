//Pacote
package enums;


// Define os estados de pureza da água no jogo.
// Este enum é mais complexo: cada constante (PURA, CONTAMINADA) carrega consigo
// um atributo (a 'descricao') e um comportamento (o método 'getDescricao').
public enum PurezaAgua {
    PURA("Limpa"),
    CONTAMINADA("Contaminada");

    private String descricao;
    PurezaAgua(String descricao) { this.descricao = descricao; }
    public String getDescricao() { return descricao; }
}