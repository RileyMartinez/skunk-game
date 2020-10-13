package skunk.domain;


public class Game {

	boolean isStarted = false; 

	
	public String getStatus() {
		if(isStarted == false) { 
			return "The Game has not started yet";
		}
		else {
			return "The Game is Afoot!";
		}
		
	}

	public void startGame() {
		this.isStarted = true;
		
	}

	public void completeGame() {
		// TODO Auto-generated method stub
		
	}

}
