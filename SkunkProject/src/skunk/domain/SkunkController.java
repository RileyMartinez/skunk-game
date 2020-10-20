package skunk.domain;

import java.util.ArrayList;

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
	
	public void rollAndUpdateScores() {
		roll.rollDiceCheckAndRecord();
		if (roll.isSkunk()) {
			turn.clearScore();
			player.removeChips(1);
			kitty.addChips(1);
		} else if (roll.isDeuce()) {
			turn.clearScore();
			player.removeChips(2);
			kitty.addChips(2);
		} else if (roll.isDouble()) {
			turn.clearScore();
			player.clearPoints();
			player.removeChips(4);
			kitty.addChips(4);
		} else {
			turn.increaseScore(roll.getLastDiceRoll());
		}
	}
	
	public String getRollsForTurn() {
		String s = "";
		ArrayList<int[]> rollHistory = roll.getRollHistory();
		for (int i = 0; i < rollHistory.size(); i++) {
			int[] tempArray = rollHistory.get(i);
			s += "Roll #" + (i + 1) 
					+ " => " + Integer.toString(tempArray[0]) 
					+ " + " + Integer.toString(tempArray[1]) + "\n";
		}
		return s;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void endTurn() {
		turn.endTurn();
	}

	public Boolean rollIsSkunk() {
		return roll.isSkunk();
	}
	
	public Boolean rollIsDeuce() {
		return roll.isDeuce();
	}
	
	public Boolean rollIsDouble() {
		return roll.isDouble();
	}
	
	public String getRollToString() {
		return roll.toString();
	}


	public int getPlayerScore() {
		return player.getPoints();
	}


	public int getTurnScore() {
		return turn.getScore();
	}


	public int getPlayerChips() {
		return player.getChips();
	}


	public int getKittyChips() {
		return kitty.getChips();
	}
	
	
	
	

}
