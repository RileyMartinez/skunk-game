package skunk.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestPredictableRoll {
	
	@Test
	public void test_roll_skunk() {
		PredictableRoll roll = new PredictableRoll(new int[] { 1 }, new int[] { 6 });
		roll.rollDiceAndCheck();
		assertTrue(roll.isSkunk());
	}
	
	@Test
	public void test_roll_not_skunk() {
		PredictableRoll roll = new PredictableRoll(new int[] { 2 }, new int[] { 4 });
		roll.rollDiceAndCheck();
		assertFalse(roll.isSkunk());
	}
	
	@Test
	public void test_roll_deuce() {
		PredictableRoll roll = new PredictableRoll(new int[] { 2 }, new int[] { 1 });
		roll.rollDiceAndCheck();
		assertTrue(roll.isDeuce());
	}
	
	@Test
	public void test_roll_double() {
		PredictableRoll roll = new PredictableRoll(new int[] { 1 }, new int[] { 1 });
		roll.rollDiceAndCheck();
		assertTrue(roll.isDouble());
	}
}
