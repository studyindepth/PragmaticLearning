package hibernate.transaction_concurrency.well;

import org.junit.Test;

public class TransactionSopingTest {
    static UserService service = new UserService();

    @Test
    public void test() throws InterruptedException {
        Thread t = new TxThread();
        Thread t1 = new TxThread();
        Thread t2 = new TxThread();
        Thread t3 = new TxThread();
        Thread t4 = new TxThread();
        t.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t.join();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        System.out.println("OK");
    }

    static class TxThread extends Thread {

        @Override
        public void run() {
            service.createUser("test");
        }
    }
}
