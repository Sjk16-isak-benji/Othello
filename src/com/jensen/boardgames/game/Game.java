package com.jensen.boardgames.game;

import com.jensen.boardgames.game.model.board.GridPosition;

/**
 * Interface for a game.
 */
public interface Game {

    /**
     * Performs a action for the current player.
     *
     * @param x The column index.
     * @param y The row index.
     * @return True if the move was preformed, otherwise false.
     */
    boolean performAction(int x, int y);

    /**
     * Performs a alternative action for the current player.
     *
     * @param x The column index.
     * @param y The row index.
     * @return True if the move was preformed, otherwise false.
     */
    boolean performAlternativeAction(int x, int y);

    /**
     * Returns true if a action can be taken.
     *
     * @param x The column index.
     * @param y The row index.
     * @return Returns true if a action can be taken.
     */
    boolean isValid(int x, int y);

    /**
     * Returns the status for the cell at the coordinates.
     *
     * @param x The column index.
     * @param y The row index.
     * @return The status.
     */
    String getStatus(int x, int y);

    /**
     * Returns an array with the grid postions of changed cells.
     *
     * @return An array of grid postions.
     */
    GridPosition[] getChangedCellPositions();

    /**
     * Returns the current message to display.
     *
     * @return The current message to display.
     */
    String getMessage();

}
