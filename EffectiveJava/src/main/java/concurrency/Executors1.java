package concurrency;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Executors1 {
    static ExecutorService executorService = Executors.newSingleThreadExecutor();
    private final static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {

        Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                logger.error("Thread " + t.getId() + " : " + e.getMessage(), e);
            }

        });
        Task task1 = new Task(1);
        try {
            executorService.execute(task1);
        } catch (Exception e) {
            System.out.println("e");
        }

        System.out.println("d");
    }

    public static class Task implements Runnable {
        int name;

        public Task(int name) {
            super();
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name);
            throw new RuntimeException();
        }

    }

}
