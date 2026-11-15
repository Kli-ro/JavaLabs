package Lab9.task6;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int capacity = 50;
        int threads = 100;
        int attemptsPerThread = 10;

        System.out.println("CoarseGrainedEnrollment");
        runTest(new CoarseGrainedEnrollment(capacity), threads, attemptsPerThread, capacity);

        System.out.println("AtomicEnrollment");
        runTest(new AtomicEnrollment(capacity), threads, attemptsPerThread, capacity);

        System.out.println("ConcurrentCollectionEnrollment");
        runTest(new ConcurrentCollectionEnrollment(capacity), threads, attemptsPerThread, capacity);
    }

    private static void runTest(CourseEnrollment enrollment, int threads, int attemptsPerThread, int capacity) throws InterruptedException {
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch finishLatch = new CountDownLatch(threads);
        ExecutorService executor = Executors.newFixedThreadPool(threads);
        AtomicInteger successCount = new AtomicInteger(0);

        try {
            for (int i = 0; i < threads; i++) {
                final int threadId = i;
                executor.submit(() -> {
                    try {
                        startLatch.await();
                        for (int j = 0; j < attemptsPerThread; j++) {
                            String studentId = "student:" + (threadId * attemptsPerThread + j);
                            if (enrollment.enroll(studentId)) {
                                successCount.incrementAndGet();
                            }
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        finishLatch.countDown();
                    }
                });
            }

            startLatch.countDown();
            finishLatch.await(10, TimeUnit.SECONDS);

            System.out.println("Enrolled count: " + enrollment.getEnrolledCount());
            System.out.println("Successful attempts: " + successCount.get());
            System.out.println("Limit respected: " + (enrollment.getEnrolledCount() <= capacity));
        } finally {
            executor.shutdownNow();
        }
    }
}