package com.jensen.game.view;

import com.jensen.game.inteface.GameView;
import com.jensen.game.model.GridPosition;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

/**
 * The defualt view for a grid game.
 */
public class DefualtGameView extends JPanel implements GameView {

    private JLabel[][] cells;
    private JPanel gridPanel;
    private JButton menuButton;
    private JLabel titleLabel;
    private JLabel messageLabel;

    /**
     * Creates a default game view with name as its title.
     *
     * @param name The name of the game.
     */
    public DefualtGameView(String name, int width, int height) {
        super();

        setLayout(new BorderLayout());
        add(initHeadPanel(name), BorderLayout.PAGE_START);
        add(initGridPanel(width, height), BorderLayout.CENTER);
        add(initMessagePanel(), BorderLayout.PAGE_END);
    }

    /**
     * Initiates and returns the grid panel.
     *
     * @param width The amount of columns in the grid
     * @param height The amount of rows in the grid
     * @return A JPanel with a FitLayout containing a grid.
     */
    private JPanel initGridPanel(int width, int height) {
        JPanel panel = new JPanel();
        panel.setLayout(new FitLayout());
        panel.setPreferredSize(new Dimension(500, 500));

        gridPanel = new JPanel();
        //gridPanel.setBorder(new LineBorder(Color.BLACK, 1));
        gridPanel.setLayout(new GridLayout(width, height));
        gridPanel.setPreferredSize(new Dimension(1, 1));
        panel.add(gridPanel);

        cells = new JLabel[height][width];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                JLabel label = new JLabel();
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setOpaque(true);
                label.setBackground(Color.WHITE);
                label.setBorder(new LineBorder(Color.BLACK, 1));
                cells[y][x] = label;
                gridPanel.add(label);
            }
        }

        return panel;
    }

    /**
     * Initiates and returns the head panel.
     *
     * @param name The text to be displayed in this header.
     * @return A JPanel with a BorderLayout containing a JLabel with name and a menu button.
     */
    private JPanel initHeadPanel(String name) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        titleLabel = new JLabel(name);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(titleLabel, BorderLayout.CENTER);

        menuButton = new JButton("Menu");
        menuButton.setActionCommand("Menu");
        panel.add(menuButton, BorderLayout.LINE_END);

        panel.add(Box.createHorizontalStrut(30), BorderLayout.LINE_START);
        return panel;
    }

    /**
     * Initiates and returns the message panel.
     *
     * @return A JPanel with a left aligned FlowLayout containing a JLabel where message will be displayed.
     */
    private JPanel initMessagePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

        panel.add(Box.createHorizontalStrut(20));

        messageLabel = new JLabel();
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(messageLabel);
        return panel;
    }

    protected JLabel getCell(int row, int col) {
        return cells[row][col];
    }

    /**
     * Sets the text in this title label.
     *
     * @param text The text to be displayed in this header.
     */
    protected void setTitleText(String text) {
        titleLabel.setText(text);
    }

    /**
     * Sets the icon in this title label.
     *
     * @param icon The icon to be displayed in this header.
     */
    protected void setTitleIcon(Icon icon) {
        titleLabel.setIcon(icon);
    }

    @Override
    public void updateCell(int x, int y, String status) {
        getCell(y, x).setText(status);
    }

    @Override
    public void mouseEnteredCell(int x, int y, String status) {

    }

    @Override
    public GridPosition getPositionOf(Object o) {
        for (int y = 0; y < cells.length; y++) {
            for (int x = 0; x <cells[y].length; x++) {
                if (cells[y][x].equals(o)) {
                    return new GridPosition(x, y);
                }
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void updateMessage(String message) {
        messageLabel.setText(message);
    }

    @Override
    public void addGridListener(MouseListener l) {
        for (JLabel[] row: cells) {
            for (JLabel cell: row) {
                cell.addMouseListener(l);
            }
        }
    }

    @Override
    public void addMenuButtonListener(ActionListener l) {
        menuButton.addActionListener(l);
    }

    @Override
    public void addSetupListener(ActionListener l) {

    }

    @Override
    public Component getComponent() {
        return this;
    }
}
