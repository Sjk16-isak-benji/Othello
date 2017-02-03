package com.jensen.game.view;

import com.jensen.game.controller.GameOption;
import com.jensen.game.inteface.GameView;
import com.jensen.game.inteface.SingleView;
import com.jensen.game.model.GridPosition;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Map;

public class SwingView implements SingleView {

    private Window window;
    private GameView game;
    private ActionListener menuListener;
    private ActionListener setupListener;
    private MouseListener gridListener;

    public SwingView() {
        window = new Window();
    }

    @Override
    public void changeViewTo(String viewName) {
        // TODO switch case with all available views
        switch (viewName.toUpperCase()) {
            case "MENU":
                displayMenu();
                break;
            case "OTHELLO_SETUP":
                displayOthelloSetup();
                break;
            case "OTHELLO":
                displayOthelloGame();
                break;
            case "ONGOING_GAME":
                continuGame();
                break;

            default:
                throw new NoSuchViewFound("Missing case for: " + viewName);
                break;
        }
    }

    @Override
    public void displayErrorMessage(String msg) {
        window.displayErrorMessage(msg);
    }

    @Override
    public void updateCell(int x, int y, String status) {
        if (isPlaying()) {
            game.updateCell(x, y, status);
        }
    }

    @Override
    public void mouseEnteredCell(int x, int y, String status) {
        if (isPlaying()) {
            game.mouseEnteredCell(x, y, status);
        }
    }

    @Override
    public GridPosition getPositionOf(Object o) {
        if (isPlaying()) {
           return game.getPositionOf(o);
        }

        throw new NullPointerException("Not Playing");
    }

    @Override
    public void updateMessage(String msg) {
        if (isPlaying()) {
            game.updateMessage(msg);
        }
    }

    @Override
    public void setSetupListener(ActionListener l) {
        setupListener = l;
    }

    @Override
    public void setMenuListener(ActionListener l) {
        menuListener = l;
    }

    @Override
    public void setGridListener(MouseListener l) {
        gridListener = l;
    }

    @Override
    public Map<String, GameOption> getOptions() {
        return null;
    }

    private boolean isPlaying() {
        return window.getCurrentView().equals(game);
    }
}
