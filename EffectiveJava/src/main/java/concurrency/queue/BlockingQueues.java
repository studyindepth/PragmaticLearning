package concurrency.queue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueues {
    public static void main(String[] args) throws InterruptedException {
        //  LinkedBlockingQueue<String> queues = new LinkedBlockingQueue<>();
        // System.out.println(queues.poll(10, TimeUnit.MILLISECONDS));

        ArrayBlockingQueue<String> arrayQueue = new ArrayBlockingQueue<>(2);
        /// arrayQueue.offer("a");
        // arrayQueue.offer("b");
        // arrayQueue.offer("c");
        // arrayQueue.poll();

        ProducerThread producer = new ProducerThread(arrayQueue);
        ConsumerThread consumer = new ConsumerThread(arrayQueue);
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
        for (String string : arrayQueue) {
            System.out.println(string);
        }

    }

    static class ProducerThread extends Thread {

        BlockingQueue<String> queue;

        public ProducerThread(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            queue.offer("a");
            queue.offer("b");
            try {
                queue.offer("c", 1000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    static class ConsumerThread extends Thread {

        BlockingQueue<String> queue;

        public ConsumerThread(BlockingQueue<String> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("consumer " + queue.poll());
        }
    }

}
