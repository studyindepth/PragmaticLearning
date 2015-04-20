package log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogTest {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        System.out.println(logger);
        int i = 0;
        while(true) {
            logger.error(i++);
        }
    }
}
