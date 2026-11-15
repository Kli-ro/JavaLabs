package task7;

import java.util.*;
import java.util.stream.Stream;

public class CourseHubProcessor {
    public static CourseHubReport process(Stream<EnrollmentEvent> events) {
        Set<Long> uniqueStudents = new HashSet<>();
        Map<Long, long[]> courseStats = new HashMap<>();
        Map<String, Long> distribution = new HashMap<>();
        List<Long> anomalies = new ArrayList<>();

        events.forEach(event -> {
            if (event.getStudentId() <= 0) {
                anomalies.add(event.getCourseId());
                return;
            }
            uniqueStudents.add(event.getStudentId());
            long[] stats = courseStats.computeIfAbsent(event.getCourseId(), k -> new long[2]);
            stats[1]++;
            if (event.isCompleted()) stats[0]++;
            distribution.merge(event.getLevel(), 1L, Long::sum);
        });

        Map<Long, Double> completionRate = new HashMap<>();
        courseStats.forEach((courseId, stats) ->
                completionRate.put(courseId, stats[1] == 0 ? 0.0 : (double) stats[0] / stats[1]));

        List<Long> top3 = completionRate.entrySet().stream()
                .sorted(Map.Entry.<Long, Double>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();

        return new CourseHubReport(uniqueStudents, completionRate, top3, distribution, anomalies);
    }
}