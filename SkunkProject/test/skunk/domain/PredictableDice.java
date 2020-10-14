package skunk.domain;

public class PredictableDice {
	private int lastRoll;
	private PredictableDie die1;
	private PredictableDie die2;
	private boolean isSkunk;
	private boolean isDeuce;
	
	
	public PredictableDice(int[] die1Rolls, int[] die2Rolls) {
		if (die1Rolls.length == 0 || die2Rolls.length == 0) {
			throw new RuntimeException("No roll values in array.");
		} else if (die1Rolls.length != die2Rolls.length) {
			throw new RuntimeException("Both arrays for each die must have the same number of rolls.");
		}
		
		for (int i = 0; i < die1Rolls.length; i++) {
			if (die1Rolls[i] + die2Rolls[i] < 2) {
				throw new RuntimeException("Dice can't roll a value less than 2.");
			} else if (die1Rolls[i] + die2Rolls[i] > 12) {
				throw new RuntimeException("Dice can't roll a value greater than 12.");
			}
		}
		
		die1 = new PredictableDie(die1Rolls);
		die2 = new PredictableDie(die2Rolls);
	}
	
	public void roll() {
		die1.roll();
		die2.roll();
		this.lastRoll = die1.getLastRoll() + die2.getLastRoll();
		checkLastRoll();
	}
	
	public void checkLastRoll() {
		if (die1.getLastRoll() == 1 || die2.getLastRoll() == 1) {
			this.isSkunk = true;
			
			if (die1.getLastRoll() == 1 && die2.getLastRoll() == 1) {
				this.isDeuce = true;
			} else {
				this.isDeuce = false;
			}
		} else {
			this.isSkunk = false;
			this.isDeuce = false;
		}
	}
	
	public int getLastRoll() {
		return this.lastRoll;
	}

	public boolean getIsSkunk() {
		return isSkunk;
	}

	public boolean getIsDeuce() {
		return isDeuce;
	}
	
}
