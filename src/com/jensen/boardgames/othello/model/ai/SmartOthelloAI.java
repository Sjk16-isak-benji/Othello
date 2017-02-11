package com.jensen.boardgames.othello.model.ai;

import com.jensen.boardgames.game.model.ai.AI;
import com.jensen.boardgames.game.model.board.Cell;
import com.jensen.boardgames.othello.model.player.OthelloPlayer;
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