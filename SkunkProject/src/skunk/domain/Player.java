package skunk.domain;

public class Player {
	
	private int points;
	private String name;
	private int chips;
	
	public Player() {
		this.chips = 50;
		this.points = 0;
		this.name = "anon";
	}
	
	public Player(String name) {
		this.chips = 50;
		this.points = 0;
		this.name = name;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}

	public int getPoints() {
		return points;
	}
	
	public void addPoints(int turnScore) {
		this.setPoints(this.getPoints() + turnScore);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public int getChips() {
		return chips;
	}

	public void addChips(int i) {
		this.setChips(this.getChips() + i);
	}

	private void setChips(int i) {
		this.chips = i;
	}

	public void removeChips(int i) {
		this.setChips(this.getChips() - i);
	}

	public void clearPoints() {
		this.setPoints(0);
	}
}
