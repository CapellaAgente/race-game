import java.util.ArrayList;
import java.util.InputMismatchException;
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
            
            int userInput = 0;
            try {
                userInput = scanner.nextInt();
                if (userInput == 1 || userInput == 2) {
                    // Valid entry, code continues from here
                } else {
                    System.out.println("Você digitou algo diferente de 1 ou 2. Tente novamente.");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Você digitou algo diferente de 1 ou 2. Tente novamente.");
                scanner.next();
                continue;
            }
   
            switch (userInput) {
                case 1:
                    Thread.sleep(1500);
                    System.out.println("MODO DE JOGO =============");
                    System.out.println("""
                            [1] Sozinho (com bots)
                            [2] Multiplayer Local
                            [3] Voltar
                            """);
                    
                    int userMenuInput = 0;
                    boolean validEntry = false;
                    while (!validEntry) {
                        try {
                            userMenuInput = scanner.nextInt();
                            if (userMenuInput == 1 || userMenuInput == 2 || userMenuInput == 3) {
                                validEntry = true; // Valid entry, code continues from here

                            } else {
                                System.out.println("Você digitou algo diferente do que 1, 2 ou 3. Tente novamente.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Você digitou algo diferente do que 1, 2 ou 3. Tente novamente.");
                            scanner.next();
                        }
                    }
                    
                        
                    Thread.sleep(1500);
                    switch (userMenuInput) {
                        case 1:
                            System.out.print("Digite quantos bots estarão na partida (máximo 4): ");
                            int countBots = 0;
                            boolean countEntry = false;
                            while (!countEntry) {
                                try {
                                    countBots = scanner.nextInt();
                                    if (countBots < 1) {
                                        System.out.println("2 jogadores no mínimo são necessários para iniciar a partida!");

                                    } else if (countBots > 4) {
                                        System.out.println("É permitido somente até 5 jogadores na partida!");
                                    } else {
                                        countEntry = true;
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Você digitou algo diferente do que os números entre 1 e 4. Tente novamente.");
                                    scanner.next();
                                }
                            }

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
                                } else {
                                    System.out.println("Input inválido! Tente novamente.");
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