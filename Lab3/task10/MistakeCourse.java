package task10;
import task1.Course;

public class MistakeCourse implements CourseDescriber, CourseSummarizer {
    @Override
    public String describe(Course course) {
        return CourseDescriber.super.describe(course) + " | " + CourseSummarizer.super.describe(course);
    }
}
