package tests;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locks {
    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        try {
            System.out.println("Going to lock...");
            lock1.lock();
            System.out.println("In critical section");
        } finally {
            lock2.unlock();
            System.out.println("Unlocking ...");
        }
    }
}
