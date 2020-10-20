package skunk.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSkunkController {

	@Test
	public void test_give_player_chips() {
		SkunkController controller = new SkunkController();
		controller.givePlayerChips(21);
		assertEquals(71, controller.getPlayerChips());
	}

}
