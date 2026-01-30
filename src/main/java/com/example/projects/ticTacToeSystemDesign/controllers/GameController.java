package com.example.projects.ticTacToeSystemDesign.controllers;

import com.example.projects.ticTacToeSystemDesign.exceptions.InvalidColumnException;
import com.example.projects.ticTacToeSystemDesign.exceptions.InvalidRowException;
import com.example.projects.ticTacToeSystemDesign.model.*;
import com.example.projects.ticTacToeSystemDesign.services.botPlayingStrategies.IBotPlayingStrategy;
import com.example.projects.ticTacToeSystemDesign.services.botPlayingStrategies.RandomBotPlayingStrategy;
import com.example.projects.ticTacToeSystemDesign.services.winnerCheckStrategies.IWinnerCheckStrategy;
import com.example.projects.ticTacToeSystemDesign.services.winnerCheckStrategies.OrderOneWinnerCheckStrategy;

import java.util.List;
import java.util.Scanner;

public class GameController {
    private IWinnerCheckStrategy strategy;

    public GameController(int dimension) {
        strategy = new OrderOneWinnerCheckStrategy(dimension);
    }

    public Game createNewGame(int dimension, List<Player> players) {
        return Game.builder()
                .dimension(dimension)
                .players(players)
                .build();
    }

    public GameStatus getGameStatus(Game game) {
        return game.getGameStatus();
    }

    public void updateGameStatus(Game game, GameStatus gameStatus) {
        game.setGameStatus(gameStatus);
    }

    public void displayBoard(Game game) {
        List<List<Cell>> cells = game.getBoard().getCells();
        for (List<Cell> row : cells) {
            for (Cell cell : row) {
                if (cell.getCellState() == CellState.EMPTY) {
                    System.out.print("[ ] ");
                } else if (cell.getCellState() == CellState.FILLED) {
                    System.out.print("[" + cell.getPlayer().getSymbol() + "] ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private void validateRowNColumn(Board board, int row, int column) {
        if (row < 0 || row >= board.getDimension()) {
            throw new InvalidRowException("Invalid row");
        }
        if (column < 0 || column >= board.getDimension()) {
            throw new InvalidColumnException("Invalid column");
        }
        if (board.getCells().get(row).get(column).getCellState() != CellState.EMPTY) {
            throw new IllegalStateException("Cell is already filled");
        }
    }


    public Move executeMove(Game game, Player player) {
        if (player.getPlayerType() == PlayerType.HUMAN) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter the row of the cell to be marked:");
            int row = sc.nextInt();
            System.out.println("Please enter the column of the cell to be marked:");
            int column = sc.nextInt();
            validateRowNColumn(game.getBoard(), row, column);
            Cell playedMoveCell = game.getBoard().getCells().get(row).get(column);
            playedMoveCell.setCellState(CellState.FILLED);
            playedMoveCell.setPlayer(player);
            return new Move(player, playedMoveCell);
        } else {
            System.out.println("Bot is making a move");
            // TODO
            IBotPlayingStrategy strategy = new RandomBotPlayingStrategy();
            return strategy.makeMove(game.getBoard(), player);
        }
    }

    public Player checkWinner(Game game, Move move) {
        // TODO
        return strategy.checkWinner(game.getBoard(), move);

    }

    public Board undoMove(Game game, Move move) {
        return null;

    }

    public void replayGame(Game game) {

    }
}
