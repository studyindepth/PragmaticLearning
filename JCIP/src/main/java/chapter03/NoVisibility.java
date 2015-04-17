package chapter03;

import net.jcip.annotations.NotThreadSafe;

@NotThreadSafe
public class NoVisibility {
    static int number;
    static boolean ready;

    static class ReaderThread extends Thread {

        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
                System.out.println("Yield");
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new ReaderThread();
        t.start();
        number = 10;
        ready = true;

    }
}