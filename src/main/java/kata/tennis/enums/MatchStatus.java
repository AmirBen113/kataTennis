package kata.tennis.enums;

public enum MatchStatus {

	/**
	 * Different status of the match
	 */
	IN_PROGRESS("in progress"),PLAYER_1_WINS("player 1 wins"),PLAYER_2_WINS("player 2 wins");
	private String status;

	MatchStatus(String status) {
		this.setStatus(status);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
