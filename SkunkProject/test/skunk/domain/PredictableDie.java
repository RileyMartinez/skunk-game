package skunk.domain;

public class PredictableDie {
	private int[] theRolls;
	private int nextInt;
	private int lastRoll;
	
	public PredictableDie(int[] is) {
		if (is.length == 0) {
			throw new RuntimeException("No roll value in array.");
		}
		for (int i = 0; i < is.length; i++) {
			if (is[i] < 1) {
				throw new RuntimeException("Die can't roll a value less than 1");
			} else if (is[i] > 6) {
				throw new RuntimeException("Die can't roll a value greater than 6");
			}
		}
		this.theRolls = is;
		this.nextInt = 0;
	}

	public void roll() {
		this.lastRoll = this.theRolls[this.nextInt];
		this.nextInt++;
		if (this.nextInt == this.theRolls.length) {
			this.nextInt = 0;
		}
	}

	public int getLastRoll() {
		return this.lastRoll;
	}

}
