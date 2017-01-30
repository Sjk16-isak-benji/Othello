package com.jensen.game.othello.model;

import com.jensen.game.inteface.AI;
import com.jensen.game.model.Cell;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class AverageOthelloAI implements AI {

    private OthelloPlayer player;

    public AverageOthelloAI(OthelloPlayer player) {
        this.player = player;
    }

    @Override
    public Cell getMove(Cell[] cells) {
        int[] weights = new OthelloCellWeightCalculator(10, 5, 1).getWeights(cells, player);
        int maxIndex = 0;
        int maxWeight = 0;

        for (int i = 0; i < weights.length; i++) {
            int weight = weights[i];

            if (weight > maxWeight || (weight == maxWeight && Math.random() > 0.5)) {
                maxIndex = i;
                maxWeight = weight;
            }
        }

        return cells[maxIndex];
    }
}
