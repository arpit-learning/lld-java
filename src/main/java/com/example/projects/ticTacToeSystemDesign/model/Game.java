package com.example.projects.ticTacToeSystemDesign.model;

import com.example.projects.ticTacToeSystemDesign.exceptions.DuplicateSymbolsException;
import com.example.projects.ticTacToeSystemDesign.exceptions.InvalidBoardDimensionException;
import com.example.projects.ticTacToeSystemDesign.exceptions.InvalidNumberOfBotsException;
import com.example.projects.ticTacToeSystemDesign.exceptions.InvalidNumberOfPlayersException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private Board board;
    private List<Player> players;
    private Player winner;
    private GameStatus gameStatus;
    private List<Move> moves;
    private Player currentPlayer;
    private List<Board> oldBoardStates;

    private Game(Board board, List<Player> players) {
        this.board = board;
        this.players = players;
        this.winner = null;
        this.gameStatus = GameStatus.YET_TO_START;
        this.moves = new ArrayList<>();
        this.currentPlayer = null;
        this.oldBoardStates = new ArrayList<>();
    }

    private Game(Builder builder) {
        this(builder.board, builder.players);
    }

    public static Builder builder() {
        return new Builder();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public List<Board> getOldBoardStates() {
        return oldBoardStates;
    }

    public void setOldBoardStates(List<Board> oldBoardStates) {
        this.oldBoardStates = oldBoardStates;
    }

    public static class Builder {
        private Board board;
        private List<Player> players;
        private Player winner;
        private GameStatus gameStatus;
        private List<Move> moves;
        private Player currentPlayer;
        private List<Board> oldBoardStates;
        private int dimension;

        public Builder board(Board board) {
            this.board = board;
            return this;
        }

        public Builder players(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder winner(Player winner) {
            this.winner = winner;
            return this;
        }

        public Builder dimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder gameStatus(GameStatus gameStatus) {
            this.gameStatus = gameStatus;
            return this;
        }

        public Builder moves(List<Move> moves) {
            this.moves = moves;
            return this;
        }

        public Builder currentPlayer(Player currentPlayer) {
            this.currentPlayer = currentPlayer;
            return this;
        }

        public Builder oldBoardStates(List<Board> oldBoardStates) {
            this.oldBoardStates = oldBoardStates;
            return this;
        }

        private void validateValidNoOfPlayers() {
            if (players.size() != board.getDimension() - 1) {
                throw new InvalidNumberOfPlayersException("Players are not equal to dimension - 1");
            }
        }

        private void validateUniqueSymbolsForPlayers() {
            Set<Character> symbols = new HashSet<>();

            for (Player player : players) {
                if (symbols.contains(player.getSymbol())) {
                    throw new DuplicateSymbolsException("Duplicate symbol found for player: " + player.getName());
                } else {
                    symbols.add(player.getSymbol());
                }
            }
        }

        private void validateDimension() {
            if (board.getDimension() < 3 || board.getDimension() > 10) {
                throw new InvalidBoardDimensionException("Dimension cannot be less than 3 or greater than 10");
            }
        }

        public void validateBotOccurrence() {
            int botsCount = 0;
            for (Player player : players) {
                if (player.getPlayerType() == PlayerType.BOT) {
                    botsCount++;
                }
            }
            if (botsCount > 1) {
                throw new InvalidNumberOfBotsException("You have " + botsCount + " bots in the game. Only a maximum of one bot is allowed in the game.");
            }
        }

        public void validate() {
            validateDimension();
            validateValidNoOfPlayers();
            validateUniqueSymbolsForPlayers();
            validateBotOccurrence();
        }

        public Game build() {
            this.board = new Board(dimension);
            validate();
            return new Game(this);
        }
    }
}
