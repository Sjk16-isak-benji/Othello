package com.jensen.boardgames.othello.model;

import com.jensen.boardgames.game.model.GameState;
import com.jensen.boardgames.othello.model.board.OthelloBoard;
import com.jensen.boardgames.othello.model.player.OthelloPlayer;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * A class describing the state of a game of othello.
 */
public class OthelloState implements GameState<OthelloBoard, OthelloPlayer> {

    protected OthelloBoard board;
    protected OthelloPlayer[] players;
    protected OthelloPlayer currentPlayer;

    @Override
    public OthelloBoard getBoard() {
        return board;
    }

    @Override
    public OthelloPlayer[] getPlayers() {
        return players;
    }

    @Override
    public OthelloPlayer getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public void setCurrentPlayer(OthelloPlayer player) {
        this.currentPlayer = player;
    }

    @Override
    public String toString() {
        throw new NotImplementedException();
    }

    @Override
    public OthelloState clone() {
        OthelloState state = new OthelloState();
        state.board = board.clone();
        state.players = players;
        state.currentPlayer = currentPlayer;

        return state;
    }

    @Override
    public boolean equals(Object obj) {
        throw new NotImplementedException();
    }
}
