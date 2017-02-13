package com.jensen.boardgames.game.view;

import javax.swing.*;

/**
 * TODO
 */
public class Window extends JFrame {

    private JPanel currentView;

    /**
     * TODO
     */
    public Window() {
        super();
    }

    /**
     * TODO
     *
     * @param view
     */
    public Window(JPanel view) {
        super();
        currentView = view;
        add(currentView);
    }

    /**
     * TODO
     *
     * @param view
     * @param title
     */
    public Window(JPanel view, String title) {
        super(title);
        currentView = view;
        add(currentView);
    }

    /**
     * TODO
     *
     * @param newView
     */
    public void setView(JPanel newView) {
        if (newView == null) throw new IllegalArgumentException("New view is null");
        if (currentView != null) remove(currentView);
        currentView = newView;
        add(currentView);
        setVisible(false);
        repaint();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * TODO
     *
     * @return
     */
    public JPanel getCurrentView() {
        return currentView;
    }

    /**
     * TODO
     *
     * @param message
     */
    public void displayErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
