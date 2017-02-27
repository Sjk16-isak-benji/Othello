package com.jensen.boardgames.game.model.board;

/**
 * A factory class for creation of game boards.
 *
 * @param <T> The type of the boards' game pieces.
 */
public class BoardFactory<T extends GamePiece> {

    /**
     * Creates an empty board of a specific size.
     *
     * @param width  The width of the board.
     * @param height The height of the board.
     * @return A new board.
     */
    public Board<T> createBoard(int width, int height) {
        return new Board<T>(width, height);
    }

    /**
     * Creates an empty board from a 2-dimensional array.
     *
     * @param boardArray The 2D array.
     * @return A new board.
     */
    public Board<T> createBoardFrom2Darray(T[][] boardArray) {
        int width = boardArray[0].length;
        int height = boardArray.length;
        Board<T> board = createBoard(width, height);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Cell<T> cell = new Cell<T>(board);
                cell.place(boardArray[y][x]);
                board.put(new GridPosition(x, y), cell);
            }
        }

        return board;
    }
}
