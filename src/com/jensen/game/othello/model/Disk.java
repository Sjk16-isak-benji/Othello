package com.jensen.game.othello.model;

import com.jensen.game.model.Piece;
import com.jensen.game.model.PieceColor;

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
