package com.jensen.game.view;

import com.jensen.game.inteface.View;

import javax.swing.JPanel;
import java.awt.Component;
import java.awt.event.ActionListener;

/**
 * A view in which to setup a game.
 */
public class GameSetupView extends JPanel implements View {

    public GameSetupView() {
        // TODO create base panels and objects then use setters for customization


    }

    // TODO Create getters for settings

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
        return null;
    }
}
