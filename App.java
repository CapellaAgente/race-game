import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        ArrayList<Player> playerList = new ArrayList<>();
        boolean running = true;
        System.out.println("Carregando...");
        Thread.sleep(3000);
        while (running) {
            System.out.println("======= CORRIDA E ATALHOS =======");
            System.out.println("""
                    [1] Jogar
                    [2] Sair
                    """);
            
            int userInput = scanner.nextInt();
            Thread.sleep(1500);
            switch (userInput) {
                case 1:
                    System.out.println("MODO DE JOGO =============");
                    System.out.println("""
                            [1] Sozinho (com bots)
                            [2] Multiplayer Local
                            [3] Voltar
                            """);
                    
                    int userMenuInput = scanner.nextInt();
                    Thread.sleep(1500);
                    switch (userMenuInput) {
                        case 1:
                            System.out.print("Digite quantos bots estarão na partida (máximo 4): ");
                            int countBots = scanner.nextInt();
                            for (int i = 0; i < countBots; i++) {
                                Bot bot = new Bot();
                                playerList.add(bot);
                            }
                            
                            System.out.print("Informe o seu nome: ");
                            String playerName = scanner.next();
                            System.out.print("Informe uma cor: ");
                            String playerColor = scanner.next();
                            Player player = new Player(playerName, playerColor);
                            playerList.add(player);

                            game.startGame(playerList);
                            if (game.isRunning() == false) {
                                System.out.println("Deseja jogar novamente? [S/N]: ");
                                char playAgain = scanner.next().charAt(0);
                                if (playAgain == 'S' || playAgain == 's') {
                                    game.startGame(playerList);

                                } else if (playAgain == 'N' || playAgain == 'n') {
                                    System.out.println("Voltando para o menu principal...");
                                    Thread.sleep(2000);
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
                    Thread.sleep(2000);
                    break;

                default:
                    running = false;
                    break;
            }
            
        }
        scanner.close();
    }
}