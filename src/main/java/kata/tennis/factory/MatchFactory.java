package kata.tennis.factory;

import kata.tennis.Match;
import kata.tennis.Player;
import kata.tennis.exceptions.TennisException;

public class MatchFactory {
	
	/**
	 * Create match
	 * @param player1
	 * @param player2
	 * @return new match
	 */
	public static Match createMatch(Player player1, Player player2) {
		
        if (player1.getName() == null || player1.getName().isEmpty() 
        		|| player2.getName() == null || player2.getName().isEmpty()) {
            throw new TennisException("A players names can not be null or empty");
        }
        
        if (player1.getName().equals(player2.getName())) {
            throw new TennisException("A players should be different.");
        }
		
		return new Match(player1, player2);
	}
}
