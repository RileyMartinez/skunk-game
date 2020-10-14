package skunk.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTurn {

	@Test
	// Create a new turn with an active player.
	public void test_begin_turn_with_1_player() {
		Player activePlayer = new Player();
		Turn currentTurn = new Turn(activePlayer);
	}

}
