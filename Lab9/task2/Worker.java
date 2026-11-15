package Lab9.task2;

public class Worker implements Runnable {
    private volatile boolean stopped = false;

    public void stop() {
        stopped = true;
    }

    @Override
    public void run() {
        while (!stopped) {
        }
        System.out.println("Worker stopped");
    }
}