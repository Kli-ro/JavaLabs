package task11;

import java.util.Objects;

public class Course {
    private final long id;
    private final String title;
    private final int durationHours;

    public Course(long id, String title, int durationHours) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Course))
            return false;
        Course c = (Course) o;
        return id == c.id && Objects.equals(title, c.title) && durationHours == c.durationHours;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, durationHours);
    }

    @Override
    public String toString() {
        return "Course_" + id + " " + title + ", " + durationHours + "hours";
    }
}