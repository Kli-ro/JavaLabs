package task6;

public class StatsAccumulator {
    private long count = 0;
    private int sum = 0;
    private int min = Integer.MAX_VALUE;
    private int max = Integer.MIN_VALUE;

    public void accept(int value) {
        count++;
        sum += value;
        if (value < min) min = value;
        if (value > max) max = value;
    }

    public StatsAccumulator combine(StatsAccumulator other) {
        this.count += other.count;
        this.sum += other.sum;
        if (other.min < this.min) this.min = other.min;
        if (other.max > this.max) this.max = other.max;
        return this;
    }

    public Stats finish() {
        return new Stats(count, sum, min, max);
    }
}