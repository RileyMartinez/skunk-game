package skunk.domain;

import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class TestGame {
	
	@Test
	//test to verify that a game has an appropriate status (started, not started, completed)
	public void test_game_status() {
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
	public void test_game_one_turn() {
		Game myGame = new Game();
		myGame.addPlayer("Nicole Burns");
		myGame.startGame();
		myGame.startNewTurn(); 
		assertTrue(myGame.getNumberOfTurns() == 1); 		
	}
	
	@Test
	//test to see if a turn is in progress
	public void test_game_turn_status() {
		Game myGame = new Game(); 
		myGame.addPlayer("Nicole Burns");
		myGame.startGame();
		myGame.startNewTurn(); 
		assertEquals(true, myGame.getTurnStatus()); 
	}
	
	@Test
	//test to see if players can be added to a game
	public void test_add_players_to_game() { 
		Game myGame = new Game(); 
		myGame.addPlayer("Nicole Burns"); 
		assertTrue(myGame.getNumberOfPlayers() == 1); 
		myGame.startGame();
		myGame.addPlayer("Riley Martinez");
		assertFalse(myGame.getNumberOfPlayers() == 2);
		
	}
	
	@Test
	//test to remove players from a game
	public void test_remove_players_from_game() { 
		Game myGame = new Game(); 
		myGame.addPlayer("Nicole Burns"); 
		assertTrue(myGame.getNumberOfPlayers() == 1); 
		myGame.startGame();
		myGame.clearAllPlayers();
		assertTrue(myGame.getNumberOfPlayers() == 0);
		
	}
	
	@Test
	//test to see who is playing a given game
	public void test_print_players() { 
		Game myGame = new Game(); 
		myGame.addPlayer("Nicole Burns"); 
		assertEquals("[Player: Nicole Burns\nCurrent Score: 0\nTotal Chips: 50]", myGame.printPlayers());
		myGame.addPlayer("Riley Martinez"); 
		assertEquals("[Player: Nicole Burns\nCurrent Score: 0\nTotal Chips: 50, Player: Riley Martinez\nCurrent Score: 0\nTotal Chips: 50]", myGame.printPlayers()); 

	}
	
	@Test
	//test to see who is playing a given game
	public void test_whose_turn_is_it() { 
		Game myGame = new Game(); 
		myGame.addPlayer("Nicole Burns");
		myGame.addPlayer("Riley Martinez");
		myGame.addPlayer("Some Random");
		
		myGame.startGame();
		
		myGame.startNewTurn();
		Player contestant = myGame.getCurrentPlayer(); 
		assertEquals("Nicole Burns",contestant.getName());
		
		myGame.startNewTurn();
		contestant = myGame.getCurrentPlayer();
		assertEquals("Riley Martinez",contestant.getName());
		
		myGame.startNewTurn();
		contestant = myGame.getCurrentPlayer();
		assertEquals("Some Random",contestant.getName());
		
		myGame.startNewTurn();
		contestant = myGame.getCurrentPlayer();
		assertEquals("Nicole Burns",contestant.getName());
	}
	
	@Test
	public void test_roll_and_update_scores_on_skunk() {
		Game game = new Game();
		game.addPlayer("Riley");
		game.startGame();
		game.startNewTurn();
		do {
			game.rollAndUpdateScores();
		} while (!game.rollIsSkunk(game.getCurrentRoll()));
		assertEquals("Check turn score", 0, game.getTurnScore(game.getCurrentTurn()));
		assertTrue("Check player chip count", game.getCurrentPlayer().getChips() < 50);
		assertTrue("Check kitty chip count", game.getKittyChips() > 0);
	}
	
	@Test
	public void test_roll_and_update_scores_on_deuce() {
		Game game = new Game();
		game.addPlayer("Nicole");
		game.startGame();
		game.startNewTurn();
		do {
			game.rollAndUpdateScores();
		} while (!game.rollIsDeuce(game.getCurrentRoll()));
		assertEquals("Check turn score", 0, game.getTurnScore(game.getCurrentTurn()));
		assertTrue("Check player chip count", game.getCurrentPlayer().getChips() < 50);
		assertTrue("Check kitty chip count", game.getKittyChips() > 0);
	}

	@Test
	public void test_roll_and_update_scores_on_double() {
		Game game = new Game();
		game.addPlayer("Eric");
		game.startGame();
		game.startNewTurn();
		do {
			game.rollAndUpdateScores();
		} while (!game.rollIsDouble(game.getCurrentRoll()));
		assertEquals("Check turn score", 0, game.getTurnScore(game.getCurrentTurn()));
		assertTrue("Check player chip count", game.getCurrentPlayer().getChips() < 50);
		assertTrue("Check kitty chip count", game.getKittyChips() > 0);
	}
	
	@Test
	public void test_check_for_final_round() {
		Game game = new Game();
		game.addPlayer("Riley");
		game.startGame();
		game.startNewTurn();
		game.rollAndUpdateScores();
		game.endTurn();
		game.getCurrentPlayer().setPoints(100);
		assertTrue(game.checkForFinalRound());
	}
	
	@Test
	public void test_get_player_chips() {
		Game game = new Game();
		game.addPlayer("Riley");
		game.startGame();
		game.startNewTurn();
		assertEquals(50, game.getPlayerChips(game.getCurrentPlayer()));
	}
	
	@Test
	public void test_start_new_turn_before_game_has_started() {
		Game game = new Game();
		game.startNewTurn();
		assertFalse(game.getTurnStatus());
	}
	
	@Test
	public void test_get_turn_not_null() {
		Game game = new Game();
		game.addPlayer("Nicole");
		game.startGame();
		game.startNewTurn();
		game.rollAndUpdateScores();
		game.endTurn();
		game.startNewTurn();
		game.rollAndUpdateScores();
		game.endTurn();
		game.startNewTurn();
		game.rollAndUpdateScores();
		game.endTurn();
		assertNotNull(game.getTurn(2));
	}
	
	@Test
	public void test_check_for_end_of_game() {
		Game game = new Game();
		game.addPlayer("Riley");
		game.addPlayer("Nicole");
		game.startGame();
		game.startNewTurn();
		game.rollAndUpdateScores();
		game.endTurn();
		game.getCurrentPlayer().setPoints(100);
		game.checkForFinalRound();
		game.checkForEndOfGame();
		game.startNewTurn();
		game.rollAndUpdateScores();
		game.endTurn();
		assertTrue(game.checkForEndOfGame());
	}
	
	@Test
	@SuppressWarnings("deprecation")
	public void test_game_to_string_summary_header() {
		Game game = new Game();
		game.addPlayer("Riley");
		game.startGame();
		game.startNewTurn();
		game.rollAndUpdateScores();
		game.endTurn();
		assertThat(game.toString(), CoreMatchers.containsString("| Player\t|\tScore\t|\tChips\t|\n"));
	}
	
	@Test
	public void test_give_loser_chips_to_winner_when_loser_has_zero_score() {
		Game game = new Game();
		game.addPlayer("Loser");
		game.addPlayer("Winner");
		game.getPlayer(1).setPoints(100);
		game.startGame();
		game.completeGame();
		game.giveLoserChipsToWinner();
		assertEquals(60, game.getWinnerSoFar().getChips());
	}
	
	@Test
	public void test_give_loser_chips_to_winner_when_loser_has_above_zero_score() {
		Game game = new Game();
		game.addPlayer("Loser");
		game.getPlayer(0).setPoints(99);
		game.addPlayer("Winner");
		game.getPlayer(1).setPoints(100);
		game.startGame();
		game.completeGame();
		game.giveLoserChipsToWinner();
		assertEquals(55, game.getWinnerSoFar().getChips());
	}
	
	@Test
	public void test_give_loser_chips_to_winner_when_loser_has_less_than_10_chips_and_zero_score() {
		Game game = new Game();
		game.addPlayer("Loser");
		game.getPlayer(0).removeChips(46);
		game.addPlayer("Winner");
		game.getPlayer(1).setPoints(100);
		game.startGame();
		game.completeGame();
		game.giveLoserChipsToWinner();
		assertEquals(54, game.getWinnerSoFar().getChips());
	}
	
	@Test
	public void test_give_loser_chips_to_winner_when_loser_has_less_than_5_chips_and_above_zero_score() {
		Game game = new Game();
		game.addPlayer("Loser");
		game.getPlayer(0).addPoints(1);
		game.getPlayer(0).removeChips(49);
		game.addPlayer("Winner");
		game.getPlayer(1).setPoints(100);
		game.startGame();
		game.completeGame();
		game.giveLoserChipsToWinner();
		assertEquals(51, game.getWinnerSoFar().getChips());
	}
	
}
