package com.jensen.game.othello.model;

import com.jensen.game.inteface.AI;
import com.jensen.game.model.Cell;

class DumbOthelloAI implements AI {
    @Override
    public Cell getMove(Cell[] cells) {
        return cells[0];
    }
}
