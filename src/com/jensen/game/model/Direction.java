package com.jensen.game.model;

/**
 * An enum representing a two-dimensional direction.
 */
public enum Direction {
    NORTH(-1, 0),
    SOUTH(+1, 0),
    WEST(0, -1),
    EAST(0, +1),
    NORTH_WEST(-1, -1),
    SOUTH_EAST(+1, +1),
    SOUTH_WEST(+1, -1),
    NORTH_EAST(-1, +1);

    private int verticalStep;
    private int horizontalStep;

    /**
     * Creates a direction with a horizontal step and a vertical step that defines the 'direction'.
     *
     * @param verticalStep The number of steps to take on the vertical plane.
     * @param horizontalStep The number of steps to take on the horizontal plane.
     */
    Direction(int verticalStep, int horizontalStep) {
        this.verticalStep = verticalStep;
        this.horizontalStep = horizontalStep;
    }

    /**
     * Returns the number of vertical steps that defines the direction.
     *
     * @return The number of vertical steps that defines the direction.
     */
    public int getVerticalStep() {
        return verticalStep;
    }

    /**
     * Returns the number of horizontal steps that defines the direction.
     *
     * @return The number of horizontal steps that defines the direction.
     */
    public int getHorizontalStep() {
        return horizontalStep;
    }
}