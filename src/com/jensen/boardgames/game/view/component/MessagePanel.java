package com.jensen.boardgames.game.view.component;

import javax.swing.Box;
import javax.swing.JLabel;
import java.awt.FlowLayout;

/**
 * TODO
 */
public class MessagePanel extends javax.swing.JPanel {

    private JLabel messageLabel;

    /**
     * TODO
     */
    public MessagePanel() {
        super();
        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(Box.createHorizontalStrut(20));

        messageLabel = new JLabel();
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        add(messageLabel);
    }

    /**
     * TODO
     *
     * @param text
     */
    public void setMessageText(String text) {
        messageLabel.setText(text);
    }
}
