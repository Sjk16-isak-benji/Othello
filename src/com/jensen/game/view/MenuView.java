package com.jensen.game.view;

import com.jensen.game.inteface.View;

import javax.swing.*;
import java.awt.Component;
import java.awt.event.ActionListener;

public class MenuView extends JPanel implements View {

    public MenuView(String[] games) {
        // TODO make a button for each game
    }

    @Override
    public void updateMessage(String message) {

    }

    @Override
    public void addMenuButtonListener(ActionListener l) {

    }

    @Override
    public void addSetupListener(ActionListener l) {

    }

    @Override
    public Component getComponent() {
        return this;
    }
}
