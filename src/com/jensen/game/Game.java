package com.jensen.game;

import com.jensen.game.inteface.GameView;
import com.jensen.game.othello.view.OthelloGameView;
import com.jensen.game.view.Window;

import javax.swing.JFrame;

public class Game {

    public static void main(String[] args) {
        GameView game = new OthelloGameView();
        JFrame window = new Window(game);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.pack();

        game.updateMessage("Hello World!");

    }
}
