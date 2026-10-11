package Lab3.task3;

import java.util.HashMap;
import java.util.Map;

public class MapIndexMain {
    public static void main(String[] args) {
        Map<String, Course> index = new HashMap<>();
        index.put("Java", new Course("Java", "Java Course"));
        index.put("Python", new Course("Python", "Python Course"));

        Course duplicate = new Course("Java", "Java Course v2");
        index.putIfAbsent("Java", duplicate);
        System.out.println(index.get("Java"));

        index.put("Java", duplicate);
        System.out.println(index.get("Java"));

        Course existing = index.get("Python");
        System.out.println("get: " + existing);
        System.out.println("containsKey: " + index.containsKey("Python"));

        index.putIfAbsent("Go", new Course("Go", "Go Course"));
        index.computeIfAbsent("C", k -> new Course(k, "C Course"));

        System.out.println(index);
    }
}