package com.jensen.game.othello.model;

import com.jensen.game.model.Difficulty;
import com.jensen.game.model.Player;
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

