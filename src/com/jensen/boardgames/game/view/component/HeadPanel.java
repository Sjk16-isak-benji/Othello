package com.jensen.boardgames.game.view.component;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

/**
 * TODO
 */
public class HeadPanel extends JPanel {

    private JButton menuButton;
    private JLabel title;

    /**
     * TODO
     *
     * @param name
     */
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

    /**
     * TODO
     *
     * @param text
     */
    public void setTitleText(String text) {
        title.setText(text);
    }

    /**
     * TODO
     *
     * @param icon
     */
    public void setTitleIcon(Icon icon) {
        title.setIcon(icon);
    }

    /**
     * TODO
     *
     * @param l
     */
    public void addMenuButtonListener(ActionListener l) {
        menuButton.addActionListener(l);
    }
}
