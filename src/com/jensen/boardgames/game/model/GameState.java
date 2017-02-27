package com.jensen.boardgames.game.model;

import com.jensen.boardgames.game.model.board.Board;
import com.jensen.boardgames.game.model.player.Player;

/**
 * An interface describing a games state.
 *
 * @param <B> The board type of the game.
 * @param <P> The player type of the game.
 */
public interface GameState<B extends Board, P extends Player> {

    /**
     * Gets the board.
     *
     * @return The board.
     */
    B getBoard();

    /**
     * Gets all the games' players.
     *
     * @return The players of the game.
     */
    P[] getPlayers();

    /**
     * Gets the player whos' turn it is.
     *
     * @return The current player.
     */
    P getCurrentPlayer();

    /**
     * Sets the current player.
     *
     * @param player A player of the game.
     */
    void setCurrentPlayer(P player);
}