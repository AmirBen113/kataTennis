package kata.tennis.exceptions;

public class TennisException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public TennisException() {
    }

    public TennisException(String message) {
        super(message);
    }

    public TennisException(String message, Throwable cause) {
    	super(message, cause);
    }
    
    public TennisException(Throwable e) {
        super(e);
    }
}