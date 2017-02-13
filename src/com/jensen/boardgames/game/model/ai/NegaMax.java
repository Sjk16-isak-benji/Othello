package com.jensen.boardgames.game.model.ai;

import com.jensen.boardgames.game.model.GameState;
import com.jensen.boardgames.game.model.board.Move;

/**
 * A base class for AI using a variation of the minimax algorithm called Negamax.
 *
 * @param <S> The type of game state.
 * @param <M> The type of move.
 */
public abstract class NegaMax<S extends GameState, M extends Move> extends MiniMax<S, M> {

    protected M bestMove;

    @Override
    protected int getWeight(S state, boolean isMax, int depth) {
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

        int maxWeight = Integer.MIN_VALUE;

        for (M move : moves) {
            S childState = makeMove(state, move);
            int weight = -getWeight(childState, !isMax, depth - 1);

            if (weight > maxWeight) {
                maxWeight = weight;
                bestMove = move;
            }
        }

        return maxWeight;
    }

    @Override
    public M getMove(S state) {
        return getMove(state, -1);
    }

    @Override
    public M getMove(S state, int depth) {
        bestMove = null;
        getWeight(state, true, depth);

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
