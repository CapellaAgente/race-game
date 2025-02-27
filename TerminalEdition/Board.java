package TerminalEdition;

import java.util.ArrayList;
import java.util.Random;

public class Board {
    private Random random = new Random(); // Gerador de números aleatórios
    private int boardSquares = 100; // Total de casas no tabuleiro
    private int dice;
    private ArrayList<Integer> shortcuts = new ArrayList<>(); // Lista de atalhos
    private int exit;

    public int rollDice() {
        dice = random.nextInt(1, 7); // Rolagem do dado (1 a 6)
        return dice; // Retorna o valor do dado
    }

    public int getBoardSquares() {
        return boardSquares; // Retorna o total de casas no tabuleiro
    }
    
    public int getExit() {
        exit = random.nextInt(5, 100); // Gera uma casa de saída aleatória
        return exit; // Retorna a casa de saída
    }

    private int shortcut; // Atalho

    public int getShortcut() {
        shortcut = random.nextInt(5, 100); // Gera um atalho aleatório
        return shortcut; // Retorna o atalho gerado
    }
    
    public String generateShortcuts() {
        for (int i = 0; i < 5; i++) {
            int shortcutSquare = getShortcut();
            shortcuts.add(shortcutSquare); // Adiciona o atalho à lista
        }
        // System.out.println(shortcuts); // Exibe os atalhos gerados
        return "Atalhos gerados!"; // Mensagem de confirmação
    }
    
    public int findClosestShortcut(Player currentPlayer) {
        int currentSquare = currentPlayer.getCountSquare(); // Posição atual do jogador
        int minDifference = Integer.MAX_VALUE; // Inicializa a diferença mínima
        int closestShortcut = -1; // Inicializa o atalho mais próximo

        for (int shortcut : shortcuts) {
            int difference = Math.abs(shortcut - currentSquare); // Calcula a diferença
            if (difference < minDifference) { // Verifica se é o menor atalho
                minDifference = difference; // Atualiza a diferença mínima
                closestShortcut = shortcut; // Atualiza o atalho mais próximo
            }
        }
        return closestShortcut; // Retorna o atalho mais próximo
    }

    public boolean inShortcut(Player currentPlayer) {
        for (int shortcut : shortcuts) {
            if (currentPlayer.getCountSquare() == shortcut) { // Verifica se o jogador está em um atalho
                return true; // Retorna verdadeiro se estiver em um atalho
            }
        }
        return false; // Retorna falso se não estiver em um atalho
    }
}