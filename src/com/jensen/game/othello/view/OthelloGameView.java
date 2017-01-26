package com.jensen.game.othello.view;

import com.jensen.game.view.DefualtGameView;
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
    public OthelloGameView() {
        super("Othello", 5, 5);
    }

    @Override
    public void updateCell(int x, int y, String status) {
        throw new NotImplementedException();
    }
}
