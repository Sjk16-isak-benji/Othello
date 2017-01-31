package com.jensen.game.othello.model;

import com.jensen.game.model.Difficulty;
import com.jensen.game.model.PieceColor;
import com.jensen.game.model.Player;

/**
 * A class representing a othello/reversi player.
 */
public class OthelloPlayer extends Player {

    private PieceColor color;

    /**
     * Creates a othello player which has a name and a color.
     *
     * @param name  The name of this player.
     * @param color The color representing this player.
     */
    public OthelloPlayer(String name, PieceColor color) {
        super(name);

        this.color = color;
    }

    /**
     * Gets the color representing this player.
     *
     * @return The color of this player.
     */
    public PieceColor getColor() {
        return color;
    }

    /**
     * Sets this player to computer controlled and gives it an AI of desired difficulty.
     *
     * @param difficulty The difficulty of this player AI.
     */
    @Override
    public void setComputerControlled(Difficulty difficulty) {
        switch (difficulty) {
            case EASY:
                ai = new DumbOthelloAI(this);
                break;
            case NORMAL:
                ai = new AverageOthelloAI(this);
                break;
            case HARD:
                ai = new SmartOthelloAI(this);
                break;
            default:
                throw new IllegalArgumentException("Unsupported difficulty");
        }
    }
}