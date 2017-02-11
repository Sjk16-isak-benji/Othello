package com.jensen.game.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * A view in which to setup a game.
 */
public class GameSetupView extends JPanel {

    public static void main(String[] args) {
        GameSetupView a = new GameSetupView("acb");
        a.showDifficulties(new String[] { "Aaifhsio", "soifseo" });
        a.showOpponentType(new String[] { "afjei", "pohjrs" });
        a.showPlayerCount(5, 10);

        JFrame frame = new JFrame();
        frame.add(a);
        //frame.setSize(new Dimension(300, 500));
        frame.pack();
        frame.setVisible(true);
    }

    private String name;
    private JPanel centerPanel;
    private JButton startButton;
    private JComboBox difficultyComboBox;
    private JComboBox opponentComboBox;
    private JSpinner playerCountSpinner;
    private JSpinner boardSizeSpinner;

    public GameSetupView(String name) {
        this.name = name;
        setLayout(new BorderLayout(5, 5));

        initCenterPanel();
        initExitPanel();
    }

    private void initExitPanel() {
        JPanel startPanel = new JPanel();
        startPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        startButton = new JButton("Done");
        startPanel.add(startButton);

        add(startPanel, BorderLayout.SOUTH);
    }

    private void initCenterPanel() {
        JPanel centerPanelWrapper = new JPanel();
        centerPanelWrapper.setLayout(new FlowLayout(FlowLayout.CENTER));

        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(0, 1, 0, 10));
        centerPanelWrapper.add(centerPanel);

        add(centerPanelWrapper);
    }

    public void showDifficulties(String[] difficulties) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel difficultyDescription = new JLabel("Difficulty: ");
        panel.add(difficultyDescription);

        difficultyComboBox = new JComboBox(difficulties);
        panel.add(difficultyComboBox);

        centerPanel.add(panel);
    }

    public Object getDifficulty() {
        if (difficultyComboBox == null) {
            return null;
        }
        return difficultyComboBox.getSelectedItem();
    }

    public void showPlayerCount(int min, int max) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel playerCountDescription = new JLabel("Player count: ");
        panel.add(playerCountDescription);

        playerCountSpinner = new JSpinner(new SpinnerNumberModel(min, min, max, 1));
        panel.add(playerCountSpinner);

        centerPanel.add(panel);
    }

    public Object getPlayerCount() {
        if (playerCountSpinner == null) {
            return null;
        }
        return playerCountSpinner.getModel().getValue();
    }

    public void showOpponentType(String[] types) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel opponentDescription = new JLabel("Opponent: ");
        panel.add(opponentDescription);

        opponentComboBox = new JComboBox(types);
        panel.add(opponentComboBox);

        centerPanel.add(panel);
    }

    public Object getOpponentType() {
        if (opponentComboBox == null) {
            return null;
        }
        return opponentComboBox.getSelectedItem();
    }

    public void showBoardSize(int min, int max, int stepSize) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel boardSizeDescription = new JLabel("Board size: ");
        panel.add(boardSizeDescription);

        boardSizeSpinner = new JSpinner(new SpinnerNumberModel(min, min, max, stepSize));
        panel.add(boardSizeSpinner);

        centerPanel.add(panel);
    }

    public Object getBoardSize() {
        if (boardSizeSpinner == null) {
            return null;
        }
        return boardSizeSpinner.getModel().getValue();
    }

    public String getName() {
        return name;
    }

    public void addListeners(ActionListener l) {
        startButton.addActionListener(l);
    }
}
