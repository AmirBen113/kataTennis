package kata.tennis;

public class Game {

	private SetGame setGame;
	private String status;

	public Game(SetGame setGame) {
		this.setGame = setGame;
		setGame.getGames().add(this);
	}

	public SetGame getSetGame() {
		return setGame;
	}

	public void setSetGame(SetGame setGame) {
		this.setGame = setGame;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * score point
	 * @param score player point
	 */
	public void scorePoint(Player player) {
		
	}
	/**
	 *  manage tie break of player 
	 * @param player1Score
	 * @param player2Score
	 */
	private void manageTieBreak(int player1Score, int player2Score, Player player) {
		
	}

	/**
	 * check tie break
	 * @return true if it's a tie break, else false
	 */
	private boolean checkTieBreak() {
		return true;
	}

	public void nextStep() {

	}
}
