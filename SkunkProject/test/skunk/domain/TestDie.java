package skunk.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDie {

	@Test
	public void test_valid_roll_range_with_100_rolls() {
		Die die = new Die();
		for (int i = 0; i < 100; i++) {
			die.roll();
			assertTrue(die.getLastRoll() >= 1 && die.getLastRoll() <= 6);
		}
	}

}
