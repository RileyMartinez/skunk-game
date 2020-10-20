package skunk.domain;

/**
 * Dice represents a single pair of rollable Die objects, randomly generating
 * sums of their two values
 * 
 * This is a Javadoc comment: add more to your finished class below
 * 
 * @author eric
 *
 */

public class Dice {
	// Instance fields (variables) may be declared anywhere in class body
	// Convention: put at top

	private int lastRoll;
	private Die die1;
	private Die die2;

	// Constructors (object initializers) also can be declared anywhere
	// Convention: after instance fields/variables

	public Dice() {
		// initialize instance variables die1 and die2 by
		// creating a new instance of each
		die1 = new Die();
		die2 = new Die();
		roll();
	}

	// Instance methods can also be declared anywhere in body of class
	// One convention: after the constructors

	public int getLastRoll() {
		return this.lastRoll;
	}
	
	public int getLastRollDie1() {
		return getDie1().getLastRoll();
	}

	public int getLastRollDie2() {
		return getDie2().getLastRoll();
	}
	
	public Die getDie1() {
		return die1;
	}

	public Die getDie2() {
		return die2;
	}

	public void roll() {
		// Roll each of die1, die2, sum their last rolls,
		// then set Dice.lastRoll to this value
		die1.roll();
		die2.roll();
		lastRoll = die1.getLastRoll() + die2.getLastRoll();
	}

	// the following method converts the internals of
	// this Dice object, and returns a descriptive String:
	//
	// Roll of 7 => 4 + 3
	//

	public String toString() {
		return "Dice with last roll: " + getLastRoll() + " => " + die1.getLastRoll() + " + " + die2.getLastRoll();
	}


	// static methods can go anywhere - but at end is one convention
	
	/*
	 * public static final int NUM_TRIALS = 360;
	 * 
	 * public static void main(String[] args) { // simulate repeated rolls of Dice,
	 * counting the many double skunks
	 * 
	 * Dice dice = new Dice(); int doubleSkunkCount = 0;
	 * 
	 * for (int i = 0; i < NUM_TRIALS; i++) { dice.roll(); StdOut.println(dice);
	 * 
	 * if (dice.getLastRoll() == 2) doubleSkunkCount++; }
	 * 
	 * StdOut.println("Actual count: " + doubleSkunkCount);
	 * StdOut.println("Expected count: " + (NUM_TRIALS / 36.0)); }
	 */
}
