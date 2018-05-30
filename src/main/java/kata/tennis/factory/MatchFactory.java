package kata.tennis.factory;

import kata.tennis.Match;
import kata.tennis.Player;

public class MatchFactory {
	
	/**
	 * Create match
	 * @param player1
	 * @param player2
	 * @return new match
	 */
	public static Match createMatch(Player player1, Player player2) {
		
		return new Match(player1, player2);
	}
}
