import java.util.Random;

public class Board {
    private Random random = new Random();

    private int boardSquares = 100;
    private int dice;

    public int rollDice() {
        dice = random.nextInt(1, 7);
        return dice;
    }

    public int getBoardSquares() {
        return boardSquares;
    }
    
    private int exit;

    public int getExit() {
        exit = random.nextInt(5, 100);
        return exit;
    }

    private int shortcut;

    public int getShortcut() {
        shortcut = random.nextInt(5, 100);
        return shortcut;
    }
}