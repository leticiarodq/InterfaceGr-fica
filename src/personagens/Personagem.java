package personagens;

import exceptions.*;

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



    public Personagem(String nome, int vida, int fome, int sede, int energia, int sanidade, Inventario inventario, String localizacao, double temperaturaCorporal) {
        this.nome = nome;
        this.vida = vida;
        this.fome = fome;
        this.sede = sede;
        this.energia = energia;
        this.sanidade = sanidade;
        this.inventario = new Inventario(40);
        this.localizacao = localizacao;
        this.temperaturaCorporal = temperaturaCorporal;
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

    public double getTemperaturaCorporal() {
        return temperaturaCorporal;
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

    // Métodos para gastar energia - lança exceção se energia insuficiente
    public void reduzirEnergia(int quantidade) throws EnergiaInsuficienteException {
        if (energia < quantidade) {
            throw new EnergiaInsuficienteException();
        }
        energia -= quantidade;
    }

    // Reduz vida - lança exceção se vida chegar a zero
    public void reduzirVida(int quantidade) throws PersonagemMortoException {
        vida = (vida - quantidade);
        if (vida == 0) {
            throw new PersonagemMortoException();
        }
    }

    // Reduz fome e, se chegar a zero, reduz vida (com exceção se morrer)
    public void reduzirFome(int quantidade) throws PersonagemMortoException {
        fome = (fome - quantidade);
        if (fome == 0) {
            reduzirVida(10);  // Perde vida por fome
        }
    }

    // Reduz sede e, se chegar a zero, reduz vida (com exceção se morrer)
    public void reduzirSede(int quantidade) throws PersonagemMortoException {
        sede = (sede - quantidade);
        if (sede == 0) {
            reduzirVida(15);  // Perde vida por sede
        }
    }

    public void reduzirSanidade(int quantidade) throws PersonagemMortoException {
        sanidade = (sanidade - quantidade);
        if (sanidade == 0) {
            reduzirVida(15); //Perde vida por falta de sanidade
        }
    }

    public void reduzirTemperaturaCorporal(double quantidade) throws PersonagemMortoException {
        temperaturaCorporal -= quantidade;
        if (temperaturaCorporal < 35.0) {
            reduzirVida(15); //Perde vida por baixa da temperatura
        }
    }

    // Recuperação
    public void recuperarVida(int quantidade) throws VidaCheiaException {
        vida =  (vida + quantidade);
    }

    public void recuperarFome(int quantidade) throws FomeCheiaException {
        fome =  (fome + quantidade);
    }

    public void recuperarSede(int quantidade) throws SedeCheiaException {
        sede = (sede + quantidade);
    }

    public void recuperarEnergia(int quantidade) throws EnergiaCheiaException {
        energia = (energia + quantidade);
    }

    public void recuperarSanidade(int quantidade) throws EnergiaCheiaException {
        sanidade = (sanidade + quantidade);
    }

    public void recuperarTemperaturaCorporal(double quantidade) throws PersonagemMortoException {
        temperaturaCorporal += quantidade;
        if (temperaturaCorporal > 42.0) {
          reduzirVida(15); //Perde vida por aumento da temperatura corporal
        }
    }

    public void exibirStatus() {
        System.out.println("Personagem: " + getNome());
        System.out.println("Vida: " + getVida());
        System.out.println("Fome: " + getFome());
        System.out.println("Sede: " + getSede());
        System.out.println("Energia: " + getEnergia());
        System.out.println("Sanidade: " + getSanidade());
        System.out.println("Localização: " + getLocalizacao());

    }


}
