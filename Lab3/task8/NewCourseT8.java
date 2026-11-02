package task8;

public class NewCourseT8 {
    private long id;
    private String title;

    public NewCourseT8(long id, String title) {
        this.id = id;
        this.title = title;
    }
    public long id() {
        return id;
    }
    public String title() {
        return title;
    }

    @Override
    public String toString() {
        return "Course#" + id + " (" + title + ")";
    }
}
