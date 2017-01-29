package com.jensen.game.othello.model;

import com.jensen.game.model.*;

/**
 * A helper class, exclusively consisting of static method, with methods related to an othello game board.
 */
public class OthelloBoard {
    /**
     * Checks whether the game is over.
     *
     * @param players The players.
     * @param board   The board.
     * @return A boolean indicating whether the game is over.
     */
    public static boolean isGameOver(OthelloPlayer[] players, Board board) {
        for (OthelloPlayer player : players) {
            if (OthelloBoard.getValidMoves(player, board).length != 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Gets valid moves a player may make on a board.
     *
     * @param player The player in question.
     * @param board  The board in question.
     * @return Valid cells a player may move to.
     */
    public static Cell[] getValidMoves(OthelloPlayer player, Board board) {
        Cell[] cells = board.getCells();
        int validCellArrayLength = 0;

        for (Cell cell : cells) {
            GridPosition position = cell.getPosition();

            if (isValidMove(player, position.getX(), position.getY(), board)) {
                validCellArrayLength++;
            }
        }

        Cell[] validCells = new Cell[validCellArrayLength];

        int i = 0;
        for (Cell cell : cells) {
            GridPosition position = cell.getPosition();

            if (isValidMove(player, position.getX(), position.getY(), board)) {
                validCells[i] = cell;
                i++;
            }
        }

        return validCells;
    }

    /**
     * TODO
     *
     * @param player
     * @param board
     * @return
     */
    public static boolean hasValidMoves(OthelloPlayer player, Board board) {
        return OthelloBoard.getValidMoves(player, board).length > 0;
    }

    /**
     * Checks whether a specific cell is a valid move for a specific player.
     *
     * @param player The player.
     * @param x      The column of the cell.
     * @param y      The row of the cell.
     * @param board  The game board.
     * @return A boolean indicating whether the cell is a valid move for the player.
     */
    public static boolean isValidMove(OthelloPlayer player, int x, int y, Board board) {
        if (!board.getCell(x, y).isEmpty()) {
            return false;
        }

        for (Direction direction : Direction.values()) {
            if (isValidMove(player, x, y, direction, board)) {
                return true;
            }
        }

        return false;
    }

    /**
     * TODO
     */
    public static boolean isValidMove(OthelloPlayer player, int x, int y, Direction direction, Board board) {
        int gap = 0;
        Cell cell = board.getCell(x, y);

        while ((cell = cell.getAdjacentCell(direction)) != null) {
            if (cell.isEmpty()) {
                break;
            }

            Piece piece = cell.getPiece();

            if (!(piece instanceof Disk)) {
                break;
            }

            Disk disk = (Disk) piece;

            if (disk.getColor() == player.getColor()) {
                if (gap > 0) {
                    return true;
                } else {
                    break;
                }
            }

            gap++;
        }

        return false;
    }

    /**
     * TODO
     *
     * @param cell
     * @return
     */
    public static boolean isInCorner(Cell cell) {
        int adjacentOutOfBounds = 0;

        for (Direction direction : Direction.values()) {
            Cell adjacentCell = cell.getAdjacentCell(direction);

            if (adjacentCell == null) {
                adjacentOutOfBounds++;
            }
        }

        return adjacentOutOfBounds >= 5;
    }

    /**
     * TODO
     *
     * @param cell
     * @return
     */
    public static boolean isNextToEdge(Cell cell) {
        for (Direction direction : Direction.values()) {
            Cell adjacentCell = cell.getAdjacentCell(direction);

            if (adjacentCell == null) {
                return true;
            }
        }

        return false;
    }

    /**
     * TODO
     *
     * @param player
     * @param x
     * @param y
     * @param board
     * @return
     */
    public static int makeMove(OthelloPlayer player, int x, int y, Board board) {
        int flips = 0;

        for (Direction direction : Direction.values()) {
            if (!OthelloBoard.isValidMove(player, x, y, direction, board)) {
                continue;
            }

            Cell cell = board.getCell(x, y);

            while ((cell = cell.getAdjacentCell(direction)) != null) {
                if (cell.isEmpty()) {
                    break;
                }

                Piece piece = cell.getPiece();

                if (!(piece instanceof Disk)) {
                    break;
                }

                Disk disk = (Disk) piece;

                if (disk.getColor() == player.getColor()) {
                    break;
                } else {
                    disk.flip();
                    flips++;
                }
            }
        }

        // place disk at origin
        Disk newDisk = new Disk(player.getColor());
        board.getCell(x, y).place(newDisk);

        return flips;
    }

    /**
     * TODO
     *
     * @param board
     * @return
     */
    public static String getScore(Board board) {
        int black = 0;
        int white = 0;
        Cell[] cells = board.getCells();
        Disk disk;

        for (Cell cell : cells) {
            if (!cell.isEmpty() && cell.getPiece() instanceof Disk) {
                disk = (Disk) cell.getPiece();
                if (disk.getColor() == PieceColor.BLACK) {
                    black++;
                } else {
                    white++;
                }
            }
        }

        return "Black: " + black + " - White: " + white;
    }
}
