package task15;

import task1.Course;

public sealed interface EnrollmentResult
        permits EnrollmentResult.Accepted,
        EnrollmentResult.Rejected {

    record Accepted(Course course) implements EnrollmentResult {}

    record Rejected(Course course, String reason) implements EnrollmentResult {}
}