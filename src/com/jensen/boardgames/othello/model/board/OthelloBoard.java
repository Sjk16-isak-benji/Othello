package com.jensen.boardgames.othello.model.board;

import com.jensen.boardgames.game.model.board.Board;
import com.jensen.boardgames.game.model.board.Cell;
import com.jensen.boardgames.game.model.board.GridPosition;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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

    @Override
    public String toString() {
        throw new NotImplementedException();
    }

    @Override
    public OthelloBoard clone() {
        OthelloBoard board = new OthelloBoard(getWidth(), getHeight());

        for (Cell<Disk> cell : this) {
            GridPosition position = cell.getPosition();
            Cell<Disk> cellClone = new Cell<Disk>(board);
            Disk disk = cell.getPiece();

            if (disk != null) {
                cellClone.place(disk.clone());
            }

            board.put(position, cellClone);
        }

        return board;
    }

    @Override
    public boolean equals(Object obj) {
        throw new NotImplementedException();
    }
}
