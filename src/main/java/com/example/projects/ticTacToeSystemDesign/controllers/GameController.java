package com.example.projects.ticTacToeSystemDesign.controllers;

import com.example.projects.ticTacToeSystemDesign.model.*;

import java.util.List;

public class GameController {
    public Game createNewGame(int dimension, List<Player> players) {
        return Game.builder()
                .dimension(dimension)
                .players(players)
                .build();
    }

    public GameStatus getGameStatus(Game game) {
        return null;
    }

    public void updateGameStatus(Game game, GameStatus gameStatus) {
        game.setGameStatus(gameStatus);
    }

    public void displayBoard(Game game) {

    }


    public Move executeMove(Game game, Player player) {
        return null;

    }

    public Player checkWinner(Game game, Move move) {
        return null;

    }

    public Board undoMove(Game game, Move move) {
        return null;

    }

    public void replayGame(Game game) {

    }
}
