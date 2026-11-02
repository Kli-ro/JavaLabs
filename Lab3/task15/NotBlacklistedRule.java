package task15;

import task1.Course;

public class NotBlacklistedRule implements EnrollmentRule {
    private final int blacklistedAge;

    public NotBlacklistedRule(int blacklistedAge) {
        this.blacklistedAge = blacklistedAge;
    }

    @Override
    public EnrollmentResult check(Course course, int age, int current, int capacity, String[] completed) {
        if (age == blacklistedAge) {
            return new EnrollmentResult.Rejected(course, "Студент в чёрном списке");
        }
        return new EnrollmentResult.Accepted(course);
    }
}