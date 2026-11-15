package task1;

public class SortDeterm{
    private final String level;
    private final int duration;
    private final String code;

    public SortDeterm(String level, int duration, String code) {
        this.level = level;
        this.duration = duration;
        this.code = code;
    }

    public String getLevel() {return level; }
    public int getDuration() { return duration; }
    public String getCode() { return code; }

    @Override
    public String toString() {
        return "SortDeterm{level='" + level + "', duration=" + duration + ", code='" + code + "'}";
    }
}
