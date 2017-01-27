package com.jensen.game.othello.model;

import com.jensen.game.model.Board;
import com.jensen.game.model.BoardFactory;
import com.jensen.game.model.Piece;
import com.jensen.game.model.PieceColor;

/**
 * A factory class for creation of othello game boards.
 */
public class OthelloBoardFactory extends BoardFactory {
    public static void main(String[] args) {

    }

    /**
     * Creates an (almost) empty board, of a specific size, with 4 pieces in the middle.
     *
     * @param width  The width of the board.
     * @param height The height of the board.
     * @return A new board.
     */
    @Override
    public Board createBoard(int width, int height) {
        Board board = new Board(width, height);

        PieceColor[] colors = PieceColor.values();
        int centerX = width / 2;
        int centerY = height / 2;

        for (int x = centerX; x < centerX + 1; x++) {
            for (int y = centerY; y < centerY + 1; y++) {
                PieceColor color = colors[(x + y) % 2];
                board.getCell(x, y).place(new Disk(color));
            }
        }

        return board;
    }

    /**
     * Creates a board based on a 2-dimensional array.
     *
     * @param boardArray The 2-dimensional array. May contain null for empty cells.
     * @return A new board.
     */
    public Board createBoardFrom2Darray(Piece[][] boardArray) {
        int width = boardArray[0].length;
        int height = boardArray.length;
        Board board = new Board(width, height);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Piece piece = boardArray[y][x];

                board.getCell(x, y).place(piece);
            }
        }

        return board;
    }
}
