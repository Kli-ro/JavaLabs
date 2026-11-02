package task15;

import task1.Course;

import java.util.List;

public class AnyOfRule implements EnrollmentRule {
    private final List<EnrollmentRule> rules;

    public AnyOfRule(List<EnrollmentRule> rules) {
        this.rules = rules;
    }

    @Override
    public EnrollmentResult check(Course course, int age, int current, int capacity, String[] completed) {
        EnrollmentResult last = null;
        for (EnrollmentRule rule : rules) {
            EnrollmentResult result = rule.check(course, age, current, capacity, completed);
            if (result instanceof EnrollmentResult.Accepted) {
                return result;
            }
            last = result;
        }
        return last != null ? last : new EnrollmentResult.Rejected(course, "Ни одно правило не пройдено");
    }
}