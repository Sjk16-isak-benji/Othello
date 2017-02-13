package com.jensen.boardgames.game.view;

import com.jensen.boardgames.game.controller.GameOption;
import com.jensen.boardgames.game.model.board.GridPosition;
import com.jensen.boardgames.othello.view.OthelloGameView;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 */
public class SwingView implements SingleView {

    private Window window;
    private GameView game;
    private GameSetupView setupView;
    private ActionListener menuListener;
    private MouseListener gridListener;
    private Map<String, GameOption> settings;

    /**
     * TODO
     */
    public SwingView() {
        window = new Window();
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void displayMenu(String[] games) {
        MenuView menu = new MenuView(games);
        menu.addListener(menuListener);

        if (game != null) {
            menu.showContinue();
        }

        window.setView(menu);
    }

    @Override
    public void displaySetup(String name, int[] size, String[] opponentTypes, String[] difficulties, int[] playerCount) {
        setupView = new GameSetupView(name);

        if (opponentTypes != null) {
            setupView.showOpponentType(opponentTypes);
        }

        if (difficulties != null) {
            setupView.showDifficulties(difficulties);
        }

        if (size != null) {
            setupView.showBoardSize(size[0], size[1], size[2]);
        }

        if (playerCount != null) {
            setupView.showPlayerCount(playerCount[0], playerCount[1]);
        }

        setupView.addListeners(menuListener);
        window.setView(setupView);
    }

    @Override
    public void playGame(String name, int width, int height) {
        // TODO make generic game view creation
        // switch case on setup name defualt creates a DefualtGameView
        switch (name.toLowerCase()) {
            case "othello":
                game = new OthelloGameView(width, height);
                break;
            default:
                game = new DefualtGameView(name, width, height);
                break;
        }
        game.addGridListener(gridListener);
        game.addMenuButtonListener(menuListener);
        window.setView((JPanel) game);
    }

    @Override
    public void continuGame() {
        window.setView((JPanel) game);
    }

    @Override
    public void quit() {
        window.dispose();
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

        if (window.getCurrentView().equals(setupView)) {
            map.put("name", new GameOption<>("gamename", setupView.getName()));
            map.put("size", new GameOption<>("size", setupView.getBoardSize()));
            map.put("difficulty", new GameOption<>("difficulty", setupView.getDifficulty()));
            map.put("opponent", new GameOption<>("opponent", setupView.getOpponentType()));
            map.put("playercount", new GameOption<>("playercount", setupView.getPlayerCount()));
            settings = map;
        }

        return settings;
    }

    /**
     * TODO
     *
     * @return
     */
    private boolean isPlaying() {
        return window.getCurrentView().equals(game);
    }
}
