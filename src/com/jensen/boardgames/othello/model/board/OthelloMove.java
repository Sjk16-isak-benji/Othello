package com.jensen.boardgames.othello.model.board;

import com.jensen.boardgames.game.model.board.GridPosition;
import com.jensen.boardgames.game.model.board.Move;
import com.jensen.boardgames.othello.model.player.OthelloPlayer;

/**
 * A class describing a game move in othello.
 */
public class OthelloMove implements Move<OthelloPlayer> {

    private GridPosition position;
    private OthelloPlayer player;

    /**
     * Creates a move to a position, performed by a specific player.
     *
     * @param position The position.
     * @param player The player.
     */
    public OthelloMove(GridPosition position, OthelloPlayer player) {
        this.position = position;
        this.player = player;
    }

    @Override
    public GridPosition getPosition() {
        return position;
    }

    @Override
    public OthelloPlayer getPlayer() {
        return player;
    }
}
