package com.jensen.boardgames.othello.model;

import com.jensen.boardgames.game.exception.UnknownStatusException;
import com.jensen.boardgames.game.Game;
import com.jensen.boardgames.game.model.board.*;
import com.jensen.boardgames.othello.model.board.*;
import com.jensen.boardgames.othello.model.player.OthelloPlayer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * TODO
 */
public class OthelloModel extends OthelloState implements Game {

    private int currentPlayerIndex;
    private Deque<String> messageQueue = new LinkedList<String>();
    private Cell latestMove;

    public OthelloModel(int width, int height, String type, String diff) {
        initPlayers();
        initBoard(width, height);

        randomPlayer();

        switch (type.toLowerCase()) {
            case "human":
                break;
            case "computer":
            default:
                // TODO allow for different difficulties in different games
                players[0].setComputerControlled(diff.toUpperCase());
                break;
        }

        prepareNextTurn();
    }

    /**
     * Initiates the board.
     *
     * @param width  The amount of columns of the board.
     * @param height The amount of rows of the board.
     */
    private void initBoard(int width, int height) {
        board = new OthelloBoardFactory().createBoard(width, height);
    }

    /**
     * Initiates players.
     */
    private void initPlayers() {
        players = new OthelloPlayer[2];

        DiskColor[] colors = DiskColor.values();

        for (int i = 0; i < players.length; i++) {
            DiskColor color = colors[i];

            players[i] = new OthelloPlayer(String.valueOf(i), color);
        }
    }

    @Override
    public boolean performAction(int x, int y) {
        OthelloPlayer player = getCurrentPlayer();
        GridPosition position = new GridPosition(x, y);
        OthelloMove move = new OthelloMove(position, getCurrentPlayer());

        if (Othello.isGameOver(this)) {
            return false;
        }

        if (!Othello.isValidMove(this, move)) {
            addMessage("Invalid Move!");
            return false;
        }

        int flips = Othello.makeMove(this, move);
        latestMove = board.get(position);
        addMessage(player.getColor() + " flipped " + flips + " disks.");

        prepareNextTurn();

        return true;
    }

    @Override
    public boolean performAlternativeAction(int x, int y) {
        return false;
    }

    @Override
    public boolean isValid(int x, int y) {
        return Othello.isValidMove(this, new OthelloMove(new GridPosition(x, y), getCurrentPlayer()));
    }

    /**
     * Gets the status (content) of a board cell.
     *
     * @param x The column of the cell
     * @param y The row of the cell
     * @return One of the following strings: "WHITE", "BLACK", "OBSTRUCTION", "" (empty string)
     */
    @Override
    public String getStatus(int x, int y) {
        Cell<Disk> cell = board.get(new GridPosition(x, y));

        if (isValid(x, y)) {
            return "VALID-" + getCurrentPlayer().getColor();
        }

        if (cell.isEmpty()) {
            return "";
        }

        Disk disk = cell.getPiece();

        if (disk != null) {
            String latest = "";
            if (cell.equals(latestMove)) {
                latest = "LATEST-";
            }

            return latest + disk.getColor();
        }

        throw new UnknownStatusException();
    }

    @Override
    public GridPosition[] getChangedCellPositions() {
        // TODO Implement getChangedCellPositions() or use observable pattern
        return new GridPosition[0];
    }

    /**
     * Gets and removes the first message from the message queue. Returns null if there are no messages.
     *
     * @return A message.
     */
    @Override
    public String getMessage() {
        try {
            return messageQueue.pop();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    /**
     * Switches to the next player with a valid move. If that player is computer controlled it perfomes the AI's move.
     * Sets game over message if no player can make a move.
     */
    private void prepareNextTurn() {
        nextPlayer();

        if (Othello.isGameOver(this)) {
            addMessage("Game Over! (" + Othello.getScore(this) + ")");
            return;
        }

        OthelloPlayer player = getCurrentPlayer();

        if (Othello.getValidMoves(this).length == 0) {
            prepareNextTurn();
        }

        addMessage(player.getColor() + "s' turn!");

        if (player.isComputerControlled()) {
            // TODO clone state?
            Move move = player.getAI().getMove(this);
            GridPosition movePosition = move.getPosition();
            performAction(movePosition.getX(), movePosition.getY());
        }
    }

    /**
     * Adds a message to the message queue.
     */
    private void addMessage(String msg) {
        messageQueue.add(msg);
    }

    /**
     * Switches to the next player.
     *
     * @return The next player.
     */
    private OthelloPlayer nextPlayer() {
        if (Othello.isGameOver(this)) {
            return null;
        }

        currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
        setCurrentPlayer(players[currentPlayerIndex]);

        if (Othello.getValidMoves(this).length == 0) {
            nextPlayer();
        }

        return getCurrentPlayer();
    }

    /**
     * Switches to a random player.
     *
     * @return The chosen player.
     */
    private OthelloPlayer randomPlayer() {
        if (Othello.isGameOver(this)) {
            return null;
        }

        currentPlayerIndex = new Random().nextInt(players.length);
        setCurrentPlayer(players[currentPlayerIndex]);

        if (Othello.getValidMoves(this).length == 0) {
            nextPlayer();
        }

        return getCurrentPlayer();
    }
}
