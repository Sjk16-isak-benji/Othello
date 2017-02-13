//package com.jensen.boardgames.game.model.board;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//public class BoardTest {
//    private final int WIDTH = 5;
//    private final int HEIGHT = 10;
//    private Board instance;
//
//    @Before
//    @Test
//    public void instanceShouldNotBeNull() {
//        instance = new Board(WIDTH, HEIGHT);
//
//        Assert.assertNotNull(instance);
//    }
//
//    @Test(expected = NegativeArraySizeException.class)
//    public void instantiationShouldThrowIfNegativeSize() {
//        new Board(10, -5);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void instantiationShouldThrowIfOneSideIsSizeZero() {
//        new Board(10, 0);
//    }
//
//    @Test
//    public void instantiationShouldSucceedIfBothSidesAreSizeZero() {
//        Board board = new Board(0, 0);
//        Assert.assertNotNull(board);
//    }
//
//    @Test
//    public void getWidthShouldReturnCorrectSize() {
//        Assert.assertEquals(WIDTH, instance.getWidth());
//    }
//
//    @Test
//    public void getHeightShouldReturnCorrectSize() {
//        Assert.assertEquals(HEIGHT, instance.getHeight());
//    }
//
//    @Test
//    public void sizeShouldReturnCorrectAmountOfCells() {
//        Assert.assertEquals(WIDTH * HEIGHT, instance.size());
//    }
//
//    @Test
//    public void getCellShouldReturnCorrectCell() {
//        for (int x = 0; x < WIDTH; x++) {
//            for (int y = 0; y < HEIGHT; y++) {
//                GridPosition position = instance.get(new GridPosition(x, y)).getPosition();
//
//                Assert.assertEquals(x, position.getX());
//                Assert.assertEquals(y, position.getY());
//            }
//        }
//    }
//
//    @Test(expected = IndexOutOfBoundsException.class)
//    public void getCellShouldThrowWhenOutOfBounds() {
//        instance.get(new GridPosition(instance.getWidth(), 0));
//    }
//
//    @Test
//    public void positionOfShouldReturnCorrectPosition() {
//        for (int x = 0; x < WIDTH; x++) {
//            for (int y = 0; y < HEIGHT; y++) {
//                Cell cell = instance.get(new GridPosition(x, y));
//                GridPosition position = instance.positionOf(cell);
//
//                Assert.assertEquals(x, position.getX());
//                Assert.assertEquals(y, position.getY());
//            }
//        }
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void positionOfShouldThrowIfCellNotPresent() {
//        instance.positionOf(new Cell(new Board(0, 0)));
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void positionOfShouldThrowIfInputNull() {
//        instance.positionOf(null);
//    }
//}
