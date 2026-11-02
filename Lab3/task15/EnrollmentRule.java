package task15;

import task1.Course;

public interface EnrollmentRule {
    EnrollmentResult check(Course course, int age, int current, int capacity, String[] completed);
}