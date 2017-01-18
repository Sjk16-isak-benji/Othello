package com.jensen.game.othello.model;

import java.awt.*;

public class Player {
    private String name;
    private Color color;
    private boolean computerControlled;

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
        this.computerControlled = false;
    }

    public void setComputerControlled(boolean computerControlled) {
        this.computerControlled = computerControlled;
    }

    public boolean isComputerControlled() {
        return this.computerControlled;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }
}
