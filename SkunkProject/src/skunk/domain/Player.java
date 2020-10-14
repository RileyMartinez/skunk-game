package skunk.domain;

public class Player {
	
	private int points;
	private String name;
	private int chips;
	
	public Player() {
		this.chips = 50;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}

	public int getPoints() {
		return points;
	}
	
	public void addPoints(int turnScore) {
		this.points += turnScore;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getName() {
		return this.name;
	}

	public int getChips() {
		return chips;
	}

	public void addChips(int i) {
		this.chips += i;
	}

	public void removeChips(int i) {
		this.chips -= i;
	}
}
