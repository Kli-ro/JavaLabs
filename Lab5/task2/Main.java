package Lab3.task2;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Java", "Java Course"),
                new Course("Python", "Python Course"),
                new Course("C", "C Course"),
                new Course("Go", "Go Course")
        );

        Set<Course> unique = new LinkedHashSet<>(courses);
        System.out.println(unique);
    }
}
