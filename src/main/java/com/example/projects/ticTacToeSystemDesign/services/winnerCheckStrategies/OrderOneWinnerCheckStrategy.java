package com.example.projects.ticTacToeSystemDesign.services.winnerCheckStrategies;

import com.example.projects.ticTacToeSystemDesign.exceptions.DrawGameException;
import com.example.projects.ticTacToeSystemDesign.model.Board;
import com.example.projects.ticTacToeSystemDesign.model.Move;
import com.example.projects.ticTacToeSystemDesign.model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneWinnerCheckStrategy implements IWinnerCheckStrategy {
    private int dimension;
    private List<HashMap<Character, Integer>> rowHMList = new ArrayList<>(); // index i of the list would represent row i hashmap
    private List<HashMap<Character, Integer>> colHMList = new ArrayList<>(); // index i of the list would represent col i hashmap
    private HashMap<Character, Integer> leftDiagHM = new HashMap<>();
    private HashMap<Character, Integer> rightDiagHM = new HashMap<>();
    private HashMap<Character, Integer> cornersHM = new HashMap<>();
    private int validHMs;

    public OrderOneWinnerCheckStrategy(int dimension) {
        this.dimension = dimension;
        this.validHMs = 2 * dimension + 3;
        for (int i = 0; i < dimension; i++) {
            rowHMList.add(new HashMap<>());
            colHMList.add(new HashMap<>());
        }
    }

    private boolean checkNUpdateRowHM(int row, char symbol) {
        HashMap<Character, Integer> hm = rowHMList.get(row);
        if (hm.containsKey(symbol)) {
            hm.put(symbol, hm.get(symbol) + 1);
            if (hm.get(symbol) == dimension) {
                return true;
            }
        } else {
            hm.put(symbol, 1);
        }

        if (hm.size() > 1) {
            validHMs--;
            if (validHMs == 0) {
                throw new DrawGameException("Game is drawn.");
            }
        }
        return false;
    }

    private boolean checkNUpdateColHM(int col, char symbol) {
        HashMap<Character, Integer> hm = colHMList.get(col);
        if (hm.containsKey(symbol)) {
            hm.put(symbol, hm.get(symbol) + 1);
            if (hm.get(symbol) == dimension) {
                return true;
            }
        } else {
            hm.put(symbol, 1);
        }
        if (hm.size() > 1) {
            validHMs--;
            if (validHMs == 0) {
                throw new DrawGameException("Game is drawn.");
            }
        }
        return false;
    }

    private boolean checkNUpdateLeftDiagonalHM(int row, int col, char symbol) {
        if (checkLeftDiagonal(row, col)) {
            if (leftDiagHM.containsKey(symbol)) {
                leftDiagHM.put(symbol, leftDiagHM.get(symbol) + 1);
                if (leftDiagHM.get(symbol) == dimension) {
                    return true;
                }
            } else {
                leftDiagHM.put(symbol, 1);
            }
            if (leftDiagHM.size() > 1) {
                validHMs--;
                if (validHMs == 0) {
                    throw new DrawGameException("Game is drawn.");
                }
            }
        }
        return false;
    }

    private boolean checkNUpdateRightDiagonalHM(int row, int col, char symbol) {
        if (checkRightDiagonal(row, col)) {
            if (rightDiagHM.containsKey(symbol)) {
                rightDiagHM.put(symbol, rightDiagHM.get(symbol) + 1);
                if (rightDiagHM.get(symbol) == dimension) {
                    return true;
                }
            } else {
                rightDiagHM.put(symbol, 1);
            }
            if (rightDiagHM.size() > 1) {
                validHMs--;
                if (validHMs == 0) {
                    throw new DrawGameException("Game is drawn.");
                }
            }
        }
        return false;
    }

    private boolean checkNUpdateCornerHM(int row, int col, char symbol) {
        if (checkCorner(row, col)) {
            if (cornersHM.containsKey(symbol)) {
                cornersHM.put(symbol, cornersHM.get(symbol) + 1);
                if (cornersHM.get(symbol) == 4) {
                    return true;
                }
            } else {
                cornersHM.put(symbol, 1);
            }
            if (cornersHM.size() > 1) {
                validHMs--;
                if (validHMs == 0) {
                    throw new DrawGameException("Game is drawn.");
                }
            }
        }
        return false;
    }

    private boolean checkLeftDiagonal(int row, int col) {
        return row == col;
    }

    private boolean checkRightDiagonal(int row, int col) {
        return row + col == dimension - 1;
    }

    private boolean checkCorner(int row, int col) {
        return ((row == 0 && col == 0) ||
                (row == dimension - 1 && col == 0) ||
                (row == 0 && col == dimension - 1) ||
                (row == dimension - 1 && col == dimension - 1)
        );
    }

    @Override
    public Player checkWinner(Board board, Move lastPlayedMove) {
        Player player = lastPlayedMove.getPlayer();
        char symbol = player.getSymbol();
        int row = lastPlayedMove.getCell().getRow();
        int col = lastPlayedMove.getCell().getColumn();

        if (checkNUpdateRowHM(row, symbol) ||
                checkNUpdateColHM(col, symbol) ||
                checkNUpdateLeftDiagonalHM(row, col, symbol) ||
                checkNUpdateRightDiagonalHM(row, col, symbol) ||
                checkNUpdateCornerHM(row, col, symbol)
        ) {
            return player;
        }

        return null;
    }
}
