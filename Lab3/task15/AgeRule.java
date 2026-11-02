package task15;

import task1.Course;

public class AgeRule implements EnrollmentRule {
    private final int minAge;

    public AgeRule(int minAge) {
        this.minAge = minAge;
    }

    @Override
    public EnrollmentResult check(Course course, int age, int current, int capacity, String[] completed) {
        if (age < minAge) {
            return new EnrollmentResult.Rejected(course, "Возраст меньше " + minAge);
        }
        return new EnrollmentResult.Accepted(course);
    }
}