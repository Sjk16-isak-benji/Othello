package com.jensen.game;

import com.jensen.game.controller.Controller;
import com.jensen.game.view.Window;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Window window = new Window();

        new Controller(window);

        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.pack();
    }
}
