package com.jensen.game.othello.model;

public class Board {
    private int width;
    private int height;
    private Cell[][] cells;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;

        reset();
    }

    private void reset() {
        cells = new Cell[height][width];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[y][x] = new Cell(this);
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Cell[] getCells() {
        Cell[] cells = new Cell[width * height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x * width + y] = getCell(x, y);
            }
        }

        return cells;
    }

    public Cell getCell(int x, int y) {
        return cells[y][x];
    }

    public GridPosition positionOf(Cell cell) {
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
