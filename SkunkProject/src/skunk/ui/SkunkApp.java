package skunk.ui;

import edu.princeton.cs.introcs.*;
import skunk.domain.SkunkController;

public class SkunkApp {
	
	static SkunkController controller;
	
	public static void main(String[] args) {
		
		Boolean isRunning = true;
		controller = new SkunkController();
		String playerName;
		String userInput;
		
		StdOut.println("Welcome to SkunkApp Demo v1.2. This demo is single player, "
				+ "and we will only play for one turn. Let's go!\n");
		StdOut.println("Enter player name: ");
		playerName = StdIn.readLine();
		
		controller.setPlayerName(playerName);
		StdOut.println("\n" + controller.getPlayerName() + "'s turn has started.\n");
		
		while (isRunning) {
			StdOut.println(controller.getPlayerName() + ", select from the following options: \n");
			StdOut.println("[r] Roll\n"
					+ "[e] End Turn\n"
					+ "[q] Quit Game");
			
			userInput = StdIn.readLine().toLowerCase();
			
			switch (userInput) {
				case "r":
					controller.rollAndUpdateScores();
					StdOut.println("\n" + controller.getPlayerName() + ", " + controller.getRoll());
					promptEnterKey();
					StdOut.println("Current Player Score: " + controller.getPlayerScore());
					StdOut.println("Current Turn Score: " + controller.getTurnScore());
					promptEnterKey();
					if (controller.rollIsSkunk() || controller.rollIsDeuce() || controller.rollIsDouble()) {
						StdOut.println("End Of Turn Summary: \n\n" + controller.getPlayer() +
								"\n\nRolls for the Turn: \n" + controller.getRollsForTurn());
						controller.endTurn();
						isRunning = false;
					}
					break;
				case "e":
					controller.endTurn();
					StdOut.println("End Of Turn Summary: \n\n" + controller.getPlayer() + 
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
