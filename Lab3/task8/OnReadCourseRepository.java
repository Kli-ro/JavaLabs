package task8;

import java.util.ArrayList;
import java.util.List;

public class OnReadCourseRepository implements CourseReader {
    private final List<NewCourseT8> courses;

    public OnReadCourseRepository(List<NewCourseT8> courses) {
        this.courses = new ArrayList<>(courses);
    }

    @Override
    public NewCourseT8 findById(long id) {
        for (NewCourseT8 c : courses) {
            if (c.id() == id) return c;
        }
        return null;
    }

    @Override
    public List<NewCourseT8> findAll() {
        return new ArrayList<>(courses);
    }
}
