package com.jensen.boardgames.game.util;

/**
 * An enum representing a two-dimensional direction.
 */
public interface Direction {

    /**
     * Gets the number of vertical steps that defines the direction.
     *
     * @return The number of vertical steps that defines the direction.
     */
    int getVerticalStep();

    /**
     * Returns the number of horizontal steps that defines the direction.
     *
     * @return The number of horizontal steps that defines the direction.
     */
    int getHorizontalStep();
}
