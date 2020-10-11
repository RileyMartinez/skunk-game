package skunk.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDice {

	@Test
	public void test_dice_skunk_roll() {
		Dice dice = new Dice();
		while (!dice.getIsSkunk()) {
			dice.roll();
		}
		assertTrue(dice.getIsSkunk());
	}
	
	@Test
	public void test_dice_deuce_roll() {
		fail("Test not yet implemented.");
	}
}
