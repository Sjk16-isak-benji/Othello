package com.jensen.game.othello.model;

import com.jensen.game.exception.UnknownStatusException;
import com.jensen.game.inteface.Game;
import com.jensen.game.model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Random;

public class OthelloModel implements Game {

    private Board board;
    private OthelloPlayer[] players;
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
                Difficulty difficulty;

                switch (diff.toLowerCase()) {
                    case "easy":
                        difficulty = Difficulty.EASY;
                        break;
                    case "normal":
                    case "hard":
                    default:
                        difficulty = Difficulty.NORMAL;
                        break;
                }

                players[0].setComputerControlled(difficulty);
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

        PieceColor[] colors = PieceColor.values();

        for (int i = 0; i < players.length; i++) {
            PieceColor color = colors[i];

            players[i] = new OthelloPlayer(String.valueOf(i), color);
        }
    }

    @Override
    public boolean performAction(int x, int y) {
        OthelloPlayer player = getCurrentPlayer();

        if (OthelloBoard.isGameOver(players, board)) {
            return false;
        }

        if (!OthelloBoard.isValidMove(player, x, y, board)) {
            addMessage("Invalid Move!");
            return false;
        }

        int flips = OthelloBoard.makeMove(player, x, y, board);
        latestMove = board.getCell(x, y);
        addMessage(player.getColor() + " flipped " + flips + " disks.");

        prepareNextTurn();

        return true;
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
        Cell cell = board.getCell(x, y);

        if (OthelloBoard.isValidMove(getCurrentPlayer(), x, y, board)) {
            return "VALID-" + getCurrentPlayer().getColor();
        }

        if (cell.isEmpty()) {
            return "";
        }

        String latest = "";
        if (cell.equals(latestMove)) {
            latest = "LATEST-";
        }

        Piece piece = cell.getPiece();

        if (piece instanceof Disk) {
            return latest + ((Disk) piece).getColor();
        }

        if (piece instanceof Obstruction) {
            return "OBSTRUCTION";
        }

        throw new UnknownStatusException();
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

        if (OthelloBoard.isGameOver(players, board)) {
            addMessage("Game Over! (" + OthelloBoard.getScore(board) + ")");
            return;
        }

        OthelloPlayer player = getCurrentPlayer();

        if (!OthelloBoard.hasValidMoves(player, board)) {
            prepareNextTurn();
        }

        addMessage(player.getColor() + "s' turn!");

        if (player.isComputerControlled()) {
            Cell[] validMoves = OthelloBoard.getValidMoves(player, board);
            Cell chosenMove = player.getAI().getMove(validMoves);
            GridPosition movePosition = chosenMove.getPosition();
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
     * Gets the current active player.
     *
     * @return A player.
     */
    private OthelloPlayer getCurrentPlayer() {
        return players[currentPlayerIndex];
    }

    /**
     * Switches to the next player.
     *
     * @return The next player.
     */
    private OthelloPlayer nextPlayer() {
        if (OthelloBoard.isGameOver(players, board)) {
            return null;
        }

        currentPlayerIndex = (currentPlayerIndex + 1) % players.length;

        OthelloPlayer player = getCurrentPlayer();

        if (!OthelloBoard.hasValidMoves(player, board)) {
            nextPlayer();
        }

        return player;
    }

    /**
     * Switches to a random player.
     *
     * @return The chosen player.
     */
    private OthelloPlayer randomPlayer() {
        if (OthelloBoard.isGameOver(players, board)) {
            return null;
        }

        currentPlayerIndex = new Random().nextInt(players.length);

        OthelloPlayer player = getCurrentPlayer();

        if (!OthelloBoard.hasValidMoves(player, board)) {
            nextPlayer();
        }

        return player;
    }
}
