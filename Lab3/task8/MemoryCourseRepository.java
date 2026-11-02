package task8;

import java.util.ArrayList;
import java.util.List;

public class MemoryCourseRepository implements CourseRepository {
    private final List<NewCourseT8> courses = new ArrayList<>();

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

    @Override
    public void save(NewCourseT8 course) {
        courses.add(course);
    }

    @Override
    public void delete(long id) {
        courses.removeIf(c -> c.id() == id);
    }
}
