package com.jensen.boardgames.game.view;

public interface Display {

    View getCurrentView();

    void setView(View view);

    void displayErrorMessage(String message);

}
