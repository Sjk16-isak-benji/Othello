package com.jensen.game.controller;

import com.jensen.game.exception.NoSuchViewFoundException;
import com.jensen.game.inteface.Game;
import com.jensen.game.inteface.SingleView;
import com.jensen.game.model.GridPosition;
import com.jensen.game.othello.model.OthelloModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

public class Controller {

    public class MenuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand().toLowerCase()) {
                case "menu":
                    displayView("MENU");
                    break;
                case "othello":
                    displayView("OTHELLO_SETUP");
                    break;
                case "continue":
                    displayView("ONGOING_GAME");
                    break;
                case "exit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Button fail: " + e.getActionCommand());
            }
        }
    }

    public class SetupListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand().toLowerCase()) {
                case "done":
                    initGame();
                    break;
                default:
                    break;
            }
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
            GridPosition pos = view.getPositionOf(e.getSource());
            String status = game.getStatus(pos.getX(), pos.getY());
            view.mouseEnteredCell(pos.getX(), pos.getY(), status);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            GridPosition pos = view.getPositionOf(e.getSource());
            String status = game.getStatus(pos.getX(), pos.getY());
            view.updateCell(pos.getX(), pos.getY(), status);
        }

        private void mouseClick(Object source) {
            GridPosition pos = view.getPositionOf(source);
            if (pos != null) {
                game.move(pos.getX(), pos.getY());
                updateBoard();
            } else {
                view.displayErrorMessage("Fatal mouse click!");
            }

            updateMessage();
        }
    }

    private SingleView view;
    private Game game;
    private int width;
    private int height;

    public Controller(SingleView view) {
        this.view = view;
        view.setMenuListener(new MenuListener());
        view.setSetupListener(new SetupListener());
        view.setGridListener(new GridListener());
        displayView("MENU");
    }

    private void displayView(String viewName) {
        try {
            view.changeViewTo(viewName);
        } catch (NoSuchViewFoundException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void initGame() {
        Map<String, GameOption> settings = view.getOptions();
        // TODO implement GameFactory
        //game = GameFactory.getGame(settings);
        //displayView(settings.get("name").getName());
        width = height = (int) settings.get("size").getValue();
        game = new OthelloModel(width, height, (String) settings.get("opponent").getValue(), (String) settings.get("difficulty").getValue());
        displayView(((String) settings.get("name").getValue()).toUpperCase());
        updateBoard();
        updateMessage();
    }
/*
    private void initOthelloGame() {
        height = width = setupView.getBoardSize();
        String type = setupView.getOpponentType();
        String diff = setupView.getDifficulty();

        game = new OthelloModel(width, height, type, diff);

        gameView = new OthelloGameView(width, height);
        gameView.addGridListener(new GridListener());
        gameView.addMenuButtonListener(new MenuListener());
        displayGameView();
    }

    private void displayGameView() {
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

        if (gameView != null) {
            menu.showContinue();
        }

        window.setView(menu);
    }*/

    private void updateBoard() {
        for (int row = 0; row < width; row++) {
            for (int column = 0; column < height; column++) {
                view.updateCell(column, row, game.getStatus(column, row));
            }
        }
    }

    private void updateMessage() {
        String message;
        while ((message = game.getMessage()) != null) {
            // TODO delay between messages
            view.updateMessage(message);
        }
    }

}
