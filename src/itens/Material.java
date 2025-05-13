package itens; // Define que esta classe pertence ao pacote 'itens'

import personagens.Personagem;

// A classe Material é uma subclasse da classe Item
public abstract class Material extends Item {
    private String tipo;
    private int resistencia;

    // Construtor
    public Material(String nome, int peso, int durabilidade, String tipo, int resistencia) {
        super(nome, peso, durabilidade);
        this.tipo = tipo;
        this.resistencia = resistencia;
    }

    // Métodos getters
    public String getTipo() {
        return tipo;
    }

    public int getResistencia() {
        return resistencia;
    }

    // Métodos setters
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    // Método combinar
    public Item combinar(Material outroMaterial) {
        String novoNome = this.getNome() + "-" + outroMaterial.getNome();
        int novoPeso = this.getPeso() + outroMaterial.getPeso();
        int novaDurabilidade = (this.getDurabilidade() + outroMaterial.getDurabilidade()) / 2;
        int eficienciaMedia = (this.resistencia + outroMaterial.resistencia) / 2;

        // Criação da ferramenta combinada
        System.out.println("Você combinou " + this.getNome() + " com " + outroMaterial.getNome()
                + " e criou: " + novoNome);

        // Agora, retornamos uma instância da ferramenta combinada
        return new FerramentaCombinada(novoNome, novoPeso, novaDurabilidade, "Ferramenta Combinada", eficienciaMedia);
    }

    public void usar(Personagem personagem, Material outroMaterial) {
        combinar(outroMaterial);
    }

}

