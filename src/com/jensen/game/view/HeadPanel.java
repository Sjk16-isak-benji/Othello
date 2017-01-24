package com.jensen.game.view;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

public class HeadPanel extends JPanel {

    private JButton menuButton;
    private JLabel title;

    public HeadPanel(String name) {
        super();
        setLayout(new BorderLayout());

        title = new JLabel(name);
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title, BorderLayout.CENTER);

        menuButton = new JButton("Menu");
        menuButton.setActionCommand("Menu");
        add(menuButton, BorderLayout.LINE_END);

        add(Box.createHorizontalStrut(30), BorderLayout.LINE_START);
    }

    public void setTitleText(String text) {
        title.setText(text);
    }

    public void setTitleIcon(Icon icon) {
        title.setIcon(icon);
    }

    public void addMenuButtonListener(ActionListener l) {
        menuButton.addActionListener(l);
    }

}
