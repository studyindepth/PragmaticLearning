package program_to_interfaces;

public class LogClient {
	private Logger logger;

	public LogClient(Logger logger) {
		this.logger = logger;
	}

	public void doSomething() {
		logger.log("start doing something");

		// Do thing

		logger.log("finish doing something");
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public static void main(String[] args) {
		Logger fileLogger = new FileLogger();
		LogClient client = new LogClient(fileLogger);
		client.doSomething();

		System.out.println("-------------------------");

		Logger dbLogger = new DBLogger();
		client.setLogger(dbLogger);
		client.doSomething();

		System.out.println("-------------------------");

		Logger fileDBLogger = new DBLoggerDecorator(fileLogger);
		client.setLogger(fileDBLogger);
		client.doSomething();
	}
}
