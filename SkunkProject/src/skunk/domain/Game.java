package skunk.domain;


public class Game {

	boolean isStarted = false; 
	boolean isCompleted = false;
	int numberOfTurns =0; 
	

	
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

}
