package com.jensen.game.inteface;

public interface Display {

    View getCurrentView();

    void changeView(View view);

    void displayErrorMessage(String message);

}
