/*
package sistema;

import ambientes.Ambiente;
import ambientes.GerenciadorDeAmbientes;
import eventos.GerenciadorDeEventos;
import eventos.Evento;
import personagens.Personagem;

public class GerenciadorDeTurnos {

    private int turnoAtual = 1;
    private Personagem jogador;
    private Ambiente ambienteAtual;
    private GerenciadorDeAmbientes gerenciadorDeAmbientes;
    private GerenciadorDeEventos gerenciadorDeEventos;
    private RegistroDeTurnos historico;

    public GerenciadorDeTurnos(Personagem jogador, Ambiente ambienteInicial, GerenciadorDeAmbientes ga, GerenciadorDeEventos ge) {
        this.jogador = jogador;
        this.ambienteAtual = ambienteInicial;
        this.gerenciadorDeAmbientes = ga;
        this.gerenciadorDeEventos = ge;
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
        jogador.obterNome();
        jogador.obterSede();
        jogador.obterEnergia();
        jogador.obterVida();
        jogador.obterSanidade();
        jogador.obterLocalizacao();
        jogador.obterTemperaturaCorporal();
        gerenciadorDeAmbientes.atualizarClima(ambienteAtual);
        historico.registrarInicioTurno(turnoAtual, jogador, ambienteAtual);
    }

    public void faseAcao() {

    }

    private void faseEventoAleatorio() {
        Evento evento = gerenciadorDeEventos.gerarEventoAleatorio(ambienteAtual);
        if (evento != null) {
            evento.executar(jogador, ambienteAtual);
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