package skunk.domain;


public class Game {

	boolean isStarted = false; 

	
	public String getStatus() {
		if(isStarted == false) { 
			return "Game has not started yet";
		}
		else {
			return "The Game is Afoot!";
		}
		
	}

	public void startGame() {
		this.isStarted = true;
		
	}

}
