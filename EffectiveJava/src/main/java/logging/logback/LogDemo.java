package logging.logback;

public class LogDemo {
    private static final SimpleLogger LOGGER = SimpleLoggerFactory.getLogger(LogDemo.class);

    public static void main(String[] args) {
//        /* start a process */
//        LOGGER.startProcess("download", System.currentTimeMillis());
//
//        System.out.println("\n\n");
//
//        /* end a process successfully */
//        LOGGER.endProcess("download", System.currentTimeMillis(), 3600000);
//
//        System.out.println("\n\n");
//
//        /* end a process unsuccessfully */
//        LOGGER.failProcess("download", "E001: Failed to download data XXX", new Exception());
//
//        System.out.println("\n\n");
//
//        /* log warning */
//        LOGGER.warning("E001", "warning mesasge");

        LOGGER.fatal("E001", "warning mesxdddasge");
    }
}
