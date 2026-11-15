package task2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CourseIndexer {
    public static Map<String, List<Course>> buildIndex(List<Course> courses) {
        return courses.stream()
                .flatMap(course -> course.getModules().stream()
                        .map(module -> Map.entry(module.getTopic().trim().toLowerCase(), course)))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())
                ));
    }
}