package task15;

import task1.Course;

public class PrerequisitesRule implements EnrollmentRule {
    private final String[] required;

    public PrerequisitesRule(String[] required) {
        this.required = required;
    }

    @Override
    public EnrollmentResult check(Course course, int age, int current, int capacity, String[] completed) {
        for (String req : required) {
            boolean found = false;
            for (String c : completed) {
                if (c.equals(req)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return new EnrollmentResult.Rejected(course, "Не пройден пререквизит: " + req);
            }
        }
        return new EnrollmentResult.Accepted(course);
    }
}