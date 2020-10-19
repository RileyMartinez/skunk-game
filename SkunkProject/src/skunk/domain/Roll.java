package skunk.domain;

public class Roll {
	
	private static final int SKUNK_VALUE = 1;
	private static final int SKUNK_DEUCE_SUM = 3;
	private Dice dice;
	private PredictableDice testDice;
	private boolean isSkunk;
	private boolean isDeuce;
	private boolean isDouble;
	
	public Roll () {
		setDice(new Dice());
	}
	
	public void rollDiceAndCheck() {
		dice.roll();
		checkLastDiceRoll();
	}
	
	public int getLastDiceRoll() {
		return getDice().getLastRollDie1() + 
				getDice().getLastRollDie2();
	}
	
	public int getLastDiceRollDie1() {
		return getDice().getLastRollDie1();
	}
	
	public int getLastDiceRollDie2() {
		return getDice().getLastRollDie2();
	}

	public Dice getDice() {
		return dice;
	}

	public void setDice(Dice dice) {
		this.dice = dice;
	}
	
	public PredictableDice getTestDice() {
		return testDice;
	}

	public void setTestDice(PredictableDice testDice) {
		this.testDice = testDice;
	}
	
	public void checkLastDiceRoll() {
		if (getLastDiceRollDie1() == SKUNK_VALUE && getLastDiceRollDie2() == SKUNK_VALUE) {
			setDouble(true);
		} else if (getLastDiceRollDie1() + getLastDiceRollDie2() == SKUNK_DEUCE_SUM) {
			setDeuce(true);
		} else if (getLastDiceRollDie1() == SKUNK_VALUE || getLastDiceRollDie2() == SKUNK_VALUE) {
			setSkunk(true);
		} else {
			setSkunk(false);
			setDeuce(false);
			setDouble(false);
		}
	}

	public boolean isSkunk() {
		return isSkunk;
	}

	public void setSkunk(boolean isSkunk) {
		this.isSkunk = isSkunk;
	}

	public boolean isDeuce() {
		return isDeuce;
	}

	public void setDeuce(boolean isDeuce) {
		this.isDeuce = isDeuce;
	}

	public boolean isDouble() {
		return isDouble;
	}

	public void setDouble(boolean isDouble) {
		this.isDouble = isDouble;
	}
	
}
