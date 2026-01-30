package com.example.projects.ticTacToeSystemDesign.services.botPlayingStrategies;

import com.example.projects.ticTacToeSystemDesign.exceptions.DrawGameException;
import com.example.projects.ticTacToeSystemDesign.model.*;

import java.util.List;

public class RandomBotPlayingStrategy implements IBotPlayingStrategy {
    @Override
    public Move makeMove(Board board, Player player) {
        List<List<Cell>> cells = board.getCells();

        for (List<Cell> row : cells) {
            for (Cell cell : row) {
                if (cell.getCellState().equals(CellState.EMPTY)) {
                    cell.setCellState(CellState.FILLED);
                    cell.setPlayer(player);
                    return new Move(player, cell);
                }
            }
        }
        throw new DrawGameException("No more moves possible.");
    }
}
