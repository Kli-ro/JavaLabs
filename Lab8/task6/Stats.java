package task6;

public class Stats {
    private final long count;
    private final int sum;
    private final int min;
    private final int max;

    public Stats(long count, int sum, int min, int max) {
        this.count = count;
        this.sum = sum;
        this.min = min;
        this.max = max;
    }

    @Override
    public String toString() {
        return "Stats{count=" + count + ", sum=" + sum + ", min=" + min + ", max=" + max + "}";
    }
}