package sistema;

import gui.system.PainelJogo;

import javax.swing.*;


public class Main { // Define a classe Main, que contém o método principal do programa

    public static void main(String[] args) { // O método main é o ponto de entrada do programa, onde começa a execução do jogo.

        // Criação da janela
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Faz com que o programa termine completamente quando a janela for fechada.
        window.setResizable(false); // Impede que o usuário redimensione a janela.
        window.setTitle("Última Fronteira"); // Define título da janela

        // Criação do painel do jogo
        PainelJogo painelJogo = new PainelJogo();
        window.add(painelJogo); // Adiciona o painel ao JFrame

        window.pack(); // Ajusta o tamanho da janela para o painel
        window.setLocationRelativeTo(null); // Centraliza a janela na tela
        window.setVisible(true); // Torna a janela visível

        painelJogo.setupJogo();
        painelJogo.iniciarThreadJogo();

    }
}
