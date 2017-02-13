package com.jensen.boardgames.othello.model;

import com.jensen.boardgames.game.model.board.Cell;
import com.jensen.boardgames.game.model.board.GridPosition;
import com.jensen.boardgames.game.util.CardinalDirection;
import com.jensen.boardgames.game.util.Direction;
import com.jensen.boardgames.othello.model.board.Disk;
import com.jensen.boardgames.othello.model.board.DiskColor;
import com.jensen.boardgames.othello.model.board.OthelloBoard;
import com.jensen.boardgames.othello.model.board.OthelloMove;
import com.jensen.boardgames.othello.model.player.OthelloPlayer;

/**
 * A helper class, exclusively consisting of static methods related to the game othello.
 */
public abstract class Othello {

    /**
     * Checks whether the game is over.
     *
     * @param state The state of the game.
     * @return A boolean indicating whether the game is over.
     */
    public static boolean isGameOver(OthelloState state) {
        for (OthelloPlayer player : state.getPlayers()) {
            state = state.clone();
            state.setCurrentPlayer(player);

            if (getValidMoves(state).length != 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Gets valid moves the current player may make on a board.
     *
     * @param state The state of the game.
     * @return Valid cells the current player may move to.
     */
    public static OthelloMove[] getValidMoves(OthelloState state) {
        OthelloPlayer player = state.getCurrentPlayer();
        int validCellArrayLength = 0;

        for (Cell cell : state.getBoard()) {
            GridPosition position = cell.getPosition();
            OthelloMove move = new OthelloMove(position, player);

            if (isValidMove(state, move)) {
                validCellArrayLength++;
            }
        }

        OthelloMove[] validMoves = new OthelloMove[validCellArrayLength];

        int i = 0;
        for (Cell cell : state.getBoard()) {
            GridPosition position = cell.getPosition();
            OthelloMove move = new OthelloMove(position, player);

            if (isValidMove(state, move)) {
                validMoves[i] = move;
                i++;
            }
        }

        return validMoves;
    }

    /**
     * Checks whether a move can be performed in the current state.
     *
     * @param state The state.
     * @param move A move.
     * @return A boolean indicating whether it's a valid move.
     */
    public static boolean isValidMove(OthelloState state, OthelloMove move) {
        GridPosition position = move.getPosition();

        if (!state.getBoard().get(position).isEmpty()) {
            return false;
        }

        for (Direction direction : CardinalDirection.values()) {
            if (isValidMove(state, move, direction)) {
                return true;
            }
        }

        return false;
    }

    /**
     * TODO what does this do exactly?
     *
     * @param state The state.
     * @param move A move.
     * @param direction A direction.
     * @return A boolean indicating whether it's a valid move.
     */
    public static boolean isValidMove(OthelloState state, OthelloMove move, Direction direction) {
        int gap = 0;
        Cell<Disk> cell = state.getBoard().get(move.getPosition());

        while ((cell = cell.getAdjacentCell(direction)) != null) {
            if (cell.isEmpty()) {
                break;
            }

            Disk disk = cell.getPiece();

            if (disk == null) {
                break;
            }

            if (disk.getColor() == move.getPlayer().getColor()) {
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
     * Applies a move to a state.
     *
     * @param state The state.
     * @param move A move.
     * @return A new state.
     */
    public static int makeMove(OthelloState state, OthelloMove move) {
        int flips = 0;
        GridPosition position = move.getPosition();
        OthelloBoard board = state.getBoard();
        OthelloPlayer player = move.getPlayer();

        for (Direction direction : CardinalDirection.values()) {
            if (!Othello.isValidMove(state, move, direction)) {
                continue;
            }

            Cell<Disk> cell = board.get(move.getPosition());

            while ((cell = cell.getAdjacentCell(direction)) != null) {
                if (cell.isEmpty()) {
                    break;
                }

                Disk disk = cell.getPiece();

                if (disk == null) {
                    break;
                }

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
        board.get(move.getPosition()).place(newDisk);

        return flips;
    }

    /**
     * Counts and returns a string with the number of black and white pieces on a specific board.
     *
     * @param state The game state.
     * @return A string with the 'score'.
     */
    public static String getScore(OthelloState state) { // TODO doesn't belong here
        int black = 0;
        int white = 0;

        for (Cell<Disk> cell : state.getBoard()) {
            if (!cell.isEmpty()) {
                Disk disk = cell.getPiece();

                if (disk.getColor() == DiskColor.BLACK) {
                    black++;
                } else {
                    white++;
                }
            }
        }

        return "Black: " + black + " - White: " + white;
    }
}
