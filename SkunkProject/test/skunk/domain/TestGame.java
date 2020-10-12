package skunk.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGame {

	
	@Test
	//test to verify that a game is actually instantiated
	public void testGameCreation() {
		Game myGame = new Game(); 
	}
	
	@Test
	//test to verify that a game is started
	public void testGameStart() {
		Game myGame = new Game();
		String gameStatus; 
		gameStatus = myGame.getStatus();
		assertEquals("Game has not started yet", gameStatus);
	}

}
