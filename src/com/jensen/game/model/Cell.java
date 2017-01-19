package com.jensen.game.model;

public class Cell {
    private Board board;
    private Piece piece;

    public Cell(Board board) {
        if (board == null) {
            throw new IllegalArgumentException("Argument 'board' is null");
        }

        this.board = board;
    }

    public GridPosition getPosition() {
        return board.positionOf(this);
    }

    public boolean isEmpty() {
        return piece == null;
    }

    public void empty() {
        piece = null;
    }

    public void place(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public Cell getAdjacentCell(Direction direction) {
        GridPosition coords = getPosition();

        try {
            return board.getCell(
                coords.getX() + direction.getHorizontalStep(),
                coords.getY() + direction.getVerticalStep()
            );
        } catch (IndexOutOfBoundsException error) {
            return null;
        }
    }
}
