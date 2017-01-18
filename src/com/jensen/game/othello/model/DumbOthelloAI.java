package com.jensen.game.othello.model;

class DumbOthelloAI implements AI {
    @Override
    public Cell getMove(Cell[] cells) {
        return cells[0];
    }
}
