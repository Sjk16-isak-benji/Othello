package com.jensen.game.view;

import com.jensen.game.inteface.GameView;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class DefualtGameView extends JPanel implements GameView {

    private GridPanel gridPanel;
    private JButton menuButton;
    private JLabel titleLabel;
    private JLabel messageLabel;

    public DefualtGameView() {
        super();
        initPanel("A Grid Game");
    }

    public DefualtGameView(String name) {
        super();
        initPanel(name);
    }

    private void initPanel(String name) {
        gridPanel = new GridPanel();

        setLayout(new BorderLayout());
        add(initHeadPanel(name), BorderLayout.PAGE_START);
        add(gridPanel, BorderLayout.CENTER);
        add(initMessagePanel(), BorderLayout.PAGE_END);
    }

    //alternativ till att HeadPanel ärver ifrån JPanel
    private JPanel initHeadPanel(String name) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        titleLabel = new JLabel(name);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(titleLabel, BorderLayout.CENTER);

        menuButton = new JButton("Menu");
        menuButton.setActionCommand("Menu");
        panel.add(menuButton, BorderLayout.LINE_END);

        panel.add(Box.createHorizontalStrut(30), BorderLayout.LINE_START);
        return panel;
    }

    private JPanel initMessagePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

        panel.add(Box.createHorizontalStrut(20));

        messageLabel = new JLabel();
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(messageLabel);
        return panel;
    }

    public void setTitleText(String text) {
        titleLabel.setText(text);
    }

    public void setTitleIcon(Icon icon) {
        titleLabel.setIcon(icon);
    }

    @Override
    public void updateCell(int x, int y, String status) {

    }

    @Override
    public void updateMessage(String message) {
        messageLabel.setText(message);
    }

    @Override
    public void addGridListener(MouseListener l) {

    }

    @Override
    public void addMenuButtonListener(ActionListener l) {
        menuButton.addActionListener(l);
    }

    @Override
    public void addSetupListener(ActionListener l) {

    }

    @Override
    public Component getComponent() {
        return this;
    }
}
