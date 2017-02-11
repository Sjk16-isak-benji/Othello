package com.jensen.game.model.AI;

public abstract class NegaMax<S, M> implements MiniMax<S, M> {

    protected M bestMove;

    protected int findBestMove(S state, boolean isMax, int depth) {
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
            int weight = -findBestMove(childState, !isMax, depth - 1);

            if (weight > maxWeight) {
                maxWeight = weight;
                bestMove = move;
            }
        }

        return maxWeight;
    }

    public M getMove(S state) {
        return getMove(state, -1);
    }

    public M getMove(S state, int depth) {
        findBestMove(state, true, depth);

        return bestMove;
    }

    protected abstract S makeMove(S state, M move);
    protected abstract M[] getMoves(S state);
    protected abstract int evaluate(S state);
    protected abstract boolean isTerminal(S state);
}
