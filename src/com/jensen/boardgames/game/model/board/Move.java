package com.jensen.boardgames.game.model.board;

import com.jensen.boardgames.game.model.player.Player;

/**
 * An interface describing a game move performed by a player.
 *
 * @param <P> The type of player.
 */
public interface Move<P extends Player> {

    /**
     * Gets the position the player moves to.
     *
     * @return The position of the move.
     */
    GridPosition getPosition();

    /**
     * Gets the player associated with the move.
     *
     * @return The player associated with the move.
     */
    P getPlayer();
}