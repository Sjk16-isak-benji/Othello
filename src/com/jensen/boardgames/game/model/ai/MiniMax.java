package com.jensen.boardgames.game.model.ai;

import com.jensen.boardgames.game.model.GameState;
import com.jensen.boardgames.game.model.board.Move;

/**
 * A base class for AI using the minimax algorithm to determine the best move a player may make.
 *
 * @param <S> The type of game state.
 * @param <M> The type of move.
 */
public abstract class MiniMax<S extends GameState, M extends Move> implements AI<S, M> {

    @Override
    public abstract M getMove(S state);

    /**
     * Gets the determined best move.
     *
     * @param state A game state.
     * @param depth The max amount of steps the algorithm may look ahead.
     * @return The determined best move.
     */
    public abstract M getMove(S state, int depth);

    /**
     * Gets the weight of the state based on the favorability for the maximizing player.
     *
     * @param state A game state.
     * @param isMax A boolean indicating if current player of the state is the player running the algorithm.
     * @param depth The max amount of steps the algorithm may look ahead.
     * @return The determined weight of the state.
     */
    protected abstract int getWeight(S state, boolean isMax, int depth);

    /**
     * Performs a move on a game state and gets the new state.
     *
     * @param state A game state.
     * @param move A move to apply to a games' state.
     * @return The game state after a move is applied.
     */
    protected abstract S makeMove(S state, M move);

    /**
     * Gets all valid moves.
     *
     * @param state A game state.
     * @return A list of valid moves.
     */
    protected abstract M[] getMoves(S state);

    /**
     * Evaluates a states' score.
     *
     * @param state A game state.
     * @return The score of the state.
     */
    protected abstract int evaluate(S state);

    /**
     * Checks if a game is over.
     *
     * @param state A game state.
     * @return A boolean indicating whether a game is over.
     */
    protected abstract boolean isTerminal(S state);
}
