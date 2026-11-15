package Lab9.task6;

import java.util.HashSet;
import java.util.Set;

public class CoarseGrainedEnrollment implements CourseEnrollment {
    private final Set<String> enrolled = new HashSet<>();
    private final int capacity;

    public CoarseGrainedEnrollment(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public synchronized boolean enroll(String studentId) {
        if (enrolled.size() >= capacity || enrolled.contains(studentId)) {
            return false;
        }
        enrolled.add(studentId);
        return true;
    }

    @Override
    public synchronized int getEnrolledCount() {
        return enrolled.size();
    }
}