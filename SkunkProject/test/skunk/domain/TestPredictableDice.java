package skunk.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestPredictableDice {

	@Test
	public void test_predictable_dice_2_3_4() {
		PredictableDice dice = new PredictableDice(new int[] {2, 3, 4});
		dice.roll();
		assertEquals(2, dice.getLastRoll());
		dice.roll();
		assertEquals(3, dice.getLastRoll());
		dice.roll();
		assertEquals(4, dice.getLastRoll());
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
	
}
