package exceptions.demo;

public class CustomException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4501853453899241674L;

	public CustomException(String message, Throwable e) {
		super(message, e);
	}

}
