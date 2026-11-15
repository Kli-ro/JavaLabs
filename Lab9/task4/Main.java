package Lab9.task4;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
        int producerCount = 2;
        int consumerCount = 3;
        int itemsPerProducer = 10;

        ExecutorService producerPool = Executors.newFixedThreadPool(producerCount);
        ExecutorService consumerPool = Executors.newFixedThreadPool(consumerCount);

        for (int i = 0; i < producerCount; i++) {
            producerPool.submit(new Producer(queue, itemsPerProducer));
        }
        for (int i = 0; i < consumerCount; i++) {
            consumerPool.submit(new Consumer(queue));
        }

        producerPool.shutdown();
        if (producerPool.awaitTermination(5, TimeUnit.SECONDS)) {
            for (int i = 0; i < consumerCount; i++) {
                queue.put("Stop");
            }
        }

        consumerPool.shutdown();
        if (!consumerPool.awaitTermination(5, TimeUnit.SECONDS)) {
            consumerPool.shutdownNow();
        }
        producerPool.shutdownNow();
    }
}