package task15;

import task1.Course;

public class MinCompletedRule implements EnrollmentRule {
    private final int minCount;

    public MinCompletedRule(int minCount) {
        this.minCount = minCount;
    }

    @Override
    public EnrollmentResult check(Course course, int age, int current, int capacity, String[] completed) {
        if (completed.length < minCount) {
            return new EnrollmentResult.Rejected(course, "Пройдено меньше " + minCount + " курсов");
        }
        return new EnrollmentResult.Accepted(course);
    }
}