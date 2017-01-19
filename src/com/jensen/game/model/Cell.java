package com.jensen.game.model;

public class Cell {
    private Board board;
    private Piece piece;

    public Cell(Board board) {
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

        return board.getCell(
            coords.getX() + direction.getHorizontalStep(),
            coords.getY() + direction.getVerticalStep()
        );
    }
}
