package com.jensen.boardgames.game.view.component;

import javax.swing.Box;
import javax.swing.JLabel;
import java.awt.FlowLayout;

public class MessagePanel extends javax.swing.JPanel {

    private JLabel messageLabel;

    public MessagePanel() {
        super();
        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(Box.createHorizontalStrut(20));

        messageLabel = new JLabel();
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        add(messageLabel);
    }

    public void setMessageText(String text) {
        messageLabel.setText(text);
    }

}
