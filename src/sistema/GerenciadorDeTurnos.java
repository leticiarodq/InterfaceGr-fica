/*
package sistema;

import ambientes.Ambiente;
import ambientes.GerenciadorDeAmbientes;
import eventos.GerenciadorDeEventos;
import eventos.Evento;
import personagens.Personagem;

public class GerenciadorDeTurnos {

    private int turnoAtual = 1;
    private Personagem personagem;
    private Ambiente ambienteAtual;
    private GerenciadorDeAmbientes gerenciadorDeAmbientes;
    private GerenciadorDeEventos gerenciadorDeEventos;
    private RegistroDeTurnos historico;

    public GerenciadorDeTurnos(Personagem personagem, Ambiente ambienteInicial, GerenciadorDeAmbientes ga, GerenciadorDeEventos ge) {
        this.personagem = personagem;
        this.ambienteAtual = ambienteInicial;
        this.gerenciadorDeAmbientes = gerenciadorDeAmbientes;
        this.gerenciadorDeEventos = gerenciadorDeEventos;
        this.historico = new RegistroDeTurnos();
    }

    public void iniciarNovoTurno() {
        faseInicio();
        faseAcao(); // Ação é decidida pela GUI
        faseEventoAleatorio();
        faseManutencao();
        turnoAtual++;
    }

    private void faseInicio() {
        personagem.exibirStatus();
        gerenciadorDeAmbientes.atualizarClima(ambienteAtual);
        historico.registrarInicioTurno(turnoAtual, personagem, ambienteAtual);
    }

    public void faseAcao() {

    //Como depende muito da GUI e não está finalizada ainda está em vazio

    }

    private void faseEventoAleatorio() {
        Evento evento = gerenciadorDeEventos.sortearEvento()(ambienteAtual);
        Evento evento = gerenciadorDeEventos.aplicarEvento()(ambienteAtual);
        if (evento != null) {
            evento.executar(Personagem personagem, Ambiente local);
        }
    }

    private void faseManutencao() {
            int vidaAntes = jogador.getVida();

        jogador.reduzirVida(danoSofrido);     // valor calculado dinamicamente
        jogador.recuperarVida(curaRecebida);  // valor calculado dinamicamente

            // Calcula o saldo final
            int vidaDepois = jogador.getVida();
            int diferenca = vidaDepois - vidaAntes;

            String resumoVida;
            if (diferenca > 0) {
                resumoVida = "Você recuperou " + diferenca + " ponto(s) de vida.";
            } else if (diferenca < 0) {
                resumoVida = "Você perdeu " + (-diferenca) + " ponto(s) de vida.";
            } else {
                resumoVida = "Sua vida permaneceu inalterada.";
            }

            gerenciadorDeAmbientes.modificarRecursos(ambienteAtual);
    }

    public int getTurnoAtual() {
        return turnoAtual;
    }
}
*/