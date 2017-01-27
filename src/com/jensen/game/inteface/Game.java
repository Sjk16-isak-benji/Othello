package com.jensen.game.inteface;

public interface Game {

    boolean move(int x, int y);

    String getStatus(int x, int y);

    String getMessage();

}
