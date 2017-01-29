package com.jensen.game.controller;

import com.jensen.game.inteface.Display;
import com.jensen.game.inteface.Game;
import com.jensen.game.inteface.GameView;
import com.jensen.game.inteface.View;
import com.jensen.game.model.GridPosition;
import com.jensen.game.othello.model.OthelloModel;
import com.jensen.game.othello.view.OthelloGameView;
import com.jensen.game.view.MenuView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller {

    public class MenuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand().toLowerCase()) {
                case "menu":
                    initOthelloGame();
                    break;
                case "play":
                    // TODO switch view to game setup
                case "continue":
                    // TODO create game model with user pref

                default:
                    System.out.println("Button fail: " + e.getActionCommand());
                    ;
            }
        }
    }

    public class SetupListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public class GridListener implements MouseListener {

        private Object pressedSource;

        @Override
        public void mouseClicked(MouseEvent e) {
            mouseClick(e.getSource());
        }

        @Override
        public void mousePressed(MouseEvent e) {
            pressedSource = e.getComponent();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (pressedSource == e.getComponent().getComponentAt(e.getPoint())) {
                mouseClick(pressedSource);
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            GridPosition pos = gameView.getPositionOf(e.getSource());
            String status = game.getStatus(pos.getX(), pos.getY());
            if (status.equalsIgnoreCase("valid")) {
                e.getComponent().setBackground(Color.GREEN);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            e.getComponent().setBackground(Color.getHSBColor(0.3305556f, 1.0f, 0.74f));
        }

        private void mouseClick(Object source) {
            GridPosition pos = gameView.getPositionOf(source);
            if (pos != null) {
                game.move(pos.getX(), pos.getY());
                updateBoard();
            } else {
                window.displayErrorMessage("Fatal mouse click!");
            }
            gameView.updateMessage(game.getMessage());
        }
    }

    private Display window;
    private GameView gameView;
    private Game game;
    private int width;
    private int height;

    public Controller(Display window) {
        this.window = window;
        //displayMenu();
        initOthelloGame();
    }

    private void initOthelloGame() {
        gameView = createOthelloView();
        gameView.addGridListener(new GridListener());
        gameView.addMenuButtonListener(new MenuListener());
        updateBoard();
        window.setView(gameView);
        updateMessage();
    }

    private void displayMenu() {
        String[] games = { "Othello" };
        View menu = new MenuView(games);
        menu.addMenuButtonListener(new MenuListener());
        this.window.setView(menu);
    }

    private GameView createOthelloView() {
        String[] playerNames = { "Black", "White" };
        width = 8;
        height = 8;
        game = new OthelloModel(playerNames, width, height);
        return new OthelloGameView(width, height);
    }

    private void updateBoard() {
        for (int row = 0; row < width; row++) {
            for (int column = 0; column < height; column++) {
                gameView.updateCell(column, row, game.getStatus(column, row));
            }
        }
    }

    private void updateMessage() {
        window.getCurrentView().updateMessage(game.getMessage());
    }

}
