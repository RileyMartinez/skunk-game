package skunk.domain;

public class Kitty {
	
	private int chips;
	
	public void addChips(int i) {
		this.setChips(this.getChips() + i);
	}

	public int getChips() {
		return chips;
	}

	public void setChips(int chips) {
		this.chips = chips;
	}

	public void removeChips(int i) {
		this.setChips(this.getChips() - i);
	}

}
