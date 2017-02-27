package com.jensen.boardgames.othello.model.ai;

import com.jensen.boardgames.game.model.board.Cell;
import com.jensen.boardgames.game.util.Direction;
import com.jensen.boardgames.game.model.board.Piece;
import com.jensen.boardgames.othello.model.player.OthelloPlayer;
import com.jensen.boardgames.othello.model.board.Disk;
import com.jensen.boardgames.othello.model.board.OthelloBoard;

public class OthelloCellWeightCalculator {

    private int cornerWeight;
    private int sideWeight;
    private int flipWeight;

    public OthelloCellWeightCalculator(int cornerWeight, int sideWeight, int flipWeight) {
        this.cornerWeight = cornerWeight;
        this.sideWeight = sideWeight;
        this.flipWeight = flipWeight;
    }

    public int[] getWeights(Cell[] cells, OthelloPlayer player) {
        int[] weights = new int[cells.length];

        for (int i = 0; i < cells.length; i++) {
            Cell cell = cells[i];

            weights[i] = getWeight(cell, player);
        }

        return weights;
    }

    public int getWeight(Cell cell, OthelloPlayer player) {
        int score = 0;

        if (OthelloBoard.isInCorner(cell)) {
            score += cornerWeight;
        } else if (OthelloBoard.isNextToEdge(cell)) {
            score += sideWeight;
        }

        for (Direction direction : Direction.values()) {
            Cell adjacentCell = cell;

            while ((adjacentCell = adjacentCell.getAdjacentCell(direction)) != null) {
                if (adjacentCell.isEmpty()) {
                    continue;
                }

                Piece piece = adjacentCell.getPiece();

                if (!(piece instanceof Disk)) {
                    continue;
                }

                Disk disk = (Disk) piece;

                if (disk.getColor() == player.getColor()) {
                    continue;
                }

                score += flipWeight;
            }
        }

        return score;
    }
}
