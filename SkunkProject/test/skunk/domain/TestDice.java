package skunk.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDice {

	@Test
	public void test_dice_roll_skunk() {
		Dice dice = new Dice();
		while (!dice.getIsSkunk()) {
			dice.roll();
		}
		assertTrue("first value", dice.getDie1().getLastRoll() == 1 || dice.getDie2().getLastRoll() == 1);
		assertTrue("second value", dice.getIsSkunk());
	}
	
	@Test
	public void test_dice_roll_not_skunk() {
		Dice dice = new Dice();
		do {
			dice.roll();
		} while (dice.getIsSkunk());
		assertTrue("first value", dice.getDie1().getLastRoll() != 1 && dice.getDie2().getLastRoll() != 1);
		assertFalse("second value", dice.getIsSkunk());
	}
	
	@Test
	public void test_dice_roll_deuce() {
		Dice dice = new Dice();
		while (!dice.getIsDeuce()) {
			dice.roll();
		}
		assertEquals("first value", 1, dice.getDie1().getLastRoll());
		assertEquals("second value", 1, dice.getDie2().getLastRoll());
		assertTrue("third value", dice.getIsDeuce());
	}
	
	@Test
	public void test_dice_roll_skunk_but_not_deuce() {
		fail("Test not implemented.");
	}
}
