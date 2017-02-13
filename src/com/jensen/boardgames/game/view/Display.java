package com.jensen.boardgames.game.view;

/**
 * TODO
 */
public interface Display {

    /**
     * TODO
     *
     * @return
     */
    View getCurrentView();

    /**
     * TODO
     *
     * @param view
     */
    void setView(View view);

    /**
     * TODO
     *
     * @param message
     */
    void displayErrorMessage(String message);
}
