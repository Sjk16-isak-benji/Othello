package com.jensen.game.othello.model;

import com.jensen.game.model.Board;
import com.jensen.game.model.BoardFactory;
import org.junit.Assert;
import org.junit.Test;

public class BoardFactoryTest {
	@Test
	public void createBoardShouldHaveCorrectSize() {
	    for (int width = 1; width < 10; width++) {
	        for (int height = 1; height < 10; height++) {
	            Board board = BoardFactory.createBoard(width, height);

                Assert.assertEquals(board.getWidth(), width);
                Assert.assertEquals(board.getHeight(), height);
            }
        }
	}

    @Test(expected = NegativeArraySizeException.class)
    public void createBoardShouldThrowIfNegativeSize() {
        Board board = BoardFactory.createBoard(10, -5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createBoardShouldThrowIfOneSideIsSizeZero() {
        BoardFactory.createBoard(10, 0);
    }

    @Test
    public void createBoardShouldSucceedIfBothSidesAreSizeZero() {
        Board board = BoardFactory.createBoard(0, 0);
        Assert.assertNotNull(board);
    }
}