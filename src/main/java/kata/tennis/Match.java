package kata.tennis;


import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

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
		SetGame set = new SetGame(this);
		Game game = new Game(set);
		game.setStatus(Constants.INIT_GAME_STATUS);
		this.setCurrentGame(game);
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
		List<SetGame> setGs = this.getSetsGame();
		int nbP1 = 0, nbP2 = 0;
		
		for (SetGame sg : setGs){
			if (MatchStatus.PLAYER_1_WINS.equals(sg.getStatus())) 
				nbP1 ++;
			else if (MatchStatus.PLAYER_2_WINS.equals(sg.getStatus())) 
				nbP2 ++;
		}
		
		if (nbP1 >= Constants.NB_SETS_TO_WIN_A_MATCH) 
			return MatchStatus.PLAYER_1_WINS;
		else if (nbP2 >= Constants.NB_SETS_TO_WIN_A_MATCH) 
			return MatchStatus.PLAYER_2_WINS;
		else 
			return MatchStatus.IN_PROGRESS;
	}

	/**
	 * @return the score of the match
	 */
	public String getScore() {
		List<SetGame> setGs = this.getSetsGame();
		StringJoiner joiner = new StringJoiner(" ");
		for (SetGame sg : setGs)
			joiner.add(sg.getScore());
		
		return joiner.toString();
	}

	/**
	 * initialize a new set
	 */
	public void addNewSet() {
		SetGame newSet = new SetGame(this);
		Game newGame = new Game(newSet);
		newGame.setStatus(Constants.INIT_GAME_STATUS);
		this.setCurrentGame(newGame);
	}
}
