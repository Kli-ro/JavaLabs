package task11;

import java.util.Objects;

public final class NewOnlineCourse {
    private final NewCourse course;
    private final String platform;

    public NewOnlineCourse(long id, String title, int durationHours, String platform) {
        this.course = new NewCourse(id, title, durationHours);
        this.platform = platform;
    }

    public NewCourse course() {
        return course;
    }
    public String platform() {
        return platform;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        NewOnlineCourse oc = (NewOnlineCourse) o;
        return course.equals(oc.course) && Objects.equals(platform, oc.platform);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, platform);
    }

    @Override
    public String toString() {
        return "NewOnlineCourse:" + course + ", " + platform;
    }
}
