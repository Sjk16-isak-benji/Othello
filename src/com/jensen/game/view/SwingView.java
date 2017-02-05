package com.jensen.game.view;

import com.jensen.game.controller.GameOption;
import com.jensen.game.exception.NoSuchViewFoundException;
import com.jensen.game.inteface.GameView;
import com.jensen.game.inteface.SingleView;
import com.jensen.game.model.Difficulty;
import com.jensen.game.model.GridPosition;
import com.jensen.game.othello.view.OthelloGameView;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

public class SwingView implements SingleView {

    private Window window;
    private GameView game;
    private GameSetupView setupView;
    private ActionListener menuListener;
    private ActionListener setupListener;
    private MouseListener gridListener;
    private Map<String, GameOption> settings;

    public SwingView() {
        window = new Window();
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void changeViewTo(String viewName) throws NoSuchViewFoundException {
        // TODO switch case with all available views
        switch (viewName.toLowerCase()) {
            case "menu":
                displayMenu();
                break;
            case "othello_setup":
                displayOthelloSetup();
                break;
            case "othello":
                displayOthelloGame();
                break;
            case "ongoing_game":
                continuGame();
                break;

            default:
                throw new NoSuchViewFoundException("Missing case for: " + viewName);
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
        // TODO change exception
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
        // TODO switch case with game name as key to create a map with nec. info.
        //  or pass along to the view if it's a setup view
        Map<String, GameOption> map = new HashMap<String, GameOption>();
        map.put("name", new GameOption<>("gameName", "Othello"));
        map.put("size", new GameOption<>("size", setupView.getBoardSize()));
        map.put("difficulty", new GameOption<>("difficulty", setupView.getDifficulty()));
        map.put("opponent", new GameOption<>("opponent", setupView.getOpponentType()));
        //map.put("playercount", new GameOption<>("playercount", setupView.getPlayerCount()));
        settings = map;
        return settings;
    }

    private void displayMenu() {
        String[] games = { "Othello" };
        MenuView menu = new MenuView(games);
        menu.addListener(menuListener);

        if (game != null) {
            menu.showContinue();
        }

        window.setView(menu);
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
        setupView.addListeners(setupListener);
        window.setView(setupView);
    }

    private void displayOthelloGame() {
        // TODO make generic game view creation
        // switch case on setup name defualt creates a DefualtGameView
        int size = (int) settings.get("size").getValue();
        game = new OthelloGameView(size, size);
        game.addGridListener(gridListener);
        game.addMenuButtonListener(menuListener);
        window.setView((JPanel) game);
    }

    private void continuGame() {
        window.setView((JPanel) game);
    }

    private boolean isPlaying() {
        return window.getCurrentView().equals(game);
    }
}
