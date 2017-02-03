package com.jensen.game.model.AI;

public abstract class NegaMaxAB<S, M> implements MiniMax<S, M> {

    private M bestMove;

    protected int findBestMove(S state, int alpha, int beta, boolean isMax, int depth) {
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
            int weight = -findBestMove(childState, alpha, beta, !isMax, depth - 1);

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

    public M getMove(S state) {
        return getMove(state, -1);
    }

    public M getMove(S state, int depth) {
        findBestMove(state, Integer.MIN_VALUE, Integer.MAX_VALUE, true, depth);

        return bestMove;
    }

    protected abstract S makeMove(S state, M move);
    protected abstract M[] getMoves(S state);
    protected abstract int evaluate(S state);
    protected abstract boolean isTerminal(S state);
}
