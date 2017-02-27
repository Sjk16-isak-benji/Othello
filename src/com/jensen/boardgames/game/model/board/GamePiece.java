package com.jensen.boardgames.game.model.board;

/**
 * An interface for a board game piece.
 */
public interface GamePiece {

    /**
     * Gets a character representation of this game piece.
     *
     * @return A character representation of this game piece.
     */
    char toRepresentativeChar();

    // TODO getOwner() ?
}
