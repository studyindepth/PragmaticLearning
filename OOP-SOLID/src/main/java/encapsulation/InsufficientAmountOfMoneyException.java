package encapsulation;

public class InsufficientAmountOfMoneyException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1994091752732750497L;

	public InsufficientAmountOfMoneyException() {
		super();
	}

	public InsufficientAmountOfMoneyException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InsufficientAmountOfMoneyException(String message, Throwable cause) {
		super(message, cause);
	}

	public InsufficientAmountOfMoneyException(String message) {
		super(message);
	}

	public InsufficientAmountOfMoneyException(Throwable cause) {
		super(cause);
	}

}
