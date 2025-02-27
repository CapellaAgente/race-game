package TerminalEdition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game(); // Instancia o objeto do jogo
        ArrayList<Player> playerList = new ArrayList<>(); // Lista para armazenar os jogadores
        boolean running = true; // Controle do loop principal
        System.out.println("Carregando...");
        Thread.sleep(3000); // Simula um carregamento

        while (running) {
            System.out.println("======= CORRIDA E ATALHOS =======");
            System.out.println("""
                    [1] Jogar
                    [2] Sair
                    """);
            
            int userInput = 0;
            try {
                userInput = scanner.nextInt(); // Lê a entrada do usuário
                if (userInput == 1 || userInput == 2) {
                    // Entrada válida, o código continua a partir daqui
                } else {
                    System.out.println("Você digitou algo diferente de 1 ou 2. Tente novamente.");
                    continue; // Retorna ao início do loop
                }
            } catch (InputMismatchException e) {
                System.out.println("Você digitou algo diferente de 1 ou 2. Tente novamente.");
                scanner.next(); // Limpa a entrada inválida
                continue; // Retorna ao início do loop
            }
   
            switch (userInput) {
                case 1: // Jogar
                    Thread.sleep(1500);
                    System.out.println("MODO DE JOGO =============");
                    System.out.println("""
                            [1] Sozinho (com bots)
                            [2] Multiplayer Local
                            [3] Voltar
                            """);
                    
                    int userMenuInput = 0;
                    boolean validEntry = false; // Controle de entrada válida
                    while (!validEntry) {
                        try {
                            userMenuInput = scanner.nextInt(); // Lê a entrada do usuário para o modo de jogo
                            if (userMenuInput == 1 || userMenuInput == 2 || userMenuInput == 3) {
                                validEntry = true; // Entrada válida
                            } else {
                                System.out.println("Você digitou algo diferente do que 1, 2 ou 3. Tente novamente.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Você digitou algo diferente do que 1, 2 ou 3. Tente novamente.");
                            scanner.next(); // Limpa a entrada inválida
                        }
                    } 
                    
                    switch (userMenuInput) {
                        case 1: // Modo Sozinho
                            Thread.sleep(1500);
                            System.out.print("Digite quantos bots estarão na partida (máximo 4): ");
                            int countBots = 0;
                            boolean countEntry = false; // Controle de entrada para a quantidade de bots
                            while (!countEntry) {
                                try {
                                    countBots = scanner.nextInt(); // Lê a quantidade de bots
                                    if (countBots < 1) {
                                        System.out.println("2 jogadores no mínimo são necessários para iniciar a partida!");
                                    } else if (countBots > 4) {
                                        System.out.println("É permitido somente até 5 jogadores na partida!");
                                    } else {
                                        countEntry = true; // Entrada válida
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Você digitou algo diferente do que os números entre 1 e 4. Tente novamente.");
                                    scanner.next(); // Limpa a entrada inválida
                                }
                            }

                            // Adiciona os bots à lista de jogadores
                            for (int i = 0; i < countBots; i++) {
                                Bot bot = new Bot(); // Cria um novo bot
                                playerList.add(bot); // Adiciona o bot à lista de jogadores
                            }
                            
                            System.out.print("Informe o seu nome: ");
                            String playerName = scanner.next(); // Lê o nome do jogador
                            System.out.print("Informe uma cor: ");
                            String playerColor = scanner.next(); // Lê a cor do jogador
                            Player player = new Player(playerName, playerColor); // Cria um novo jogador
                            playerList.add(player); // Adiciona o jogador à lista

                            game.startGame(playerList); // Inicia o jogo
                            break;

                        case 2: // Modo Multiplayer Local
                            Thread.sleep(1500);
                            System.out.print("Informe a quantidade de jogadores (máximo 5): ");
                            int countPlayers = 0;
                            boolean playerEntry = false; // Controle de entrada para a quantidade de jogadores
                            while (!playerEntry) {
                                try {
                                    countPlayers = scanner.nextInt(); // Lê a quantidade de jogadores
                                    if (countPlayers < 1) {
                                        System.out.println("2 jogadores no mínimo são necessários para iniciar a partida!");
                                    } else if (countPlayers > 5) {
                                        System.out.println("É permitido somente até 5 jogadores na partida!");
                                    } else {
                                        playerEntry = true; // Entrada válida
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Você digitou algo diferente do que números entre 1 e 5. Tente novamente.");
                                    scanner.next(); // Limpa a entrada inválida
                                }
                            }

                            // Adiciona os jogadores à lista
                            for (int i = 0; i < countPlayers; i++) {
                                System.out.println("==== JOGADOR " + i + " ====");
                                System.out.print("Informe o seu nome: ");
                                String localPlayerName = scanner.next(); 
                                System.out.print("Informe a cor: ");
                                String localColorName = scanner.next();
                                Player newPlayer = new Player(localPlayerName, localColorName); // Cria um novo jogador
                                playerList.add(newPlayer); // Adiciona o jogador à lista
                            }

                            game.startGame(playerList); // Inicia o jogo
                            break;

                        case 3: // Voltar ao menu principal
                            System.out.println("Voltando para o menu principal...");
                            Thread.sleep(1500);
                            break;

                        default:
                            break;
                    }
                    break;

                case 2: // Sair do jogo
                    System.out.println("Saindo...");
                    running = false; // Encerra o loop
                    Thread.sleep(2000);
                    break;

                default:
                    running = false; // Encerra o loop
                    break;
            }
            
        }
        scanner.close(); // Fecha o scanner
    }
}