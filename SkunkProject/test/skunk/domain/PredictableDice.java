package skunk.domain;

public class PredictableDice {
	private int[] ceilingRoll;
	private int[] floorRoll;
	private int lastRoll;
	private PredictableDie ceilingDie;
	private PredictableDie floorDie;
	private boolean isSkunk;
	
	
	public PredictableDice(int[] is) {
		if (is.length == 0) {
			throw new RuntimeException("No roll value in array.");
		}
		ceilingRoll = new int[is.length];
		floorRoll = new int[is.length];
		
		for (int i = 0; i < is.length; i++) {
			if (is[i] < 2) {
				throw new RuntimeException("Dice can't roll a value less than 2.");
			} else if (is[i] > 12) {
				throw new RuntimeException("Dice can't roll a value greater than 12.");
			}
			ceilingRoll[i] = (int)Math.ceil((double)is[i]/2);
			floorRoll[i] = (int)Math.floor((double)is[i]/2);
		}
		ceilingDie = new PredictableDie(ceilingRoll);
		floorDie = new PredictableDie(floorRoll);
	}
	
	public void roll() {
		ceilingDie.roll();
		floorDie.roll();
		this.lastRoll = ceilingDie.getLastRoll() + floorDie.getLastRoll();
		checkLastRoll();
	}
	
	public void checkLastRoll() {
		if (ceilingDie.getLastRoll() == 1 || floorDie.getLastRoll() == 1) {
			this.isSkunk = true;
		}
	}
	
	public int getLastRoll() {
		return this.lastRoll;
	}

	public boolean getIsSkunk() {
		return isSkunk;
	}
	
}
