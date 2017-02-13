package com.jensen.boardgames.game.controller;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * TODO
 */
public class Settings {

    private String gameName;
    private String opponent;
    private String difficulty;
    private int width;
    private int height;
    private int playerCount = 1;

    /**
     * TODO
     *
     * @return
     */
    public String getGameName() {
        return gameName;
    }

    /**
     * TODO
     *
     * @param gameName
     */
    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    /**
     * TODO
     *
     * @return
     */
    public String getOpponent() {
        return opponent;
    }

    /**
     * TODO
     *
     * @param opponent
     */
    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    /**
     * TODO
     *
     * @return
     */
    public String getDifficulty() {
        return difficulty;
    }

    /**
     * TODO
     *
     * @param difficulty
     */
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * TODO
     *
     * @return
     */
    public int getWidth() {
        return width;
    }

    /**
     * TODO
     *
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * TODO
     *
     * @return
     */
    public int getHeight() {
        return height;
    }

    /**
     * TODO
     *
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * TODO
     *
     * @return
     */
    public int getPlayerCount() {
        return playerCount;
    }

    /**
     * TODO
     *
     * @param playerCount
     */
    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    @Override
    public String toString() {
        throw new NotImplementedException();
    }

    @Override
    public Settings clone() {
        throw new NotImplementedException();
    }

    @Override
    public boolean equals(Object obj) {
        throw new NotImplementedException();
    }
}
