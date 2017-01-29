package com.jensen.game.othello.view;

import com.jensen.game.view.DefualtGameView;
import com.jensen.game.view.StretchIcon;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.Color;

/**
 * An Extension of the defualt game view to display a othello game.
 * Overrides updateCell to display othello pieces instead of text.
 *
 * @see DefualtGameView
 */
public class OthelloGameView extends DefualtGameView {

    private final Color STANDARD_COLOR = Color.getHSBColor(0.3305556f, 1.0f, 0.74f);
    private final Color LATEST_PLACED_COLOR = Color.YELLOW;
    private final Color VALID_COLOR = Color.GREEN;

    /**
     * Creates a othello game view with Othello written in the header.
     */
    public OthelloGameView(int width, int height) {
        super("Othello", width, height);
        setColor(width, height);
    }

    private void setColor(int width, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                getCell(i, j).setBackground(STANDARD_COLOR);
            }
        }
    }

    @Override
    public void updateCell(int x, int y, String status) {
        StretchIcon image;

        if(status.contains("VALID")) {
            status = "";
        }

        if (status.contains("LATEST")) {
            status = status.replace("LATEST-", "");
            getCell(y, x).setBackground(LATEST_PLACED_COLOR);
        } else {
            getCell(y, x).setBackground(STANDARD_COLOR);
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

    @Override
    public void mouseEnteredCell(int x, int y, String status) {
        if (status.contains("VALID")) {
            StretchIcon image;
            getCell(y, x).setBackground(VALID_COLOR);

            switch (status) {
                case "VALID-WHITE":
                    // TODO use resouceLoader instead
                    image = new StretchIcon("resources/othello/white.png");
                    break;
                case "VALID-BLACK":
                    // TODO use resouceLoader instead
                    image = new StretchIcon("resources/othello/black.png");
                    break;
                default:
                    throw new IllegalArgumentException("Unknown status.");
            }

            getCell(y, x).setIcon(image);
        }
    }
}
