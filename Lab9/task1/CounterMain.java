package Lab9.task1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CounterMain {
    public static void main(String[] args) throws InterruptedException {
        SharedCounter counter = new SharedCounter();
        int threads = 10;
        int iterations = 100_000;

        ExecutorService executor = Executors.newFixedThreadPool(threads);
        for (int i = 0; i < threads; i++) {
            executor.submit(new IncrementRun(counter));
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("Expected: " + (threads * iterations));
        System.out.println("Actual:   " + counter.getCnt());
    }
}