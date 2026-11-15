package task7;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseHubReport {
    private final Set<Long> uniqueStudents;
    private final Map<Long, Double> completionRate;
    private final List<Long> top3;
    private final Map<String, Long> distribution;
    private final List<Long> anomalies;

    public CourseHubReport(Set<Long> uniqueStudents, Map<Long, Double> completionRate,
                           List<Long> top3, Map<String, Long> distribution, List<Long> anomalies) {
        this.uniqueStudents = uniqueStudents;
        this.completionRate = completionRate;
        this.top3 = top3;
        this.distribution = distribution;
        this.anomalies = anomalies;
    }

    @Override
    public String toString() {
        return "CourseHubReport{uniqueStudents=" + uniqueStudents.size() + ", completionRate=" + completionRate + ", top3=" + top3 + ", distribution=" + distribution + ", anomalies=" + anomalies + "}";
    }
}