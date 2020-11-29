package skunk.domain;

import java.util.ArrayList;

// Wrapper class around Game to provide separation between domain and UI layers
public class SkunkController {
	
	private Game game;
	
	public SkunkController() {
		this.game = new Game();
	}
	
	public void startGame() {
		game.startGame();
	}
	
	public void startNewTurn() {
		game.startNewTurn();
	}
	
	public void addPlayer(String playerName) {
		game.addPlayer(playerName);
	}

	public void setPlayerName(String name) {
		game.setPlayerName(getCurrentPlayer(), name);
	}
	
	public Player getCurrentPlayer() {
		return game.getCurrentPlayer();
	}
	
	public String getCurrentPlayerName() {
		return game.getCurrentPlayerName();
	}
	
	public String getPlayerName(int index) {
		return game.getPlayerName(game.getPlayer(index));
	}
	
	public void rollAndUpdateScores() {
		game.rollAndUpdateScores();
	}
	
	public String getRollsForTurn() {
		return game.getRollsForTurn(game.getCurrentRoll());
	}
	
	public Player getPlayer(int index) {
		return game.getPlayer(index);
	}
	
	public ArrayList<Player> getPlayers() {
		return game.getPlayers();
	}
	
	public void endTurn() {
		game.endTurn();
	}
	
	public void distributeChipsToWinner() {
		game.giveKittyChipsToWinner();
		game.giveLoserChipsToWinner();
	}
	
	public void checkForFinalRound() {
		game.checkForFinalRound();
	}
	
	public void checkForEndOfGame() {
		game.checkForEndOfGame();
	}
	
	public boolean isGameCompleted() {
		return game.isCompleted();
	}

	public boolean currentRollIsSkunk() {
		return game.rollIsSkunk(game.getCurrentRoll());
	}
	
	public boolean currentRollIsDeuce() {
		return game.rollIsDeuce(game.getCurrentRoll());
	}
	
	public boolean currentRollIsDouble() {
		return game.rollIsDouble(game.getCurrentRoll());
	}
	
	public String getCurrentRollToString() {
		return game.getRollToString(game.getCurrentRoll());
	}


	public int getCurrentPlayerScore() {
		return game.getPlayerScore(getCurrentPlayer());
	}

	public int getChipsInKitty() {
		return game.getKittyChips();
	}

	public int getCurrentTurnScore() {
		return game.getTurnScore(game.getCurrentTurn());
	}

	public String getGameRules() {
		return game.getGameRules();
	}
	
	public Game getGame() {
		return game;
	}
}
