import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        ArrayList<Player> playerList = new ArrayList<>();

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
                            for (int i = 0; i < countBots; i++) {
                                Bot bot = new Bot();
                                playerList.add(bot);
                            }
                            
                            System.out.print("Informe o seu nome:");
                            String playerName = scanner.next();
                            System.out.print("Informe uma cor:");
                            String playerColor = scanner.next();
                            Player player = new Player(playerName, playerColor);
                            playerList.add(player);

                            game.startGame(playerList);
                            if (game.isRunning() == false) {
                                System.out.println("Deseja jogar novamente? [S/N]");
                                char playAgain = scanner.next().charAt(1);
                                if (playAgain == 'S' || playAgain == 's') {
                                    game.startGame(playerList);
                                } else if (playAgain == 'N' || playAgain == 'n') {
                                    System.out.println("Voltando para o menu principal...");
                                }
                            }
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