package skunk.domain;

import java.util.ArrayList;


public class Game {

	private boolean isStarted = false; 
	private boolean isCompleted = false;
	private int numberOfTurns; 
	private boolean turnInProgress = false;
	private Kitty kitty;
	private ArrayList<Roll> rolls;
	private ArrayList<Player> players;
	private ArrayList<Turn> turns;
	private static final String GAME_RULES = "Rules of Skunk\r\n" + 
			"\r\n" + 
			"DIRECTIONS FOR PLAYING\r\n" + 
			"\r\n" + 
			"The object of the game is to accumulate a score of 100 points or more. A score is made by rolling the dice\r\n" +
			"and combining the points on the two dice.\r\n" + 
			"For example: A 4 and 5 would be 9 points - if the player decides to take another roll of the dice and\r\n" + 
			"turns up a 3 and 5 (8 points), he would then have an accumulated total of 17 points for the two rolls.\r\n" + 
			"The player has the privilege of continuing to shake to increase his score or of passing the dice to wait\r\n" +
			"for the next series, thus preventing the possibility of rolling a Skunk and losing his score.\r\n" + 
			"\r\n" + 
			"PENALTIES:\r\n" + 
			"\r\n" + 
			"A skunk in any series voids the score for that series only and draws a penalty of 1 chip placed in the \"kitty,\" and loss of dice.\r\n" + 
			"\r\n" + 
			"A skunk and a deuce voids the score for that series only and draws a penalty of 2 chips placed in the \"kitty,\" and loss of dice.\r\n" + 
			"\r\n" + 
			"TWO skunks void the ENTIRE accumulated score and draws a penalty of 4 chips placed in the \"kitty,\" and loss of dice. Player must again start to score from scratch.\r\n" + 
			"\r\n" + 
			"Any number can play. [Assume at least two players!] The suggested number of chips to start is 50.\r\n" +
			"There are sufficient chips in the box to allow 8 players to start with 50 chips by placing a par value of \"one\" on white chips, 5 for 1 on red chips and 10 for 1 on the blue chips.\r\n" + 
			"\r\n" + 
			"The first player to accumulate a total of 100 or more points can continue to score as many points over 100 as he believes is needed to win.\r\n" +
			"When he decides to stop, his total score is the “goal.” Each succeeding player receives one more chance to better the goal and end the game.\r\n" + 
			"\r\n" + 
			"The winner of each game collects all chips in \"kitty\" and in addition ﬁve chips from each losing player or 10 chips from any player without a score.\r\n";
	
	public Game() {
		this.kitty = new Kitty();
		this.rolls = new ArrayList<Roll>();
		this.players = new ArrayList<Player>(); 
		this.turns = new ArrayList<Turn>();
	}

	public void setPlayerName(Player player, String name) {
		player.setName(name);
	}
	
	public String getPlayerName(Player player) {
		return player.getName();
	}
	
	public Player getPlayer(int index) {
		return players.get(index);
	}
	
	public void givePlayerChips(Player player, int amount) {
		player.addChips(amount);
	}
	
	public void takePlayerChips(Player player, int amount) {
		player.removeChips(amount);
	}
	
	public void givePlayerPoints(Player player, int turnScore) {
		player.addPoints(turnScore);
	}
	
	public void rollAndUpdateScores() {
		Roll roll = getCurrentRoll();
		Player player = getCurrentPlayer();
		Turn turn = getCurrentTurn();
		
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
	
	public String getRollsForTurn(Roll roll) {
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
	
	public void endTurn() {
		getCurrentTurn().endTurn();
	}

	public Boolean rollIsSkunk(Roll roll) {
		return roll.isSkunk();
	}
	
	public Boolean rollIsDeuce(Roll roll) {
		return roll.isDeuce();
	}
	
	public Boolean rollIsDouble(Roll roll) {
		return roll.isDouble();
	}
	
	public String getRollToString(Roll roll) {
		return roll.toString();
	}


	public int getPlayerScore(Player player) {
		return player.getPoints();
	}


	public int getTurnScore(Turn turn) {
		return turn.getScore();
	}


	public int getPlayerChips(Player player) {
		return player.getChips();
	}


	public int getKittyChips() {
		return kitty.getChips();
	}
	
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

	//Start a new turn IF a game is in progress
	public void startNewTurn() {
		if(this.isStarted == true) { 
			turnInProgress = true; 
			Turn myTurn = new Turn(this.getCurrentPlayer());
			Roll myRoll = new Roll();
			turns.add(myTurn); 
			rolls.add(myRoll);
		}
		else
			turnInProgress = false; 
	}

	public int getNumberOfTurns() {
		// TODO Auto-generated method stub
		return turns.size();
	}

	public boolean getTurnStatus() {
		// TODO Auto-generated method stub
		return turnInProgress;
	}
	
	
	public void addPlayer(String playerName) {
		if(this.isStarted == false) {
			Player player = new Player(playerName);
			players.add(player);
		}		
	}

	//returns the number of players in the array list
	public int getNumberOfPlayers() {
		// TODO Auto-generated method stub
		int numberOfPlayers = players.size(); 
		return numberOfPlayers;
	}

	public String printPlayers() {
		// TODO Auto-generated method stub
		return players.toString();
	}

	public void clearAllPlayers() {
		// TODO Auto-generated method stub
		players.clear();
	}

	//method to return whose turn it currently is
	public Player getCurrentPlayer() {
		int index = (turns.size()+1)%(players.size()); 
		Player currentPlayer = players.get(index);
		return currentPlayer;
	}
	
	public String getCurrentPlayerName() {
		return getCurrentPlayer().getName();
	}
	
	public Turn getCurrentTurn() {
		return turns.get(turns.size() - 1);
	}
	
	public Turn getTurn(int index) {
		return turns.get(index);
	}
	
	public Roll getCurrentRoll() {
		return rolls.get(rolls.size() - 1);
	}
	
	public String getGameRules() {
		return GAME_RULES;
	}

}
