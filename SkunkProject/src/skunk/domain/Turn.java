package skunk.domain;

public class Turn {

	private Player player;
	private int score;

	public Turn(Player p) {
		this.player = p;
	}

	public void increaseScore(int i) {
		this.setScore(i);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
