package skunk.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDice {

	@Test
	public void test_dice_valid_roll_range_with_100_rolls() {
		Dice dice = new Dice();
		for (int i = 0; i < 100; i++) {
			dice.roll();
			assertTrue(dice.getLastRoll() >= 2 && dice.getLastRoll() <= 12);
		}
	}
	
	@Test
	public void test_dice_to_string() {
		Dice dice = new Dice();
		String expectedToString = "Dice with last roll: " + dice.getLastRoll() + 
				" => " + dice.getLastRollDie1() + " + " + dice.getLastRollDie2();
		assertEquals(dice.toString(), expectedToString);
	}
}
