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
}
