package com.jensen.game.model;

/**
 * A factory class for creation of game boards.
 */
public abstract class BoardFactory {
    /**
     * Creates a normal board of a specific size.
     *
     * @param width the width of the board.
     * @param height the height of the board.
     * @return a new board.
     */
    public static Board createBoard(int width, int height) {
        return new Board(width, height);
    }
}
