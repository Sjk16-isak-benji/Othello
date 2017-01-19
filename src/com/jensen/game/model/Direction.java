package com.jensen.game.model;

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

    Direction(int verticalStep, int horizontalStep) {
        this.verticalStep = verticalStep;
        this.horizontalStep = horizontalStep;
    }

    public int getVerticalStep() {
        return verticalStep;
    }

    public int getHorizontalStep() {
        return horizontalStep;
    }
}