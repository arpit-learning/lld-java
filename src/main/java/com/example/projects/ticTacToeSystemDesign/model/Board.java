package com.example.projects.ticTacToeSystemDesign.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> cells;
    private int dimension;

    public Board(int dimension) {
        this.dimension = dimension;
        this.cells = new ArrayList<>();
        for (int i = 0; i < dimension; i++) {
            cells.add(new ArrayList<>());
            for (int j = 0; j < dimension; j++) {
                cells.get(i).add(new Cell(i, j));
            }
        }
    }


    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public void setCells(List<List<Cell>> cells) {
        this.cells = cells;
    }

    /**
     * Creates a deep copy of this board
     */
    public Board copy() {
        Board copiedBoard = new Board(this.dimension);
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                Cell originalCell = this.cells.get(i).get(j);
                Cell copiedCell = originalCell.copy();
                copiedBoard.cells.get(i).set(j, copiedCell);
            }
        }
        return copiedBoard;
    }
}
