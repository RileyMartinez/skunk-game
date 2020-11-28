package skunk.ui;

import edu.princeton.cs.introcs.*;
import skunk.domain.SkunkController;

public class SkunkApp {
	
	static SkunkController controller;
	
	public static void main(String[] args) {
		
		boolean isRunning = true;
		controller = new SkunkController();
		String playerName;
		int playerCount;
		String userInput;
		
		StdOut.println("Welcome to SkunkApp  v1.3. Let's play!\n");
		StdOut.println("Enter number of players: ");
		playerCount = Integer.parseInt(StdIn.readLine());
		
		for (int i = 1; i <= playerCount; i++) {
			StdOut.println("Enter player name: ");
			playerName = StdIn.readLine();
			controller.addPlayer(playerName);
		}
		
		StdOut.println("View game rules? (y/n):");
		userInput = StdIn.readLine();
		
		if (userInput.equalsIgnoreCase("y")) {
			StdOut.println(controller.getGameRules());
			StdOut.println("^Scroll up to view game rules.^");
		}
		
		promptEnterKey();
		
		controller.startGame();
		controller.startNewTurn();
		StdOut.println(controller.getCurrentPlayerName() + "'s turn has started.\n");
		
		while (isRunning) {
			StdOut.println(controller.getCurrentPlayerName() + ", select from the following options: \n");
			StdOut.println("[r] Roll\n"
					+ "[e] End Turn\n"
					+ "[q] Quit Game");
			
			userInput = StdIn.readLine().toLowerCase();
			
			switch (userInput) {
				case "r":
					controller.rollAndUpdateScores();
					printEndOfRollSummary();
					if (controller.currentRollIsSkunk() || controller.currentRollIsDeuce() || controller.currentRollIsDouble()) {
						resolveTurn();
						if (controller.isGameCompleted()) {
							cleanup();
							isRunning = false;
							break;
						}
						startNextTurn();
					}
					break;
				case "e":
					resolveTurn();
					if (controller.isGameCompleted()) {
						cleanup();
						isRunning = false;
						break;
					}
					startNextTurn();
					break;
				case "q":
					isRunning = quitConfirmation();
					break;
				default:
					StdOut.println("Invalid user input.\n");	
			}
		}
		printEndOfGameSummary();
	}
	
	public static void promptEnterKey() {
		StdOut.println("\nPress \"ENTER\" to continue.\n");
		StdIn.readLine();
	}
	
	public static void printEndOfRollSummary() {
		StdOut.println("\n" + controller.getCurrentPlayerName() + ", " + controller.getCurrentRollToString());
		promptEnterKey();
		StdOut.println("Current Player Score: " + controller.getCurrentPlayerScore());
		StdOut.println("Current Turn Score: " + controller.getCurrentTurnScore());
		promptEnterKey();
	}
	
	public static void printEndOfTurnSummary() {
		StdOut.println("End Of Turn Summary: \n\n" + controller.getCurrentPlayer() + 
				"\n\nRolls for the Turn: \n" + controller.getRollsForTurn() +
				"\nChips in Kitty: " + controller.getChipsInKitty());
	}
	
	public static void printEndOfGameSummary() {
		StdOut.println("End Of Game Summary: \n\n");
		StdOut.println(controller.getGameSummary());
		promptEnterKey();
		StdOut.println("That's the end of the game. Thanks for playing!");
	}
	
	public static boolean quitConfirmation() {
		StdOut.println("Are you sure you want to quit? (y/n)");
		String userInput = StdIn.readLine();
		if (userInput.equalsIgnoreCase("y")) {
			StdOut.println("User quit the game. No chips are distributed...");
			promptEnterKey();
			return false;
		} else {
			return true;
		}
	}
	
	public static void resolveTurn() {
		controller.endTurn();
		printEndOfTurnSummary();
		promptEnterKey();
		controller.checkForFinalRound();
		controller.checkForEndOfGame();
	}
	
	public static void startNextTurn() {
		controller.startNewTurn();
		StdOut.println(controller.getCurrentPlayerName() + "'s turn has started.\n");
	}
	
	public static void cleanup() {
		StdOut.println("Distributing chips to the winner...\n");
		controller.distributeChipsToWinner();
		promptEnterKey();
	}
	
}
