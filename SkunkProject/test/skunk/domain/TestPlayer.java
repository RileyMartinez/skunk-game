package skunk.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlayer {

	@Test
	public void test_create_a_new_player_with_name() {
		Player player = new Player();
		player.setName("Riley");
		assertEquals(player.getName(), "Riley");
	}

}
