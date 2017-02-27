package com.jensen.boardgames.game.model.player;

import com.jensen.boardgames.game.model.GameState;
import com.jensen.boardgames.game.model.ai.AI;
import com.jensen.boardgames.game.model.board.Move;

/**
 * An interface representing a player of a board game.
 */
public interface Player<S extends GameState, M extends Move> {

    /**
     * Gets the name of the player.
     *
     * @return The name of the player.
     */
    String getName();

    /**
     * Gets the AI of this player.
     *
     * @return The AI of this player, or null if this player is human.
     */
    AI<S, M> getAI();

    /**
     * Sets this player to be computer controlled.
     *
     * @param difficulty The difficulty of this players AI.
     */
    void setComputerControlled(String difficulty); // TODO String?

    /**
     * Checks whether this player is computer controlled.
     *
     * @return A boolean indicating whether this player is computer controlled.
     */
    boolean isComputerControlled();
}