package skunk.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlayer {

	@Test
	public void test_create_a_new_player_with_name() {
		Player player = new Player("Riley");
		assertEquals(player.getName(), "Riley");
	}
	
	@Test
	public void test_create_new_anonymous_player() {
		Player player = new Player();
		assertEquals(player.getName(), "anon");
	}
	
	@Test
	public void test_rename_player() {
		Player player = new Player();
		assertEquals("first value", player.getName(), "anon");
		player.setName("Nicole");
		assertEquals("second value", player.getName(), "Nicole");
	}
	
	@Test
	public void test_starting_chip_total_equals_50() {
		Player player = new Player();
		assertEquals(player.getChips(), 50);
	}
	
	@Test
	public void test_adding_chips_to_player_chip_total() {
		// Player starts out with 50 chips
		Player player = new Player();
		player.addChips(8);
		player.addChips(4);
		assertEquals(player.getChips(), 62);
	}
	
	@Test
	public void test_removing_chips_from_player_chip_total() {
		// Player starts out with 50 chips
		Player player = new Player();
		player.removeChips(10);
		player.removeChips(6);
		assertEquals(player.getChips(), 34);
	}
	
	@Test
	public void test_starting_points_total_equals_0() {
		Player player = new Player();
		assertEquals(player.getPoints(), 0);
	}
	
	@Test
	public void test_adding_points() {
		Player player = new Player();
		player.addPoints(10);
		player.addPoints(11);
		assertEquals(player.getPoints(), 21);
	}
	
	@Test
	public void test_clearing_points() {
		Player player = new Player();
		player.addPoints(99);
		player.clearPoints();
		assertEquals(player.getPoints(), 0);
	}

}
