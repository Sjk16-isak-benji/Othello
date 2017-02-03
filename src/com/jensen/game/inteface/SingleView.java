package com.jensen.game.inteface;

import com.jensen.game.controller.GameOption;
import com.jensen.game.model.GridPosition;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Map;

public interface SingleView {

    void changeViewTo(String viewName);

    void displayErrorMessage(String msg);

    /**
     * Updates a cell in the view to display the status of corresponding cell from the model.
     *
     * @param x      The column index.
     * @param y      The row index.
     * @param status The status of the cell, i.e. empty or other keyword of what the cell contains.
     */
    void updateCell(int x, int y, String status);

    /**
     * Updates the cell the mouse is hovering over.
     *
     * @param x      The column index.
     * @param y      The row index.
     * @param status The status of the cell.
     */
    void mouseEnteredCell(int x, int y, String status);

    /**
     * Returns the grid position of the object if it exists in this game views grid otherwise null.
     *
     * @param o The object which coorinates you want from this game view.
     * @return Returns the objects grid position or null.
     */
    GridPosition getPositionOf(Object o);

    void updateMessage(String msg);

    void setSetupListener(ActionListener l);

    void setMenuListener(ActionListener l);

    void setGridListener(MouseListener l);

    Map<String, GameOption> getOptions();

}
