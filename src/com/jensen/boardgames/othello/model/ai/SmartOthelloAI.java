package com.jensen.boardgames.othello.model.ai;

import com.jensen.boardgames.game.model.ai.NegaMax;
import com.jensen.boardgames.game.model.board.Cell;
import com.jensen.boardgames.game.model.board.Grid;
import com.jensen.boardgames.game.model.board.GridFactory;
import com.jensen.boardgames.game.model.board.GridPosition;
import com.jensen.boardgames.othello.model.Othello;
import com.jensen.boardgames.othello.model.OthelloState;
import com.jensen.boardgames.othello.model.board.Disk;
import com.jensen.boardgames.othello.model.board.OthelloMove;

/**
 * TODO
 */
public class SmartOthelloAI extends NegaMax<OthelloState, OthelloMove> {

    @Override
    public OthelloMove getMove(OthelloState state) {
        return getMove(state, 5);
    }

    @Override
    protected OthelloState makeMove(OthelloState state, OthelloMove move) {
        OthelloState newState = state.clone();
        Othello.makeMove(newState, move);

        return newState;
    }

    @Override
    protected OthelloMove[] getMoves(OthelloState state) {
        return Othello.getValidMoves(state);
    }

    @Override
    protected int evaluate(OthelloState state) {
        Grid<Integer> weights = new GridFactory<Integer>().createBoardFrom2Darray(new Integer[][] {
            { 99, -8,  8,  6,  6,  8, -8, 99 },
            { -8,-24, -4, -3, -3, -4,-24, -8 },
            {  8, -4,  7,  4,  4,  7, -4,  8 },
            {  6, -3,  4,  0,  0,  4, -3,  6 },
            {  6, -3,  4,  0,  0,  4, -3,  6 },
            {  8, -4,  7,  4,  4,  7, -4,  8 },
            { -8,-24, -4, -3, -3, -4,-24, -8 },
            { 99, -8,  8,  6,  6,  8, -8, 99 }
        });

        int weight = 0;

        for (Cell<Disk> cell : state.getBoard()) {
            int flag = 1;

            if (cell.isEmpty()) {
                continue;
            } else if (cell.getPiece().getColor() != state.getCurrentPlayer().getColor()) {
                flag *= -1;
            }

            GridPosition position = cell.getPosition();
            weight += weights.get(position) * flag;
        }

        return weight;
    }

    @Override
    protected boolean isTerminal(OthelloState state) {
        return Othello.isGameOver(state);
    }
}