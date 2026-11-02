package Lab4.task7;

import java.util.Optional;

public class CourseFind {
    public Optional<String> findCourse(String course) {
        if (course == null || course.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(course);
        }
    }
}
