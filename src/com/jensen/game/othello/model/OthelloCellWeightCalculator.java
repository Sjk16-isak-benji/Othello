package com.jensen.game.othello.model;

import com.jensen.game.model.Cell;
import com.jensen.game.model.Direction;
import com.jensen.game.model.Piece;

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
        Cell adjacentCell;

        if (isCornerCell(cell)) {
            score += cornerWeight;
        } else if (isSideCell(cell)) {
            score += sideWeight;
        }

        for (Direction direction : Direction.values()) {
            while ((adjacentCell = cell.getAdjacentCell(direction)) != null) {
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

    private boolean isCornerCell(Cell cell) {
        int adjacentOutOfBounds = 0;

        for (Direction direction : Direction.values()) {
            Cell adjacentCell = cell.getAdjacentCell(direction);

            if (adjacentCell == null) {
                adjacentOutOfBounds++;
            }
        }

        return adjacentOutOfBounds >= 5;
    }

    private boolean isSideCell(Cell cell) {
        int adjacentOutOfBounds = 0;

        for (Direction direction : Direction.values()) {
            Cell adjacentCell = cell.getAdjacentCell(direction);

            if (adjacentCell == null) {
                adjacentOutOfBounds++;
            }
        }

        return adjacentOutOfBounds > 0 && adjacentOutOfBounds < 5;
    }
}
