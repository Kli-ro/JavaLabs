package task6;

public class NewCourse {
    private long id;
    private String title;
    private int durationHours;

    public NewCourse(long id, String title, int durationHours) {
        this.id = id;
        this.title = title;
        this.durationHours = durationHours;
    }

    public long id() {
        return id;
    }

    public String title() {
        return title;
    }

    public int durationHours() {
        return durationHours;
    }
}
