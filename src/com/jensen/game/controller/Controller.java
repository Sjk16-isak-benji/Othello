package com.jensen.game.controller;

import com.jensen.game.inteface.Display;
import com.jensen.game.inteface.Game;
import com.jensen.game.inteface.GameView;
import com.jensen.game.inteface.View;
import com.jensen.game.model.GridPosition;
import com.jensen.game.view.MenuView;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
                case "play":
                    // TODO switch view to game setup
                case "continue":
                    // TODO create game model with user pref

                default:
                    throw new NotImplementedException();
            }
        }
    }

    public class SetupListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public class GridListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            GridPosition pos = gameView.getPositionOf(e.getSource());
            if (pos != null) {
                game.move(pos.getX(), pos.getY());
            } else {
                window.displayErrorMessage("Fatal mouse click!");
            }
            gameView.updateMessage(game.getMessage());

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    private Display window;
    private GameView gameView;
    private Game game;

    public Controller(Display window) {
        this.window = window;
        //displayMenu();
        createOthelloView();
        window.setView();
    }

    private void displayMenu() {
        String[] games = {"Othello"};
        View menu = new MenuView(games);
        menu.addMenuButtonListener(new MenuListener());
        this.window.setView(menu);
    }

    private void createOthelloView() {
        String[] playerNames = {"Håkan", "Harald"};
        int length = 8;
        game = OthelloModel(playerNames, length, length);
    }

}
