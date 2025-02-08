import java.util.Random;

public class Bot {
    private Random random = new Random();
    private int countSquare = 0;
    private String[] name = new String[]{"Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Hannah", "Isaac", "Jack", 
                                "Katy", "Leo", "Mia", "Nina", "Oscar", "Paul", "Quinn", "Ryan", "Sara", "Tom", 
                                "Uma", "Victor", "Wendy", "Xander", "Yara", "Zack", "Ava", "Ben", "Cara", "Dan", 
                                "Ella", "Finn", "Gina", "Henry", "Ivy", "Jake", "Kate", "Liam", "Mila", "Noah", 
                                "Olivia", "Parker", "Quincy", "Rose", "Sam", "Tina", "Ursula", "Vince"};

    
    private String[] color = new String[]{"Preto", "Branco", "Cinza", "Vermelho", "Verde", "Azul", "Amarelo", "Laranja", "Rosa", "Roxo",
                   "Marrom", "Bege", "Violeta", "Marinho", "Turquesa", "Salmão", "Dourado", "Prata", "Vinho"};
    
    private String chosenName;
    private String chosenColor;
                   
    public void setName() {
        for (int i = 0; i < name.length; i++) {
            chosenName = name[random.nextInt(name.length)];
        }
    }

    public String getName() {
        return chosenName;
    }

    public void setColor() {
        for (int i = 0; i < color.length; i++) {
            chosenColor = color[random.nextInt(color.length)];
        }
    }

    public String getColor() {
        return chosenColor;
    }

    public void setCountSquare(int countSquare) {
        this.countSquare = countSquare;
    }

    public int getCountSquare() {
        return countSquare;
    }
}