package tests;

import java.util.concurrent.atomic.AtomicInteger;

public class Atomics {

    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(0);
        increment(i);
        System.out.println(i);
    }

    static void increment(AtomicInteger atomicInt) {
        atomicInt.incrementAndGet();
    }
}

class MyThread extends Thread {
    public void run() {
        System.out.println("In run method; thread name is: " + Thread.currentThread().getName());
    }

    public static void main(String args[]) {
        Thread myThread = new MyThread();
        myThread.run(); // #1
        System.out.println("In main method; thread name is: " + Thread.currentThread().getName());
    }
}

class Te2st1 implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String arg[]) {
        Thread thread = new Thread(new Te2st1());
        // thread.run();
        // //thread.run();
        thread.start();

        Thread thread1 = new Thread(new Te2st1());
        // thread1.run();
        // thread1.run();
        thread1.start();
        System.out.println("d");
    }
}