package concurrency.thread;

import java.util.concurrent.BlockingQueue;

public class TenantTask {
    private int teantId;
    private boolean isProcessed;
    private BlockingQueue<Runnable> userEventsQueue;
}
