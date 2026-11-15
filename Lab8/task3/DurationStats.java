package task3;

public class DurationStats {
    private final int totalDuration;
    private final int count;

    public DurationStats(int totalDuration, int count) {
        this.totalDuration = totalDuration;
        this.count = count;
    }

    public static DurationStats identity() {
        return new DurationStats(0, 0);
    }

    public DurationStats accumulate(DurationStats other) {
        return new DurationStats(this.totalDuration + other.totalDuration, this.count + other.count);
    }

    public DurationStats combine(DurationStats other) {
        return accumulate(other);
    }

    public int getTotalDuration() { return totalDuration; }
    public int getCount() { return count; }
}