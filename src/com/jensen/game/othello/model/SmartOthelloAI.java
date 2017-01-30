package com.jensen.game.othello.model;

import com.jensen.game.inteface.AI;
import com.jensen.game.model.Cell;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

class SmartOthelloAI implements AI {

    private OthelloPlayer player;

    public SmartOthelloAI(OthelloPlayer player) {
        this.player = player;
    }

    @Override
    public Cell getMove(Cell[] cells) {
        // TODO
        throw new NotImplementedException();
    }
}