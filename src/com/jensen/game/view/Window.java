package com.jensen.game.view;

import javax.swing.*;

public class Window extends JFrame {

    private JPanel currentView;

    public Window() {
        super();
    }

    public Window(JPanel view) {
        super();
        currentView = view;
        add(currentView);
    }

    public Window(JPanel view, String title) {
        super(title);
        currentView = view;
        add(currentView);
    }

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

    public JPanel getCurrentView() {
        return currentView;
    }

    public void displayErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

}
