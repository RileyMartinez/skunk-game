package skunk.domain;

public class Player {
	
	private int points;
	private String name;
	
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
}
