package task1;

public class ArrCourseFormatter implements CourseFormatter {
    @Override
    public String format(Course course) {
        return "[" + course.id() + ", " + course.title() + ", " + course.durationHours() + ", " + course.completedHours() + ", " + course.remainingHours() + ", " + course.isCompleted() + "]";
    }
}
