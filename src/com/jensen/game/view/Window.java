package com.jensen.game.view;

import com.jensen.game.inteface.Display;
import com.jensen.game.inteface.View;

import javax.swing.*;

public class Window extends JFrame implements Display {

    private View currentView;

    public Window(View view) {
        super();
        currentView = view;
        add(currentView.getComponent());
    }

    public Window(View view, String title) {
        super(title);
        currentView = view;
        add(currentView.getComponent());
    }

    @Override
    public void changeView(View newView) {
        if (newView == null) throw new IllegalArgumentException("New view is null");
        if (currentView != null) remove(currentView.getComponent());
        currentView = newView;
        add(currentView.getComponent());
        repaint();
        pack();
    }

    @Override
    public View getCurrentView() {
        return currentView;
    }

    @Override
    public void displayErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

}
