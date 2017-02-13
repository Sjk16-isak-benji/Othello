package com.jensen.boardgames.game.model.board;

import com.jensen.boardgames.game.util.CardinalDirection;
import com.jensen.boardgames.game.util.Direction;
import com.sun.istack.internal.NotNull;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * A class representing a cell of a game board.
 *
 * @param <T> The type of the game piece the cell contains.
 */
public class Cell<T extends GamePiece> {

    private Board<T> board;
    private T piece;

    /**
     * Creates a new cell.
     *
     * @param board The board this cell belongs to.
     */
    public Cell(@NotNull Board<T> board) {
        this.board = board;
    }

    /**
     * Gets the position of this cell.
     *
     * @return The position.
     */
    public GridPosition getPosition() {
        return board.positionOf(this);
    }

    /**
     * Checks whether the cell is empty.
     *
     * @return A boolean indicating whether the cell is empty.
     */
    public boolean isEmpty() {
        return piece == null;
    }

    /**
     * Empties the cell.
     */
    public void empty() {
        piece = null;
    }

    /**
     * Places a game piece in the cell.
     *
     * @param piece The piece.
     */
    public void place(T piece) {
        this.piece = piece;
    }

    /**
     * Gets the piece placed in the cell, if any.
     *
     * @return The piece, or null if no piece has been placed in this cell.
     */
    public T getPiece() {
        return piece;
    }

    /**
     * Gets a cell adjacent to this cell, in a specific direction.
     *
     * @param direction The direction.
     * @return A cell, or null if out of bounds.
     */
    public Cell<T> getAdjacentCell(Direction direction) {
        GridPosition coords = getPosition();

        try {
            return board.get(new GridPosition(
                coords.getX() + direction.getHorizontalStep(),
                coords.getY() + direction.getVerticalStep()
            ));
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    /**
     * TODO
     *
     * @return
     */
    public boolean isInCorner() { // TODO doesn't belong here
        int adjacentOutOfBounds = 0;

        for (Direction direction : CardinalDirection.values()) {
            Cell adjacentCell = getAdjacentCell(direction);

            if (adjacentCell == null) {
                adjacentOutOfBounds++;
            }
        }

        return adjacentOutOfBounds >= 5;
    }

    /**
     * TODO
     *
     * @return
     */
    public boolean isNextToEdge() { // TODO doesn't belong here
        for (Direction direction : CardinalDirection.values()) {
            Cell adjacentCell = getAdjacentCell(direction);

            if (adjacentCell == null) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        throw new NotImplementedException();
    }

    @Override
    public Cell<T> clone() {
        throw new NotImplementedException();
    }

    @Override
    public boolean equals(Object obj) {
        throw new NotImplementedException();
    }
}
