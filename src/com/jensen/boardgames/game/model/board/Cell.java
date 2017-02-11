package com.jensen.boardgames.game.model.board;

import com.jensen.boardgames.game.util.Direction;

/**
 * A class representing a cell of a game board.
 */
public class Cell {

    private Board board;
    private Piece piece;

    /**
     * Creates a new cell.
     *
     * @param board The board this cell belongs to.
     */
    public Cell(Board board) {
        if (board == null) {
            throw new IllegalArgumentException("Argument 'board' is null");
        }

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
    public void place(Piece piece) {
        this.piece = piece;
    }

    /**
     * Gets the piece placed in the cell, if any.
     *
     * @return The piece, or null if no piece has been placed in this cell.
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * Gets a cell adjacent to this cell, in a specific direction.
     *
     * @param direction The direction.
     * @return A cell, or null if out of bounds.
     */
    public Cell getAdjacentCell(Direction direction) {
        GridPosition coords = getPosition();

        try {
            return board.getCell(
                coords.getX() + direction.getHorizontalStep(),
                coords.getY() + direction.getVerticalStep()
            );
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}
