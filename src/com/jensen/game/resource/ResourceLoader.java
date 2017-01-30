package com.jensen.game.resource;

interface ResourceLoader<T> {
    T load(String path);
}
