package com.jensen.boardgames.game.model.ai;

import com.jensen.boardgames.game.model.GameState;
import com.jensen.boardgames.game.model.board.Move;

/**
 * An inteface for a players AI.
 *
 * @param <S> The games' type of state.
 * @param <M> The games' type of move.
 */
public interface AI<S extends GameState, M extends Move> {

    /**
     * Resolves a move based on the current state of the game.
     *
     * @param state The state of the game.
     * @return The chosen move to make.
     */
    M getMove(S state);
}
