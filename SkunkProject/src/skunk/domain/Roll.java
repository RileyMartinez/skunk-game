package skunk.domain;

import java.util.ArrayList;

public class Roll {
	
	private static final int SKUNK_VALUE = 1;
	private static final int SKUNK_DEUCE_SUM = 3;
	private Dice dice;
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
	
	public void checkLastDiceRoll() {
		if (getLastDiceRollDie1() == SKUNK_VALUE && getLastDiceRollDie2() == SKUNK_VALUE) {
			setDouble(true);
			setSkunk(false);
			setDeuce(false);
		} else if (getLastDiceRollDie1() + getLastDiceRollDie2() == SKUNK_DEUCE_SUM) {
			setDeuce(true);
			setSkunk(false);
			setDouble(false);
		} else if (getLastDiceRollDie1() == SKUNK_VALUE || getLastDiceRollDie2() == SKUNK_VALUE) {
			setSkunk(true);
			setDeuce(false);
			setDouble(false);
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
			s = "oof, you rolled a skunk! You lose 1 chip to the Kitty.\n";
		} else if (isDeuce) {
			s = "big oof, you rolled a deuce! You lose 2 chips to the Kitty.\n";
		} else if (isDouble) {
			s = "really big oof, you rolled a double skunk! You lose 4 chips to the Kitty, "
					+ "and your total points for the game have been reset to 0.\n";
		}
		return s += "Roll #" + getRollHistory().size() + "\n"
				+ "Roll Total: " + getLastDiceRoll() + " => " 
				+ getLastDiceRollDie1() + " + " + getLastDiceRollDie2(); 
	}
	
}
