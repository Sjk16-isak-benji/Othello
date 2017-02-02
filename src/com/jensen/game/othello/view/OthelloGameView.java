package com.jensen.game.othello.view;

import com.jensen.game.othello.resource.OthelloImages;
import com.jensen.game.view.DefualtGameView;
import com.jensen.game.view.StretchIcon;

import java.awt.Color;

/**
 * An Extension of the defualt game view to display a othello game.
 * Overrides updateCell to display othello pieces instead of text.
 *
 * @see DefualtGameView
 */
public class OthelloGameView extends DefualtGameView {

    private final Color STANDARD_COLOR = Color.getHSBColor(0.3305556f, 1.0f, 0.74f);
    private final Color LATEST_PLACED_COLOR = Color.BLUE;
    private final Color VALID_COLOR = Color.GREEN;

    /**
     * Creates a othello game view with Othello written in the header.
     */
    public OthelloGameView(int width, int height) {
        super("Othello", width, height);
    }

    @Override
    public void updateCell(int x, int y, String status) {
        StretchIcon image;

        getCell(y, x).setBackground(STANDARD_COLOR);

        switch (status) {
            case "LATEST-WHITE":
                getCell(y, x).setBackground(LATEST_PLACED_COLOR);
            case "WHITE":
                image = new StretchIcon(OthelloImages.getWhiteDisk());
                break;
            case "LATEST-BLACK":
                getCell(y, x).setBackground(LATEST_PLACED_COLOR);
            case "BLACK":
                image = new StretchIcon(OthelloImages.getBlackDisk());
                break;
            case "OBSTRUCTION":
                image = new StretchIcon(OthelloImages.getObstruction());
                break;
            default:
                image = null;
        }

        getCell(y, x).setIcon(image);
    }

    @Override
    public void mouseEnteredCell(int x, int y, String status) {

        switch (status) {
            case "VALID-WHITE":
                updateValidCell(x, y, new StretchIcon(OthelloImages.getWhiteTransDisk()));
                break;
            case "VALID-BLACK":
                updateValidCell(x, y, new StretchIcon(OthelloImages.getBlackTransDisk()));
                break;
            default:
        }

    }

    private void updateValidCell(int x, int y, StretchIcon image) {
        getCell(y, x).setBackground(VALID_COLOR);
        getCell(y, x).setIcon(image);
    }
}
