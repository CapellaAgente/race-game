package TerminalEdition;

public class Player {
    private String name;
    private String color;
    private int countSquare = 0;

    public Player(String name, String color) {
        this.name = name;
        this.color = color;
        setName(this.name);
        setColor(this.color);
    }

    public void setName(String name) {
        this.name = name; // Define o nome do jogador
    }

    public String getName() {
        return name; // Retorna o nome do jogador
    }

    public void setColor(String color) {
        this.color = color; // Define a cor do jogador
    }

    public String getColor() {
        return color; // Retorna a cor do jogador
    }

    public void setCountSquare(int countSquare) {
        this.countSquare = countSquare; // Define a posição do jogador no tabuleiro
    }

    public int getCountSquare() {
        return countSquare; // Retorna a posição do jogador no tabuleiro
    }
}