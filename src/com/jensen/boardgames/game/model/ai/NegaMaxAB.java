package com.jensen.boardgames.game.model.ai;

import com.jensen.boardgames.game.model.GameState;
import com.jensen.boardgames.game.model.board.Move;

/**
 * A base class for AI using a variation of the minimax algorithm called Negamax, with alpha-beta pruning
 * for faster lookups.
 *
 * @param <S> The type of game state.
 * @param <M> The type of move.
 */
public abstract class NegaMaxAB<S extends GameState, M extends Move> extends NegaMax<S, M> {

    /**
     * Gets the weight of the state based on the favorability for the maximizing player.
     *
     * @param state A game state.
     * @param alpha The alpha value used for pruning.
     * @param beta The beta value used for pruning.
     * @param isMax A boolean indicating if current player of the state is the player running the algorithm.
     * @param depth The max amount of steps the algorithm may look ahead.
     * @return The determined weight of the state.
     */
    protected int getWeight(S state, int alpha, int beta, boolean isMax, int depth) {
        if (isTerminal(state) || depth == 0) {
            int utility = evaluate(state);

            if (!isMax) {
                utility *= -1;
            }

            return utility;
        }

        M[] moves = getMoves(state);

        if (moves.length == 0) {
            throw new IllegalArgumentException("State was not terminal, but failed to find child states!");
        }

        for (M move : moves) {
            S childState = makeMove(state, move);
            int weight = -getWeight(childState, alpha, beta, !isMax, depth - 1);

            if (isMax) {
                if (weight > alpha) {
                    bestMove = move;
                    alpha = weight;
                }
            } else {
                if (weight < beta) {
                    bestMove = move;
                    beta = weight;
                }
            }

            if (alpha >= beta) {
                break;
            }
        }

        return isMax ? alpha : beta;
    }

    @Override
    public M getMove(S state, int depth) {
        getWeight(state, Integer.MIN_VALUE, Integer.MAX_VALUE, true, depth);

        return bestMove;
    }

    @Override
    protected abstract S makeMove(S state, M move);

    @Override
    protected abstract M[] getMoves(S state);

    @Override
    protected abstract int evaluate(S state);

    @Override
    protected abstract boolean isTerminal(S state);
}
