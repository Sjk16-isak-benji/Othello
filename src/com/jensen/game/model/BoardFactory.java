package com.jensen.game.model;

public abstract class BoardFactory {
    public static Board createBoard(int width, int height) {
        return new Board(width, height);
    }
}
