package com.jensen.game.inteface;

public interface Display {

    View getCurrentView();

    void setView(View view);

    void displayErrorMessage(String message);

}
