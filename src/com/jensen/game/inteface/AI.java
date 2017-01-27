package com.jensen.game.inteface;

import com.jensen.game.model.Cell;

/**
 * An inteface for a players AI.
 */
public interface AI {
    Cell getMove(Cell[] cells);
}
