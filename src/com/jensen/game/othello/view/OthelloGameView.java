package com.jensen.game.othello.view;

import com.jensen.game.view.DefualtGameView;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.swing.*;

/**
 * An Extension of the defualt game view to display a othello game.
 * Overrides updateCell to display othello pieces instead of text.
 *
 * @see DefualtGameView
 */
public class OthelloGameView extends DefualtGameView {

    /**
     * Creates a othello game view with Othello written in the header.
     */
    public OthelloGameView() {
        super("Othello", 5, 5);
    }

    @Override
    public void updateCell(int x, int y, String status) {
        ImageIcon image;

        switch (status) {
            case "WHITE":
                // TODO use resouceLoader instead
                image = new ImageIcon("/resources/othello/white.png");
                break;
            case "BLACK":
                // TODO use resouceLoader instead
                image = new ImageIcon("/resources/othello/black.png");
                break;
            case "OBSTRUCTION":
                // TODO
                throw new NotImplementedException();
            case "":
                image = null;
                break;
            default:
                throw new IllegalArgumentException("Unknown status.");
        }

        getCell(y, x).setIcon(image);
    }
}
