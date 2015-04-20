package threads;

import java.util.concurrent.TimeUnit;

public class TestThreads {
    public static void main(String[] args) {
        new Thread(new Idle()).start();
        new Thread(new Busy()).start();
    }

}

class Idle implements Runnable {

    @Override
    public void run() {
        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Busy implements Runnable {

    @Override
    public void run() {
        while (true) {
            "test".matches("t*");
            System.out.println("t");
        }
    }
}
