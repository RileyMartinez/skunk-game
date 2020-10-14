package skunk.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTurn {

	@Test
	// Create a new turn with an active player.
	public void test_begin_turn_with_1_player() {
		Player player = new Player();
		Turn turn = new Turn(player);
	}

	@Test
	public void test_increasing_score() {
		Player player = new Player();
		Turn turn = new Turn(player);
		turn.increaseScore(12);
		turn.increaseScore(6);
		assertEquals(turn.getScore(), 18);
	}
	
	@Test
	public void test_wiping_score() {
		Player player = new Player();
		Turn turn = new Turn(player);
		turn.increaseScore(4);
		turn.wipeScore();
		assertEquals(turn.getScore(), 0);
	}
	
	@Test
	public void test_end_of_turn() {
		Player player = new Player();
		Turn turn = new Turn(player);
		turn.increaseScore(8);
		turn.increaseScore(11);
		turn.endTurn();
		assertEquals(player.getPoints(), 19);
	}
}
