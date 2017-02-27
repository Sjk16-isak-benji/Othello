package com.jensen.boardgames.game.model.board;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * A class representing a general game board.
 *
 * @param <T> The type of the boards' game pieces.
 */
public class Board<T extends GamePiece> extends Grid<Cell<T>> {

    /**
     * Creates a board with of a specific size.
     *
     * @param width  The width of the board.
     * @param height The height of the board.
     */
    public Board(int width, int height) {
        super(width, height);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                put(new GridPosition(x, y), new Cell<T>(this));
            }
        }
    }

    /**
     * Gets a graphical string representation of the board.
     *
     * @return A string representation of the board.
     */
    public String toTableString() {
        String output = "";

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                T item = get(new GridPosition(x, y)).getPiece();
                char c = ' ';

                if (item != null) {
                    c = item.toRepresentativeChar();
                }

                output += String.format("%4s", c);
            }

            output += "\n";
        }

        return output;
    }

    @Override
    public String toString() {
        throw new NotImplementedException();
    }

    @Override
    public Board<T> clone() {
        throw new NotImplementedException();
    }

    @Override
    public boolean equals(Object obj) {
        throw new NotImplementedException();
    }
}
