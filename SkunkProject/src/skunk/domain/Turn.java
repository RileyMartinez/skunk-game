package skunk.domain;

public class Turn {

	private Player player;
	private int score;

	public Turn(Player p) {
		this.player = p;
		this.score = 0;
	}

	public void increaseScore(int rollAmount) {
		this.setScore(this.getScore() + rollAmount);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void clearScore() {
		this.setScore(0);
	}

	public void endTurn() {
		this.player.addPoints(this.getScore());
	}
}
