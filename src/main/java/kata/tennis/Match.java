package kata.tennis;


import java.util.ArrayList;
import java.util.List;

import kata.tennis.constants.Constants;
import kata.tennis.enums.MatchStatus;

public class Match {

	private Player player1;
	private Player player2;
	private List<SetGame> setsGame = new ArrayList<SetGame>();
	private Game currentGame;

	public Match(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public List<SetGame> getSetsGame() {
		return setsGame;
	}

	public void setSetsGame(List<SetGame> setsGame) {
		this.setsGame = setsGame;
	}

	public Game getCurrentGame() {
		return currentGame;
	}

	public void setCurrentGame(Game currentGame) {
		this.currentGame = currentGame;
	}

	/**
	 * @return return the status of the match
	 */
	public MatchStatus getStatus() {
		return null;
	}

	/**
	 * @return the score of the match
	 */
	public String getScore() {
		return null;
	}

	/**
	 * initialize a new set
	 */
	public void addNewSet() {

	}
}
