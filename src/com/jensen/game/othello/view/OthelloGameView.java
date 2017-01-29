package com.jensen.game.othello.view;

import com.jensen.game.view.DefualtGameView;
import com.jensen.game.view.StretchIcon;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
    public OthelloGameView(int width, int height) {
        super("Othello", width, height);
    }

    @Override
    public void updateCell(int x, int y, String status) {
        StretchIcon image;

        if(status.contains("VALID")) {
            status = "";
        }

        switch (status) {
            case "WHITE":
                // TODO use resouceLoader instead
                image = new StretchIcon("resources/othello/white.png");
                break;
            case "BLACK":
                // TODO use resouceLoader instead
                image = new StretchIcon("resources/othello/black.png");
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
