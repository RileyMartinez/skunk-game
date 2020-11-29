package skunk.domain;

import static org.junit.Assert.*;

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
	
//	@Test
//	public void test_skunk_roll_and_update_scores() {
//		SkunkController controller = new SkunkController();
//		controller.rollAndUpdateScores();
//	}
	
}
