package com.example.projects.ticTacToeSystemDesign;

import com.example.projects.ticTacToeSystemDesign.controllers.GameController;
import com.example.projects.ticTacToeSystemDesign.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int id = 1;
        List<Player> players = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Tic Tac Toe Game!");

        System.out.println("Please enter the dimension for the board:");
        int dimension = sc.nextInt();
        GameController gc = new GameController(dimension);

        System.out.println("Do you want a bot in the game? (y/n)");
        String botAns = sc.next();
        if (botAns.equalsIgnoreCase("Y")) {
            Bot bot = new Bot(id++, "Bot", '$', PlayerType.BOT, BotDifficultyLevel.MEDIUM);
            players.add(bot);
        }

        while (id < dimension) {
            System.out.println("Please enter the name of player " + id + ":");
            String name = sc.next();
            System.out.println("Please enter the symbol for player " + id + ":");
            char symbol = sc.next().charAt(0);
            players.add(new Player(id++, name, symbol, PlayerType.HUMAN));
        }

        Collections.shuffle(players);
        Game game = gc.createNewGame(dimension, players);
        int playerInd = -1;
        List<GameStatus> allowedStates = new ArrayList<>(List.of(GameStatus.YET_TO_START, GameStatus.RUNNING));
        while (allowedStates.contains(gc.getGameStatus(game))) {
            gc.updateGameStatus(game, GameStatus.RUNNING);
            playerInd++;
            playerInd = playerInd % players.size();
            gc.displayBoard(game);
            Move executedMove = gc.executeMove(game, players.get(playerInd));
            // TODO
            Player winner = gc.checkWinner(game, executedMove);
            if (winner != null) {
                System.out.println("Winner is: " + winner.getName() + " with symbol: " + winner.getSymbol());
                gc.updateGameStatus(game, GameStatus.WIN);
                gc.displayBoard(game);
                break;
            }
        }
    }
}
