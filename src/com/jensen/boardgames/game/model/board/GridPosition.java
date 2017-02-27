package com.jensen.boardgames.game.model.board;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
        return getClass().getSimpleName() + "(x:" + getX() + ", y:" + getY() + ")";
    }

    @Override
    public GridPosition clone() {
        throw new NotImplementedException();
    }

    @Override
    public boolean equals(Object obj) {
        throw new NotImplementedException();
    }
}
