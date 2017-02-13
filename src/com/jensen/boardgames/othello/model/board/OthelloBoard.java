package com.jensen.boardgames.othello.model.board;

import com.jensen.boardgames.game.model.board.Board;

/**
 * A othello board is a board containing othello disks.
 */
public class OthelloBoard extends Board<Disk> {

    /**
     * Creates a board with of a specific size.
     *
     * @param width The width of the board.
     * @param height The height of the board.
     */
    public OthelloBoard(int width, int height) {
        super(width, height);
    }
}
