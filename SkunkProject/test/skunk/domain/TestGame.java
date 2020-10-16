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
	//test to verify that a game has an appropriate status (started, not started, completed)
	public void testGameStatus() {
		Game myGame = new Game();
		String gameStatus; 
		
		gameStatus = myGame.getStatus();
		assertEquals("The Game has not started yet", gameStatus);
		
		myGame.startGame();
		gameStatus = myGame.getStatus();
		assertEquals("The Game is Afoot!", gameStatus);
		
		myGame.completeGame();
		gameStatus = myGame.getStatus();
		assertEquals("The Game has ended", gameStatus);
	}

	@Test
	//test to verify that there is at least one turn per game
	public void testGameOneTurn() {
		Game myGame = new Game(); 
		myGame.startTurn(); 
		assertTrue(myGame.getNumberOfTurns() == 1); 
	}
	
}
