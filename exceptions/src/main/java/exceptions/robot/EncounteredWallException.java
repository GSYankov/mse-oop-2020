package exceptions.robot;

public class EncounteredWallException extends RuntimeException {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = -2126746582477114357L;

	/**
	 * Constructs the exception.
	 * 
	 * @param message the message.
	 */
	public EncounteredWallException(String message) {
		super(message);
	}
}
