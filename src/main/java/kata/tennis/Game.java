package kata.tennis;


import kata.tennis.constants.Constants;
import kata.tennis.enums.MatchStatus;

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
		Player player2 = this.getSetGame().getMatch().getPlayer2();
		
		switch (this.status) {

			case Constants.DEUCE :  if (player2.equals(player)) 
										this.status = Constants.ADVANTAGE_PLAYER_2;
									 else 
										this.status = Constants.ADVANTAGE_PLAYER_1;
									break;
									
			case Constants.ADVANTAGE_PLAYER_1 : if (player2.equals(player)) 
													this.status = Constants.DEUCE;
												else 
													this.status = Constants.PLAYER_1_WINS;
	
												break;
			case Constants.ADVANTAGE_PLAYER_2 : if (player2.equals(player)) {
													this.status = Constants.PLAYER_2_WINS;
													nextStep();
												} else 
													this.status = Constants.DEUCE;
												break;
			default : 
				String[] individualScores = this.status.split(Constants.HYPHEN);
				int player1Score = Integer.valueOf(individualScores[0]);
				int player2Score = Integer.valueOf(individualScores[1]);
				if (checkTieBreak()) 
					manageTieBreak(player1Score, player2Score, player);
				else {
					switch (player.getPlayerNb()) {
						case Constants.PLAYER_1 : 
										if (player1Score < 30) {
											player1Score += 15;
											this.status = Integer.toString(player1Score).concat(Constants.HYPHEN).concat(Integer.toString(player2Score));
										} else if (player1Score < 40) {
											if (player2Score == 40) 
												this.status = Constants.DEUCE;
											else {
												player1Score += 10;
												this.status = Integer.toString(player1Score).concat(Constants.HYPHEN)
														.concat(Integer.toString(player2Score));
											}
										} else {
											this.status = Constants.PLAYER_1_WINS;
											nextStep();
										}
										break;
						case Constants.PLAYER_2 : 
										if (player2Score < 30) {
											player2Score += 15;
											this.status = Integer.toString(player1Score).concat(Constants.HYPHEN).concat(Integer.toString(player2Score));
										} else if (player2Score < 40) {
											if (player1Score == 40) 
												this.status = Constants.DEUCE;
											 else {
												player2Score += 10;
												this.status = Integer.toString(player1Score).concat(Constants.HYPHEN)
														.concat(Integer.toString(player2Score));
											}
										} else {
											this.status = Constants.PLAYER_2_WINS;
											nextStep();
										}
										break;
					}
				}
		}
	}
	/**
	 *  manage tie break of player 
	 * @param player1Score
	 * @param player2Score
	 */
	private void manageTieBreak(int player1Score, int player2Score, Player player) {
		
		switch (player.getPlayerNb()) {
			case Constants.PLAYER_1 : player1Score++;
							if (player1Score >= Constants.NB_POINTS_TO_WIN_A_TIE_BREAK
									&& player1Score - player2Score >= Constants.DIFF_TO_WIN_THE_GAME) {
								this.status = Constants.PLAYER_1_WINS;
								nextStep();
							} else 
								this.status = Integer.toString(player1Score).concat(Constants.HYPHEN)
										.concat(Integer.toString(player2Score));
							break;
			
			case Constants.PLAYER_2 : player2Score++;
							if (player2Score >= Constants.NB_POINTS_TO_WIN_A_TIE_BREAK
									&& player2Score - player1Score >= Constants.DIFF_TO_WIN_THE_GAME) {
								this.status = Constants.PLAYER_2_WINS;
								nextStep();
							} else 
								this.status = Integer.toString(player1Score).concat(Constants.HYPHEN)
										.concat(Integer.toString(player2Score));
							break;
		}
		
	}

	/**
	 * check tie break
	 * @return true if it's a tie break, else false
	 */
	private boolean checkTieBreak() {
		boolean tieBreak = false;
		if (this.setGame.getGames().size() > Constants.NB_GAMES_TO_HAVE_A_TIE_BREAK) {
			tieBreak = true;
		}
		return tieBreak;
	}

	public void nextStep() {
		if (this.getSetGame().getStatus().equals(MatchStatus.IN_PROGRESS)) {
			this.getSetGame().addNewGame();
		} else if (this.getSetGame().getMatch().getStatus().equals(MatchStatus.IN_PROGRESS)) {
			this.getSetGame().getMatch().addNewSet();
		}
	}
}
