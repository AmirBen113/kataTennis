package kata.tennis;

import static kata.tennis.constants.Constants.*;

import java.util.ArrayList;
import java.util.List;

import kata.tennis.constants.Constants;
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
		int nbP1 = 0, nbP2 = 0;
		List<Game> games = this.getGames();
		
		for (Game ge : games) {
			if (PLAYER_1_WINS.equals(ge.getStatus())) 
				nbP1 ++;
			else if (PLAYER_2_WINS.equals(ge.getStatus())) 
				nbP2 ++;
		}
		return "(".concat(String.valueOf(nbP1)).concat(HYPHEN).concat(String.valueOf(nbP2)).concat(")");
	}

	/**
	 * @return the MatchStatus
	 */
	public MatchStatus getStatus() {
		List<Game> games = this.getGames();
		int nbP1 = 0, nbP2 = 0;

		for (Game ge : games) {
			if (PLAYER_1_WINS.equals(ge.getStatus())) 
				nbP1 ++;
			else if (PLAYER_2_WINS.equals(ge.getStatus())) 
				nbP2 ++;
		}
		
		if (nbP1 == NB_GAMES_TO_WIN_A_SET_WITH_TIE_BREAK || (nbP1 >= NB_GAMES_TO_WIN_A_SET
						&& nbP1 - nbP2 >= DIFF_TO_WIN_THE_SET)) 
			return MatchStatus.PLAYER_1_WINS;
		else if (nbP2 == NB_GAMES_TO_WIN_A_SET_WITH_TIE_BREAK || (nbP2 >= NB_GAMES_TO_WIN_A_SET
						&& nbP2 - nbP1 >= DIFF_TO_WIN_THE_SET)) 
			return MatchStatus.PLAYER_2_WINS;
		else 
			return MatchStatus.IN_PROGRESS;
		
	}

	/**
	 * add new game
	 */
	public void addNewGame() {
		Game newGame = new Game(this);
		newGame.setStatus(Constants.INIT_GAME_STATUS);
		this.getMatch().setCurrentGame(newGame);
	}
}
