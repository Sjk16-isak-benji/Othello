package com.jensen.game.view;

import com.jensen.game.inteface.GameView;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

/**
 * The defualt view for a grid game.
 */
public class DefualtGameView extends JPanel implements GameView {

    private JPanel gridPanel;
    private JButton menuButton;
    private JLabel titleLabel;
    private JLabel messageLabel;

    /**
     * Creates a default game view with name as its title.
     *
     * @param name The name of the game.
     */
    public DefualtGameView(String name, int width, int height) {
        super();

        setLayout(new BorderLayout());
        add(initHeadPanel(name), BorderLayout.PAGE_START);
        add(initGridPanel(width, height), BorderLayout.CENTER);
        add(initMessagePanel(), BorderLayout.PAGE_END);
    }

    /**
     * Initiates and returns the grid panel.
     *
     * @param width The amount of columns in the grid
     * @param height The amount of rows in the grid
     * @return A JPanel with a FitLayout containing a grid.
     */
    private JPanel initGridPanel(int width, int height) {
        JPanel panel = new JPanel();
        panel.setLayout(new FitLayout());
        panel.setPreferredSize(new Dimension(500, 500));

        gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(width, height));
        gridPanel.setPreferredSize(new Dimension(1, 1));
        panel.add(gridPanel);

        for (int i = 0; i < width * height; i++) {
            JLabel label = new JLabel();
            label.setHorizontalAlignment(JLabel.CENTER);
            gridPanel.add(label);
        }

        return panel;
    }

    /**
     * Initiates and returns the head panel.
     *
     * @param name The text to be displayed in this header.
     * @return A JPanel with a BorderLayout containing a JLabel with name and a menu button.
     */
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

    /**
     * Initiates and returns the message panel.
     *
     * @return A JPanel with a left aligned FlowLayout containing a JLabel where message will be displayed.
     */
    private JPanel initMessagePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

        panel.add(Box.createHorizontalStrut(20));

        messageLabel = new JLabel();
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(messageLabel);
        return panel;
    }

    /**
     * Sets the text in this title label.
     *
     * @param text The text to be displayed in this header.
     */
    public void setTitleText(String text) {
        titleLabel.setText(text);
    }

    /**
     * Sets the icon in this title label.
     *
     * @param icon The icon to be displayed in this header.
     */
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
