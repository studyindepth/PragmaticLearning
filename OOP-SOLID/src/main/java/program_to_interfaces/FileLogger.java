package program_to_interfaces;

public class FileLogger implements Logger {

	@Override
	public void log(String message) {
		System.out.printf("Log '%s' to File \n", message);
	}

}
