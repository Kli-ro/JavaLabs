package task15;

import task1.Course;

import java.util.List;

public class AllOfRule implements EnrollmentRule {
    private final List<EnrollmentRule> rules;

    public AllOfRule(List<EnrollmentRule> rules) {
        this.rules = rules;
    }

    @Override
    public EnrollmentResult check(Course course, int age, int current, int capacity, String[] completed) {
        for (EnrollmentRule rule : rules) {
            EnrollmentResult result = rule.check(course, age, current, capacity, completed);
            if (result instanceof EnrollmentResult.Rejected) {
                return result;
            }
        }
        return new EnrollmentResult.Accepted(course);
    }
}