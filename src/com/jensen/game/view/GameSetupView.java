package com.jensen.game.view;

import com.jensen.game.inteface.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * A view in which to setup a game.
 */
public class GameSetupView extends JPanel implements View {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new GameSetupView());
        //frame.setSize(new Dimension(300, 500));
        frame.pack();
        frame.setVisible(true);
    }

    private JComboBox<String> difficultyComboBox;

    public GameSetupView() {
        // TODO create base panels and objects then use setters for customization
        setLayout(new GridLayout(0, 1, 0, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel panel;

        panel = new JPanel(new FlowLayout());
        panel.add(new JLabel("Difficulty: "));
        difficultyComboBox = new JComboBox<String>(new String[] { "Easy", "Normal", "Hard" });
        panel.add(difficultyComboBox);
        add(panel);

        panel = new JPanel(new FlowLayout());
        panel.add(new JLabel("Player count: "));
        panel.add(new JSpinner(new SpinnerNumberModel(1, 1, 4, 1)));
        add(panel);

        panel = new JPanel(new FlowLayout());
        panel.add(new JLabel("Something: "));
        panel.add(new JButton("Wawawa"));
        add(panel);

        panel = new JPanel(new FlowLayout());
        panel.add(new JLabel("Something else: "));
        panel.add(new JButton("Woop"));
        add(panel);

        add(new JButton("Start"));
    }

    public void setDifficulties(String[] difficulties) {
        difficultyComboBox.removeAllItems();
        difficultyComboBox.setModel(new DefaultComboBoxModel<String>(difficulties));
    }

    public String getDifficulty() {
        return (String) difficultyComboBox.getSelectedItem();
    }

    public boolean getFightAI() {
        return true;
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
