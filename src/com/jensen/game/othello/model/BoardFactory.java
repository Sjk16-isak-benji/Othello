package com.jensen.game.othello.model;

public abstract class BoardFactory {
    public static Board createStandardEmptyBoard() {
        return new Board(8, 8);
    }
}
