package Lab9.task1;

public class IncrementRun implements Runnable{
    private final SharedCounter counter;

    public IncrementRun(SharedCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100_000; i++) {
            counter.increment();
        }
    }
}
