package com.jensen.game.inteface;

import java.awt.event.MouseListener;

public interface GameView extends View {

    void updateCell(int x, int y, String status);

    void updateMessage(String message);

    void addGridListener(MouseListener l);

}
