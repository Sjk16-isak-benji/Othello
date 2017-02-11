package com.jensen.game.controller;

import com.jensen.game.inteface.Game;
import com.jensen.game.inteface.SingleView;
import com.jensen.game.model.Difficulty;
import com.jensen.game.model.GridPosition;
import com.jensen.game.othello.model.OthelloModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

/**
 * TODO
 */
public class Controller {

    public class MenuListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand().toLowerCase()) {
                case "menu":
                    view.displayMenu(new String[] { "Othello" });
                    break;
                case "othello":
                    view.displaySetup("othello", new int[] { 8, 14, 2 }, new String[] { "Human", "Computer" },
                            new String[] { Difficulty.EASY.toString(), Difficulty.NORMAL.toString(), Difficulty.HARD.toString() },
                            null);
                    break;
                case "continue":
                    view.continuGame();
                    break;
                case "exit":
                    view.quit();
                    break;
                case "done":
                    initGame();
                    break;
                default:
                    System.out.println("Button fail: " + e.getActionCommand());
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
                game.performAction(pos.getX(), pos.getY());
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

    /**
     * TODO
     *
     * @param view
     */
    public Controller(SingleView view) {
        this.view = view;
        view.setMenuListener(new MenuListener());
        view.setGridListener(new GridListener());
        view.displayMenu(new String[] { "Othello" });
    }

    /**
     * TODO
     */
    private void initGame() {
        Map<String, GameOption> settings = view.getOptions();
        // TODO implement GameFactory
        //game = GameFactory.getGame(settings);
        //displayView(settings.get("name").getName());
        width = height = (int) settings.get("size").getValue();
        game = new OthelloModel(width, height, (String) settings.get("opponent").getValue(), (String) settings.get("difficulty").getValue());
        view.playGame((String) settings.get("name").getValue(), width, height);
        updateBoard();
        updateMessage();
    }

    /**
     * TODO change to only update changed cells
     */
    private void updateBoard() {
        for (int row = 0; row < width; row++) {
            for (int column = 0; column < height; column++) {
                view.updateCell(column, row, game.getStatus(column, row));
            }
        }
    }

    /**
     * TODO
     */
    private void updateMessage() {
        String message;
        while ((message = game.getMessage()) != null) {
            // TODO delay between messages
            view.updateMessage(message);
        }
    }

}
