package com.jensen.boardgames.othello.model.board;

import com.jensen.boardgames.game.model.board.PieceColor;
import com.jensen.boardgames.othello.model.board.Disk;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DiskTest {
    private PieceColor color = PieceColor.WHITE;
    private Disk instance;

    @Before
    @Test
    public void instanceShouldNotBeNull() {
        instance = new Disk(color);

        Assert.assertNotNull(instance);
    }

    @Test
    public void getColorShouldReturnCorrectColor() {
        Assert.assertEquals(color, instance.getColor());
    }

    @Test
    public void flipShouldChangeDiskColor() {
        Assert.assertEquals(color, instance.getColor());
        instance.flip();
        Assert.assertNotEquals(color, instance.getColor());
    }
}
