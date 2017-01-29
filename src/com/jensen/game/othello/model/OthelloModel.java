package com.jensen.game.othello.model;

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

    public OthelloModel(String[] playerNames, int width, int height) {
        initPlayers(playerNames);
        initBoard(width, height);

        randomPlayer();

        // players[0].setComputerControlled(Difficulty.NORMAL);
        // players[1].setComputerControlled(Difficulty.EASY);

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
     *
     * @param playerNames The names of the players.
     */
    private void initPlayers(String[] playerNames) {
        players = new OthelloPlayer[playerNames.length];

        PieceColor[] colors = PieceColor.values();

        for (int i = 0; i < playerNames.length; i++) {
            String name = playerNames[i];
            PieceColor color = colors[i];

            players[i] = new OthelloPlayer(name, color);
        }
    }

    @Override
    public boolean move(int x, int y) {
         OthelloPlayer player = getCurrentPlayer();

        if (OthelloBoard.isGameOver(players, board)) {
            return false;
        }

        if (!OthelloBoard.isValidMove(player, x, y, board)) {
            addMessage("Invalid Move!");
            return false;
        }

        int flips = OthelloBoard.makeMove(player, x, y, board);
        addMessage(player.getName() + " flipped " + flips + " disks.");

        prepareNextTurn();

        return true;
    }

    /**
     * TODO
     */
    private void prepareNextTurn() {
        nextPlayer();

        if (OthelloBoard.isGameOver(players, board)) {
            // TODO Check who won and add to or replace message
            addMessage("Game Over!" + " (" + OthelloBoard.getScore(board) + ")");
            return;
        }

        OthelloPlayer player = getCurrentPlayer();

        if (!OthelloBoard.hasValidMoves(player, board)) {
            prepareNextTurn();
        }

        addMessage(player.getName() + "s' turn!");

        if (player.isComputerControlled()) {
            Cell[] validMoves = OthelloBoard.getValidMoves(player, board);
            Cell chosenMove = player.getAI().getMove(validMoves);
            GridPosition movePosition = chosenMove.getPosition();
            move(movePosition.getX(), movePosition.getY());
        }
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

        if (cell.isEmpty()) {
            return "";
        }

        Piece piece = cell.getPiece();

        if (piece instanceof Disk) {
            return ((Disk) piece).getColor().toString();
        }

        if (piece instanceof Obstruction) {
            return "OBSTRUCTION";
        }

        return ""; // throw Exception?
    }

    /**
     * Gets and removes the first message from the message queue. Returns null if there are no messages.
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
        //addMessage(player.getName() + "s' " + "(" + player.getColor().toString().toLowerCase() + ")" + " turn!");

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
        //addMessage(player.getName() + "s' " + "(" + player.getColor().toString().toLowerCase() + ")" + " turn!");

        if (!OthelloBoard.hasValidMoves(player, board)) {
            nextPlayer();
        }

        return player;
    }
}
