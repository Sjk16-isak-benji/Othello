package com.jensen.boardgames.game.view.component;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class StretchIcon extends ImageIcon {
    public StretchIcon(byte[] imageData) {
        super(imageData);
    }

    public StretchIcon(byte[] imageData, String description) {
        super(imageData, description);
    }

    public StretchIcon(Image image) {
        super(image);
    }

    public StretchIcon(Image image, String description) {
        super(image, description);
    }

    public StretchIcon(String filename) {
        super(filename);
    }

    public StretchIcon(String filename, String description) {
        super(filename, description);
    }

    public StretchIcon(URL location) {
        super(location);
    }

    public StretchIcon(URL location, String description) {
        super(location, description);
    }

    @Override
    public synchronized void paintIcon(Component c, Graphics g, int x, int y) {
        Image image = getImage();

        if (image == null) {
            return;
        }

        Insets insets = ((Container) c).getInsets();

        int width = c.getWidth() - insets.right - insets.left;
        int height = c.getHeight() - insets.bottom - insets.top;

        g.drawImage(image, insets.left, insets.top, width, height, getImageObserver());
    }
}