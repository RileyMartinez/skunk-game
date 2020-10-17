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
		myGame.startNewTurn(); 
		assertTrue(myGame.getNumberOfTurns() == 1); 		
	}
	
	@Test
	//test to see if a turn is in progress
	public void testGameTurnStatus() {
		Game myGame = new Game(); 
		myGame.startNewTurn(); 
		assertEquals(true, myGame.getTurnStatus()); 
	}
	
	@Test
	//test to see if players can be added to a game
	public void testAddPlayersToGame() { 
		Game myGame = new Game(); 
		myGame.addPlayer("Nicole Burns"); 
		assertTrue(myGame.getNumberOfPlayers() == 1); 
		myGame.addPlayer("Riley Martinez");
		assertTrue(myGame.getNumberOfPlayers() == 2);
	}
	
	@Test
	//test to see who is playing a given game
	public void testPrintPlayers() { 
		Game myGame = new Game(); 
		myGame.addPlayer("Nicole Burns"); 
		assertEquals("[(Nicole Burns, 50 chips, 0 points)]", myGame.printPlayers()); 

	}

	
}
