package skunk.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSkunkController {

	@Test
	public void test_give_player_chips() {
		SkunkController controller = new SkunkController();
		controller.givePlayerChips(21);
		assertEquals(71, controller.getPlayerChips());
	}
	
	@Test
	public void test_take_player_chips() {
		SkunkController controller = new SkunkController();
		controller.takePlayerChips(21);
		assertEquals(29, controller.getPlayerChips());
	}
	
	@Test
	public void test_change_player_name() {
		SkunkController controller = new SkunkController();
		assertEquals("First check", "anon", controller.getPlayerName());
		controller.setPlayerName("Riley");
		assertEquals("Second check", "Riley", controller.getPlayerName());
	}
	
	@Test
	public void test_give_player_points() {
		SkunkController controller = new SkunkController();
		controller.givePlayerPoints(21);
		assertEquals(21, controller.getPlayerScore());
	}
	
	@Test
	public void test_get_rolls_for_turn_with_1_roll() {
		SkunkController controller = new SkunkController();
		controller.rollAndUpdateScores();
		String expectedRollNumber = "Roll #1";
		assertTrue(controller.getRollsForTurn().contains(expectedRollNumber)); 
	}
	
	@Test
	public void test_get_rolls_for_turn_with_2_rolls() {
		SkunkController controller = new SkunkController();
		controller.rollAndUpdateScores();
		controller.rollAndUpdateScores();
		String expectedRollNumber = "Roll #2";
		assertTrue(controller.getRollsForTurn().contains(expectedRollNumber)); 
	}
	
	@Test
	public void test_turn_score_clears_when_roll_is_skunk() {
		SkunkController controller = new SkunkController();
		while(!controller.rollIsSkunk()) {
			controller.rollAndUpdateScores();
		}
		assertEquals(controller.getTurnScore(), 0);
	}
	
	@Test
	public void test_turn_score_clears_when_roll_is_deuce() {
		SkunkController controller = new SkunkController();
		while(!controller.rollIsDeuce()) {
			controller.rollAndUpdateScores();
		}
		assertEquals(controller.getTurnScore(), 0);
	}
	
	@Test
	public void test_turn_score_clears_when_roll_is_double() {
		SkunkController controller = new SkunkController();
		while(!controller.rollIsDouble()) {
			controller.rollAndUpdateScores();
		}
		assertEquals(controller.getTurnScore(), 0);
	}
	
	@Test
	public void test_player_score_clears_when_roll_is_double() {
		SkunkController controller = new SkunkController();
		controller.givePlayerPoints(10);
		while(!controller.rollIsDouble()) {
			controller.rollAndUpdateScores();
		}
		assertEquals(controller.getPlayerScore(), 0);
	}
	
	@Test
	public void test_end_turn() {
		SkunkController controller = new SkunkController();
		controller.rollAndUpdateScores();
		int expectedPlayerScore = controller.getTurnScore();
		controller.endTurn();
		assertEquals(expectedPlayerScore, controller.getPlayerScore());
	}
}
