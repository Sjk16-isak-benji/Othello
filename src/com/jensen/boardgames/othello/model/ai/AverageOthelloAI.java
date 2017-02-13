package com.jensen.boardgames.othello.model.ai;

import com.jensen.boardgames.game.model.ai.AI;
import com.jensen.boardgames.game.model.ai.EvaluationTable;
import com.jensen.boardgames.game.model.board.GridPosition;
import com.jensen.boardgames.othello.model.OthelloState;
import com.jensen.boardgames.othello.model.board.OthelloMove;
import com.jensen.boardgames.othello.model.player.OthelloPlayer;

/**
 * TODO
 */
public class AverageOthelloAI implements AI<OthelloState, OthelloMove> {

    @Override
    public OthelloMove getMove(OthelloState state) {
        OthelloPlayer player = state.getCurrentPlayer();

        EvaluationTable weights = new OthelloCellWeightCalculator(10, 5, 1).getWeights(state);
        GridPosition position = weights.findMaxLocation();

        return new OthelloMove(position, player);
    }
}
