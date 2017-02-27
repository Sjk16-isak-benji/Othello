package com.jensen.boardgames.othello.model.player;

import com.jensen.boardgames.game.model.ai.AI;
import com.jensen.boardgames.game.model.player.Player;
import com.jensen.boardgames.othello.model.OthelloState;
import com.jensen.boardgames.othello.model.board.DiskColor;
import com.jensen.boardgames.othello.model.board.OthelloMove;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * A class representing a othello/reversi player.
 */
public class OthelloPlayer implements Player<OthelloState, OthelloMove> {

    private String name;
    private AI<OthelloState, OthelloMove> ai;
    private DiskColor color;

    /**
     * Creates a othello player which has a name and a color.
     *
     * @param name  The name of this player.
     * @param color The color representing this player.
     */
    public OthelloPlayer(String name, DiskColor color) {
        this.name = name;
        this.color = color;
    }

    /**
     * Gets the color representing this player.
     *
     * @return The color of this player.
     */
    public DiskColor getColor() {
        return color;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public AI<OthelloState, OthelloMove> getAI() {
        return ai;
    }

    @Override
    public void setComputerControlled(String difficulty) {
        switch (difficulty) {
            case "EASY":
                throw new NotImplementedException();
                //break;
            case "NORMAL":
                throw new NotImplementedException();
                //break;
            case "HARD":
                throw new NotImplementedException();
                //break;
            default:
                throw new IllegalArgumentException("Unsupported difficulty");
        }
    }

    @Override
    public boolean isComputerControlled() {
        return ai != null;
    }

    @Override
    public String toString() {
        throw new NotImplementedException();
    }

    @Override
    public OthelloPlayer clone() {
        throw new NotImplementedException();
    }

    @Override
    public boolean equals(Object obj) {
        throw new NotImplementedException();
    }
}