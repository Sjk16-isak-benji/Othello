package com.jensen.boardgames.othello.model.ai;

import com.jensen.boardgames.game.model.ai.EvaluationTable;
import com.jensen.boardgames.game.model.board.Cell;
import com.jensen.boardgames.game.model.board.GridPosition;
import com.jensen.boardgames.game.util.CardinalDirection;
import com.jensen.boardgames.game.util.Direction;
import com.jensen.boardgames.othello.model.OthelloState;
import com.jensen.boardgames.othello.model.board.Disk;
import com.jensen.boardgames.othello.model.board.OthelloBoard;
import com.jensen.boardgames.othello.model.player.OthelloPlayer;

// TODO remake

/**
 * TODO
 */
public class OthelloCellWeightCalculator {

    private int cornerWeight;
    private int sideWeight;
    private int flipWeight;

    /**
     * TODO
     *
     * @param cornerWeight
     * @param sideWeight
     * @param flipWeight
     */
    public OthelloCellWeightCalculator(int cornerWeight, int sideWeight, int flipWeight) {
        this.cornerWeight = cornerWeight;
        this.sideWeight = sideWeight;
        this.flipWeight = flipWeight;
    }

    /**
     * TODO
     *
     * @param state
     * @return
     */
    public EvaluationTable getWeights(OthelloState state) {
        OthelloBoard board = state.getBoard();
        EvaluationTable weights = new EvaluationTable(board.getWidth(), board.getHeight());

        for (int x = 0; x < board.getWidth(); x++) {
            for (int y = 0; y < board.getHeight(); y++) {
                GridPosition position = new GridPosition(x, y);

                Cell<Disk> cell = board.get(position);
                weights.put(position, getWeight(cell, state.getCurrentPlayer()));
            }
        }

        return weights;
    }

    /**
     * TODO
     *
     * @param cell
     * @param player
     * @return
     */
    public int getWeight(Cell<Disk> cell, OthelloPlayer player) {
        int score = 0;

        if (cell.isInCorner()) {
            score += cornerWeight;
        } else if (cell.isNextToEdge()) {
            score += sideWeight;
        }

        for (Direction direction : CardinalDirection.values()) {
            Cell<Disk> adjacentCell = cell;

            while ((adjacentCell = adjacentCell.getAdjacentCell(direction)) != null) {
                if (adjacentCell.isEmpty()) {
                    continue;
                }

                Disk disk = adjacentCell.getPiece();

                if (disk == null) {
                    continue;
                }

                if (disk.getColor() == player.getColor()) {
                    continue;
                }

                score += flipWeight;
            }
        }

        return score;
    }
}
