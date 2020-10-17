package skunk.domain;

import java.util.ArrayList;
import java.util.Arrays;


public class Game {

	private boolean isStarted = false; 
	private boolean isCompleted = false;
	private int numberOfTurns; 
	private boolean turnInProgress = false; 
	private ArrayList<Player> players = new ArrayList(); 
	private int numberOfPlayers; 
	
	Player n = new Player();

	
	public String getStatus() {
		if(isStarted == false && isCompleted == false) { 
			return "The Game has not started yet";
		}
		if(isStarted == true && isCompleted == false) {
			return "The Game is Afoot!";
		}
		else {
			return "The Game has ended";
		}
		
	}

	public void startGame() {
		this.isStarted = true;
		
	}

	public void completeGame() {
		this.isCompleted = true;
		
		
	}

	public void startNewTurn() {
		numberOfTurns ++; 
		
	}

	public int getNumberOfTurns() {
		// TODO Auto-generated method stub
		return numberOfTurns;
	}

	public boolean getTurnStatus() {
		// TODO Auto-generated method stub
		return true;
	}

	public void addPlayer(String playerName) {
		Player player = new Player(playerName);
		players.add(player);
		numberOfPlayers++; 
		
	}

	public int getNumberOfPlayers() {
		// TODO Auto-generated method stub
		return numberOfPlayers;
	}

	public String printPlayers() {
		// TODO Auto-generated method stub
		return players.toString();
	}

}
