package com.jensen.game.othello.model;

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