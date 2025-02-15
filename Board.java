import java.util.ArrayList;
import java.util.Random;

public class Board {
    private Random random = new Random();

    private int boardSquares = 100;
    private int dice;

    private ArrayList<Integer> shortcuts = new ArrayList<>();
    private int exit;

    public int rollDice() {
        dice = random.nextInt(1, 7);
        return dice;
    }

    public int getBoardSquares() {
        return boardSquares;
    }
    
    public int getExit() {
        exit = random.nextInt(5, 100);
        return exit;
    }

    private int shortcut;

    public int getShortcut() {
        shortcut = random.nextInt(5, 100);
        return shortcut;
    }

    public String generateShortcuts() {
        for (int i = 0; i < 5; i++) {
            int shortcutSquare = getShortcut();
            shortcuts.add(shortcutSquare);
        }
        return "Atalhos gerados!";
    }

    public int findClosestShortcut(Player currentPlayer) {
        int currentSquare = currentPlayer.getCountSquare();
        int minDifference = Integer.MAX_VALUE;
        int closestShortcut = -1;

        for (int shortcut : shortcuts) {
            int difference = Math.abs(shortcut - currentSquare);
            if (difference < minDifference) {
                minDifference = difference;
                closestShortcut = shortcut;
            }
        }
        return closestShortcut;
    }
    
}