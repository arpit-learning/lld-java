package com.example.projects.ticTacToeSystemDesign;

import com.example.projects.ticTacToeSystemDesign.controllers.GameController;
import com.example.projects.ticTacToeSystemDesign.exceptions.*;
import com.example.projects.ticTacToeSystemDesign.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            runGame();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }

    private static void runGame() {
        int id = 1;
        List<Player> players = new ArrayList<>();

        System.out.println("========================================");
        System.out.println("   Welcome to Tic Tac Toe Game!");
        System.out.println("========================================");
        System.out.println();

        // Get board dimension with validation
        int dimension = getValidDimension();
        GameController gc = new GameController(dimension, sc);

        // Get bot preference with validation
        boolean hasBot = getBotPreference();
        BotDifficultyLevel botDifficulty = null;
        
        if (hasBot) {
            botDifficulty = getBotDifficulty();
            Bot bot = new Bot(id++, "Bot", '$', PlayerType.BOT, botDifficulty);
            players.add(bot);
        }

        // Get player information with validation
        while (id < dimension) {
            System.out.println("\n--- Player " + id + " Setup ---");
            String name = getValidPlayerName(id);
            char symbol = getValidPlayerSymbol(id, players);
            players.add(new Player(id++, name, symbol, PlayerType.HUMAN));
        }

        // Create and start game
        try {
            Collections.shuffle(players);
            Game game = gc.createNewGame(dimension, players);
            playGame(gc, game, players);
            
            // After game ends, offer replay
            offerReplay(gc, game);
            
        } catch (InvalidBoardDimensionException e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("Please restart the game with a valid dimension (3-10).");
        } catch (InvalidNumberOfPlayersException e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("Please restart the game with the correct number of players.");
        } catch (DuplicateSymbolsException e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("Please restart the game and ensure all players have unique symbols.");
        } catch (InvalidNumberOfBotsException e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("Please restart the game with at most one bot.");
        }
    }

    private static int getValidDimension() {
        while (true) {
            try {
                System.out.print("Please enter the dimension for the board (3-10): ");
                int dimension = sc.nextInt();
                sc.nextLine(); // Consume newline
                
                if (dimension < 3 || dimension > 10) {
                    System.err.println("Error: Dimension must be between 3 and 10. Please try again.");
                    continue;
                }
                return dimension;
            } catch (InputMismatchException e) {
                System.err.println("Error: Invalid input. Please enter a valid integer number.");
                sc.nextLine(); // Clear invalid input
            }
        }
    }

    private static boolean getBotPreference() {
        while (true) {
            try {
                System.out.print("Do you want a bot in the game? (y/n): ");
                String botAns = sc.next().trim();
                sc.nextLine(); // Consume newline
                
                if (botAns.equalsIgnoreCase("Y") || botAns.equalsIgnoreCase("YES")) {
                    return true;
                } else if (botAns.equalsIgnoreCase("N") || botAns.equalsIgnoreCase("NO")) {
                    return false;
                } else {
                    System.err.println("Error: Please enter 'y' for yes or 'n' for no.");
                }
            } catch (Exception e) {
                System.err.println("Error: Invalid input. Please try again.");
                sc.nextLine(); // Clear invalid input
            }
        }
    }

    private static BotDifficultyLevel getBotDifficulty() {
        while (true) {
            try {
                System.out.println("\nSelect bot difficulty level:");
                System.out.println("1. Easy");
                System.out.println("2. Medium");
                System.out.println("3. Hard");
                System.out.print("Enter your choice (1-3): ");
                
                int choice = sc.nextInt();
                sc.nextLine(); // Consume newline
                
                switch (choice) {
                    case 1:
                        return BotDifficultyLevel.EASY;
                    case 2:
                        return BotDifficultyLevel.MEDIUM;
                    case 3:
                        return BotDifficultyLevel.HARD;
                    default:
                        System.err.println("Error: Please enter a number between 1 and 3.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Error: Invalid input. Please enter a valid number.");
                sc.nextLine(); // Clear invalid input
            }
        }
    }

    private static String getValidPlayerName(int playerId) {
        while (true) {
            try {
                System.out.print("Please enter the name of player " + playerId + ": ");
                String name = sc.nextLine().trim();
                
                if (name == null || name.isEmpty()) {
                    System.err.println("Error: Player name cannot be empty. Please try again.");
                    continue;
                }
                if (name.length() > 50) {
                    System.err.println("Error: Player name is too long (max 50 characters). Please try again.");
                    continue;
                }
                return name;
            } catch (Exception e) {
                System.err.println("Error: Invalid input. Please try again.");
            }
        }
    }

    private static char getValidPlayerSymbol(int playerId, List<Player> existingPlayers) {
        while (true) {
            try {
                System.out.print("Please enter the symbol for player " + playerId + " (single character): ");
                String input = sc.nextLine().trim();
                
                if (input == null || input.isEmpty()) {
                    System.err.println("Error: Symbol cannot be empty. Please try again.");
                    continue;
                }
                if (input.length() > 1) {
                    System.err.println("Error: Symbol must be a single character. Please try again.");
                    continue;
                }
                
                char symbol = input.charAt(0);
                
                // Check for duplicate symbols
                boolean isDuplicate = existingPlayers.stream()
                    .anyMatch(p -> p.getSymbol() == symbol);
                
                if (isDuplicate) {
                    System.err.println("Error: This symbol is already taken by another player. Please choose a different symbol.");
                    continue;
                }
                
                return symbol;
            } catch (Exception e) {
                System.err.println("Error: Invalid input. Please try again.");
            }
        }
    }

    private static void playGame(GameController gc, Game game, List<Player> players) {
        int playerInd = -1;
        List<GameStatus> allowedStates = new ArrayList<>(List.of(GameStatus.YET_TO_START, GameStatus.RUNNING));
        
        System.out.println("\n========================================");
        System.out.println("Game Started! Let's play!");
        System.out.println("========================================\n");
        
        while (allowedStates.contains(gc.getGameStatus(game))) {
            try {
                gc.updateGameStatus(game, GameStatus.RUNNING);
                playerInd++;
                playerInd = playerInd % players.size();
                
                Player currentPlayer = players.get(playerInd);
                System.out.println("\n--- " + currentPlayer.getName() + "'s Turn (Symbol: " + currentPlayer.getSymbol() + ") ---");
                gc.displayBoard(game);
                
                // Show game menu
                showGameMenu();
                
                Move executedMove = null;
                boolean moveSuccessful = false;
                
                while (!moveSuccessful) {
                    try {
                        String choice = sc.nextLine().trim().toLowerCase();
                        
                        if (choice.equals("u") || choice.equals("undo")) {
                            try {
                                gc.undoMove(game);
                                // Go back to previous player
                                playerInd = (playerInd - 1 + players.size()) % players.size();
                                gc.displayBoard(game);
                                System.out.println("Move undone. " + players.get(playerInd).getName() + "'s turn again.");
                                showGameMenu();
                                continue;
                            } catch (NoMovesToUndoException e) {
                                System.err.println("Error: " + e.getMessage());
                                showGameMenu();
                                continue;
                            }
                        } else if (choice.equals("q") || choice.equals("quit")) {
                            System.out.println("Game quit by user.");
                            return;
                        } else {
                            // Execute move
                            executedMove = gc.executeMove(game, currentPlayer);
                            moveSuccessful = true;
                        }
                    } catch (InvalidInputException e) {
                        System.err.println("Error: " + e.getMessage());
                        System.err.println("Please try again.");
                        showGameMenu();
                    } catch (InvalidRowException e) {
                        System.err.println("Error: " + e.getMessage());
                        System.err.println("Please try again.");
                        showGameMenu();
                    } catch (InvalidColumnException e) {
                        System.err.println("Error: " + e.getMessage());
                        System.err.println("Please try again.");
                        showGameMenu();
                    } catch (CellAlreadyFilledException e) {
                        System.err.println("Error: " + e.getMessage());
                        System.err.println("Please try again.");
                        showGameMenu();
                    } catch (GameNotInProgressException e) {
                        System.err.println("Error: " + e.getMessage());
                        return;
                    }
                }
                
                // Store board state after move
                gc.addOldBoardState(game);
                
                // Check for winner
                try {
                    Player winner = gc.checkWinner(game, executedMove);
                    if (winner != null) {
                        System.out.println("\n========================================");
                        System.out.println("🎉 Winner is: " + winner.getName() + " with symbol: " + winner.getSymbol() + " 🎉");
                        System.out.println("========================================\n");
                        gc.updateGameStatus(game, GameStatus.WIN);
                        gc.displayBoard(game);
                        break;
                    }
                } catch (DrawGameException e) {
                    System.out.println("\n========================================");
                    System.out.println("🤝 Game is a DRAW! 🤝");
                    System.out.println("========================================\n");
                    gc.updateGameStatus(game, GameStatus.DRAW);
                    gc.displayBoard(game);
                    break;
                }
                
                // Check if board is full (draw condition)
                if (gc.isBoardFull(game)) {
                    System.out.println("\n========================================");
                    System.out.println("🤝 Game is a DRAW! Board is full. 🤝");
                    System.out.println("========================================\n");
                    gc.updateGameStatus(game, GameStatus.DRAW);
                    gc.displayBoard(game);
                    break;
                }
                
            } catch (InvalidPlayerException e) {
                System.err.println("Error: " + e.getMessage());
                return;
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
                return;
            } catch (Exception e) {
                System.err.println("An unexpected error occurred during gameplay: " + e.getMessage());
                e.printStackTrace();
                return;
            }
        }
    }

    private static void showGameMenu() {
        System.out.println("\nOptions:");
        System.out.println("  - Enter row and column to make a move");
        System.out.println("  - Type 'u' or 'undo' to undo last move");
        System.out.println("  - Type 'q' or 'quit' to quit the game");
        System.out.print("Your choice: ");
    }

    private static void offerReplay(GameController gc, Game game) {
        while (true) {
            try {
                System.out.println("\n========================================");
                System.out.println("Game Over!");
                System.out.println("========================================");
                System.out.println("Options:");
                System.out.println("  1. Replay the game");
                System.out.println("  2. Start a new game");
                System.out.println("  3. Exit");
                System.out.print("Enter your choice (1-3): ");
                
                int choice = sc.nextInt();
                sc.nextLine(); // Consume newline
                
                switch (choice) {
                    case 1:
                        gc.replayGame(game);
                        break;
                    case 2:
                        System.out.println("\nStarting a new game...\n");
                        runGame();
                        return;
                    case 3:
                        System.out.println("Thank you for playing! Goodbye!");
                        return;
                    default:
                        System.err.println("Error: Please enter a number between 1 and 3.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Error: Invalid input. Please enter a valid number.");
                sc.nextLine(); // Clear invalid input
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}
