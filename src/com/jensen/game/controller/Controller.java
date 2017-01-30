package com.jensen.game.controller;

import com.jensen.game.inteface.Display;
import com.jensen.game.inteface.Game;
import com.jensen.game.inteface.GameView;
import com.jensen.game.inteface.View;
import com.jensen.game.model.Difficulty;
import com.jensen.game.model.GridPosition;
import com.jensen.game.othello.model.OthelloModel;
import com.jensen.game.othello.view.OthelloGameView;
import com.jensen.game.view.GameSetupView;
import com.jensen.game.view.MenuView;
import com.jensen.game.view.Window;

import javax.swing.*;
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
                    displayMenu();
                    break;
                case "othello":
                    displayOthelloSetup();
                    break;
                case "continue":
                    // TODO create game model with user pref
                    break;
                default:
                    System.out.println("Button fail: " + e.getActionCommand());
            }
        }
    }

    public class SetupListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            initOthelloGame();
        }
    }

    public class GridListener implements MouseListener {

        private Object pressedSource;

        @Override
        public void mouseClicked(MouseEvent e) {
            //mouseClick(e.getSource());
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
            gameView.mouseEnteredCell(pos.getX(), pos.getY(), status);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            GridPosition pos = gameView.getPositionOf(e.getSource());
            String status = game.getStatus(pos.getX(), pos.getY());
            gameView.updateCell(pos.getX(), pos.getY(), status);
        }

        private void mouseClick(Object source) {
            GridPosition pos = gameView.getPositionOf(source);
            if (pos != null) {
                game.move(pos.getX(), pos.getY());
                updateBoard();
            } else {
                window.displayErrorMessage("Fatal mouse click!");
            }

            updateMessage();
        }
    }

    private Window window;
    private GameSetupView setupView;
    private GameView gameView;
    private Game game;
    private int width;
    private int height;

    public Controller(Window window) {
        this.window = window;
        displayMenu();
    }

    private void initOthelloGame() {
        height = width = setupView.getBoardSize();
        String type = setupView.getOpponentType();
        String diff = setupView.getDifficulty();

        game = new OthelloModel(width, height, type, diff);

        gameView = new OthelloGameView(width, height);
        gameView.addGridListener(new GridListener());
        gameView.addMenuButtonListener(new MenuListener());
        window.setView((JPanel) gameView);
        updateBoard();
        updateMessage();
    }

    private void displayOthelloSetup() {
        setupView = new GameSetupView();
        setupView.showOpponentType(new String[] { "Human", "Computer" });

        Difficulty[] difficulties = Difficulty.values();
        String[] strings = new String[difficulties.length];

        for (int i = 0; i < difficulties.length; i++) {
            Difficulty difficulty = difficulties[i];
            strings[i] = difficulty.toString();
        }

        setupView.showDifficulties(strings);
        setupView.showBoardSize(8, 14, 2);
        setupView.addListeners(new SetupListener());
        window.setView(setupView);
    }

    private void displayMenu() {
        String[] games = { "Othello" };
        MenuView menu = new MenuView(games);
        menu.addListener(new MenuListener());
        window.setView(menu);
    }

    private void updateBoard() {
        for (int row = 0; row < width; row++) {
            for (int column = 0; column < height; column++) {
                gameView.updateCell(column, row, game.getStatus(column, row));
            }
        }
    }

    private void updateMessage() {
        String message;
        while ((message = game.getMessage()) != null) {
            // TODO delay between messages
            gameView.updateMessage(message);
        }
    }

}
