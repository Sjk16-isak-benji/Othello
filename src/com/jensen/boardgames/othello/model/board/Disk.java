package com.jensen.boardgames.othello.model.board;

import com.jensen.boardgames.game.model.board.Piece;
import com.jensen.boardgames.game.model.board.PieceColor;

/**
 * A class representing a so called disk, a game piece in the game othello/reversi.
 * It has a color and may be flipped to switch color.
 */
public class Disk extends Piece {

    private PieceColor color;

    /**
     * Creates a disk of a specific color.
     *
     * @param color The color of the disk.
     */
    public Disk(PieceColor color) {
        this.color = color;
    }

    /**
     * Gets the color of this disk.
     *
     * @return The color of this disk.
     */
    public PieceColor getColor() {
        return color;
    }

    /**
     * Flips the disk, changing its' color.
     */
    public void flip() {
        PieceColor[] colors = PieceColor.values();
        int index = (color.ordinal() + 1) % colors.length;
        color = colors[index];
    }
}
