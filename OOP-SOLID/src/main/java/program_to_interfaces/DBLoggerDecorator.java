package program_to_interfaces;

public class DBLoggerDecorator extends LoggerDecorator {

	private Logger decoratingLogger;

	public DBLoggerDecorator(Logger decoratedLogger) {
		super(decoratedLogger);
		decoratingLogger = new DBLogger();
	}

	public DBLoggerDecorator(Logger decoratedLogger, Logger decoratingLogger) {
		super(decoratedLogger);
		this.decoratingLogger = decoratingLogger;
	}

	@Override
	public void log(String message) {
		super.log(message);
		logToDB(message);

	}

	private void logToDB(String message) {
		decoratingLogger.log(message);
	}

}
