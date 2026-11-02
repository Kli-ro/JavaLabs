package task12;

import task1.Course;

public class EnrollmentService {

    public EnrollmentResult enroll(Course course, int age, int current, int capacity) {
        if (age < 18) {
            return new EnrollmentResult.Rejected(course, "Age < 18");
        }
        if (current >= capacity) {
            return new EnrollmentResult.WaitListed(course, current - capacity + 1);
        }
        return new EnrollmentResult.Accepted(course);
    }
}