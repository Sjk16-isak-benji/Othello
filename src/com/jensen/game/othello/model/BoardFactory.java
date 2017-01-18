package com.jensen.game.othello.model;

public abstract class BoardFactory {
    public static Board createBoard(int width, int height) {
        return new Board(width, height);
    }
}
