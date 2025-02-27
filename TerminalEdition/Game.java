package TerminalEdition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {
    private ArrayList<Player> playerList;
    private boolean running = true; // Controle do loop do jogo
    private Player currentPlayer ;
    private Scanner scanner = new Scanner(System.in);
    private Board board = new Board(); // Instância do tabuleiro

    public boolean isRunning() {
        return running; // Retorna o estado do jogo
    }

    public void currentPlayerPositions() throws InterruptedException {
        System.out.println("Posição atual de cada jogador:");
        Thread.sleep(1000);
        for (int i = 0; i < this.playerList.size(); i++) {
            Thread.sleep(1000);
            System.out.println("----------------------");
            currentPlayer = this.playerList.get(i); // Obtém o jogador atual
            System.out.println(currentPlayer.getName() + " está na casa " + currentPlayer.getCountSquare()); // Exibe a posição do jogador
        }
        System.out.println("----------------------");
    }

    public void startGame(ArrayList<Player> playerList) throws InterruptedException {
        this.playerList = playerList; // Inicializa a lista de jogadores
        Collections.shuffle(this.playerList); // Embaralha a lista de jogadores
        board.generateShortcuts(); // Gera atalhos no tabuleiro
        System.out.println("Iniciando o jogo...");
        Thread.sleep(2000);

        while (running) {
            for (int i = 0; i < this.playerList.size(); i++) {
                currentPlayer = this.playerList.get(i); // Define o jogador atual
                System.out.println("É a sua vez, " + currentPlayer.getName() + "!"); // Mensagem de turno
                Thread.sleep(1200);
                int dice = board.rollDice(); // Rolagem do dado
                System.out.println("Jogando o dado...");
                Thread.sleep(1200);

                int exit = board.getExit(); // Obtém a casa de saída
                if (dice == 6) {
                    System.out.println("Você tirou Atalho! Vá para o atalho mais próximo!");
                    Thread.sleep(1200);
                    board.findClosestShortcut(currentPlayer);
                    System.out.println("O atalho te levou para a casa " + exit + "!"); // Exibe a nova posição
                    currentPlayer.setCountSquare(exit); // Atualiza a posição do jogador
                    Thread.sleep(1500); // Pausa após a atualização
                } else {
                    System.out.println("Você andou " + dice + " casa(s)!");
                    currentPlayer.setCountSquare(currentPlayer.getCountSquare() + dice); // Atualiza a posição do jogador
                    if (board.inShortcut(currentPlayer) == true) { // Verifica se o jogador caiu em um atalho
                        System.out.println("Você pegou um atalho!");
                        Thread.sleep(1200);
                        System.out.println("O atalho te levou para a casa " + exit + "!"); // Exibe a nova posição
                        currentPlayer.setCountSquare(exit); // Atualiza a posição do jogador
                    }
                }

                if (currentPlayer.getCountSquare() == board.getBoardSquares()) { // Verifica se o jogador venceu
                    System.out.println(currentPlayer.getName() + " venceu! Parabéns!");
                    running = false; // Encerra o jogo
                    break; // Sai do loop
                }   
            }
            currentPlayerPositions(); // Exibe as posições atuais dos jogadores
            Thread.sleep(2000);
            playAgain(); // Pergunta se deseja jogar novamente
        }
    }

    public void playAgain() throws InterruptedException {
        if (isRunning() == false) { // Verifica se o jogo terminou
            System.out.println("Deseja jogar novamente? [S/N]: ");
            char playAgain = scanner.next().charAt(0); // Lê a resposta do usuário
            if (playAgain == 'S' || playAgain == 's') {
                for (int i = 0; i < this.playerList.size(); i++) {
                    Player player = this.playerList.get(i);
                    player.setCountSquare(0); // Reseta a posição dos jogadores
                }
                running = true; // Reinicia o controle do jogo
                startGame(this.playerList); // Inicia o jogo novamente

            } else if (playAgain == 'N' || playAgain == 'n') {
                System.out.println("Voltando para o menu principal ...");
                Thread.sleep(2000); // Pausa antes de voltar ao menu
            } else {
                System.out.println("Input inválido! Tente novamente."); // Mensagem de entrada inválida
                playAgain(); // Chama novamente a função para perguntar se deseja jogar novamente
            }
        }
    }
}