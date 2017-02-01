package com.jensen.game.inteface;

/**
 * Interface for a game.
 */
public interface Game {

    /**
     * Performs a move for the current player.
     *
     * @param x The column index.
     * @param y The row index.
     * @return True if the move was preformed, otherwise false.
     */
    boolean move(int x, int y);

    /**
     * Returns the status for the cell at the coordinates.
     *
     * @param x The column index.
     * @param y The row index.
     * @return The status.
     */
    String getStatus(int x, int y);

    /**
     * Returns the current message to display.
     *
     * @return The current message to display.
     */
    String getMessage();

}
