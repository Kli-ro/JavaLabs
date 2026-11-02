package task6;

public class MainTask6 {
    public static void main(String[] args) {
        NewCourse javaCourse = new NewCourse(10, "Java course", 16);

        NewCourseFormatter formatter = new NewCompactFormatter();
        System.out.println(formatter.format(javaCourse));

        BaseFormatter base = new MistakeFormatter();
        System.out.println(base.format("hello"));
    }
}
