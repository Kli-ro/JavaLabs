package Lab9.task3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SessionMain {
    public static void main(String[] args) throws InterruptedException {
        SessionRegistr registry = new SessionRegistr();
        AtomicInteger successCount = new AtomicInteger(0);
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            executor.submit(() -> {
                if (registry.registerSession("session-1", new Session("session-1"))) {
                    successCount.incrementAndGet();
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("Successful registrations: " + successCount.get());
    }
}