package com.jensen.boardgames.game.model.board;

import com.sun.istack.internal.NotNull;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A class wrapping a 2-dimensional array with helping methods to ease working with it or iterating through it.
 *
 * @param <T> The type the grid contains.
 */
public class Grid<T> implements Iterable<T> {

    /**
     * TODO
     */
    class RowIterator implements Iterator<T> {
        int x = 0;
        int y = 0;

        public boolean hasNext() {
            return x < getWidth() && y < getHeight();
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T item = get(new GridPosition(x, y));

            if (x == getWidth() - 1) {
                x = 0;
                y++;
            } else {
                x++;
            }

            return item;
        }
    }

    /**
     * TODO
     */
    class ColumnIterator implements Iterator<T> {
        int x = 0;
        int y = 0;

        public boolean hasNext() {
            return x < getWidth() && y < getHeight();
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T item = get(new GridPosition(x, y));

            if (y == getHeight() - 1) {
                y = 0;
                x++;
            } else {
                y++;
            }

            return item;
        }
    }

    protected int width;
    protected int height;
    protected T[][] items;

    /**
     * Creates a grid with a specific size.
     *
     * @param width The width of the grid.
     * @param height The height of the grid.
     */
    public Grid(int width, int height) {
        if ((width == 0 || height == 0) && width != height) {
            throw new IllegalArgumentException("Cannot not have only one side of size 0");
        }

        this.width = width;
        this.height = height;

        // TODO use List instead of array
        //@SuppressWarnings("unchecked")
        items = (T[][]) new Object[height][width];
    }

    /**
     * Gets the width.
     *
     * @return The width.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets the height.
     *
     * @return The height.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Gets the size.
     *
     * @return The size.
     */
    public int size() {
        return width * height;
    }

    /**
     * Gets the value of a specific cell.
     *
     * @param position The position of the requested cell.
     * @return The value of the cell.
     */
    public T get(GridPosition position) {
        return items[position.getY()][position.getX()];
    }

    /**
     * Sets the value of a specific cell.
     *
     * @param position The position of the cell.
     * @param item The value.
     */
    public void put(GridPosition position, T item) {
        items[position.getY()][position.getX()] = item;
    }

    /**
     * Gets the cell position of a specific value.
     *
     * @param item The value.
     * @return The position.
     */
    public GridPosition positionOf(@NotNull T item) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                GridPosition position = new GridPosition(x, y);

                if (get(position).equals(item)) {
                    return position;
                }
            }
        }

        throw new IllegalArgumentException("Item not found");
    }

    @Override
    public Iterator<T> iterator() {
        return new RowIterator();
    }

    @Override
    public String toString() {
        throw new NotImplementedException();
    }

    @Override
    public Grid<T> clone() {
        throw new NotImplementedException();
    }

    @Override
    public boolean equals(Object obj) {
        throw new NotImplementedException();
    }
}