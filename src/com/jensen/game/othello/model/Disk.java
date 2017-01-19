package com.jensen.game.othello.model;

public class Disk extends Piece {
    private PieceColor color;

    public Disk(PieceColor color) {
        this.color = color;
    }

    public PieceColor getColor() {
        return color;
    }

    public void flip() {
        PieceColor[] colors = PieceColor.values();
        int index = (color.ordinal() + 1) % colors.length;
        color = colors[index];
    }
}
