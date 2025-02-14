import java.util.ArrayList;
import java.util.Collections;

public class Game {
    private ArrayList<Player> playerList;
    private boolean running = true;
    private Player currentPlayer;
    private Board board = new Board();

    public boolean isRunning() {
        return running;
    }

    public void startGame(ArrayList<Player> playerList) throws InterruptedException {
        this.playerList = playerList;
        Collections.shuffle(this.playerList);

        System.out.println("Iniciando o jogo...");
        Thread.sleep(2000);
        while (running) {
            for (int i = 0; i < this.playerList.size(); i++) {
                currentPlayer = this.playerList.get(i);
                System.out.println("É sua vez, " + currentPlayer.getName() + "!");
                int dice = board.rollDice();
                System.out.println("Jogando o dado...");
                if (dice == 6) {
                    System.out.println("Você tirou Atalho! Vá para o atalho mais próximo");
                    board.findClosestShortcut(currentPlayer);
                    System.out.println("O atalho te levou para a casa " + board.getExit() + "!");
                } else {
                    System.out.println("Você andou " + dice + " casas!");
                    currentPlayer.setCountSquare(currentPlayer.getCountSquare() + dice);
                    if (currentPlayer.getCountSquare() == board.getBoardSquares()) {
                        System.out.println(currentPlayer.getName() + " venceu o jogo! Parabéns!");
                        running = false;
                    }
                }
            }
        }
    }
}
