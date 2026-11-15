package task4;

import task1.SortDeterm;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CourseStatistics {
    public static Map<String, CourseSummary> summarize(List<SortDeterm> courses) {
        return courses.stream()
                .collect(Collectors.groupingBy(
                        SortDeterm::getLevel,
                        Collectors.teeing(
                                Collectors.counting(),
                                Collectors.averagingInt(SortDeterm::getDuration),
                                (count, avg) -> new CourseSummary(null, count, avg)
                        )
                ));
    }
}