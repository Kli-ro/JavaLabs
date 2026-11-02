package task8;

import java.util.List;
public interface CourseReader {
    NewCourseT8 findById(long id);
    List<NewCourseT8> findAll();
}
