package com.jensen.boardgames.othello.model.board;

import com.jensen.boardgames.game.model.board.GridPosition;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GridPositionTest {
    private int xPos = -5;
    private int yPos = 10;
    private GridPosition instance;

    @Before
    @Test
    public void instanceShouldNotBeNull() {
        instance = new GridPosition(xPos, yPos);

        Assert.assertNotNull(instance);
    }

	@Test
	public void getXShouldReturnCorrectHorizontalPosition() {
        Assert.assertEquals(xPos, instance.getX());
	}

	@Test
	public void getYShouldReturnCorrectVerticalPosition() {
        Assert.assertEquals(yPos, instance.getY());
	}
}
