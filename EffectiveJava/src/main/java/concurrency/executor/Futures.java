package concurrency.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Futures extends test {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService exe = Executors.newCachedThreadPool();
        test(exe);
    }

    private static void test(ExecutorService exe) throws InterruptedException, ExecutionException {
        tet1(exe);
    }

    static class CallMe implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("call me");
            return "called";
        }

    }
}
