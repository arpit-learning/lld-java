package com.example.projects.ticTacToeSystemDesign.controllers;

import com.example.projects.ticTacToeSystemDesign.exceptions.*;
import com.example.projects.ticTacToeSystemDesign.model.*;
import com.example.projects.ticTacToeSystemDesign.services.botPlayingStrategies.BotStrategyFactory;
import com.example.projects.ticTacToeSystemDesign.services.botPlayingStrategies.IBotPlayingStrategy;
import com.example.projects.ticTacToeSystemDesign.services.winnerCheckStrategies.IWinnerCheckStrategy;
import com.example.projects.ticTacToeSystemDesign.services.winnerCheckStrategies.OrderOneWinnerCheckStrategy;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GameController {
    private IWinnerCheckStrategy winnerCheckStrategy;
    private Scanner scanner;

    public GameController(int dimension) {
        this.winnerCheckStrategy = new OrderOneWinnerCheckStrategy(dimension);
        this.scanner = new Scanner(System.in);
    }

    public GameController(int dimension, Scanner scanner) {
        this.winnerCheckStrategy = new OrderOneWinnerCheckStrategy(dimension);
        this.scanner = scanner;
    }

    public Game createNewGame(int dimension, List<Player> players) {
        Game game = Game.builder()
                .dimension(dimension)
                .players(players)
                .build();
        
        // Set initial current player
        if (!players.isEmpty()) {
            game.setCurrentPlayer(players.get(0));
        }
        
        return game;
    }

    public GameStatus getGameStatus(Game game) {
        if (game == null) {
            throw new IllegalArgumentException("Game cannot be null");
        }
        return game.getGameStatus();
    }

    public void updateGameStatus(Game game, GameStatus gameStatus) {
        if (game == null) {
            throw new IllegalArgumentException("Game cannot be null");
        }
        if (gameStatus == null) {
            throw new IllegalArgumentException("GameStatus cannot be null");
        }
        game.setGameStatus(gameStatus);
    }

    public void displayBoard(Game game) {
        if (game == null) {
            throw new IllegalArgumentException("Game cannot be null");
        }
        if (game.getBoard() == null) {
            throw new IllegalStateException("Game board is null");
        }
        displayBoard(game.getBoard());
    }

    public void displayBoard(Board board) {
        if (board == null) {
            throw new IllegalArgumentException("Board cannot be null");
        }
        
        List<List<Cell>> cells = board.getCells();
        System.out.print("   ");
        for (int j = 0; j < board.getDimension(); j++) {
            System.out.print(" " + j + "  ");
        }
        System.out.println();
        
        for (int i = 0; i < cells.size(); i++) {
            System.out.print(i + "  ");
            for (Cell cell : cells.get(i)) {
                if (cell.getCellState() == CellState.EMPTY) {
                    System.out.print("[ ] ");
                } else if (cell.getCellState() == CellState.FILLED) {
                    System.out.print("[" + cell.getPlayer().getSymbol() + "] ");
                } else if (cell.getCellState() == CellState.BLOCKED) {
                    System.out.print("[X] ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private void validateRowNColumn(Board board, int row, int column) {
        if (board == null) {
            throw new IllegalArgumentException("Board cannot be null");
        }
        if (row < 0 || row >= board.getDimension()) {
            throw new InvalidRowException(
                String.format("Invalid row: %d. Row must be between 0 and %d (exclusive)", 
                    row, board.getDimension())
            );
        }
        if (column < 0 || column >= board.getDimension()) {
            throw new InvalidColumnException(
                String.format("Invalid column: %d. Column must be between 0 and %d (exclusive)", 
                    column, board.getDimension())
            );
        }
        if (board.getCells().get(row).get(column).getCellState() != CellState.EMPTY) {
            throw new CellAlreadyFilledException(
                String.format("Cell at position (%d, %d) is already filled", row, column)
            );
        }
    }

    public Move executeMove(Game game, Player player) {
        if (game == null) {
            throw new IllegalArgumentException("Game cannot be null");
        }
        if (player == null) {
            throw new InvalidPlayerException("Player cannot be null");
        }
        if (game.getGameStatus() != GameStatus.RUNNING && game.getGameStatus() != GameStatus.YET_TO_START) {
            throw new GameNotInProgressException(
                String.format("Cannot execute move. Game status is: %s", game.getGameStatus())
            );
        }
        
        Move move;
        if (player.getPlayerType() == PlayerType.HUMAN) {
            move = executeHumanMove(game, player);
        } else {
            move = executeBotMove(game, player);
        }
        
        // Track the move
        game.getMoves().add(move);
        game.setCurrentPlayer(player);
        
        return move;
    }

    private Move executeHumanMove(Game game, Player player) {
        int row = -1;
        int column = -1;
        
        try {
            System.out.println("Please enter the row of the cell to be marked:");
            row = scanner.nextInt();
            System.out.println("Please enter the column of the cell to be marked:");
            column = scanner.nextInt();
            scanner.nextLine(); // Consume newline
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Clear the invalid input
            throw new InvalidInputException(
                "Invalid input. Please enter valid integer numbers for row and column.", e
            );
        }
        
        validateRowNColumn(game.getBoard(), row, column);
        
        Cell playedMoveCell = game.getBoard().getCells().get(row).get(column);
        playedMoveCell.setCellState(CellState.FILLED);
        playedMoveCell.setPlayer(player);
        
        return new Move(player, playedMoveCell);
    }

    private Move executeBotMove(Game game, Player player) {
        System.out.println("Bot (" + player.getName() + ") is making a move...");
        
        // Get bot strategy based on difficulty level
        IBotPlayingStrategy botStrategy;
        if (player instanceof Bot) {
            Bot bot = (Bot) player;
            botStrategy = BotStrategyFactory.getBotStrategy(bot.getDifficultyLevel());
        } else {
            botStrategy = BotStrategyFactory.getBotStrategy(BotDifficultyLevel.MEDIUM);
        }
        
        try {
            Move move = botStrategy.makeMove(game.getBoard(), player);
            System.out.println("Bot placed symbol at (" + move.getCell().getRow() + 
                             ", " + move.getCell().getColumn() + ")");
            return move;
        } catch (DrawGameException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Bot failed to make a move: " + e.getMessage(), e);
        }
    }

    public Player checkWinner(Game game, Move move) {
        if (game == null) {
            throw new IllegalArgumentException("Game cannot be null");
        }
        if (move == null) {
            throw new IllegalArgumentException("Move cannot be null");
        }
        if (game.getBoard() == null) {
            throw new IllegalStateException("Game board is null");
        }
        try {
            return winnerCheckStrategy.checkWinner(game.getBoard(), move);
        } catch (DrawGameException e) {
            throw e;
        }
    }

    /**
     * Undoes the last move made in the game
     * @param game The game to undo the move from
     * @return The move that was undone, or null if no moves to undo
     */
    public Move undoMove(Game game) {
        if (game == null) {
            throw new IllegalArgumentException("Game cannot be null");
        }
        
        List<Move> moves = game.getMoves();
        if (moves.isEmpty()) {
            throw new NoMovesToUndoException("No moves to undo. Game has not started yet.");
        }
        
        // Get the last move
        Move lastMove = moves.remove(moves.size() - 1);
        Cell cell = lastMove.getCell();
        
        // Revert the cell state
        cell.setCellState(CellState.EMPTY);
        cell.setPlayer(null);
        
        // Remove the last board state if available
        List<Board> oldBoardStates = game.getOldBoardStates();
        if (!oldBoardStates.isEmpty()) {
            oldBoardStates.remove(oldBoardStates.size() - 1);
        }
        
        // Update current player to the previous player
        List<Player> players = game.getPlayers();
        if (!players.isEmpty() && !moves.isEmpty()) {
            // Get the player from the previous move
            Move previousMove = moves.get(moves.size() - 1);
            game.setCurrentPlayer(previousMove.getPlayer());
        } else if (!players.isEmpty()) {
            // If no moves left, set to first player
            game.setCurrentPlayer(players.get(0));
        }
        
        System.out.println("Undid move by " + lastMove.getPlayer().getName() + 
                         " at (" + cell.getRow() + ", " + cell.getColumn() + ")");
        
        return lastMove;
    }

    /**
     * Replays the game by displaying all stored board states in sequence
     * @param game The game to replay
     */
    public void replayGame(Game game) {
        if (game == null) {
            throw new IllegalArgumentException("Game cannot be null");
        }
        
        List<Board> oldBoardStates = game.getOldBoardStates();
        if (oldBoardStates.isEmpty()) {
            System.out.println("No game history available for replay.");
            return;
        }
        
        System.out.println("\n========================================");
        System.out.println("Replaying Game...");
        System.out.println("========================================\n");
        
        // Display initial board
        System.out.println("Initial Board:");
        displayBoard(game.getBoard());
        
        // Display each board state
        for (int i = 0; i < oldBoardStates.size(); i++) {
            System.out.println("Move " + (i + 1) + ":");
            displayBoard(oldBoardStates.get(i));
            
            // Add a small delay for better visualization (optional)
            try {
                Thread.sleep(1000); // 1 second delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        
        System.out.println("========================================");
        System.out.println("Replay Complete!");
        System.out.println("========================================\n");
    }

    /**
     * Stores the current board state as a deep copy for replay functionality
     * @param game The game to store the board state for
     */
    public void addOldBoardState(Game game) {
        if (game == null) {
            throw new IllegalArgumentException("Game cannot be null");
        }
        if (game.getBoard() == null) {
            throw new IllegalStateException("Game board is null");
        }
        
        // Create a deep copy of the board to store
        Board boardCopy = game.getBoard().copy();
        game.getOldBoardStates().add(boardCopy);
    }

    /**
     * Gets the next player in the rotation
     * @param game The game
     * @param currentPlayerIndex Current player index
     * @return Next player index
     */
    public int getNextPlayerIndex(Game game, int currentPlayerIndex) {
        if (game == null || game.getPlayers() == null || game.getPlayers().isEmpty()) {
            throw new IllegalArgumentException("Invalid game or players");
        }
        return (currentPlayerIndex + 1) % game.getPlayers().size();
    }

    /**
     * Checks if the board is full (all cells filled)
     * @param game The game to check
     * @return true if board is full, false otherwise
     */
    public boolean isBoardFull(Game game) {
        if (game == null || game.getBoard() == null) {
            return false;
        }
        
        List<List<Cell>> cells = game.getBoard().getCells();
        for (List<Cell> row : cells) {
            for (Cell cell : row) {
                if (cell.getCellState() == CellState.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public void close() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
