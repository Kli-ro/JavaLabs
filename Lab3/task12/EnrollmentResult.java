package task12;

import task1.Course;

public sealed interface EnrollmentResult
        permits EnrollmentResult.Accepted,
        EnrollmentResult.Rejected,
        EnrollmentResult.WaitListed {

    record Accepted(Course course) implements EnrollmentResult {}

    record Rejected(Course course, String reason) implements EnrollmentResult {}

    record WaitListed(Course course, int position) implements EnrollmentResult {}
}