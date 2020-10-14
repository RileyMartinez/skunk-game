package skunk.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestKitty {

	@Test
	public void test_add_chips_to_kitty() {
		Kitty kitty = new Kitty();
		kitty.addChips(4);
		kitty.addChips(2);
		assertEquals(kitty.getChips(), 6);
	}

}
