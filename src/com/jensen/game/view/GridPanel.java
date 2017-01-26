package com.jensen.game.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.GridLayout;

public class GridPanel extends JPanel {

    public GridPanel() {
        super();
        setLayout(new GridLayout(5, 5, 1, 1));
        setBackground(Color.black);
        for (int i = 0; i < 25; i++) {
            JLabel label = new JLabel(String.valueOf(i));
            label.setBackground(Color.white);
            label.setOpaque(true);
            label.setHorizontalAlignment(JLabel.CENTER);
            add(label);
        }
    }
}
