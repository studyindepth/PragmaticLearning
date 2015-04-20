package concurrency.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import concurrency.executor.Futures.CallMe;

public class test {

    protected static void tet1(ExecutorService exe) throws InterruptedException, ExecutionException {
        CallMe callMe = new CallMe();
        Future<String> f = exe.submit(callMe);
        System.out.println(f.getClass());
        System.out.println(f.get());
    }

    public test() {
        super();
    }

}