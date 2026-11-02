package task6;

public class NewCompactFormatter implements NewCourseFormatter {
    @Override
    public String format(NewCourse course) {
        return course.title() + " " + "hours: " +course.durationHours();
    }
}
