package task15;

import task1.Course;

public class EnrollmentEngine {
    private final EnrollmentRule rootRule;

    public EnrollmentEngine(EnrollmentRule rootRule) {
        this.rootRule = rootRule;
    }

    public EnrollmentResult enroll(Course course, int age, int current, int capacity, String[] completed) {
        return rootRule.check(course, age, current, capacity, completed);
    }
}