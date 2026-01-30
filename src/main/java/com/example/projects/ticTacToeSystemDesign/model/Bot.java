package com.example.projects.ticTacToeSystemDesign.model;

public class Bot extends Player {
    private BotDifficultyLevel difficultyLevel;

    public Bot(int id, String name, char symbol, PlayerType playerType, BotDifficultyLevel difficultyLevel) {
        super(id, name, symbol, playerType);
        this.difficultyLevel = difficultyLevel;
    }

    public BotDifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(BotDifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
}
