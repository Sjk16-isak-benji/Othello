package com.jensen.game.othello.model;

import com.jensen.game.model.Board;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OthelloBoardFactoryTest {
    private OthelloBoardFactory instance;

    @Before
    @Test
    public void instanceShouldNotBeNull() {
        instance = new OthelloBoardFactory();

        Assert.assertNotNull(instance);
    }

    // TODO more tests

    @Test
	public void createBoardShouldHaveCorrectSize() {
	    for (int width = 1; width < 10; width++) {
	        for (int height = 1; height < 10; height++) {
	            Board board = instance.createBoard(width, height);

                Assert.assertEquals(board.getWidth(), width);
                Assert.assertEquals(board.getHeight(), height);
            }
        }
	}

    @Test(expected = NegativeArraySizeException.class)
    public void createBoardShouldThrowIfNegativeSize() {
        Board board = instance.createBoard(10, -5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createBoardShouldThrowIfOneSideIsSizeZero() {
        instance.createBoard(10, 0);
    }

    @Test
    public void createBoardShouldSucceedIfBothSidesAreSizeZero() {
        Board board = instance.createBoard(0, 0);
        Assert.assertNotNull(board);
    }
}