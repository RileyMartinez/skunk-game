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
		assertTrue("first value", dice.getDie1().getLastRoll() == 1 || dice.getDie2().getLastRoll() == 1);
		assertTrue("second value", dice.getIsSkunk());
	}
	
	@Test
	public void test_dice_deuce_roll() {
		Dice dice = new Dice();
		while (!dice.getIsDeuce()) {
			dice.roll();
		}
		assertEquals("first value", 1, dice.getDie1().getLastRoll());
		assertEquals("second value", 1, dice.getDie2().getLastRoll());
		assertTrue("third value", dice.getIsDeuce());
	}
}
