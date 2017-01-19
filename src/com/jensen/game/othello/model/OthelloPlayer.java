package com.jensen.game.othello.model;

import com.jensen.game.model.Difficulty;
import com.jensen.game.model.PieceColor;
import com.jensen.game.model.Player;

public class OthelloPlayer extends Player {
    private PieceColor color;

    public OthelloPlayer(String name, PieceColor color) {
        super(name);

        this.color = color;
    }

    public PieceColor getColor() {
        return color;
    }

    @Override
    public void setComputerControlled(Difficulty difficulty) {
        switch (difficulty) {
            case EASY:
                // TODO
                break;
            case NORMAL:
                // TODO
                break;
            case HARD:
                // TODO
                break;
            default:
                throw new IllegalArgumentException("Unsupported difficulty");
        }
    }
}