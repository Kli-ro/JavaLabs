package Lab3.task10;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KeyContractMain {
    public static void main(String[] args) {
        ChangeCourse course = new ChangeCourse("Java", "Java Course");

        Set<ChangeCourse> set = new HashSet<>();
        set.add(course);

        Map<ChangeCourse, String> map = new HashMap<>();
        map.put(course, "first");

        System.out.println("contains before: " + set.contains(course));
        System.out.println("map get before: " + map.get(course));

        course.setCode("Python");

        System.out.println("contains after: " + set.contains(course));
        System.out.println("map get after: " + map.get(course));

        ChangeCourse search = new ChangeCourse("Python", "Java Course");
        System.out.println("contains by equal key: " + set.contains(search));
    }
}