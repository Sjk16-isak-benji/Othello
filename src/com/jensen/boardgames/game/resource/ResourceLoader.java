package com.jensen.boardgames.game.resource;

interface ResourceLoader<T> {
    T load(String path);
}
