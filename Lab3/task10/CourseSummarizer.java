package task10;

import task1.Course;

public interface CourseSummarizer {
    default String describe(Course course) {
        return "Кратко: " + course.title() + " (" + course.durationHours() + " ч)";
    }
}