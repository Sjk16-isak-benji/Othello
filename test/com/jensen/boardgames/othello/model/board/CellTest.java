package com.jensen.boardgames.othello.model.board;

import com.jensen.boardgames.game.model.board.Board;
import com.jensen.boardgames.game.model.board.Cell;
import com.jensen.boardgames.game.model.board.GridPosition;
import com.jensen.boardgames.game.model.board.Piece;
import com.jensen.boardgames.game.util.Direction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CellTest {
    private int xPos = 3;
    private int yPos = 2;
    private Board board;
    private Cell instance;

    @Before
    @Test
    public void instanceShouldNotBeNull() {
        board = new Board(5, 5);
        instance = board.getCell(xPos, yPos);

        Assert.assertNotNull(instance);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorShouldThrowIfArgumentIsNull() {
        new Cell(null);
    }

	@Test
	public void getPositionShouldReturnCorrectPosition() {
        GridPosition position = instance.getPosition();

        Assert.assertEquals(xPos, position.getX());
        Assert.assertEquals(yPos, position.getY());
	}

	@Test
	public void emptyShouldEmptyCell() {
        instance.place(new Piece() {});
        Assert.assertFalse(instance.isEmpty());
        instance.empty();
        Assert.assertTrue(instance.isEmpty());
	}

	@Test
	public void placeShouldPlacePieceInCell() {
        Piece piece = new Piece() {};
        instance.place(piece);
        Assert.assertSame(piece, instance.getPiece());
	}

	@Test
	public void getAdjacentCellShouldReturnCorrectCellOrNullIfOutOfBounds() {
        for (Cell cell : board.getCells()) {
            GridPosition position = cell.getPosition();

            for (Direction direction : Direction.values()) {
                int x = position.getX() + direction.getHorizontalStep();
                int y = position.getY() + direction.getVerticalStep();
                Cell adjacentCell = cell.getAdjacentCell(direction);

                if (x < 0 || x >= board.getWidth() || y < 0 || y >= board.getHeight()) {
                    Assert.assertNull(adjacentCell);
                } else {
                    GridPosition adjacentPosition = adjacentCell.getPosition();

                    Assert.assertNotNull(adjacentCell);
                    Assert.assertEquals(x, adjacentPosition.getX());
                    Assert.assertEquals(y, adjacentPosition.getY());
                }
            }
        }
    }
}
