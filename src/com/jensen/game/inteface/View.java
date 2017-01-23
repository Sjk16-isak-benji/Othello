package com.jensen.game.inteface;

import java.awt.Component;
import java.awt.event.ActionListener;

public interface View {

    void addMenuButtonListener(ActionListener l);

    void addSetupListener(ActionListener l);

    Component getComponent();


}
