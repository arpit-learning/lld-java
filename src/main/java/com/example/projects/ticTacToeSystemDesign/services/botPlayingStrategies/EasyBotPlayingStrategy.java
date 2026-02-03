package com.example.projects.ticTacToeSystemDesign.services.botPlayingStrategies;

import com.example.projects.ticTacToeSystemDesign.exceptions.DrawGameException;
import com.example.projects.ticTacToeSystemDesign.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Easy bot strategy: Makes random moves from available empty cells
 */
public class EasyBotPlayingStrategy implements IBotPlayingStrategy {
    private Random random = new Random();
    
    @Override
    public Move makeMove(Board board, Player player) {
        List<List<Cell>> cells = board.getCells();
        List<Cell> emptyCells = new ArrayList<>();
        
        // Collect all empty cells
        for (List<Cell> row : cells) {
            for (Cell cell : row) {
                if (cell.getCellState().equals(CellState.EMPTY)) {
                    emptyCells.add(cell);
                }
            }
        }
        
        if (emptyCells.isEmpty()) {
            throw new DrawGameException("No more moves possible.");
        }
        
        // Select a random empty cell
        Cell selectedCell = emptyCells.get(random.nextInt(emptyCells.size()));
        selectedCell.setCellState(CellState.FILLED);
        selectedCell.setPlayer(player);
        
        return new Move(player, selectedCell);
    }
}
