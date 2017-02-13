package com.jensen.boardgames.game.model.ai;

import com.jensen.boardgames.game.model.board.Grid;
import com.jensen.boardgames.game.model.board.GridPosition;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * A 2-dimensional array containing integer weights to be used in AI calculations.
 */
public class EvaluationTable extends Grid<Integer> {

    /**
     * Creates an evaluation table with a specific size.
     *
     * @param width The width of the table.
     * @param height The height of the table.
     */
    public EvaluationTable(int width, int height) {
        super(width, height);
    }

    /**
     * Finds the grid location with the highest value. If two or more positions have the same value, one position will
     * be chosen at random.
     *
     * @return A position in the table.
     */
    public GridPosition findMaxLocation() {
        throw new NotImplementedException();
    }
}
