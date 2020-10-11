package skunk.domain;

public class PredictableDice {
	private int[] ceilingRoll;
	private int[] floorRoll;
	private int nextInt;
	private int lastRoll;
	private PredictableDie ceilingDie;
	private PredictableDie floorDie;
	
	public PredictableDice(int[] is) {
		if (is.length == 0) {
			throw new RuntimeException();
		}
		ceilingRoll = new int[is.length];
		floorRoll = new int[is.length];
		
		for (int i = 0; i < is.length; i++) {
			ceilingRoll[i] = (int)Math.ceil((double)is[i]/2);
			floorRoll[i] = (int)Math.floor((double)is[i]/2);
		}
		ceilingDie = new PredictableDie(ceilingRoll);
		floorDie = new PredictableDie(floorRoll);
		this.nextInt = 0;
	}
	
	public void roll() {
		ceilingDie.roll();
		floorDie.roll();
		this.lastRoll = ceilingDie.getLastRoll() + floorDie.getLastRoll();
		this.nextInt++;
	}
	
	public int getLastRoll() {
		return this.lastRoll;
	}
	
}
