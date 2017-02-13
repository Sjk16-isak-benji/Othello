package com.jensen.boardgames.othello.model.board;

import com.jensen.boardgames.game.model.board.Board;
import com.jensen.boardgames.game.model.board.BoardFactory;
import com.jensen.boardgames.game.model.board.Piece;
import com.jensen.boardgames.game.model.board.PieceColor;

/**
 * A factory class for creation of othello game boards.
 */
public class OthelloBoardFactory extends BoardFactory {

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
        int centerX = width / 2 - 1;
        int centerY = height / 2 - 1;

        for (int x = centerX; x <= centerX + 1; x++) {
            for (int y = centerY; y <= centerY + 1; y++) {
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