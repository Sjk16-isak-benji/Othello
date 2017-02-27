package com.jensen.boardgames;

import com.jensen.boardgames.game.controller.Controller;
import com.jensen.boardgames.game.view.SwingView;

public class Main {

    public static void main(String[] args) {
        new Controller(new SwingView());
    }
}
