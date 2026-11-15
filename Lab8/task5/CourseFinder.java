package task5;

import task1.SortDeterm;
import java.util.List;
import java.util.Optional;

public class CourseFinder {
    public static Optional<SortDeterm> findLongest(List<SortDeterm> courses) {
        return courses.stream().max((a, b) -> Integer.compare(a.getDuration(), b.getDuration()));
    }

    public static SortDeterm findLongestOrFallback(List<SortDeterm> courses) {
        return findLongest(courses).orElse(new SortDeterm("N/A", 0, "N/A"));
    }
}
