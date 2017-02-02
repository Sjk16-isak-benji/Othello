package com.jensen.game.inteface;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public interface SingleView {

    void changeViewTo(String viewName);

    void updateCell(int x, int y, String status);

    void updateMessage(String msg);

    void addSetupListener(ActionListener l);

    void addMenuListener(ActionListener l);

    void addGridListener(MouseListener l);

    ArrayList<GameOption> getOptions();

}
