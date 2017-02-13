package com.jensen.boardgames.othello.resource;

import com.jensen.boardgames.game.resource.ImageLoader;

import java.awt.*;

/**
 * A static class used to get images related to othello.
 */
public abstract class OthelloImages {

    /**
     * Gets an image of an othello disk with the white side up.
     *
     * @return An image of an othello disk with the white side up.
     */
    public static Image getWhiteDisk() {
        return ImageLoader.getInstance().load("/othello/white.png", true);
    }

    /**
     * Gets an image of an othello disk with the black side up.
     *
     * @return An image of an othello disk with the black side up.
     */
    public static Image getBlackDisk() {
        return ImageLoader.getInstance().load("/othello/black.png", true);
    }

    /**
     * Gets an image of an transparent othello disk with the white side up.
     *
     * @return An image of an transparent othello disk with the white side up.
     */
    public static Image getWhiteTransDisk() {
        // TODO is it not possible to generate a transparent version on runtime?
        return ImageLoader.getInstance().load("/othello/whiteTrans.png", true);
    }

    /**
     * Gets an image of an transparent othello disk with the black side up.
     *
     * @return An image of an transparent othello disk with the black side up.
     */
    public static Image getBlackTransDisk() {
        // TODO is it not possible to generate a transparent version on runtime?
        return ImageLoader.getInstance().load("/othello/blackTrans.png", true);
    }
}
