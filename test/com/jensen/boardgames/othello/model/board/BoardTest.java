package com.jensen.boardgames.othello.model.board;

import com.jensen.boardgames.game.model.board.Board;
import com.jensen.boardgames.game.model.board.Cell;
import com.jensen.boardgames.game.model.board.GridPosition;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {
    private final int WIDTH = 5;
    private final int HEIGHT = 10;
    private Board instance;

    @Before
    @Test
    public void instanceShouldNotBeNull() {
        instance = new Board(WIDTH, HEIGHT);

        Assert.assertNotNull(instance);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void instantiationShouldThrowIfNegativeSize() {
        new Board(10, -5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void instantiationShouldThrowIfOneSideIsSizeZero() {
        new Board(10, 0);
    }

    @Test
    public void instantiationShouldSucceedIfBothSidesAreSizeZero() {
        Board board = new Board(0, 0);
        Assert.assertNotNull(board);
    }

    @Test
    public void getWidthShouldReturnCorrectSize() {
        Assert.assertEquals(WIDTH, instance.getWidth());
    }

    @Test
    public void getHeightShouldReturnCorrectSize() {
        Assert.assertEquals(HEIGHT, instance.getHeight());
    }

    @Test
    public void getCellsShouldReturnCorrectAmountOfCells() {
        Cell[] cells = instance.getCells();

        Assert.assertEquals(WIDTH * HEIGHT, cells.length);
    }

    @Test
    public void getCellShouldReturnCorrectCell() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                GridPosition point = instance.getCell(x, y).getPosition();

                Assert.assertEquals(x, point.getX());
                Assert.assertEquals(y, point.getY());
            }
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getCellShouldThrowWhenOutOfBounds() {
        instance.getCell(instance.getWidth(), 0);
    }

    @Test
    public void positionOfShouldReturnCorrectPosition() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                Cell cell = instance.getCell(x, y);
                GridPosition point = instance.positionOf(cell);

                Assert.assertEquals(x, point.getX());
                Assert.assertEquals(y, point.getY());
            }
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void positionOfShouldThrowIfCellNotPresent() {
        instance.positionOf(new Cell(new Board(0, 0)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void positionOfShouldThrowIfInputNull() {
        instance.positionOf(null);
    }
}
