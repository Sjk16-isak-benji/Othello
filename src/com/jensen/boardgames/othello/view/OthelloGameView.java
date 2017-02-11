package com.jensen.boardgames.othello.view;

import com.jensen.boardgames.othello.resource.OthelloImages;
import com.jensen.boardgames.game.view.DefualtGameView;
import com.jensen.boardgames.game.view.component.StretchIcon;

import javax.swing.JLabel;
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
        Color bgColor = STANDARD_COLOR;

        switch (status) {
            case "LATEST-WHITE":
                bgColor = LATEST_PLACED_COLOR;
            case "WHITE":
                image = new StretchIcon(OthelloImages.getWhiteDisk());
                break;
            case "LATEST-BLACK":
                bgColor = LATEST_PLACED_COLOR;
            case "BLACK":
                image = new StretchIcon(OthelloImages.getBlackDisk());
                break;
            case "OBSTRUCTION":
                image = new StretchIcon(OthelloImages.getObstruction());
                break;
            default:
                image = null;
        }

        updateCell(x, y, bgColor, image);
    }

    @Override
    public void mouseEnteredCell(int x, int y, String status) {
        Color bgColor = VALID_COLOR;

        switch (status) {
            case "VALID-WHITE":
                updateCell(x, y, bgColor, new StretchIcon(OthelloImages.getWhiteTransDisk()));
                break;
            case "VALID-BLACK":
                updateCell(x, y, bgColor, new StretchIcon(OthelloImages.getBlackTransDisk()));
                break;
            default:
        }

    }

    private void updateCell(int x, int y, Color bgColor, StretchIcon image) {
        JLabel cell = getCell(y, x);
        cell.setBackground(bgColor);
        cell.setIcon(image);
    }

}
