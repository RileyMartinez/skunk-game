package skunk.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestPredictableDice {

	@Test
	public void test_predictable_dice_roll_range() {
		int[] testRolls = new int[] {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}; 
		PredictableDice dice = new PredictableDice(testRolls);
		for (int i = 0; i < testRolls.length; i++) {
			dice.roll();
			assertEquals(testRolls[i], dice.getLastRoll());
		}
	}
	
	@Test
	public void test_predictable_dice_2_more_than_once() {
		PredictableDice dice = new PredictableDice(new int[] {2});
		dice.roll();
		assertEquals(2, dice.getLastRoll());
		dice.roll();
		assertEquals(2, dice.getLastRoll());
	}
	
	@Test (expected = RuntimeException.class)
	public void test_predictable_dice_with_empty_initial_int_array() {
		PredictableDice dice = new PredictableDice(new int[] {});
		dice.roll();
	}
	
	@Test (expected = RuntimeException.class)
	public void test_predictable_dice_with_value_beyond_lower_bound() {
		PredictableDice dice = new PredictableDice(new int[] {1});
		dice.roll();
	}
	
	@Test (expected = RuntimeException.class)
	public void test_predictable_dice_with_value_beyond_upper_bound() {
		PredictableDice dice = new PredictableDice(new int[] {13});
		dice.roll();
	}
	
	@Test
	public void test_predictable_dice_roll_skunk() {
		PredictableDice dice = new PredictableDice(new int[] {3});
		dice.roll();
		assertTrue(dice.getIsSkunk());
	}
	
	@Test
	public void test_predictable_dice_roll_deuce() {
		PredictableDice dice = new PredictableDice(new int[] {2});
		dice.roll();
		assertTrue(dice.getIsDeuce());
	}
}
