package kata.tennis;

import org.junit.Before;
import org.junit.Test;

import kata.tennis.constants.Constants;
import kata.tennis.factory.MatchFactory;

public class KataTest {

	private Match match;
	private Player player1;
	private Player player2;

	@Before
	public void beforeMatchTest() {
		player1 = new Player("player1", Constants.PLAYER_1);
		player2 = new Player("player2", Constants.PLAYER_2);
		match = MatchFactory.createMatch(player1, player2);
	}

	
	/**
	 * fifteen should be the player 1 score
	 */
	@Test
	public void fifteenShouldBeThePlayer1Score() {

	}
	
	/**
	 * fifteen should be the player 2 score
	 */
	@Test
	public void fifteenShouldBeThePlayer2Score() {

	}
	
	// test ex 1 (6 -1) (7-5) (1-0)
	@Test
	public void inProgressStatusShouldBeTheMatchStatus() {

	}

	// test ex 2 (6 -1) (7-5) (0-0)
	@Test
	public void deuceShouldBeTheCurrentGameStatusAtLeastThreePointsHaveBeenScoredByPlayersEqual() {
	

	}


	// set score (6-1) (7-5)
	public void initTest() {
		// first set (6-1)
		for (int i = 0; i <= 1 ; i++) 
			winNormalGame(player1);
		
		winNormalGame(player2);
		
		for (int i = 0; i <= 3 ; i++) 
			winNormalGame(player1);
		
		// second set (7-5)
		for (int i = 0; i <= 4 ; i++) 
			winNormalGame(player1);
		
		for (int i = 0; i <= 4 ; i++) 
			winNormalGame(player2);
		
		for (int i = 0; i <= 1 ; i++) 
			winNormalGame(player1);
		
	}
	
	/**
	 * win normal game
	 * @param player
	 */
	public void winNormalGame(Player player) {
		for (int i = 0; i <= 3 ; i++) 
			match.getCurrentGame().scorePoint(player);
		
	}	

	/**
	 * Initialise for tie break game
	 */
	public void initializeForTieBreakGame() {
		winNormalGame(player1);
		winNormalGame(player2);
		winNormalGame(player1);
		winNormalGame(player2);
		winNormalGame(player1);
		winNormalGame(player2);
		winNormalGame(player1);
		winNormalGame(player2);
		winNormalGame(player1);
		winNormalGame(player2);
		winNormalGame(player1);
		winNormalGame(player2);
	}
}
