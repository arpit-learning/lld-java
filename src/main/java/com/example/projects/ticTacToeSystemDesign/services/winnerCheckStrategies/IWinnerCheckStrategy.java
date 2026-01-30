package com.example.projects.ticTacToeSystemDesign.services.winnerCheckStrategies;

import com.example.projects.ticTacToeSystemDesign.model.Board;
import com.example.projects.ticTacToeSystemDesign.model.Move;
import com.example.projects.ticTacToeSystemDesign.model.Player;

public interface IWinnerCheckStrategy {
    Player checkWinner(Board board, Move lastPlayedMove);
}
