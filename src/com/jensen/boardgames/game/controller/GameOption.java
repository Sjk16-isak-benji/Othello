package com.jensen.boardgames.game.controller;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * TODO
 *
 * @param <E>
 */
public class GameOption<E> {

    private String name;
    private E value;

    /**
     * TODO
     *
     * @param optionName
     * @param value
     */
    public GameOption(String optionName, E value) {
        this.name = optionName;
        this.value = value;
    }

    /**
     * TODO
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * TODO
     *
     * @return
     */
    public E getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(value:" + getValue().toString() + ", type:" + getValue().getClass().getSimpleName() + ")";
    }

    @Override
    public GameOption<E> clone() {
        throw new NotImplementedException();
    }

    @Override
    public boolean equals(Object obj) {
        throw new NotImplementedException();
    }
}
