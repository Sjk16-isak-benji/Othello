package com.jensen.boardgames.game.resource;

/**
 * An interface describing a resource loader.
 *
 * @param <T> The type of resource to load.
 */
public interface ResourceLoader<T> {

    /**
     * Loads a resource based on a path.
     *
     * @param path The path of the resource.
     * @return A resource.
     */
    T load(String path);
}
