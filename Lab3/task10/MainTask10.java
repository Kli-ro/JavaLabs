package task10;
import task1.Course;

public class MainTask10 {
    public static void main(String[] args) {
        Course course = new Course(1, "Java Fundamentals", 32);
        MistakeCourse report = new MistakeCourse();
        System.out.println(report.describe(course));
    }
}
