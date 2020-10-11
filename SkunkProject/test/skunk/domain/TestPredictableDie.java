package skunk.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPredictableDie {

	@Test
	public void test_predictable_die_1_2_3() {
		PredictableDie die = new PredictableDie(new int[] {1, 2, 3});
		die.roll();
		assertEquals(1, die.getLastRoll());
		die.roll();
		assertEquals(2, die.getLastRoll());
		die.roll();
		assertEquals(3, die.getLastRoll());
	}
	
	@Test
	public void test_predictable_die_1_more_than_once() {
		PredictableDie die = new PredictableDie(new int[] {1});
		die.roll();
		assertEquals(1, die.getLastRoll());
		die.roll();
		assertEquals(1, die.getLastRoll());
	}

	@Test (expected = RuntimeException.class)
	public void test_predictable_die_with_empty_initial_int_array() {
		PredictableDie die = new PredictableDie(new int[] {});
		die.roll();
	}
	
	@Test (expected = RuntimeException.class)
	public void test_predictable_die_with_value_beyond_lower_bound() {
		PredictableDie die = new PredictableDie(new int[] {0});
		die.roll();
	}
	
	@Test (expected = RuntimeException.class)
	public void test_predictable_die_with_value_beyond_upper_bound() {
		PredictableDie die = new PredictableDie(new int[] {7});
		die.roll();
	}
	
}
