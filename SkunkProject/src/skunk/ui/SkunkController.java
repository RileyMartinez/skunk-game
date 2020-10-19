package skunk.ui;

import skunk.domain.*;

public class SkunkController {
	
	private Kitty kitty;
	private Player player;
	private Turn turn;
	private Roll roll;
	
	public SkunkController() {
		this.kitty = new Kitty();
		this.player = new Player();
		this.roll = new Roll();
		this.turn = new Turn(player);
	}

	
	public void setPlayerName(String name) {
		player.setName(name);
	}
	
	public String getPlayerName() {
		return player.getName();
	}
	
	public void givePlayerChips(int amount) {
		player.addChips(amount);
	}
	
	public void takePlayerChips(int amount) {
		player.removeChips(amount);
	}
	
	public void givePlayerPoints(int turnScore) {
		player.addPoints(turnScore);
	}
	
	public void addToKitty(int amount) {
		
	}

	public void roll() {
		roll.rollDiceCheckAndRecord();
	}


	public String getRoll() {
		return roll.toString();
	}


	public int getPlayerScore() {
		return player.getPoints();
	}


	public int getTurnScore() {
		return turn.getScore();
	}
	
	
	
	

}
