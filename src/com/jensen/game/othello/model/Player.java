package com.jensen.game.othello.model;

public abstract class Player {
    private String name;
    private AI ai;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public AI getAI() {
        return ai;
    }

    public abstract void setComputerControlled(Difficulty difficulty);

    public boolean isComputerControlled() {
        return ai != null;
    }
}