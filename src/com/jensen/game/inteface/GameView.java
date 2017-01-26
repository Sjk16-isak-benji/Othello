package com.jensen.game.inteface;

import java.awt.event.MouseListener;

/**
 * Extension of View, for a view containing a grid
 * @see com.jensen.game.inteface.View
 */
public interface GameView extends View {

    /**
     * Updates a cell in the view to display the status of corresponding cell from the model.
     *
     * @param x      The column index.
     * @param y      The row index.
     * @param status The status of the cell, i.e. empty or other keyword of what the cell contains.
     */
    void updateCell(int x, int y, String status);

    /**
     * Adds a mouse listener to each cell in the grid.
     *
     * @param l The mouse listener to be notified when the user interact with a game grid.
     */
    void addGridListener(MouseListener l);

}
