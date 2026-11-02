package task10;
import task1.Course;
public interface CourseDescriber {
    default String describe(Course course) {
        return "Описание курса: " + course.title();
    }
}
