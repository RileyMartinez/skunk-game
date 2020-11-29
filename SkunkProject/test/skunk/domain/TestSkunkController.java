package skunk.domain;

import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class TestSkunkController {

	@Test
	public void test_start_game() {
		SkunkController controller = new SkunkController();
		controller.startGame();
		assertTrue(controller.getGame().isStarted());
	}
	
	@Test
	public void test_start_new_turn() {
		SkunkController controller = new SkunkController();
		controller.startGame();
		controller.startNewTurn();
		assertTrue(controller.getGame().getTurnStatus());
	}
	
	@Test
	public void test_add_player() {
		SkunkController controller = new SkunkController();
		controller.addPlayer("Riley");
		assertEquals("Riley", controller.getPlayerName(0));
	}
	
	@Test
	public void test_add_4_players() {
		SkunkController controller = new SkunkController();
		controller.addPlayer("Riley");
		controller.addPlayer("Nicole");
		controller.addPlayer("Alaina");
		controller.addPlayer("Eric");
		assertEquals("First player", "Riley", controller.getPlayerName(0));
		assertEquals("Second player", "Nicole", controller.getPlayerName(1));
		assertEquals("Third player", "Alaina", controller.getPlayerName(2));
		assertEquals("Fourth player", "Eric", controller.getPlayerName(3));
	}
	
	@Test
	public void test_set_player_name() {
		SkunkController controller = new SkunkController();
		controller.addPlayer("Riley");
		controller.startGame();
		controller.startNewTurn();
		controller.setPlayerName("Nicole");
		assertEquals("Nicole", controller.getPlayerName(0));
	}
	
	@Test
	public void test_get_current_player() {
		SkunkController controller = new SkunkController();
		controller.addPlayer("Riley");
		controller.addPlayer("Nicole");
		controller.startGame();
		controller.startNewTurn();
		controller.startNewTurn();
		assertEquals("Nicole", controller.getCurrentPlayer().getName());
	}
	
	@Test
	public void test_get_current_player_name() {
		SkunkController controller = new SkunkController();
		controller.addPlayer("Riley");
		controller.addPlayer("Nicole");
		controller.addPlayer("Alaina");
		controller.addPlayer("Eric");
		controller.startGame();
		controller.startNewTurn();
		controller.startNewTurn();
		controller.startNewTurn();
		assertEquals("Alaina", controller.getCurrentPlayerName());
	}
	
	@Test
	public void test_get_player_name() {
		SkunkController controller = new SkunkController();
		controller.addPlayer("Riley");
		controller.addPlayer("Nicole");
		controller.addPlayer("Alaina");
		controller.addPlayer("Eric");
		assertEquals("Eric", controller.getPlayerName(3));
	}
	
	@Test
	@SuppressWarnings("deprecation")
	public void test_get_rolls_for_turn() {
		SkunkController controller = new SkunkController();
		controller.addPlayer("Riley");
		controller.startGame();
		controller.startNewTurn();
		controller.rollAndUpdateScores();
		assertThat(controller.getRollsForTurn(), CoreMatchers.containsString("Roll #1"));	
	}
	
	@Test
	public void test_get_player() {
		SkunkController controller = new SkunkController();
		controller.addPlayer("Riley");
		controller.addPlayer("Nicole");
		controller.addPlayer("Alaina");
		controller.addPlayer("Eric");
		assertEquals("Nicole", controller.getPlayer(1).getName());
	}
	
	@Test
	public void test_get_players() {
		SkunkController controller = new SkunkController();
		controller.addPlayer("Riley");
		controller.addPlayer("Nicole");
		controller.addPlayer("Alaina");
		controller.addPlayer("Eric");
		assertEquals(4, controller.getPlayers().size());
	}
	
	@Test
	public void test_end_turn() {
		SkunkController controller = new SkunkController();
		controller.addPlayer("Riley");
		controller.startGame();
		controller.startNewTurn();
		assertTrue("Check current turn score before roll", controller.getCurrentTurnScore() == 0);
		do {
			controller.rollAndUpdateScores();
		} while (controller.currentRollIsSkunk() || controller.currentRollIsDeuce() 
				|| controller.currentRollIsDouble());
		assertTrue("Check current turn score after roll", controller.getCurrentTurnScore() > 0);
		assertTrue("Check player score before turn", controller.getCurrentPlayerScore() == 0);
		controller.endTurn();
		assertTrue("Check player score after turn", controller.getCurrentPlayerScore() > 0);
		
	}
	
	@Test
	public void test_get_chips_in_kitty() {
		SkunkController controller = new SkunkController();
		controller.addPlayer("Riley");
		controller.startGame();
		controller.startNewTurn();
		do {
			controller.rollAndUpdateScores();
		} while (!controller.currentRollIsSkunk() && !controller.currentRollIsDeuce() 
				&& !controller.currentRollIsDouble());
		assertTrue(controller.getChipsInKitty() > 0);
	}
	
	@Test
	@SuppressWarnings("deprecation")
	public void test_get_current_roll_to_string() {
		SkunkController controller = new SkunkController();
		controller.addPlayer("Riley");
		controller.startGame();
		controller.startNewTurn();
		controller.rollAndUpdateScores();
		controller.rollAndUpdateScores();
		assertThat(controller.getCurrentRollToString(), CoreMatchers.containsString("Roll #2"));
	}
	
	@Test
	public void test_check_for_final_round() {
		SkunkController controller = new SkunkController();
		controller.addPlayer("Riley");
		controller.startGame();
		controller.startNewTurn();
		controller.rollAndUpdateScores();
		controller.endTurn();
		controller.startNewTurn();
		assertFalse(controller.checkForFinalRound());
	}
	
	@Test
	public void test_check_for_end_of_game() {
		SkunkController controller = new SkunkController();
		controller.addPlayer("Nicole");
		controller.startGame();
		controller.startNewTurn();
		controller.rollAndUpdateScores();
		controller.endTurn();
		controller.getGame().completeGame();
		assertTrue(controller.checkForEndOfGame());
	}
	
	@Test
	public void test_is_game_completed() {
		SkunkController controller = new SkunkController();
		controller.addPlayer("Nicole");
		controller.startGame();
		controller.startNewTurn();
		controller.rollAndUpdateScores();
		controller.endTurn();
		controller.getGame().completeGame();
		assertTrue(controller.isGameCompleted());
	}
	
	@Test
	public void test_distribute_chips_to_winner() {
		SkunkController controller = new SkunkController();
		controller.addPlayer("Riley");
		controller.addPlayer("Nicole");
		controller.startGame();
		controller.startNewTurn();
		do {
			controller.rollAndUpdateScores();
		} while (!controller.currentRollIsSkunk() && !controller.currentRollIsDeuce() 
				&& !controller.currentRollIsDouble());
		controller.endTurn();
		controller.startNewTurn();
		do {
			controller.rollAndUpdateScores();
		} while (controller.currentRollIsSkunk() || controller.currentRollIsDeuce() 
				|| controller.currentRollIsDouble());
		controller.endTurn();
		controller.distributeChipsToWinner();
		assertTrue("Check losing player chip count", controller.getPlayer(0).getChips() < 50);
		assertTrue("Check winning player chip count", controller.getPlayer(1).getChips() > 50);
	}
		
	@Test
	public void test_get_game_rules() {
		SkunkController controller = new SkunkController();
		String expectedString = "Rules of Skunk\r\n" + 
				"\r\n" + 
				"DIRECTIONS FOR PLAYING\r\n" + 
				"\r\n" + 
				"The object of the game is to accumulate a score of 100 points or more. A score is made by rolling the dice\r\n" +
				"and combining the points on the two dice.\r\n\r\n" + 
				"For example: A 4 and 5 would be 9 points - if the player decides to take another roll of the dice and\r\n" + 
				"turns up a 3 and 5 (8 points), he would then have an accumulated total of 17 points for the two rolls.\r\n" + 
				"The player has the privilege of continuing to shake to increase his score or of passing the dice to wait\r\n" +
				"for the next series, thus preventing the possibility of rolling a Skunk and losing his score.\r\n" + 
				"\r\n" + 
				"PENALTIES:\r\n" + 
				"\r\n" + 
				"A skunk in any series voids the score for that series only and draws a penalty of 1 chip placed in the \"kitty,\" and loss of dice.\r\n" + 
				"\r\n" + 
				"A skunk and a deuce voids the score for that series only and draws a penalty of 2 chips placed in the \"kitty,\" and loss of dice.\r\n" + 
				"\r\n" + 
				"TWO skunks void the ENTIRE accumulated score and draws a penalty of 4 chips placed in the \"kitty,\" and loss of dice. Player must again start to score from scratch.\r\n" + 
				"\r\n" + 
				"Any number can play. [Assume at least two players!] The suggested number of chips to start is 50.\r\n" +
				"There are sufficient chips in the box to allow 8 players to start with 50 chips by placing a par value of \"one\" on white chips, 5 for 1 on red chips and 10 for 1 on the blue chips.\r\n" + 
				"\r\n" + 
				"The first player to accumulate a total of 100 or more points can continue to score as many points over 100 as he believes is needed to win.\r\n" +
				"When he decides to stop, his total score is the \"goal.\" Each succeeding player receives one more chance to better the goal and end the game.\r\n" + 
				"\r\n" + 
				"The winner of each game collects all chips in \"kitty\" and in addition five chips from each losing player or 10 chips from any player without a score.\r\n";
		assertEquals(expectedString, controller.getGameRules());
	}	
}
