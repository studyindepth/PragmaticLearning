package encapsulation;

public class IllegalAccountStateException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5985591426618494650L;

	public IllegalAccountStateException() {
		super();
	}

	public IllegalAccountStateException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public IllegalAccountStateException(String message, Throwable cause) {
		super(message, cause);
	}

	public IllegalAccountStateException(String message) {
		super(message);
	}

	public IllegalAccountStateException(Throwable cause) {
		super(cause);
	}

}
