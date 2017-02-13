package com.jensen.boardgames.game.controller;

import com.jensen.boardgames.game.Game;
import com.jensen.boardgames.othello.model.OthelloModel;

import java.util.Map;

/**
 * TODO
 */
public class GameFactory {

    /**
     * TODO
     *
     * @param options
     * @return
     */
    public Game createGame(Map<String, GameOption> options) {
        String name = (String) options.get("name").getValue();
        switch (name.toLowerCase()) {
            case "othello":
                return othelloGame(options);
            default:
                break;
        }
        return null;
    }

    /**
     * TODO
     *
     * @param settings
     * @return
     */
    public Game createGame(Settings settings) {
        String name = settings.getGameName();
        switch (name.toLowerCase()) {
            case "othello":
                return othelloGame(settings);
            default:
                break;
        }
        return null;
    }

    /**
     * TODO
     *
     * @param options
     * @return
     */
    private Game othelloGame(Map<String, GameOption> options) {
        int width = (int) options.get("size").getValue();
        int height = width;
        String opponent = (String) options.get("opponent").getValue();
        String difficulty = (String) options.get("difficulty").getValue();
        return createOthelloModel(width, height, opponent, difficulty);
    }

    /**
     * TODO
     *
     * @param settings
     * @return
     */
    private Game othelloGame(Settings settings) {
        int width = settings.getWidth();
        int height = settings.getHeight();
        String opponent = settings.getOpponent();
        String difficulty = settings.getDifficulty();
        return createOthelloModel(width, height, opponent, difficulty);
    }

    /**
     * TODO
     *
     * @param width
     * @param height
     * @param opponent
     * @param difficulty
     * @return
     */
    private Game createOthelloModel(int width, int height, String opponent, String difficulty) {
        return new OthelloModel(width, height, opponent, difficulty);
    }
}
