package com.jensen.game.model;

import com.jensen.game.inteface.AI;

/**
 * A base class representing a player of a board game.
 */
public abstract class Player {

    private String name;
    protected AI ai;

    /**
     * Creates a player with a specific name.
     *
     * @param name The name of the player.
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the player.
     *
     * @return The name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the object responsible for this players AI.
     *
     * @return The AI object, or null if player is human.
     */
    public AI getAI() {
        return ai;
    }

    /**
     * Sets this player to be computer controlled.
     *
     * @param difficulty The difficulty of this player AI.
     */
    public abstract void setComputerControlled(Difficulty difficulty);

    /**
     * Checks whether this player is computer controlled.
     *
     * @return A boolean indicating whether this player is computer controlled.
     */
    public boolean isComputerControlled() {
        return ai != null;
    }
}