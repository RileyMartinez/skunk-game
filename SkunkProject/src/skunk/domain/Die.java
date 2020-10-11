package skunk.domain;

public class Die {
	private int lastRoll;

	public Die() {
		this.roll();
	}

	// getter or accessor method
	public int getLastRoll() { 
		return this.lastRoll;
	}
	
	// note how this changes Die's state, but doesn't return anything
	public void roll() { 
		this.lastRoll = (int) (Math.random() * 6 + 1);
	}

	@Override
	// this OVERRIDES the default Object.toString()
	public String toString() { 
		return "Die: " + this.getLastRoll();
	}

}
