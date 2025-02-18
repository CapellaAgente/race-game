import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {
    private ArrayList<Player> playerList;
    private boolean running = true;
    private Player currentPlayer;
    private Scanner scanner = new Scanner(System.in);
    private Board board = new Board();

    public boolean isRunning() {
        return running;
    }

    public void currentPlayerPositions() throws InterruptedException {
        System.out.println("Posição atual de cada jogador:");
        Thread.sleep(1000);
        for (int i = 0; i < this.playerList.size(); i++) {
            Thread.sleep(1000);
            System.out.println("----------------------");
            currentPlayer = this.playerList.get(i);
            System.out.println(currentPlayer.getName() + " está na casa " + currentPlayer.getCountSquare());
        }
        System.out.println("----------------------");
    }

    public void startGame(ArrayList<Player> playerList) throws InterruptedException {
        this.playerList = playerList;
        Collections.shuffle(this.playerList);
        board.generateShortcuts();
        System.out.println("Iniciando o jogo...");
        Thread.sleep(2000);

        while (running) {
            for (int i = 0; i < this.playerList.size(); i++) {
                currentPlayer = this.playerList.get(i);
                System.out.println("É a sua vez, " + currentPlayer.getName() + "!");
                Thread.sleep(1000);
                int dice = board.rollDice();
                System.out.println("Jogando o dado...");
                Thread.sleep(1000);

                if (dice == 6) {
                    System.out.println("Você tirou Atalho! Vá para o atalho mais próximo!");
                    Thread.sleep(1000);
                    board.findClosestShortcut(currentPlayer);
                    int exit = board.getExit();
                    System.out.println("O atalho te levou para a casa " + exit + "!");
                    currentPlayer.setCountSquare(exit);
                    Thread.sleep(1500);
                } else {
                    System.out.println("Você andou " + dice + " casa(s)!");
                    currentPlayer.setCountSquare(currentPlayer.getCountSquare() + dice);
                    Thread.sleep(1500);
                }

                if (currentPlayer.getCountSquare() == board.getBoardSquares()) {
                    System.out.println(currentPlayer.getName() + " venceu! Parabéns!");
                    running = false;
                    break;
                }   
            }
            currentPlayerPositions();
            Thread.sleep(2000);
            playAgain();
        }
    }

    public void playAgain() throws InterruptedException {
        if (isRunning() == false) {
            System.out.println("Deseja jogar novamente? [S/N]: ");
            char playAgain = scanner.next().charAt(0);
            if (playAgain == 'S' || playAgain == 's') {
                for (int i = 0; i < this.playerList.size(); i++) {
                    Player player = this.playerList.get(i);
                    player.setCountSquare(0);
                }
                running = true;
                startGame(this.playerList);

            } else if (playAgain == 'N' || playAgain == 'n') {
                System.out.println("Voltando para o menu principal...");
                Thread.sleep(2000);

            } else {
                System.out.println("Input inválido! Tente novamente.");
                playAgain();
            }
        }
    }
}
