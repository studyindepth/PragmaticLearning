package concurrency.thread;

public class EventTask implements Runnable {

    @Override
    public void run() {
        System.out.println("sync events");
    }

}
