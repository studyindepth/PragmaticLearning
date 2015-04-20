package concurrency;

public class WaitAndNotify {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread wait = new WaitThread(lock);
        Thread notify = new NotifyThread(lock);
        wait.start();
        notify.start();
    }

    static class WaitThread extends Thread {

        Object lock;

        public WaitThread(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                try {
                    lock.wait();
                    System.out.println("running");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    static class NotifyThread extends Thread {
        Object lock;

        public NotifyThread(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock) {
                System.out.println("start notifying");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.notify();

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("notifying ends");
            }
        }

    }
}
