package com.jensen.game.inteface;

import java.awt.Component;
import java.awt.event.ActionListener;

/**
 * An inteface for a controller to communicate with a view.
 */
public interface View {

    /**
     * Displays a message to the user.
     *
     * @param message The message to be displayed.
     */
    void updateMessage(String message);

    /**
     * Adds a listener to all menu buttons in the view.
     *
     * @param l The listener to be notified when a menu button is clicked.
     */
    void addMenuButtonListener(ActionListener l);

    /**
     * Adds a listener to all setup related event.
     *
     * @param l The listener to be notified when a setting is changed or set.
     */
    void addSetupListener(ActionListener l);

    /**
     * Returns the view as a component.
     *
     * @return The view
     * @see Component
     */
    Component getComponent();


}
