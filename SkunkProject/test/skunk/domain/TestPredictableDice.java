package skunk.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestPredictableDice {

	@Test
	public void test_predictable_dice_roll_range() {
		int[] die1Rolls = {
				1, 1, 1, 1, 1, 1,
				2, 2, 2, 2, 2, 2,
				3, 3, 3, 3, 3, 3,
				4, 4, 4, 4, 4, 4,
				5, 5, 5, 5, 5, 5,
				6, 6, 6, 6, 6, 6
		};
		
		int[] die2Rolls = {
				1, 2, 3, 4, 5, 6,
				1, 2, 3, 4, 5, 6,
				1, 2, 3, 4, 5, 6,
				1, 2, 3, 4, 5, 6,
				1, 2, 3, 4, 5, 6,
				1, 2, 3, 4, 5, 6
				
		};
		
		PredictableDice dice = new PredictableDice(die1Rolls, die2Rolls);
		for (int i = 0; i < die1Rolls.length; i++) {
			dice.roll();
			assertEquals(die1Rolls[i] + die2Rolls[i], dice.getLastRoll());
		}
	}
	
	
	@Test
	public void test_predictable_dice_2_more_than_once() {
		PredictableDice dice = new PredictableDice(new int[] { 1 }, new int[] { 1 });
		dice.roll();
		assertEquals(2, dice.getLastRoll());
		dice.roll();
		assertEquals(2, dice.getLastRoll());
	}

	@Test(expected = RuntimeException.class)
	public void test_predictable_dice_with_empty_initial_int_array() {
		PredictableDice dice = new PredictableDice(new int[] {}, new int[] {});
		dice.roll();
	}

	@Test(expected = RuntimeException.class)
	public void test_predictable_dice_with_value_beyond_lower_bound() {
		PredictableDice dice = new PredictableDice(new int[] { 0 }, new int[] { 1 });
		dice.roll();
	}

	@Test(expected = RuntimeException.class)
	public void test_predictable_dice_with_value_beyond_upper_bound() {
		PredictableDice dice = new PredictableDice(new int[] { 6 }, new int[] { 7 });
		dice.roll();
	}

	@Test
	public void test_predictable_dice_roll_skunk() {
		PredictableDice dice = new PredictableDice(new int[] { 1 }, new int[] { 5 });
		dice.roll();
		assertTrue(dice.getIsSkunk());
	}

	@Test
	public void test_predictable_dice_roll_deuce() {
		PredictableDice dice = new PredictableDice(new int[] { 1 }, new int[] { 1 });
		dice.roll();
		assertTrue(dice.getIsDeuce());
	}
	
	@Test(expected = RuntimeException.class)
	public void test_predictable_dice_with_unequal_number_of_rolls_between_each_die() {
		PredictableDice dice = new PredictableDice(new int[] { 2, 6, 5 }, new int[] { 3 });
		dice.roll();
	}
	 
}
