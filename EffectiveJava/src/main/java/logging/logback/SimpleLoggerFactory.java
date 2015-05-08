package logging.logback;

import org.slf4j.LoggerFactory;

public class SimpleLoggerFactory {

	public static SimpleLogger getLogger(Class<?> forClass) {
		return new SimpleLogger(LoggerFactory.getLogger(forClass));
	}

}
