package program_to_interfaces;

public abstract class LoggerDecorator implements Logger {

	private Logger decoratedLogger;

	public LoggerDecorator(Logger decoratedLogger) {
		this.decoratedLogger = decoratedLogger;
	}

	@Override
	public void log(String message) {
		decoratedLogger.log(message);
	}

}
