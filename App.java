import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("======= CORRIDA E ATALHOS =======");
            System.out.println("""
                    [1] Jogar
                    [2] Sair
                    """);
            
            int userInput = scanner.nextInt();

            switch (userInput) {
                case 1:
                    System.out.println("MODO DE JOGO =============");
                    System.out.println("""
                            [1] Sozinho (com bots)
                            [2] Multiplayer Local
                            [3] Voltar
                            """);
                    
                    int userMenuInput = scanner.nextInt();

                    switch (userMenuInput) {
                        case 1:
                            System.out.print("Digite quantos bots estarão na partida (máximo 4): ");
                            System.out.println();
                            int countBots = scanner.nextInt();
                            ArrayList<Bot> playerList = new ArrayList<>();
                            for (int i = 0; i < countBots; i++) {
                                Bot bot = new Bot();
                                bot.setName();
                                bot.setColor();
                                playerList.add(bot);
                            }
                            
                            Player player = new Player();
                            System.out.println("Informe o seu nome:");
                            String playerName = scanner.nextLine();
                            player.setName(playerName);
                            System.out.println("Informe uma cor:");
                            String playerColor = scanner.nextLine();
                            player.setColor(playerColor);
                            break;

                        case 2:

                            break;

                        case 3:
                            break;
                        default:
                            break;
                    }
                    break;

                case 2:
                    System.out.println("Saindo...");
                    running = false;
                    break;

                default:
                    running = false;
                    break;
            }
            
        }
        scanner.close();
    }
}