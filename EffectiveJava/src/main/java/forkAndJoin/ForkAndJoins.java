package forkAndJoin;

import java.util.concurrent.ForkJoinPool;

public class ForkAndJoins {
    public static void main(String[] args) {
        System.out.println(ForkJoinPool.commonPool().submit(new Task()));
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println("execute");
        }

    }
}
