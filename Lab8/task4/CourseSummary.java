package task4;

public class CourseSummary {
    private final String level;
    private final long count;
    private final double avgDuration;

    public CourseSummary(String level, long count, double avgDuration) {
        this.level = level;
        this.count = count;
        this.avgDuration = avgDuration;
    }

    @Override
    public String toString() {
        return "CourseSummary{level='" + level + "', count=" + count + ", avgDuration=" + avgDuration + "}";
    }
}