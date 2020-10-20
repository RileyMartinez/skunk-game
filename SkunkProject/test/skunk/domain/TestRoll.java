package skunk.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRoll {

	@Test
	public void test_roll_valid_roll_range_with_100_rolls() {
		Roll roll = new Roll();
		for (int i = 0; i < 100; i++) {
			roll.rollDiceCheckAndRecord();
			assertTrue(roll.getLastDiceRoll() >= 2 && roll.getLastDiceRoll() <= 12);
		}
	}
	
	@Test
	public void test_dice_roll_record() {
		Roll roll = new Roll();
		roll.rollDiceCheckAndRecord();
		int expectedRoll = roll.getLastDiceRoll();
		assertEquals(expectedRoll, roll.getDiceRollFromRecord(1));
	}
	
	@Test
	public void test_die1_roll_from_record() {
		Roll roll = new Roll();
		roll.rollDiceCheckAndRecord();
		roll.rollDiceCheckAndRecord();
		int expectedRoll = roll.getLastDiceRollDie1();
		assertEquals(expectedRoll, roll.getDie1RollFromRecord(2));
	}
	
	@Test
	public void test_die2_roll_from_record() {
		Roll roll = new Roll();
		roll.rollDiceCheckAndRecord();
		roll.rollDiceCheckAndRecord();
		roll.rollDiceCheckAndRecord();
		int expectedRoll = roll.getLastDiceRollDie2();
		assertEquals(expectedRoll, roll.getDie2RollFromRecord(3));
	}
	
	@Test
	public void test_roll_history_is_storing_rolls() {
		Roll roll = new Roll();
		roll.rollDiceCheckAndRecord();
		roll.rollDiceCheckAndRecord();
		roll.rollDiceCheckAndRecord();
		roll.rollDiceCheckAndRecord();
		roll.rollDiceCheckAndRecord();
		assertEquals(5, roll.getRollHistory().size());
	}
	
	@Test
	public void test_roll_to_string_reports_skunk() {
		Roll roll = new Roll();
		while (!roll.isSkunk()) {
			roll.rollDiceCheckAndRecord();
		}
		String expectedMessage = "oof, you rolled a skunk! You lose 1 chip to the Kitty.\n"
				+ "Roll #" + roll.getRollHistory().size() + "\n"
				+ "Roll Total: " + roll.getLastDiceRoll() + " => " 
				+ roll.getLastDiceRollDie1() + " + " + roll.getLastDiceRollDie2();
		assertEquals(expectedMessage, roll.toString());
	}
	
	@Test
	public void test_roll_to_string_reports_deuce() {
		Roll roll = new Roll();
		while (!roll.isDeuce()) {
			roll.rollDiceCheckAndRecord();
		}
		String expectedMessage = "big oof, you rolled a deuce! You lose 2 chips to the Kitty.\n"
				+ "Roll #" + roll.getRollHistory().size() + "\n"
				+ "Roll Total: " + roll.getLastDiceRoll() + " => " 
				+ roll.getLastDiceRollDie1() + " + " + roll.getLastDiceRollDie2();
		assertEquals(expectedMessage, roll.toString());
	}
	
	@Test
	public void test_roll_to_string_reports_double() {
		Roll roll = new Roll();
		while (!roll.isDouble()) {
			roll.rollDiceCheckAndRecord();
		}
		String expectedMessage = "really big oof, you rolled a double skunk! You lose 4 chips to the Kitty.\n"
				+ "Roll #" + roll.getRollHistory().size() + "\n"
				+ "Roll Total: " + roll.getLastDiceRoll() + " => " 
				+ roll.getLastDiceRollDie1() + " + " + roll.getLastDiceRollDie2();
		assertEquals(expectedMessage, roll.toString());
	}
}
