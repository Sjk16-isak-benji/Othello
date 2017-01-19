package com.jensen.game.othello.model;

import com.jensen.game.model.Difficulty;
import com.jensen.game.model.PieceColor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OthelloPlayerTest {
    private PieceColor color = PieceColor.WHITE;
    private OthelloPlayer instance;

    @Before
    @Test
    public void instanceShouldNotBeNull() {
        instance = new OthelloPlayer("", color);

        Assert.assertNotNull(instance);
    }

	@Test
	public void getColorShouldReturnCorrectColor() {
        Assert.assertEquals(color, instance.getColor());
	}

	@Test
	public void setComputerControlledShouldMakePlayerComputerControlled() {
        Assert.assertFalse(instance.isComputerControlled());
        instance.setComputerControlled(Difficulty.EASY);
        Assert.assertTrue(instance.isComputerControlled());
    }
}
