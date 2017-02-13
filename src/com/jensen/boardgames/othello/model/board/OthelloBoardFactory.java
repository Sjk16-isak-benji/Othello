package com.jensen.boardgames.othello.model.board;

import com.jensen.boardgames.game.model.board.BoardFactory;
import com.jensen.boardgames.game.model.board.GridPosition;

/**
 * A factory class for creation of othello game boards.
 */
public class OthelloBoardFactory extends BoardFactory<Disk> {

    /**
     * Creates an othello board of a specific size, with 4 disks in the middle
     *
     * @param width  The width of the board.
     * @param height The height of the board.
     * @return A new board.
     */
    @Override
    public OthelloBoard createBoard(int width, int height) {
        OthelloBoard board = new OthelloBoard(width, height);

        DiskColor[] colors = DiskColor.values();
        int centerX = width / 2 - 1;
        int centerY = height / 2 - 1;

        for (int x = centerX; x <= centerX + 1; x++) {
            for (int y = centerY; y <= centerY + 1; y++) {
                DiskColor color = colors[(x + y) % 2];
                board.get(new GridPosition(x, y)).place(new Disk(color));
            }
        }

        return board;
    }

    @Override
    public OthelloBoard createBoardFrom2Darray(Disk[][] boardArray) {
        return (OthelloBoard) super.createBoardFrom2Darray(boardArray);
    }
}
