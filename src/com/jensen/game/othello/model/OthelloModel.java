package com.jensen.game.othello.model;

import com.jensen.game.inteface.Game;
import com.jensen.game.model.*;

import java.util.Random;

public class OthelloModel implements Game {

    private Board board;
    private OthelloPlayer[] players;
    private int currentPlayerIndex;
    private String message = "";

    public OthelloModel(String[] playerNames, int width, int height) {
        initPlayers(playerNames);
        initBoard(width, height);
    }

    /**
     * Initiates the board.
     *
     * @param width The amount of columns of the board.
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

        if (isGameOver()) {
            setMessage("Game Over!");
            return false;
        }

        if (getValidMoves(player).length == 0) {
            setMessage(player.getName() + " can't make a move!");
            nextPlayer();
            move(x, y);
        }

        if (!isValidMove(player, x, y)) {
            setMessage("Invalid Move!");
            return false;
        }

        // place disk
        Disk newDisk = new Disk(player.getColor());
        board.getCell(x, y).place(newDisk);

        // flip other player disks
        int flips = 0;

        for (Direction direction : Direction.values()) {
            if (!isValidMove(player, x, y, direction)) {
                continue;
            }

            Cell cell = board.getCell(x, y);

            while ((cell = cell.getAdjacentCell(direction)) != null) {
                if (cell.isEmpty()) {
                    break;
                }

                Piece piece = cell.getPiece();

                if (!(piece instanceof Disk)) {
                    break;
                }

                Disk disk = (Disk) piece;

                if (disk.getColor() == player.getColor()) {
                    break;
                } else {
                    disk.flip();
                    flips++;
                }
            }
        }

        setMessage(player.getName() + " flipped " + flips + " disks.");

        // TODO what if player can't move?
        player = nextPlayer();
        setMessage(player.getName() + "s' turn!");

        // TODO what if only computer controlled players?
        if (player.isComputerControlled()) {
            Cell chosenMove = player.getAI().getMove(getValidMoves(player));
            GridPosition movePosition = chosenMove.getPosition();
            move(movePosition.getX(), movePosition.getY());
        }

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

    @Override
    public String getMessage() {
        return message;
    }

    /**
     * Sets the current message.
     */
    private void setMessage(String msg) {
        message = msg;
    }

    /**
     * Checks whether the game is over.
     *
     * @return A boolean indicating whether
     */
    private boolean isGameOver() {
        for (OthelloPlayer player : players) {
            if (getValidMoves(player).length != 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Gets valid moves a player may make.
     *
     * @param player The player in question.
     * @return Valid cells a player may move to.
     */
    private Cell[] getValidMoves(OthelloPlayer player) {
        Cell[] cells = board.getCells();
        int validCellArrayLength = 0;

        for (Cell cell : cells) {
            GridPosition position = cell.getPosition();

            if (isValidMove(player, position.getX(), position.getY())) {
                validCellArrayLength++;
            }
        }

        Cell[] validCells = new Cell[validCellArrayLength];

        int i = 0;
        for (Cell cell: cells) {
            GridPosition position = cell.getPosition();

            if (isValidMove(player, position.getX(), position.getY())) {
                validCells[i] = cell;
                i++;
            }
        }

        return validCells;
    }

    /**
     * Checks whether a specific cell is a valid move for a specific player.
     *
     * @param player The player.
     * @param x The column of the cell.
     * @param y The row of the cell.
     * @return A boolean indicating whether the cell is a valid move for the player.
     */
    private boolean isValidMove(OthelloPlayer player, int x, int y) {
        for (Direction direction : Direction.values()) {
            if (isValidMove(player, x, y, direction)) {
                return true;
            }
        }

        return false;
    }

    /**
     * TODO
     */
    private boolean isValidMove(OthelloPlayer player, int x, int y, Direction direction) {
        int gap = 0;
        Cell cell = board.getCell(x, y);

        while ((cell = cell.getAdjacentCell(direction)) != null) {
            if (cell.isEmpty()) {
                break;
            }

            Piece piece = cell.getPiece();

            if (!(piece instanceof Disk)) {
                break;
            }

            Disk disk = (Disk) piece;

            if (disk.getColor() == player.getColor()) {
                break;
            }

            gap++;
        }

        return gap > 0;
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
        currentPlayerIndex = (currentPlayerIndex + 1) % players.length;

        return getCurrentPlayer();
    }

    /**
     * Switches to a random player.
     *
     * @return The chosen player.
     */
    private OthelloPlayer randomPlayer() {
        currentPlayerIndex = new Random().nextInt(players.length);

        return getCurrentPlayer();
    }
}
