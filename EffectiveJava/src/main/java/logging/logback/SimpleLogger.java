package logging.logback;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class SimpleLogger {
    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    Marker fatal = MarkerFactory.getMarker("FATAL");
    private Logger log;

    public SimpleLogger(Logger log) {
        this.log = log;
    }

    public void startProcess(String processName, long startTimeMilis) {
        if (log.isInfoEnabled()) {
            StringBuilder out = new StringBuilder();
            out.append("\n===========================================================\n");
            out.append("BEGIN ");
            out.append(processName);
            out.append("\n----------------------------------------");
            out.append("\nStarted at ");
            out.append(dateFormatter.format(new Date(startTimeMilis)));
            out.append("\n===========================================================\n");
            log.info(out.toString());
        }
    }

    public void endProcess(String processName, long endTimeMilis, long startTimeMilis) {
        if (log.isInfoEnabled()) {
            StringBuilder out = new StringBuilder();
            out.append("\n===========================================================\n");
            out.append("FINISHED SUCCESSFUL ");
            out.append(processName);
            out.append("\n----------------------------------------");
            out.append("\nTotal time ");
            out.append(formatMilis(endTimeMilis - startTimeMilis));
            out.append("\nFinished at ");
            out.append(dateFormatter.format(new Date(endTimeMilis)));
            out.append("\n===========================================================\n");
            log.info(out.toString());
        }
    }

    public void failProcess(String processName, String errorMessage, Throwable e) {
        if (log.isErrorEnabled()) {
            StringBuilder out = new StringBuilder();
            out.append("\n===========================================================\n");
            out.append("EXECUTE FAILURE! ");
            out.append(processName);
            out.append("\n");
            out.append(errorMessage);
            out.append("\n----------------------------------------\n");
            out.append(ExceptionUtils.getStackTrace(e));
            out.append("===========================================================\n");
            log.error(out.toString());
        }
    }

    public void warning(String messageId, String content) {
        log.warn("{} - {}", messageId, content);
    }

    public void fatal(String messageId, String content) {
        System.out.println(fatal);
        log.error(fatal, "{} - {}", messageId, content);
    }

    public static String formatMilis(long millis) {
        return String.format(
                "%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(millis),
                TimeUnit.MILLISECONDS.toMinutes(millis)
                        - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                TimeUnit.MILLISECONDS.toSeconds(millis)
                        - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
    }

}
