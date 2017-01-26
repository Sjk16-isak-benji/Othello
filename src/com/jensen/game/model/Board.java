package com.jensen.game.model;

/**
 * A class representing a general game board.
 */
public class Board {
    private int width;
    private int height;
    private Cell[][] cells;

    /**
     * Creates a board with of a specific size.
     *
     * @param width the width of the board.
     * @param height the height of the board.
     */
    public Board(int width, int height) {
        if ((width == 0 || height == 0) && width != height) {
            throw new IllegalArgumentException("Cannot not have only one side of size 0");
        }

        this.width = width;
        this.height = height;

        reset();
    }

    /**
     * Resets all board cells.
     */
    private void reset() {
        cells = new Cell[height][width];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[y][x] = new Cell(this);
            }
        }
    }

    /**
     * Gets the width of this board.
     *
     * @return the width of this board.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets the height of this board.
     *
     * @return the height of this board.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Gets all cells in this board in an one-dimensional array.
     *
     * @return array of the cells in this board.
     */
    public Cell[] getCells() {
        Cell[] cells = new Cell[width * height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x * width + y] = getCell(x, y);
            }
        }

        return cells;
    }

    /**
     * Gets a specific cell.
     *
     * @param x the column of the cell.
     * @param y the row of the cell.
     * @return the cell.
     */
    public Cell getCell(int x, int y) {
        return cells[y][x];
    }

    /**
     * Gets the position of a cell.
     *
     * @param cell the cell.
     * @return the position.
     */
    public GridPosition positionOf(Cell cell) {
        if (cell == null) {
            throw new IllegalArgumentException("Argument 'cell' is null");
        }

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (getCell(x, y).equals(cell)) {
                    return new GridPosition(x, y);
                }
            }
        }

        throw new IllegalArgumentException("Cell not found");
    }
}
