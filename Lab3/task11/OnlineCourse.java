package task11;

import java.util.Objects;

public class OnlineCourse extends Course {
    private final String platform;

    public OnlineCourse(long id, String title, int durationHours, String platform) {
        super(id, title, durationHours);
        this.platform = platform;
    }

    public String platform() {
        return platform;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof OnlineCourse))
            return false;
        OnlineCourse oc = (OnlineCourse) o;
        return super.equals(oc) && Objects.equals(platform, oc.platform);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), platform);
    }

    @Override
    public String toString() {
        return "OnlineCourse_" + id() + " " + title() + ", " + platform;
    }
}