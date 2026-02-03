package com.example.projects.ticTacToeSystemDesign.services.botPlayingStrategies;

import com.example.projects.ticTacToeSystemDesign.model.BotDifficultyLevel;

/**
 * Factory class to create bot playing strategies based on difficulty level
 */
public class BotStrategyFactory {
    
    public static IBotPlayingStrategy getBotStrategy(BotDifficultyLevel difficultyLevel) {
        if (difficultyLevel == null) {
            return new RandomBotPlayingStrategy(); // Default strategy
        }
        
        switch (difficultyLevel) {
            case EASY:
                return new EasyBotPlayingStrategy();
            case MEDIUM:
                return new RandomBotPlayingStrategy(); // Medium uses random for now
            case HARD:
                return new RandomBotPlayingStrategy(); // Hard uses random for now (can be upgraded to minimax)
            default:
                return new RandomBotPlayingStrategy();
        }
    }
}
