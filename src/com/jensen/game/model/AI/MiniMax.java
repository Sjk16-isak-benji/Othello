package com.jensen.game.model.AI;

interface MiniMax<S, M> {
    M getMove(S state);
    M getMove(S state, int depth);
}
