package task15;

import task1.Course;

public class CapacityRule implements EnrollmentRule {
    @Override
    public EnrollmentResult check(Course course, int age, int current, int capacity, String[] completed) {
        if (current >= capacity) {
            return new EnrollmentResult.Rejected(course, "Hasn't free places");
        }
        return new EnrollmentResult.Accepted(course);
    }
}