package com.jensen.boardgames.othello.model.player;

import com.jensen.boardgames.game.util.Difficulty;
import com.jensen.boardgames.game.model.player.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
    private String name = "George Michael";
    private Player instance;

    @Before
    @Test
    public void instanceShouldNotBeNull() {
        instance = new Player(name) {
            @Override
            public void setComputerControlled(Difficulty difficulty) {}
        };

        Assert.assertNotNull(instance);
    }

	@Test
	public void getNameShouldReturnCorrectName() {
		Assert.assertEquals(name, instance.getName());
	}
}

