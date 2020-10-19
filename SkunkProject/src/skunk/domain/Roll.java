package skunk.domain;

import java.util.ArrayList;

public class Roll {
	
	private static final int SKUNK_VALUE = 1;
	private static final int SKUNK_DEUCE_SUM = 3;
	private Dice dice;
	private PredictableDice testDice;
	private boolean isSkunk;
	private boolean isDeuce;
	private boolean isDouble;
	private ArrayList<int[]> rollHistory;
	
	public Roll () {
		setDice(new Dice());
		setRollHistory(new ArrayList<int[]>());
	}
	
	public void rollDiceCheckAndRecord() {
		dice.roll();
		checkLastDiceRoll();
		recordLastRoll();
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
	
	public ArrayList<int[]> getRollHistory() {
		return rollHistory;
	}
	
	public void setRollHistory(ArrayList<int[]> rollHistory) {
		this.rollHistory = rollHistory;
	}
	
	public void recordLastRoll() {
		int[] rollValues = { getLastDiceRollDie1(), getLastDiceRollDie2() };
		rollHistory.add(rollValues);
	}
	
	public int getDiceRollFromRecord(int rollNumber) {
		int[] rollArray = rollHistory.get(rollNumber -1);
		int diceValue = rollArray[0] + rollArray[1];
		return diceValue;
	}
	
	public int getDie1RollFromRecord(int rollNumber) {
		int[] rollArray = rollHistory.get(rollNumber - 1);
		int die1Value = rollArray[0];
		return die1Value;
	}
	
	public int getDie2RollFromRecord(int rollNumber) {
		int[] rollArray = rollHistory.get(rollNumber - 1);
		int die2Value = rollArray[1];
		return die2Value;
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
	
	public String toString() {
		String s = "";
		
		if (isSkunk) {
			s = "Oof, you rolled a skunk!\n";
		} else if (isDeuce) {
			s = "Big oof, you rolled a deuce!\n";
		} else if (isDouble) {
			s = "Really big oof, you rolled a double skunk!\n";
		}
		return s += "Roll #" + getRollHistory().size() + ":\n"
				+ "Roll Total: " + getLastDiceRoll() + " => " 
				+ getLastDiceRollDie1() + " + " + getLastDiceRollDie2(); 
	}
	
}
