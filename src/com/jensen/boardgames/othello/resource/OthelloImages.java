package com.jensen.boardgames.othello.resource;

import com.jensen.boardgames.game.resource.ImageLoader;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;

public abstract class OthelloImages {

    public static Image getWhiteDisk() {
        return ImageLoader.getInstance().load("/othello/white.png", true);
    }

    public static Image getBlackDisk() {
        return ImageLoader.getInstance().load("/othello/black.png", true);
    }

    public static Image getWhiteTransDisk() {
        return ImageLoader.getInstance().load("/othello/whiteTrans.png", true);
    }

    public static Image getBlackTransDisk() {
        return ImageLoader.getInstance().load("/othello/blackTrans.png", true);
    }

    public static Image getObstruction() {
        // TODO Implement obstuction image
        throw new NotImplementedException();
    }
}
