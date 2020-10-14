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
	
	@Test
	public void test_remove_chips_from_kitty() {
		Kitty kitty = new Kitty();
		kitty.addChips(4);
		kitty.addChips(4);
		kitty.removeChips(2);
		kitty.removeChips(1);
		assertEquals(kitty.getChips(), 1);
	}

}
