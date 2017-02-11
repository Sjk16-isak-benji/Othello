package com.jensen.boardgames.othello.model.ai;

import com.jensen.boardgames.game.model.ai.AI;
import com.jensen.boardgames.game.model.board.Cell;
import com.jensen.boardgames.othello.model.player.OthelloPlayer;

class DumbOthelloAI implements AI {

    private OthelloPlayer player;

    public DumbOthelloAI(OthelloPlayer player) {
        this.player = player;
    }

    @Override
    public Cell getMove(Cell[] cells) {
        int[] weights = new OthelloCellWeightCalculator(2, 1, 1).getWeights(cells, player);
        int maxIndex = 0;
        int maxWeight = 0;

        for (int i = 0; i < weights.length; i++) {
            int weight = weights[i];

            if (weight > maxWeight && Math.random() > 0.5) {
                maxIndex = i;
                maxWeight = weight;
            }
        }

        return cells[maxIndex];
    }
}
