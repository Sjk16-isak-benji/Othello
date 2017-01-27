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
     * @param x The x position.
     * @param y The y position.
     */
    public GridPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the x position.
     *
     * @return The x position.
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the y position.
     *
     * @return The y position.
     */
    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ")";
    }
}
