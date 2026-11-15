package task3;

import task1.SortDeterm;
import java.util.List;

public class DurationReducer {
    public static DurationStats reduceCorrect(List<SortDeterm> courses) {
        return courses.stream()
                .map(c -> new DurationStats(c.getDuration(), 1))
                .reduce(DurationStats.identity(), DurationStats::accumulate, DurationStats::combine);
    }

    public static DurationStats reduceWrong(List<SortDeterm> courses) {
        DurationStats wrongIdentity = new DurationStats(1, 1);
        return courses.stream()
                .map(c -> new DurationStats(c.getDuration(), 1))
                .reduce(wrongIdentity, DurationStats::accumulate, DurationStats::combine);
    }
}