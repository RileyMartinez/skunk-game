package skunk.ui;

import edu.princeton.cs.introcs.*;
import skunk.domain.SkunkController;

public class SkunkApp {
	
	static SkunkController controller;
	
	public static void main(String[] args) {
		
		Boolean isRunning = true;
		controller = new SkunkController();
		String playerName;
		int playerCount;
		String userInput;
		
		StdOut.println("Welcome to SkunkApp Demo v1.2. This demo is single player, "
				+ "and we will only play for one turn. Let's go!\n");
		StdOut.println("Enter number of players: ");
		playerCount = Integer.parseInt(StdIn.readLine());
		
		for (int i = 1; i <= playerCount; i++) {
			StdOut.println("Enter player name: ");
			playerName = StdIn.readLine();
			controller.addPlayer(playerName);
		}
		
		StdOut.println("View game rules? (y/n):");
		userInput = StdIn.readLine().toLowerCase();
		
		if (userInput.equalsIgnoreCase("y")) {
			StdOut.println(controller.getGameRules());
			StdOut.println("^Scroll up to view game rules.^");
		}
		
		promptEnterKey();
		
		controller.startGame();
		controller.startNewTurn();
		
		StdOut.println("\n" + controller.getCurrentPlayerName() + "'s turn has started.\n");
		
		while (isRunning) {
			StdOut.println(controller.getCurrentPlayerName() + ", select from the following options: \n");
			StdOut.println("[r] Roll\n"
					+ "[e] End Turn\n"
					+ "[q] Quit Game");
			
			userInput = StdIn.readLine().toLowerCase();
			
			switch (userInput) {
				case "r":
					controller.rollAndUpdateScores();
					StdOut.println("\n" + controller.getCurrentPlayerName() + ", " + controller.getCurrentRollToString());
					promptEnterKey();
					StdOut.println("Current Player Score: " + controller.getCurrentPlayerScore());
					StdOut.println("Current Turn Score: " + controller.getCurrentTurnScore());
					promptEnterKey();
					if (controller.currentRollIsSkunk() || controller.currentRollIsDeuce() || controller.currentRollIsDouble()) {
						StdOut.println("End Of Turn Summary: \n\n" + controller.getCurrentPlayer() +
								"\n\nRolls for the Turn: \n" + controller.getRollsForTurn());
						controller.endTurn();
						isRunning = false;
					}
					break;
				case "e":
					controller.endTurn();
					StdOut.println("End Of Turn Summary: \n\n" + controller.getCurrentPlayer() + 
							"\n\nRolls for the Turn: \n" + controller.getRollsForTurn());
					isRunning = false;
					break;
				case "q":
					isRunning = false;
					break;
				default:
					StdOut.println("Invalid user input.");	
			}
		}
		promptEnterKey();
		StdOut.println("That's the end of the demo. Thanks for playing!");
	}
	
	public static void promptEnterKey() {
		StdOut.println("\nPress \"ENTER\" to continue.\n");
		StdIn.readLine();
	}
	
}
