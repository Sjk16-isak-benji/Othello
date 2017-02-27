package com.jensen.boardgames.othello.model.board;

import com.jensen.boardgames.game.model.board.GamePiece;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * A class representing a so called disk, a game piece in the game othello/reversi.
 * It has a color and may be flipped to switch color.
 */
public class Disk implements GamePiece {

    private DiskColor color;

    /**
     * Creates a disk of a specific color.
     *
     * @param color The color of the disk.
     */
    public Disk(DiskColor color) {
        this.color = color;
    }

    /**
     * Gets the color of this disk.
     *
     * @return The color of this disk.
     */
    public DiskColor getColor() {
        return color;
    }

    /**
     * Flips the disk, changing its' color.
     */
    public void flip() {
        DiskColor[] colors = DiskColor.values();
        int index = (color.ordinal() + 1) % colors.length;
        color = colors[index];
    }

    @Override
    public char toRepresentativeChar() {
        if (color == DiskColor.BLACK) {
            return 'X';
        }

        return 'O';
    }

    @Override
    public String toString() {
        throw new NotImplementedException();
    }

    @Override
    public Disk clone() {
        return new Disk(color);
    }

    @Override
    public boolean equals(Object obj) {
        throw new NotImplementedException();
    }
}
