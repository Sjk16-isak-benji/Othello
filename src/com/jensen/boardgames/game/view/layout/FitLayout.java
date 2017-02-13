package com.jensen.boardgames.game.view.layout;

import java.awt.*;

/**
 * TODO
 */
public class FitLayout implements LayoutManager {

    @Override
    public void addLayoutComponent(String name, Component comp) {
        // TODO
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        // TODO
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        // TODO
        return new Dimension(100, 100);
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        // TODO
        return new Dimension(1, 1);
    }

    @Override
    public void layoutContainer(Container parent) {
        Insets insets = parent.getInsets();
        int maxWidth = parent.getWidth() - (insets.left + insets.right);
        int maxHeight = parent.getHeight() - (insets.top + insets.bottom);
        int x = insets.left;
        int y = insets.top;

        for (int i = 0; i < parent.getComponentCount(); i++) {
            Component component = parent.getComponent(i);

            if (!component.isVisible()) {
                continue;
            }

            Dimension dimension = component.getPreferredSize();
            int width = dimension.width;
            int height = dimension.height;
            double a = (double) maxWidth / maxHeight;
            double b = (double) width / height;

            if (a > b) {
                height = maxHeight;
                width = (int) (height * b);
                x += maxWidth / 2 - width / 2;
            } else {
                width = maxWidth;
                height = (int) (width / b);
                y += maxHeight / 2 - height / 2;
            }

            component.setBounds(x, y, width, height);
        }
    }
}
