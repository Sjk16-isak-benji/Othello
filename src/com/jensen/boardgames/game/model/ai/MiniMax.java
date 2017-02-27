package com.jensen.boardgames.game.model.ai;

interface MiniMax<S, M> {
    M getMove(S state);
    M getMove(S state, int depth);
}
