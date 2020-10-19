package skunk.ui;

import edu.princeton.cs.introcs.*;

public class SkunkApp {
	
	static SkunkController controller;
	
	public static void main(String[] args) {
		
		Boolean isRunning = true;
		controller = new SkunkController();
		String playerName;
		int userInput;
		
		StdOut.println("Welcome to SkunkApp v1.2");
		StdOut.println("Enter player name: ");
		playerName = StdIn.readLine();
		
		controller.setPlayerName(playerName);
		
		while (isRunning) {
			StdOut.println("\n" + controller.getPlayerName() + "'s turn has started.");
			StdOut.println("\n" + controller.getPlayerName() + ", select from the following options: \n");
			StdOut.println("1: Roll\n"
					+ "2: End Turn\n"
					+ "3: Quit Game");
			
			userInput = Integer.parseInt(StdIn.readLine());
			
			switch (userInput) {
				case 1:
					controller.roll();
					StdOut.println("\n" + controller.getPlayerName() + ", " + controller.getRoll());
					StdOut.println("Current Player Score: " + controller.getPlayerScore());
					StdOut.println("Current Turn Score: " + controller.getTurnScore());
			}
		}
		
	}
	
}
