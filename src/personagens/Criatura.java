//Pacote
package personagens;

//Import
import enums.TipoAcaoCriatura;

//Classe Criatura
public class Criatura {
    private String nome;
    private int nivelPerigo;
    private double vida;
    private TipoAcaoCriatura tipoAcao;

    //Construtor
    public Criatura(String nome, int nivelPerigo, double vida, TipoAcaoCriatura acao) {
        this.nome = nome;
        this.nivelPerigo = nivelPerigo;
        this.vida = vida;
        this.tipoAcao = tipoAcao;
    }

    //Getters
    public String getAcaoDescricao() {
        return tipoAcao.getDescricao();
    }

    public TipoAcaoCriatura getTipoAcao() {
        return tipoAcao;
    }

    public String getNome() {
        return nome;
    }

    public int getNivelPerigo() {
        return nivelPerigo;
    }

    public double getVida() {
        return vida;
    }

    //Setter
    public void setVida(double vida) {
        this.vida = Math.max(0, vida);
    }

    //Método de receber dano do ataque de qualquer personagem(mecanico, rastreador, sobreviventenato, medico)
    public void receberDano(double dano) {
        this.vida = Math.max(0, this.vida - dano);
    }
}
