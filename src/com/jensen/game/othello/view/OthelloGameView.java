package com.jensen.game.othello.view;

import com.jensen.game.othello.resource.OthelloImages;
import com.jensen.game.view.DefualtGameView;
import com.jensen.game.view.StretchIcon;

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

        switch (status) {
            case "WHITE":
                image = new StretchIcon(OthelloImages.getWhiteDisk());
                break;
            case "BLACK":
                image = new StretchIcon(OthelloImages.getBlackDisk());
                break;
            case "OBSTRUCTION":
                image = new StretchIcon(OthelloImages.getObstruction());
                break;
            case "":
                image = null;
                break;
            default:
                throw new IllegalArgumentException("Unknown status.");
        }

        getCell(y, x).setIcon(image);
    }
}
