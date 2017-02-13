package com.jensen.boardgames.game.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * TODO
 */
public class MenuView extends JPanel {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setMinimumSize(new Dimension(500, 500));
        frame.add(new MenuView(new String[] { "Test", "Test", "Test", "Test" }));
        frame.pack();
        frame.setVisible(true);
    }

    private JButton exitButton;
    private JButton[] gameButtons;
    private JButton continueButton;

    /**
     * TODO
     *
     * @param games
     */
    public MenuView(String[] games) {
        setLayout(new BorderLayout(5, 5));

        initCenterPanel(games);
        initExitPanel();
    }

    /**
     * TODO
     */
    private void initExitPanel() {
        JPanel exitPanel = new JPanel();
        exitPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        exitButton = new JButton("Exit");
        exitPanel.add(exitButton);

        add(exitPanel, BorderLayout.SOUTH);
    }

    /**
     * TODO
     *
     * @param games
     */
    private void initCenterPanel(String[] games) {
        JPanel centerPanelWrapper = new JPanel();
        centerPanelWrapper.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(0, 1, 0, 10));
        centerPanelWrapper.add(centerPanel);

        continueButton = new JButton("Continue");
        continueButton.setVisible(false);
        centerPanel.add(continueButton);

        gameButtons = new JButton[games.length];

        for (int i = 0; i < games.length; i++) {
            String game = games[i];
            JButton gameButton = new JButton(game);
            gameButtons[i] = gameButton;
            centerPanel.add(gameButton);
        }

        add(centerPanelWrapper);
    }

    /**
     * TODO
     */
    public void showContinue() {
        continueButton.setVisible(true);
    }

    /**
     * TODO
     *
     * @param l
     */
    public void addListener(ActionListener l) {
        continueButton.addActionListener(l);
        exitButton.addActionListener(l);

        for (JButton game : gameButtons) {
            game.addActionListener(l);
        }
    }
}
