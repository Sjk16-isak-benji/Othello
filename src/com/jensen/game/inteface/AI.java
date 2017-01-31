package com.jensen.game.inteface;

import com.jensen.game.model.Cell;

/**
 * An inteface for a players AI.
 */
public interface AI {

    /**
     * Given all the available cells on which this AI can make a move on it returns
     * the cell on which to place a piece.
     *
     * @param cells The cells on which this AI can make a move on.
     * @return The cell it's programmed to return.
     */
    Cell getMove(Cell[] cells);
}
