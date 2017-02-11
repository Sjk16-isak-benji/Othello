package com.jensen.game;

import com.jensen.game.controller.Controller;
import com.jensen.game.view.SwingView;

public class Main {

    public static void main(String[] args) {

        new Controller(new SwingView());
    }
}
