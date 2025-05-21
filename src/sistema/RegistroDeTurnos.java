/*
package sistema;

import java.util.ArrayList;
import java.util.List;

public class RegistroDeTurnos {

    private final List<String> turnos;

    public RegistroDeTurnos() {
        this.turnos = new ArrayList<>();
    }

    // Adiciona uma entrada de histórico para o turno atual
    public void registrarTurno(String descricao) {
        turnos.add(descricao);
    }

    // Retorna o histórico completo dos turnos
    public List<String> getHistorico() {
        return new ArrayList<>(turnos); // Retorna uma cópia para evitar modificações diretas
    }

    // Retorna a última ação registrada (por exemplo, para exibir no início do próximo turno)
    public String getResumoUltimoTurno() {
        if (turnos.isEmpty()) {
            return "Nenhuma ação registrada ainda.";
        }
        return turnos.get(turnos.size() - 1);
    }

    // Limpa todo o histórico (pode ser usado ao reiniciar o jogo)
    public void limparHistorico() {
        turnos.clear();
    }

    // retorna o número total de turnos registrados
    public int getNumeroDeTurnos() {
        return turnos.size();
    }
}
*/