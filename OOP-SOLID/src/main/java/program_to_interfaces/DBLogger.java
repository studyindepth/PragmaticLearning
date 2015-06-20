package program_to_interfaces;

public class DBLogger implements Logger {

	@Override
	public void log(String message) {
		System.out.printf("Log '%s' to Database \n", message);
	}

}
