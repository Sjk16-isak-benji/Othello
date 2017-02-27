package com.jensen.boardgames.game.model.board;

/**
 * A factory class for creation of game boards.
 *
 * @param <T> The type the grid contains.
 */
public class GridFactory<T> {

    /**
     * Creates an empty grid of a specific size.
     *
     * @param width  The width of the grid.
     * @param height The height of the grid.
     * @return A new grid.
     */
    public Grid<T> createBoard(int width, int height) {
        return new Grid<T>(width, height);
    }

    /**
     * Creates an empty grid from a 2-dimensional array.
     *
     * @param gridArray The 2D array.
     * @return A new grid.
     */
    public Grid<T> createBoardFrom2Darray(T[][] gridArray) {
        int width = gridArray[0].length;
        int height = gridArray.length;
        Grid<T> grid = createBoard(width, height);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                T item = gridArray[y][x];
                grid.put(new GridPosition(x, y), item);
            }
        }

        return grid;
    }
}
