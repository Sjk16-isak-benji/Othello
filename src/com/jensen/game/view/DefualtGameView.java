package com.jensen.game.view;

import com.jensen.game.inteface.GameView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class DefualtGameView extends JPanel implements GameView {

    @Override
    public void updateCell(int x, int y, String status) {

    }

    @Override
    public void updateMessage(String message) {

    }

    @Override
    public void addGridListener(MouseListener l) {

    }

    @Override
    public void addMenuButtonListener(ActionListener l) {

    }

    @Override
    public void addSetupListener(ActionListener l) {

    }

    @Override
    public Component getComponent() {
        return null;
    }
}
