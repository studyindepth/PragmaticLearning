package hibernate.transaction_concurrency;

import org.junit.Test;

public class TransactionSopingTest {
    static UserService service = new UserService(new PostDao(), new UserDAO());

    @Test
    public void test() throws InterruptedException {
        Thread t = new TxThread();
        Thread t1 = new TxThread();
        t.start();
        t1.start();
        t.join();
        t1.join();

    }

    static class TxThread extends Thread {

        @Override
        public void run() {
            service.createUserAndFirstPost("toan", "transaction scoping");
            //service.findAll();
        }

    }
}
