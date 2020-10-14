package skunk.domain;

public class Turn {

	private Player player;
	private int score;

	public Turn(Player p) {
		this.player = p;
	}

	public void increaseScore(int rollAmount) {
		this.score += rollAmount;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void wipeScore() {
		this.setScore(0);
	}

	public void cashOut() {
		this.player.addPoints(this.getScore());
	}
}
