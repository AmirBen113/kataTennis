package kata.tennis;

import java.util.ArrayList;
import java.util.List;

import kata.tennis.enums.MatchStatus;

public class SetGame {

	private Match match;
	private List<Game> games = new ArrayList<Game>();

	public SetGame(Match match) {
		this.match = match;
		match.getSetsGame().add(this);
	}

	public Match getMatch() {
		return match;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	/**
	 * @return the score of the set
	 */
	public String getScore() {
		return null;
	}

	/**
	 * @return the MatchStatus
	 */
	public MatchStatus getStatus() {
		return null;
	}

	/**
	 * add new game
	 */
	public void addNewGame() {
	}
}
