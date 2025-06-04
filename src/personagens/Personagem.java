//Pacote
package personagens;

//Imports
import exceptions.*;
import itens.Arma;

//Classe
public class Personagem {

    private String nome;
    private int vida;
    private int fome;
    private int sede;
    private int energia;
    private int sanidade;
    private Inventario inventario;
    private String localizacao;
    private double temperaturaCorporal = 36.5;
    private int sedeMaxima;
    private int velocidade;
    private boolean desidratado;
    private boolean infectado;
    private boolean delirio;
    private Arma armaEquipada;

    //Construtor
    public Personagem(String nome, int vida, int fome, int sede, int energia, int sanidade, Inventario inventario, String localizacao, int sedeMaxima, int velocidade, boolean desidratado, boolean infectado, boolean delirio, Arma armaEquipada) {
        this.nome = nome;
        this.vida = vida;
        this.fome = fome;
        this.sede = sede;
        this.energia = energia;
        this.sanidade = sanidade;
        this.inventario = inventario;
        if (this.inventario == null) {
            this.inventario = new Inventario(40);}
        this.localizacao = localizacao;
        this.sedeMaxima = sedeMaxima;
        this.velocidade = velocidade;
        this.infectado = infectado;
        this.desidratado = desidratado;
        this.delirio = delirio;
        this.armaEquipada = armaEquipada;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public int getFome() {
        return fome;
    }

    public int getSede() {
        return sede;
    }

    public int getEnergia() {
        return energia;
    }

    public int getSanidade() {
        return sanidade;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public int getSedeMaxima(){
        return sedeMaxima;
    }

    public double getTemperaturaCorporal() {
        return temperaturaCorporal;
    }

    public int getVelocidade(){
        return velocidade;
    }

    public Arma getArmaEquip() {
        return armaEquipada;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setFome(int fome) {
        this.fome = fome;
    }

    public void setSede(int sede) {
        this.sede = sede;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public void setSanidade(int sanidade) {
        this.sanidade = sanidade;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public void setTemperaturaCorporal(double temperaturaCorporal) {
        this.temperaturaCorporal = temperaturaCorporal;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public void setVelocidade(int velocidade){
        this.velocidade = velocidade;
    }

    public void setArmaEquip(Arma arma) {
        this.armaEquipada = arma;
    }

    //Metodos de reduções de atributos + exceções para casos de erros
    public void reduzirEnergia(int quantidade) {
        if (energia < quantidade) {
            throw new EnergiaInsuficienteException();
        }
        energia -= quantidade;
    }

    public void reduzirVida(int quantidade) {
        vida -= quantidade;
        if (vida <= 0) {
            throw new PersonagemMortoException();
        }
    }

    public void reduzirFome(int quantidade) {
        fome -= quantidade;
        if (fome <= 0) {
            reduzirSanidade(10);// Perde vida por fome
        }
    }

    public void reduzirSede(int quantidade) {
        sede -= quantidade;
        if (sede <= 0) {
            reduzirSanidade(15);  // Perde vida por sede
        }
    }

    public void reduzirSanidade(int quantidade) {
        sanidade -= quantidade;
        if (sanidade <= 0) {
            reduzirVida(15);  // Perde vida por falta de sanidade
        }
    }

    public void reduzirTemperaturaCorporal(double quantidade) {
        temperaturaCorporal -= quantidade;
        if (temperaturaCorporal < 35.0) {
            reduzirVida(15);  // Perde vida por baixa da temperatura
        }

    }


    //Metodos de recuperações de atributos + exceções para casos de erros
    public void recuperarVida(int quantidade) {
        vida += quantidade;
        if (vida > 100) {
            throw new VidaCheiaException("A vida já está cheia!");
        }
    }

    public void recuperarFome(int quantidade) {
        fome += quantidade;
        if (fome > 100) {
            throw new FomeCheiaException("A fome já está cheia!");
        }
    }

    public void recuperarSede(int quantidade) {
        sede += quantidade;
        if (sede > 100) {
            throw new SedeCheiaException("A sede já está cheia!");
        }
    }

    public void recuperarEnergia(int quantidade) {
        energia += quantidade;
        if (energia > 100) {
            throw new EnergiaCheiaException("A energia já está cheia!");
        }
    }

    public void recuperarSanidade(int quantidade) {
        sanidade += quantidade;
        if (sanidade > 100) {
            throw new SanidadeCheiaException("A sanidade já está cheia!");
        }
    }

    public void recuperarTemperaturaCorporal(double quantidade) {
        temperaturaCorporal += quantidade;
        if (temperaturaCorporal > 42.0) {
            reduzirVida(15); // Perde vida por aumento da temperatura corporal
        }
    }

    //Método para exibir status na aplicação da GUI
    public String obterStatus() {
        StringBuilder status = new StringBuilder();
        status.append("Personagem: ").append(getNome()).append("\n");
        status.append("Vida: ").append(getVida()).append("\n");
        status.append("Fome: ").append(getFome()).append("\n");
        status.append("Sede: ").append(getSede()).append("\n");
        status.append("Energia: ").append(getEnergia()).append("\n");
        status.append("Sanidade: ").append(getSanidade()).append("\n");
        status.append("Localização: ").append(getLocalizacao()).append("\n");
        status.append("Temperatura Corporal: ").append(getTemperaturaCorporal()).append(("n"));
        status.append("Velocidade: ").append(getVelocidade()).append(("n"));
        return status.toString();
    }

    //Métodos boolean para identificação do EventoDoencaFerimento no personagem
    public boolean isDesidratado() { return desidratado; }

    public boolean isDelirando() {
        return delirio;
    }

    public boolean isInfectado() { return infectado; }

    public void setDesidratado(boolean desidratado) { this.desidratado = desidratado; }

    public void setInfectado(boolean infectado) { this.infectado = infectado; }

    public void setDelirando(boolean delirio) {
        this.delirio = delirio;
    }

    //Método de ataque a criaturas baseado atacar com arma ou sem a arma
    public void atacar(Criatura inimigo) {
        if (armaEquipada != null) {
            armaEquipada.atacar(inimigo);
        } else {
            int danoMao = 10; // dano padrão sem arma
            inimigo.receberDano(danoMao);
        }
    }


}
