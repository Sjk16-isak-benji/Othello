package com.jensen.game.othello.resouce;

import com.jensen.game.resource.ImageLoader;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.awt.*;

public abstract class OthelloImages {

    public static Image getWhiteDisk() {
        return ImageLoader.getInstance().load("/othello/white.png", true);
    }

    public static Image getBlackDisk() {
        return ImageLoader.getInstance().load("/othello/black.png", true);
    }

    public static Image getObstruction() {
        // TODO
        throw new NotImplementedException();
    }
}
