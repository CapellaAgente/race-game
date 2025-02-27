package TerminalEdition;

import java.util.Random;

public class Bot extends Player {
    private Random random = new Random(); // Gerador de números aleatórios
    private int countSquare = 0; // Posição do bot no tabuleiro
    private String[] name = new String[]{"Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Hannah", "Isaac", "Jack", 
                                "Katy", "Leo", "Mia", "Nina", "Oscar", "Paul", "Quinn", "Ryan", "Sara", "Tom", 
                                "Uma", "Victor", "Wendy", "Xander", "Yara", "Zack", "Ava", "Ben", "Cara", "Dan", 
                                "Ella", "Finn", "Gina", "Henry", "Ivy", "Jake", "Kate", "Liam", "Mila", "Noah", 
                                "Olivia", "Parker", "Quincy", "Rose", "Sam", "Tina", "Ursula", "Vince"}; 

    private String[] color = new String[]{"Preto", "Branco", "Cinza", "Vermelho", "Verde", "Azul", "Amarelo", "Laranja", "Rosa", "Roxo",
                   "Marrom", "Bege", "Violeta", "Marinho", "Turquesa", "Salmão", "Dourado", "Prata", "Vinho"};
    
    private String chosenName;
    private String chosenColor; 

    public Bot() {
        super("", ""); // Chama o construtor da classe pai com valores vazios
        setName(); // Define o nome do bot
        setColor(); // Define a cor do bot
    }
                   
    public void setName() {
        chosenName = name[random.nextInt(name.length)]; // Escolhe um nome aleatório da lista
    }

    public String getName() {
        return chosenName; // Retorna o nome do bot
    }

    public void setColor() {
        chosenColor = color[random.nextInt(color.length)]; // Escolhe uma cor aleatória da lista
    }

    public String getColor() {
        return chosenColor; // Retorna a cor do bot
    }

    public void setCountSquare(int countSquare) {
        this.countSquare = countSquare; // Define a posição do bot no tabuleiro
    }

    public int getCountSquare() {
        return countSquare; // Retorna a posição do bot no tabuleiro
    }
}