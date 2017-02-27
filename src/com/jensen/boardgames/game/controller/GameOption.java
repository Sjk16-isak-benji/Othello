package com.jensen.boardgames.game.controller;

public class GameOption<E> {

    private String name;
    private E value;

    public GameOption(String optionName, E value) {
        this.name = optionName;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public E getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getName() + ": " + getValue().toString() + "; Class: " + getValue().getClass().getSimpleName();
    }

}
