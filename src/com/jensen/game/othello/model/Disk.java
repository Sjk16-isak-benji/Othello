package com.jensen.game.othello.model;

public class Disk extends Piece {
    private Player owner;

    public Disk(Player owner) {
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player player) {
        owner = player;
    }
}
