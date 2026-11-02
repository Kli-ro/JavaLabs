package Lab4.task11;

public class CourseEnrollmentService {
    private int enrollCount = 0;

    public void enroll(String studentId) {
        if (studentId == null) {
            throw new IllegalArgumentException("ID студента не может быть пустым");
        }
        enrollCount++;
    }

    public int getEnrolledCount() {
        return enrollCount;
    }
}