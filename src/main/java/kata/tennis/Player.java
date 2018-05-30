package kata.tennis;

public class Player {

	private String name;
	private String playerNb;

	public Player(String name, String playerNb) {
		this.name = name;
		this.playerNb = playerNb;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlayerNb() {
		return playerNb;
	}

	public void setPlayerNb(String playerNb) {
		this.playerNb = playerNb;
	}
}
