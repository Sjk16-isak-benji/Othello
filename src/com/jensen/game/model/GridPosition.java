package com.jensen.game.model;

/**
 * A class representing a position in a grid, so basically just a container of integer coordinates.
 */
public class GridPosition {
    private int x;
    private int y;

    /**
     * Creates a new grid position.
     *
     * @param x the x position.
     * @param y the y position.
     */
    public GridPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the x position.
     *
     * @return the x position.
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the y position.
     *
     * @return the y position.
     */
    public int getY() {
        return y;
    }
}
